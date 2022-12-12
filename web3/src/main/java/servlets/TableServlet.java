package servlets;

import beans.ProcessBean;
import beans.Row;
import sql.RowDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TableServlet", value = "/TableServlet")
public class TableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcessBean processBean = (ProcessBean) getServletContext().getAttribute("process");
        try {
            StringBuilder result= new StringBuilder();
            for (Row row: processBean.getRows("rows", (RowDAO) getServletContext().getAttribute("dao"))){
                result.append(row.data());

            }
            response.getWriter().write(result.toString());
        }
        catch(SQLException exp){
            exp.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
