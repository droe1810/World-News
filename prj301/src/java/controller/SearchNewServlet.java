package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class SearchNewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String txtSearch = request.getParameter("txt");
        
        NewDAO nd = new NewDAO();
        
        List<New> listN = nd.searchByName(txtSearch);

        request.setAttribute("listN", listN);
        request.setAttribute("txtSearch", txtSearch);
        
        request.getRequestDispatcher("manager_new.jsp").forward(request, response);
    }

}
