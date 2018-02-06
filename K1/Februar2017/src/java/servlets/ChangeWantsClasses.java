/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ProfileBean;
import entities.Korisnik;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
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
public class ChangeWantsClasses extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Februar2017PU");
        EntityManager em = emf.createEntityManager();
        
        try {
            ProfileBean profileBean = (ProfileBean)session.getAttribute("profileBean");
            if (profileBean != null) {
                em.setFlushMode(FlushModeType.COMMIT);
                em.getTransaction().begin();
                Korisnik user = em.find(Korisnik.class, profileBean.getUsername());
                if (user != null) {
                    user.setZelimCasove(!user.getZelimCasove());
                }
                
                em.getTransaction().commit();
                profileBean.setWantsClasses(!profileBean.getWantsClasses());
                profileBean.setShouldShowPaid(false);
                profileBean.resetGear();
                session.setAttribute("profileBean", profileBean);
            }
            
            response.sendRedirect("profile.jsp");
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
