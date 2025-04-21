package inventario;
import java.util.List;

public interface EntityDAO<T> {
    public List<T> getAll();
    public T save(T entity);
    public T update(T entity);
    public boolean delete(int id);
    public boolean delete(T entity);
}