package com.example.coffee_management;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Lấy tên người dùng và mật khẩu từ form đăng nhập
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập
        boolean isValid = checkLogin(username, password);

        if (isValid) {
            // Nếu thông tin đăng nhập đúng, chuyển hướng vào trang chủ
            response.sendRedirect("/coffee");// Điều chỉnh đường dẫn của trang chủ nếu cần
        } else {
            // Nếu thông tin đăng nhập không đúng, hiển thị thông báo lỗi
            PrintWriter out = response.getWriter();
//            response.sendRedirect("/index.jsp");
            request.setAttribute("message", "Tên tk hoặc mk không chính xác!");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
//            out.println("<html><body>");
//            out.println("<h1>Đăng nhập không thành công! Vui lòng kiểm tra lại tên người dùng và mật khẩu.</h1>");
//            out.println("</body></html>");
        }
    }

    private boolean checkLogin(String username, String password) {
        // Trong ví dụ này, chúng ta kiểm tra thông tin đăng nhập cứng
        // Trong thực tế, bạn sẽ kiểm tra từ cơ sở dữ liệu hoặc nguồn dữ liệu khác
        return username.equals("admin") && password.equals("admin123");
    }
}
