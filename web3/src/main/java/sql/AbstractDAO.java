package sql;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T extends Saveable> {
    public abstract void add(String tableName, T t) throws SQLException;
    public abstract void removeLast(String tableName);
    public abstract List<T> getAll(String tableName) throws SQLException;
    public abstract void createTable(String tableName) throws SQLException;

}
