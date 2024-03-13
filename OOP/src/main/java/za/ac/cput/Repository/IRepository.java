package za.ac.cput.Repository;

public interface IRepository <T,ID>{
    T create(T obj);
    T read(ID id);
    T update(T obj);
    boolean delete(ID id);
}
