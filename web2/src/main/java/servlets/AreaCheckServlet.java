package servlets;

import model.Row;
import model.Table;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.ZoneId;

@WebServlet(name = "AreaCheckServlet", value = "/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    private static Table table ;
    @Override
    public void init() throws ServletException {

        table = new Table();

        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        Row row = new Row(Double.parseDouble(x),Double.parseDouble(y),Double.parseDouble(r), ZoneId.of(request.getParameter("timeZone")));
        row.isHit();
        table.addRow(row);
        response.getWriter().write(table.saveTable());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public static Table getTable() {
        return table;
    }

}
