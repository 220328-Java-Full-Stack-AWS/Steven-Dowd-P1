package p1;

import models.ReimbModel;
import models.UserModel;
import persistence.ReimbDao;
import persistence.UserDao;

import java.sql.Connection;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        try {
            Connection conn = ConnectionManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        //create
        UserDao dao = new UserDao();
        UserModel user = new UserModel("sking", "pass", "stephen", "king", "sking@aol.com", 2);
        user = dao.create(user);
        */

/*
        //read
        UserDao dao = new UserDao();
        UserModel queryModel = dao.read(3);
        System.out.println(queryModel);
*/

        //update
        ReimbDao dao = new ReimbDao();
        //UserModel updateModel = dao.read(2);
       // ReimbModel reimb = new ReimbModel(55.55f, Timestamp.from(Instant.now()), null, "testing", 2, 1, 1, 2  );

        //dao.updateResolved(reimb);
       // System.out.println(reimb);
        List<ReimbModel> list = dao.getAll();
        System.out.println(list);





        ConnectionManager.close();

    }
}
