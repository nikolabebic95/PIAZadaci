/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.IndexBean;
import beans.ProfileBean;
import entities.Korisnik;
import java.io.IOException;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Februar2017PU");
        EntityManager em = emf.createEntityManager();
        
        HttpSession session = request.getSession();
        ServletContext application = getServletContext();
        
        try {
            Korisnik user = em.find(Korisnik.class, username);
            if (user == null) {
                IndexBean indexBean = new IndexBean("User does not exist", username);
                session.setAttribute("indexBean", indexBean);
                response.sendRedirect("index.jsp");
            } else if (!user.getPassword().equals(password)) {
                IndexBean indexBean = new IndexBean("Wrong password", username);
                session.setAttribute("indexBean", indexBean);
                response.sendRedirect("index.jsp");
            } else {
                if (user.getJeInstruktor() == 0 && type.equals("Instructor") || user.getJeInstruktor() == 1 && type.equals("Skier")) {
                    IndexBean indexBean = new IndexBean("Wrong type", username);
                    session.setAttribute("indexBean", indexBean);
                    response.sendRedirect("index.jsp");
                } else {
                    if (user.getJeInstruktor() == 0) {
                        ProfileBean profileBean = new ProfileBean(user);
                        session.setAttribute("profileBean", profileBean);

                        if (user.getZelimCasove()) {
                            HashSet<String> loggedIn = (HashSet<String>)application.getAttribute("loggedIn");
                            if (loggedIn == null) loggedIn = new HashSet<>();
                            loggedIn.add(user.getUsername());
                            application.setAttribute("loggedIn", loggedIn);
                        }
                        
                        session.setAttribute("indexBean", null);
                        response.sendRedirect("profile.jsp");
                    } else {
                        session.setAttribute("instructorBean", null);
                        response.sendRedirect("instructor.jsp");
                    }
                }
            }
        } finally {
            em.close();
            emf.close();
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
