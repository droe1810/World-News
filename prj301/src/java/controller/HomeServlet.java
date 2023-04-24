package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String sId = request.getParameter("cid");
        if(sId == null){
            sId = "1";
        }
        int id = Integer.parseInt(sId);
        
        NewDAO nd = new NewDAO();
        CategoryDAO cd = new CategoryDAO();
        
        List<New> listN = nd.getNewByCID(id);
        List<New> last = nd.get3LastNew();
        List<Category> listC = cd.getAllCategory();
        Category c = cd.getCategoryByID(sId);
        
        request.setAttribute("listN", listN);
        request.setAttribute("listC", listC);
        request.setAttribute("last", last);
        request.setAttribute("c", c);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

}
