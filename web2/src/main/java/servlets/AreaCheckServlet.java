package servlets;

import model.Row;
import model.Table;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.ZoneId;

@WebServlet(name = "AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Table table = (Table) request.getSession().getAttribute("table");
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        Row row = new Row(Double.parseDouble(x),Double.parseDouble(y),Double.parseDouble(r), ZoneId.of(request.getParameter("timeZone")));
        row.isHit();
        table.addRow(row);
        request.getSession().setAttribute("table", table);
        response.getWriter().write(table.saveTable());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
