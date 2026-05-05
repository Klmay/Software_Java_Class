import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        double amount = Double.parseDouble(request.getParameter("loanAmount"));
        double rate = Double.parseDouble(request.getParameter("annualInterestRate"));
        int years = Integer.parseInt(request.getParameter("numberOfYears"));

        Loan loan = new Loan(rate, years, amount);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Loan Calculation Results</h2>");
        out.println("<p>Monthly Payment: <b>$" + String.format("%.2f", loan.getMonthlyPayment()) + "</b></p>");
        out.println("<p>Total Payment: <b>$" + String.format("%.2f", loan.getTotalPayment()) + "</b></p>");
        out.println("<br><a href='index.html'>Back</a>");
        out.println("</body></html>");
    }
}
