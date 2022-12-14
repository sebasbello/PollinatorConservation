package pollinatorconservation.model.pojo;

public class User {

    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String username;
    private String password;
    private Role role;
    private int responseCode;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (object == this) {
            isEquals = true;
        } else {
            if (object != null && object instanceof User) {
                User user = (User) object;
                isEquals = (this.getName().equals(user.getName())
                        && this.getPaternalSurname().equals(user.getPaternalSurname())
                        && this.getMaternalSurname().equals(user.getMaternalSurname())
                        && this.getRole().getIdRole() == user.getRole().getIdRole());
            }
        }
        return isEquals;
    }
    
}