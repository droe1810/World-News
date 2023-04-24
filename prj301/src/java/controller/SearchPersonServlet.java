package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class SearchPersonServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String txtSearch = request.getParameter("txt");
        
        PersonDAO pd = new PersonDAO();
        
        List<Person> listP = pd.searchByName(txtSearch);

        request.setAttribute("listP", listP);
        request.setAttribute("txtSearch", txtSearch);
        
        request.getRequestDispatcher("manager_writer.jsp").forward(request, response);
    }

}
