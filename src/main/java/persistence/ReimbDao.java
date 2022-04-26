package persistence;

import models.ReimbModel;
import models.UserModel;
import p1.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ReimbDao {


    /**
     * This is a DAO class, which means it is used to access a datasource in order to store or retrieve data
     * This implements the CRUDInterface which sets forth a 'contract' or 'promise' so to speak.
     * The CRUDInterface has a generic type associated with it, which in this case is resolved to TestTableModel
     */

    /**
     * Inserts a model into the database in the test_table table
     * @param model - The POJO to be inserted into the database. Pojo must extend the Model abstract class.
     */

    public ReimbModel create(ReimbModel model) {
        String sql = "INSERT INTO ers_reimb (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (?, ?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setFloat(1, model.getReimbAmount());
            pstmt.setTimestamp(2, model.getReimbSubmitted());
            pstmt.setTimestamp(3, model.getReimbResolved());
            pstmt.setString(4, model.getReimbDescription());
            pstmt.setInt(5, model.getReimbAuthor());
            pstmt.setInt(6, model.getReimbResolver());
            pstmt.setInt(7, model.getReimbStatusId());
            pstmt.setInt(8, model.getReimbTypeId());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()) {
                int key = keys.getInt(1);
                model.setReimbId(key);
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

    public ReimbModel read(int id) {
        ReimbModel model = new ReimbModel();
        try {
            String SQL = "SELECT * FROM ers_reimb WHERE reimb_id = ?";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();


            while(rs.next()) {
                model.setReimbId(rs.getInt("reimb_id"));
                model.setReimbAmount(rs.getFloat("reimb_amount"));
                model.setReimbSubmitted(rs.getTimestamp("reimb_submitted"));
                model.setReimbResolved(rs.getTimestamp("reimb_resolved"));
                model.setReimbDescription(rs.getString("reimb_description"));
                model.setReimbAuthor(rs.getInt("reimb_author"));
                model.setReimbResolver(rs.getInt("reimb_resolver"));
                model.setReimbStatusId(rs.getInt("reimb_status_id"));
                model.setReimbTypeId(rs.getInt("reimb_type_id"));

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

    public void updateResolved(ReimbModel model) {
        String sql = "UPDATE ers_reimb SET reimb_resolved = now() WHERE reimb_id = ?";
        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, model.getReimbId());
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
        String sql = "DELETE FROM ers_reimb WHERE reimb_id = ?";
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

    public void delete(ReimbModel model) {
        String sql = "DELETE FROM ers_reimb WHERE reimb_id = ?";
        try {
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, model.getReimbId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * returns a list of the entire contents of test_table
     * @return a LinkList of TestTableModel objects which represent the entire test_table table
     */

    public List<ReimbModel> getAll() {
        List<ReimbModel> list = new LinkedList<>();
        try {
            String SQL = "SELECT * FROM ers_reimb";
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            ResultSet rs = pstmt.executeQuery();


            while(rs.next()) {
                ReimbModel model = new ReimbModel();
                model.setReimbId(rs.getInt("reimb_id"));
                model.setReimbAmount(rs.getFloat("reimb_amount"));
                model.setReimbSubmitted(rs.getTimestamp("reimb_submitted"));
                model.setReimbResolved(rs.getTimestamp("reimb_resolved"));
                model.setReimbDescription(rs.getString("reimb_description"));
                model.setReimbAuthor(rs.getInt("reimb_author"));
                model.setReimbResolver(rs.getInt("reimb_resolver"));
                model.setReimbStatusId(rs.getInt("reimb_status_id"));
                model.setReimbTypeId(rs.getInt("reimb_type_id"));
                list.add(model);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}


