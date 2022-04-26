package persistence;

import java.util.List;

import models.Model;
import models.ReimbModel;


public interface CRUDInterface<T extends Model> {
    //CRUD - create, read, update, delete
    public T create(T model);

    ReimbModel create(ReimbModel model);

    public T read(int id);
    //public void update(T model);
    public void delete(int id);
    public void delete(T model);
    public List<T> getAll();

}