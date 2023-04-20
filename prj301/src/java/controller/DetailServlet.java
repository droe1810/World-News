package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class DetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
              
        NewDAO nd = new NewDAO();
        PersonDAO pd = new PersonDAO();
        
        New n = nd.getNewByID(sid);
        Person p = pd.getPersonByNewID(id);
        
        request.setAttribute("detail", n);
        request.setAttribute("p", p);
        request.getRequestDispatcher("detail.jsp").forward(request, response);

    }

}
