package ra.md4_ss7bt1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customerServlet")
public class CustomerServlet extends HttpServlet {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customers.add(new Customer("Huan", convertToDate("1999-1-15"), "Hà Nam", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTB5M5HDqaev_qDkghiOs_KEs8613aw3SdB4g&usqp=CAU"));
        customers.add(new Customer("Giang", convertToDate("1998-4-16"), "Hà Nội", "data:image/jpeg;base64,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"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/customer.jsp").forward(request, response);
    }

    private LocalDate convertToDate(String inputDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        try {
            return LocalDate.parse(inputDate, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace(); // In lỗi ra console để kiểm tra và xử lý
            return null; // Hoặc trả về giá trị mặc định hoặc thông báo lỗi khác
        }
    }
}
