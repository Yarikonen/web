package sql;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SqlConnector {
    abstract Connection getConnection();
    abstract void connect(String url, String userName, String password) throws SQLException, ClassNotFoundException;

}
