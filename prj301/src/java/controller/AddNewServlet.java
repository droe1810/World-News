package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class AddNewServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
   
        int category = Integer.parseInt(request.getParameter("category"));
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int writerID = a.getId();
        
        NewDAO nd = new NewDAO();
        nd.add(name, image, title, content, category, writerID);
        
        String mess = "Post successful!";
        request.setAttribute("mess", mess);
        
        request.getRequestDispatcher("home").forward(request, response);
    }
}
