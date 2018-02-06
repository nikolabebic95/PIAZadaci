/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ProfileBean;
import entities.Iznajmljivanje;
import entities.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nikola
 */
public class ReturnGear extends HttpServlet {

    private static long calculateDifference(Date before, Date after) {
        long diff = after.getTime() - before.getTime();
        return (long)(Math.ceil(diff / (1000.0 * 60 * 60 * 24)));
    }
    
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
                
                Query query = em.createQuery("SELECT i FROM Iznajmljivanje i WHERE i.idkorisnik.username = :username AND i.razduzeno = false");
                query.setParameter("username", profileBean.getUsername());
                List<Iznajmljivanje> results = query.getResultList();
                
                double price = 0;
                Date today = new Date();
                
                for (Iznajmljivanje result : results) {
                    double days = calculateDifference(result.getDatumpreuz(), today);
                    double priceForThis = days * result.getIdopreme().getCenapodanu() * (result.getImapopust() ? 0.7 : 1) - result.getDepozit();
                    price += priceForThis;
                    result.setRazduzeno(true);
                    result.setUkupnoNaplata(priceForThis);
                    result.getIdopreme().setKolicina(result.getIdopreme().getKolicina() + 1);
                }
                
                em.getTransaction().commit();
                
                profileBean.setPaid(price);
                profileBean.setShouldShowPaid(true);
                
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
