/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nikola
 */
public class ChangeInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangeInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ChangeInfo</h1>");
            
            HttpSession session = request.getSession();
            String username = (String)session.getAttribute("username");
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zadatak9PU");
            EntityManager em = emf.createEntityManager();

            
            User user = em.find(User.class, username);
            
            out.println("<form action=\"InfoChanged\" method=\"POST\" >");
            
            out.println("Username");
            out.println("<input type=\"text\" name=\"username\" value=\"" + username + "\" >");
            out.println("<br />");
            
            out.println("Password");
            out.println("<input type=\"password\" name=\"password\" value=\"" + user.getPassword() + "\" >");
            out.println("<br />");
            
            out.println("First name");
            out.println("<input type=\"text\" name=\"first\" value=\"" + user.getFirstName() + "\" >");
            out.println("<br />");

            out.println("Last name");
            out.println("<input type=\"text\" name=\"last\" value=\"" + user.getLastName() + "\" >");
            out.println("<br />");

            out.println("Email");
            out.println("<input type=\"text\" name=\"email\" value=\"" + user.getEmail() + "\" >");
            out.println("<br />");

            out.println("Phone number");
            out.println("<input type=\"text\" name=\"phone\" value=\"" + user.getPhone() + "\" >");
            out.println("<br />");
            
            out.println("<input type=\"submit\" value=\"Submit\" >");
            
            out.println("</form>");
            
            out.println("<a href=\"Logout\" >Logout</a>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
