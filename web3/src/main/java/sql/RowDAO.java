package sql;

import beans.Row;


import java.io.Serializable;
import java.sql.*;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class RowDAO extends AbstractDAO<Row> implements Serializable {
    private final static String INSERT_QUERY="INSERT INTO rows (hit, executionTime, birthTime, x, y, r) VALUES(?,?,?,?,?,?)";
    private final static String GET_ALL_QUERY = "SELECT * FROM rows";
    private final static String GET_SIZE = "SELECT count(*) FROM rows";
    private final static String GET_SUBLIST = "SELECt  * FROM rows limit 23 offset ";
    private final static String CREATE_TABLE ="CREATE TABLE IF NOT EXISTS rows (hit bool, executionTime bigint, birthTime time, x double precision, y double precision, r double precision)";

    public void setSqlConnector(SqlConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    public SqlConnector getSqlConnector() {
        return sqlConnector;
    }

    private SqlConnector sqlConnector;
    public RowDAO() throws SQLException, ClassNotFoundException {
        this.sqlConnector=new PostgressConnector();
        sqlConnector.connect("localhost:5432/postgres", "postgres", System.getenv("password"));
        createTable();

    }

    @Override
    public void add(Row row) throws SQLException {
        Connection connection =  sqlConnector.getConnection();
        if (connection!=null) {
            row.checkZone();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setBoolean(1, row.isHit());
            preparedStatement.setLong(2, row.getExTime());
            preparedStatement.setTime(3, Time.valueOf(row.getBirthTime()));
            preparedStatement.setDouble(4, row.getX());
            preparedStatement.setDouble(5, row.getY());
            preparedStatement.setDouble(6, row.getR());
            preparedStatement.execute();
        }
        else throw new SQLException();



    }



    @Override
    public List<Row> getAll() throws SQLException {
        List<Row> rowList = new LinkedList<>();
        Connection connection =  sqlConnector.getConnection();
        if (connection!=null) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Row row =new Row();
                row.setHit(resultSet.getBoolean(1));
                row.setBirthTime(resultSet.getObject(3, LocalTime.class));
                row.setExTime(resultSet.getLong(2));
                row.setX(resultSet.getDouble(4));
                row.setY(resultSet.getDouble(5));
                row.setR(resultSet.getDouble(6));
                rowList.add(row);
            }

        }
        else throw new SQLException();
        return rowList;
    }

    @Override
    public void createTable() throws SQLException {
        Connection connection = sqlConnector.getConnection();
        if(connection!=null){
            PreparedStatement statement = connection.prepareStatement(CREATE_TABLE);
            statement.execute();
        }
        else{
            throw new SQLException();
        }
    }
    public int getSize() throws SQLException {
        Connection connection = sqlConnector.getConnection();
        if(connection!=null){
            PreparedStatement statement = connection.prepareStatement(GET_SIZE);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return(rs.getInt(1));

        }
        return(0);
    }



    public List<Row> getSublist(int begin) throws SQLException {
        List<Row> rowList = new LinkedList<>();
        Connection connection =  sqlConnector.getConnection();
        if (connection!=null) {
            PreparedStatement statement = connection.prepareStatement(GET_SUBLIST + begin);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Row row =new Row();
                row.setHit(resultSet.getBoolean(1));
                row.setBirthTime(resultSet.getObject(3, LocalTime.class));
                row.setExTime(resultSet.getLong(2));
                row.setX(resultSet.getDouble(4));
                row.setY(resultSet.getDouble(5));
                row.setR(resultSet.getDouble(6));
                rowList.add(row);
            }

        }
        else throw new SQLException();
        return rowList;
    }

}
