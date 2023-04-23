package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class LoadNewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        NewDAO nd = new NewDAO();

        New n = nd.getNewByID(id);

        request.setAttribute("detail", n);

        request.getRequestDispatcher("edit_new.jsp").forward(request, response);
    }
}
