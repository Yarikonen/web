package sql;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T extends Saveable> {
    public abstract void add(T t) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
    public abstract void createTable() throws SQLException;
    public abstract int getSize() throws SQLException;
    public abstract List<T> getSublist(int begin) throws SQLException;

}
