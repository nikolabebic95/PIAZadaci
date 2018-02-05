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
public class Login extends HttpServlet {

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
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zadatak9PU");
        EntityManager em = emf.createEntityManager();
        
        String username = request.getParameter("username");
        
        User user = em.find(User.class, username);
        
        String password = request.getParameter("password");
        
        if (user == null) {
            response.sendRedirect("wrong_username.html");
        } else if (!user.getPassword().equals(password)) {
            response.sendRedirect("wrong_password.html");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("logout", null);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User page</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Profile</h1>");

                out.println("Username: ");
                out.println(user.getUsername());
                out.println("<br />");

                out.println("First name: ");
                out.println(user.getFirstName());
                out.println("<br />");

                out.println("Last name: ");
                out.println(user.getLastName());
                out.println("<br />");

                out.println("Email: ");
                out.println(user.getEmail());
                out.println("<br />");

                out.println("Phone number: ");
                out.println(user.getPhone());
                out.println("<br />");

                out.println("<a href=\"ChangeInfo\" >Change info</a>");
                out.println("<a href=\"Logout\" >Logout</a>");
                
                out.println("</body>");
                out.println("</html>");
            }
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
