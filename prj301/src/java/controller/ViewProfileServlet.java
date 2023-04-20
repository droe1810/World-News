package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ViewProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        PersonDAO pd = new PersonDAO();
        String sid = request.getParameter("id");
        int id;
        if (sid == null) {
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            id = a.getId();
        } else {
            id = Integer.parseInt(sid);
        }
        Person p = pd.getPersonByID(id);

        request.setAttribute("p", p);

        request.getRequestDispatcher("view_profile.jsp").forward(request, response);

    }
}
