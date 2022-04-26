package services;

import models.UserModel;
import persistence.UserDao;

import java.util.List;

public class UserService {
    private final UserDao dao;

    public UserService() {
        this.dao = new UserDao();
    }

    public UserModel create(UserModel model) {
        return dao.create(model);
    }
    public UserModel read(int id) {
        return dao.read(id);
    }
    public void updateRoleToAdmin(UserModel model) {
        dao.updateRoleToAdmin(model);
    }
    public void delete(int id) {
        dao.delete(id);
    }
    public void delete(UserModel model) {
        dao.delete(model);
    }
    public List<UserModel> getAll() {
        return dao.getAll();
    }



}
