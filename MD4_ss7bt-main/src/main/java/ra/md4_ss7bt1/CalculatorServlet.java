package ra.md4_ss7bt1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculatorServlet", value = "/calculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double operand1 = Double.parseDouble(req.getParameter("operand1"));
            double operand2 = Double.parseDouble(req.getParameter("operand2"));
            String operator = req.getParameter("operator");

            double result = calculate(operand1, operand2, operator);

            req.setAttribute("result", result);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("error",
                    "Đâu vao không hợp lệ. Vui lòng nhập số hợp lệ.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (ArithmeticException e) {
            req.setAttribute("error", "Không thể chia cho số 0.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    private static double calculate(double operand1, double operand2, String operator) throws ArithmeticException {
        switch (operator) {
            case "add":
                return operand1 + operand2;
            case "subtract":
                return operand1 - operand2;
            case "multiply":
                return operand1 * operand2;
            case "divide":
                if (operand2 == 0) {
                    throw new ArithmeticException("Không thể chia cho số 0.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}