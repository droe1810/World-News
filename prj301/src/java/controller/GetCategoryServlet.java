package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class GetCategoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        CategoryDAO cd = new CategoryDAO();
        List<Category> listC = cd.getAllCategory();
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("add_new.jsp").forward(request, response);

    }

}
