package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("user");
        String password = request.getParameter("pass");
      
        AccountDAO ad = new AccountDAO();
        Account a = ad.login(username, password);
        
        if(a == null){
            request.setAttribute("mess", "Wrong username or password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else{
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
             response.sendRedirect("home");
        }
    }

}
