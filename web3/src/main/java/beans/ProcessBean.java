package beans;

import sql.AbstractDAO;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import java.util.Base64;
import java.util.List;

public class ProcessBean {


    private int pageCount;
    private AbstractDAO<Row> rowHandler;
    private static final int ROW_PER_LIST =24;

    public ProcessBean(){
        pageCount=0;



    }

    public void addToBase(Row row) throws SQLException {
        rowHandler.add(row);
    }
    public List<Row> getTable() throws SQLException {
        return(rowHandler.getSublist(pageCount*ROW_PER_LIST));


    }
    public List<Row> getRows() throws SQLException {
        return rowHandler.getAll();
    }
    public void next() throws SQLException {
        int size = rowHandler.getSize();
        int totalPages = (size /ROW_PER_LIST) + ((size %ROW_PER_LIST != 0) ? 1 : 0);
        pageCount=Math.min(pageCount+1,totalPages-1);
    }
    public void previous() {
        pageCount=Math.max(pageCount-1,0);
    }

    public void setRowHandler(AbstractDAO<Row> rowHandler) {
        this.rowHandler = rowHandler;
    }
}
