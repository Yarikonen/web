package beans;

import sql.AbstractDAO;
import sql.PostgressConnector;
import sql.RowDAO;
import sql.SqlConnector;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProcessBean {

    private static final String tableName="rows";
    private int pageCount;
    private static final int ROW_PER_LIST =24;

    public ProcessBean(){
        pageCount=0;

    }
    public void addToBase(Row row, AbstractDAO<Row> rowHandler) throws SQLException {
        rowHandler.add("rows", row);
    }
    public List<Row> getTable(String table, AbstractDAO<Row> rowHandler) throws SQLException {
        List<Row> rows = rowHandler.getAll(tableName);
        Collections.reverse(rows);
        return rows.subList(pageCount*23, Math.min((pageCount+1)*23,rows.size()));

    }
    public List<Row> getRows(String tableName, AbstractDAO<Row> rowHandler) throws SQLException {
        List<Row> rows = rowHandler.getAll(tableName);
        return rows;
    }
    public void next(String table, AbstractDAO<Row> rowHandler) throws SQLException {
        List<Row> rows = rowHandler.getAll(tableName);
        int totalPages = (rows.size() /ROW_PER_LIST) + ((rows.size() %ROW_PER_LIST != 0) ? 1 : 0);
        pageCount=Math.min(pageCount+1,totalPages-1);
    }
    public void previous(String table, AbstractDAO<Row> rowHandler) throws SQLException {
        List<Row> rows = rowHandler.getAll(tableName);
        pageCount=Math.max(pageCount-1,0);
    }
}
