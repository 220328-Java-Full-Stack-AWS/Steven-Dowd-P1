package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ReimbModel;
import services.ReimbService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbServlet extends HttpServlet {
    private ReimbService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.service = new ReimbService();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reimb_id = req.getHeader("reimb_id");
        int integer = Integer.parseInt(reimb_id);
        ReimbModel model = service.read(integer);

        String json = mapper.writeValueAsString(model);
        resp.setContentType("application/json");
        resp.getWriter().print(json);
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReimbModel model = mapper.readValue(req.getInputStream(),ReimbModel.class);
        model = service.create(model);
        String json = mapper.writeValueAsString(model);
        resp.setStatus(201);;
        resp.setContentType("application/json");
        resp.getWriter().print(json);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReimbModel model = mapper.readValue(req.getInputStream(), ReimbModel.class);
        service.update(model);
        String json = mapper.writeValueAsString(model);
        resp.setStatus(201);
        resp.setContentType("application/json");
        resp.getWriter().print(json);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.delete(Integer.parseInt(req.getHeader("reimb_id")));
        resp.setStatus(200);
    }
}
