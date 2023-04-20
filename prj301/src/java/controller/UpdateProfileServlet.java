package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.sql.Date;

public class UpdateProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();

        String name = request.getParameter("name");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String address = request.getParameter("address");

        PersonDAO pd = new PersonDAO();
        pd.edit(name, dob, address, id);

        response.sendRedirect("viewprofile");
    }

}
