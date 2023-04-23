package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ManagerNewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        NewDAO nd = new NewDAO();

        List<New> listN = nd.getAllNew();

        request.setAttribute("listN", listN);

        request.getRequestDispatcher("manager_new.jsp").forward(request, response);

    }

}
