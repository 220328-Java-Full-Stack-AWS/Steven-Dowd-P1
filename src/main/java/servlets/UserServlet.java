package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.UserModel;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private UserService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.service = new UserService();
        this.mapper = new ObjectMapper();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*
        there are several ways to get data out of the request
        located in the URL - this is a query parameter in the URL there are key/value pairs something.com/something?key=value&key=value&item_id=1
        Also located in the URL - Path parameters. We won't be seeing this until we start working with spring controllers
        located in header - key value pairs from the header of the request
        located in the body - JSON resource representation

        query param - good for requests only, because we don't send URI back in the response.
        This is where we would find HTML form data
        System.out.println("query param: " + req.getParameter("item_id"));
        get from headers - good for request and response, as both have a set of key/value pairs that are called "headers"
        get from request body - also good for req and response, even get requests which do not traditionally have a body
         */

        //UserModel model = service.read(Integer.parseInt(req.getHeader("ers_users_id")));

        String ers_users_id = req.getHeader("ers_users_id");
        int integer = Integer.parseInt(ers_users_id);
        UserModel model = service.read(integer);

        //now we want to turn model into JSON to transmit in the response body
        //ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(model);
        resp.setContentType("application/json");
        resp.getWriter().print(json);
        resp.setStatus(200);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel model = mapper.readValue(req.getInputStream(), UserModel.class);
        model = service.create(model);
        String json = mapper.writeValueAsString(model);
        resp.setStatus(201); //successfully created
        resp.setContentType("application/json");
        resp.getWriter().print(json);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel model = mapper.readValue(req.getInputStream(), UserModel.class);
        service.update(model);
        String json = mapper.writeValueAsString(model);
        resp.setStatus(201); //successfully created
        resp.setContentType("application/json");

        resp.getWriter().print(json);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.delete(Integer.parseInt(req.getHeader("ers_users_id")));
        resp.setStatus(200);
    }
}
