package models;

public class UserModel {
    /*
    create table if not exists ers_users (
	ers_users_id serial primary key,
	ers_username varchar(50),
	ers_password varchar(50),
	user_first_name varchar(50),
	user_last_name varchar (50),
	user_email varchar(50),
	user_role_id int,
	constraint user_roles_fk foreign key (user_role_id) references ers_user_roles (ers_user_role_id)
     */
    int ersUsersId;
    String ersUsername;
    String ersPassword;
    String userFirstName;
    String userLastName;
    String userEmail;
    int userRoleId;

    public UserModel() {
    }

    public UserModel(String ersUsername, String ersPassword, String userFirstName, String userLastName, String userEmail, int userRoleId) {

        this.ersUsername = ersUsername;
        this.ersPassword = ersPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleId = userRoleId;
    }

    public int getErsUsersId() {
        return ersUsersId;
    }

    public void setErsUsersId(int ersUsersId) {
        this.ersUsersId = ersUsersId;
    }

    public String getErsUsername() {
        return ersUsername;
    }

    public void setErsUsername(String ersUsername) {
        this.ersUsername = ersUsername;
    }

    public String getErsPassword() {
        return ersPassword;
    }

    public void setErsPassword(String ersPassword) {
        this.ersPassword = ersPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "ers_users_id=" + ersUsersId +
                ", ers_username='" + ersUsername + '\'' +
                ", ers_password='" + ersPassword + '\'' +
                ", user_first_name='" + userFirstName + '\'' +
                ", user_last_name='" + userLastName + '\'' +
                ", user_email='" + userEmail + '\'' +
                ", user_role_id=" + userRoleId +
                '}';
    }
}
