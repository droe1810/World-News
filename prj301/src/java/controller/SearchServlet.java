package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String txtSearch = request.getParameter("txt");
        
        NewDAO nd = new NewDAO();
        CategoryDAO cd = new CategoryDAO();
        
        List<New> listN = nd.searchByName(txtSearch);
        List<Category> listC = cd.getAllCategory();

        request.setAttribute("listN", listN);
        request.setAttribute("listC", listC);
        request.setAttribute("txtSearch", txtSearch);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
