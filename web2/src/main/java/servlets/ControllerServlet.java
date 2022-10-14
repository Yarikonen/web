package servlets;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.util.Arrays;
import java.util.HashSet;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private final  HashSet<Double> xArr= new HashSet<>(Arrays.asList(-2.0, -1.5, -1.0, -0.5, 0.0, 0.5 , 1.0,1.5,2.0));
    private final  HashSet<Double> rArr= new HashSet<>(Arrays.asList(1.0,1.5,2.0,2.5,3.0));


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
            double xx = Double.parseDouble(x);
            double yy=  Double.parseDouble(y);
            double rr = Double.parseDouble(r);
            return(xArr.contains(xx) && rArr.contains(rr) && yy<=5 && yy>=-5 );
        }catch(NumberFormatException exp){
            return false;

        }

    }
}
