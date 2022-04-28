package services;

import models.ReimbModel;
import persistence.ReimbDao;

import java.util.List;

public class ReimbService {
    private final ReimbDao dao;

    public ReimbService() {
        this.dao = new ReimbDao();
    }

    public ReimbModel create(ReimbModel model) {
        return dao.create(model);
    }

    public ReimbModel read(int id) {
        return dao.read(id);
    }

    public void update(ReimbModel model) {
        dao.update(model);
    }
    public void delete(int id) {
        dao.delete(id);
    }
    public void delete(ReimbModel model) {
        dao.delete(model);
    }
    public List<ReimbModel> getAll() {
        return dao.getAll();
    }
}
