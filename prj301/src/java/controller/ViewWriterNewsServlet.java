package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ViewWriterNewsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        NewDAO nd = new NewDAO();
        PersonDAO pd = new PersonDAO();
        
        int id = Integer.parseInt(request.getParameter("id"));

        List<New> listN = nd.getNewByWriterID(id);
        Person p = pd.getPersonByID(id);

        request.setAttribute("listN", listN);
        request.setAttribute("p", p);

        request.getRequestDispatcher("view_writer_news.jsp").forward(request, response);

    }
}
