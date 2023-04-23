package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ManagerWriterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        AccountDAO ad = new AccountDAO();
        PersonDAO pd = new PersonDAO();


        List<Account> listW = ad.getAllWriter();
        List<Person> listP = pd.getAllPerson();
        

        request.setAttribute("listW", listW);
        request.setAttribute("listP", listP);

        request.getRequestDispatcher("manager_writer.jsp").forward(request, response);

    }

}
