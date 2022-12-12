package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgressConnector extends SqlConnector {
    Connection postgressConnection = null;
    @Override
    Connection getConnection() {
        return(postgressConnection);
    }

    @Override
    public void connect(String url, String userName, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        postgressConnection= DriverManager.getConnection("jdbc:postgresql://" + url,userName,password);

    }


}
