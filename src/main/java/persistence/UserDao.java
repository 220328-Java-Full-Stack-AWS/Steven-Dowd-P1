package persistence;

import models.UserModel;
import p1.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao {


    /**
     * This is a DAO class, which means it is used to access a datasource in order to store or retrieve data
     * This implements the CRUDInterface which sets forth a 'contract' or 'promise' so to speak.
     * The CRUDInterface has a generic type associated with it, which in this case is resolved to TestTableModel
     */

        /**
         * Inserts a model into the database in the test_table table
         * @param model - The POJO to be inserted into the database. Pojo must extend the Model abstract class.
         */

        public UserModel create(UserModel model) {
            String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES (?, ?,?,?,?,?)";
            try {
                PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                pstmt.setString(1, model.getErsUsername());
                pstmt.setString(2, model.getErsPassword());
                pstmt.setString(3, model.getUserFirstName());
                pstmt.setString(4, model.getUserLastName());
                pstmt.setString(5, model.getUserEmail());
                pstmt.setInt(6, model.getUserRoleId());
                pstmt.executeUpdate();

                ResultSet keys = pstmt.getGeneratedKeys();
                if(keys.next()) {
                    int key = keys.getInt(1);
                    model.setErsUsersId(key);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * This returns a model object from a table row
         * @param id - The ID to identify the row we wish to retrieve from the database
         * @return - TestTableModel which contains the info retrieved form the corresponding table row
         */

        public UserModel read(int id) {
            UserModel model = new UserModel();
            try {
                String SQL = "SELECT * FROM ers_users WHERE ers_users_id = ?";
                Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                pstmt.setInt(1, id);

                ResultSet rs = pstmt.executeQuery();


                while(rs.next()) {
                    model.setErsUsersId(rs.getInt("ers_users_id"));
                    model.setErsUsername(rs.getString("ers_username"));
                    model.setErsPassword(rs.getString("ers_password"));
                    model.setUserFirstName(rs.getString("user_first_name"));
                    model.setUserLastName(rs.getString("user_last_name"));
                    model.setUserEmail(rs.getString("user_email"));
                    model.setUserRoleId(rs.getInt("user_role_id"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return model;
        }

        /**
         * This updates a row in the database based on a model
         * @param model - the object used to update the corresponding row in the table based on id
         */

        public void updateRoleToAdmin(UserModel model) {
            String sql = "UPDATE ers_users SET user_role_id = 2 WHERE ers_users_id = ?";
            try {
                PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
                pstmt.setInt(1, model.getUserRoleId());
                //pstmt.setInt(2, model.getErs_users_id());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * This deletes a single row from the database based on id
         * @param id The ID to identify the row we wish to delete
         */

        public void delete(int id) {
            String sql = "DELETE FROM ers_users WHERE ers_users_id = ?";
            try {
                PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        /**
         * This deletes a single row from the database based on id included in model object
         * @param model The model containing the ID to identify the row we wish to delete
         */

        public void delete(UserModel model) {
            String sql = "DELETE FROM ers_users WHERE ers_users_id = ?";
            try {
                PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
                pstmt.setInt(1, model.getErsUsersId());
                pstmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * returns a list of the entire contents of test_table
         * @return a LinkList of TestTableModel objects which represent the entire test_table table
         */

        public List<UserModel> getAll() {
            List<UserModel> list = new LinkedList<>();
            try {
                String SQL = "SELECT * FROM ers_users";
                Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);

                ResultSet rs = pstmt.executeQuery();


                while(rs.next()) {
                    UserModel model = new UserModel();
                    model.setErsUsersId(rs.getInt("ers_users_id"));
                    model.setErsUsername(rs.getString("ers_username"));
                    model.setErsPassword(rs.getString("ers_password"));
                    model.setUserFirstName(rs.getString("user_first_name"));
                    model.setUserLastName(rs.getString("user_last_name"));
                    model.setUserEmail(rs.getString("user_email"));
                    model.setUserRoleId(rs.getInt("user_role_id"));
                    list.add(model);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return list;
        }
    }
