package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import java.sql.Date;

public class AddPersonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String xDob = request.getParameter("dob");
        Date dob = Date.valueOf(xDob);
        String address = request.getParameter("address");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        request.setAttribute("user", user);
        request.setAttribute("pass", pass);
               
        PersonDAO pd = new PersonDAO();
        pd.add(name, dob, address);
        
        AccountDAO ad = new AccountDAO();
        ad.add(user, pass);
        
        request.getRequestDispatcher("managerwriter").forward(request, response);
        

    }
}
