package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class CreateAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String re_password = request.getParameter("re_pass");

        request.setAttribute("user", username);
        request.setAttribute("pass", password);

        AccountDAO ad = new AccountDAO();

        if (password.equals(re_password) == false) {
            request.setAttribute("mess", "password not match!");
            request.getRequestDispatcher("create_account.jsp").forward(request, response);
        }  else {
            ad.addReader(username, password);
            request.getRequestDispatcher("home").forward(request, response);
        }
    }

}
