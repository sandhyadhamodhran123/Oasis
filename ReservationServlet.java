// ReservationServlet.java
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/reserve", "/cancel"})
public class ReservationServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = request.getServletPath();
        
        if ("/reserve".equals(path)) {
            String trainNumber = request.getParameter("trainNumber");
            String trainName = request.getParameter("trainName");
            String classType = request.getParameter("classType");
            String journeyDate = request.getParameter("journeyDate");
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            
            response.setContentType("text/html");
            response.getWriter().println("<h2>Reservation Confirmed</h2>");
            response.getWriter().println("<p>Train Number: " + trainNumber + "</p>");
            response.getWriter().println("<p>Train Name: " + trainName + "</p>");
            response.getWriter().println("<p>Class Type: " + classType + "</p>");
            response.getWriter().println("<p>Date of Journey: " + journeyDate + "</p>");
            response.getWriter().println("<p>From: " + from + "</p>");
            response.getWriter().println("<p>To: " + to + "</p>");
        } else if ("/cancel".equals(path)) {
            String pnr = request.getParameter("pnr");

            response.setContentType("text/html");
            response.getWriter().println("<h2>Cancellation Confirmed</h2>");
            response.getWriter().println("<p>PNR Number: " + pnr + " has been canceled.</p>");
        }
    }
}
