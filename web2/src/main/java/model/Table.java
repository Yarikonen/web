package model;



import java.io.Serializable;
import java.util.LinkedList;

public class Table implements Serializable {
    private LinkedList<Row> rows ;
    private static final String tableHeader ="<tr><th>Hit or miss </th>     <th>Execution time [ns]</th>        <th>DateTime</th>        <th>X</th>        <th>Y</th>        <th>R</th> </tr>";

    public Table(){
        this.rows= new LinkedList<>();
    }
    public String saveTable(){
        if(rows.size()>23){
            rows.pollFirst();
        }
        StringBuilder table = new StringBuilder(tableHeader);
        for (Row row: rows
             ) {
            table.append(row.toString());

        }
        return(table.toString());
    }
    public String returnValues(){
        StringBuilder result= new StringBuilder();
        for (Row row: rows){
            result.append(row.data());

        }
        return(result.toString());
    }
    public void setRows(LinkedList<Row> rows){
        this.rows=rows;
    }
    public LinkedList<Row> getRows(){
        return(rows);
    }
    public void addRow(Row row){
        rows.offer(row);
    }
    public static String getHeader(){
        return tableHeader;
    }

}
