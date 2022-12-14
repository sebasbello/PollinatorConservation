package pollinatorconservation.model.dao;

import pollinatorconservation.model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pollinatorconservation.model.pojo.Role;
import pollinatorconservation.model.pojo.User;
import pollinatorconservation.util.Constants;

public class UserDAO {

    public static User login(String username, String password) throws SQLException {
        User user = new User();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.open();
        String query = "SELECT user.username, user.name, user.paternalSurname, user.maternalSurname, role.idRole, role.name as role FROM user\n"
                + "INNER JOIN role\n"
                + "ON user.IdRole = role.IdRole\n"
                + "WHERE username = ? AND password = ?";
        try (Connection database = databaseConnection.open()) {
            PreparedStatement configureQuery = database.prepareStatement(query);
            configureQuery.setString(1, username);
            configureQuery.setString(2, password);
            ResultSet result = configureQuery.executeQuery();
            if (result.next()) {
                user.setUsername(result.getString("username"));
                user.setName(result.getString("name"));
                user.setPaternalSurname(result.getString("paternalSurname"));
                user.setMaternalSurname(result.getString("maternalSurname"));
                Role role = new Role();
                role.setIdRole(result.getInt("idRole"));
                role.setName(result.getString("role"));
                user.setRole(role);
                user.setResponseCode(Constants.CORRECT_OPERATION_CODE);
            } else {
                user.setResponseCode(Constants.INVALID_ENTERED_DATA_CODE);
            }
        } catch (SQLException exception) {
            user.setResponseCode(Constants.NO_DATABASE_CONNECTION_CODE);
        } finally {
            databaseConnection.close();
        }
        return user;
    }

}