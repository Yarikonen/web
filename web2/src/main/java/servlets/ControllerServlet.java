package servlets;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;



@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");

        if (x != null && y != null &&  r != null && request.getParameter("timeZone")!=null && validate(x,y,r)) {
            getServletContext().getNamedDispatcher("AreaCheckServlet").forward(request,response);

        }
        else{
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private boolean validate(String x, String y, String r){

        try{
            Double.parseDouble(x);
            double yy=  Double.parseDouble(y);
            Double.parseDouble(r);
            return( yy<=5 && yy>=-5 );
        }catch(NumberFormatException exp){
            return false;

        }

    }
}
