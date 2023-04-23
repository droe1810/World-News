package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class ManagerNewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        
        NewDAO nd = new NewDAO();
        List<New> listN;

        if(a.getIsAdmin()== 1){
             listN = nd.getAllNew();
        } else {
            listN = nd.getNewByWriterID(id);
        }

        request.setAttribute("listN", listN);

        request.getRequestDispatcher("manager_new.jsp").forward(request, response);

    }

}
