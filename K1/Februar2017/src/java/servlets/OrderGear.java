/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ProfileBean;
import entities.Iznajmljivanje;
import entities.Korisnik;
import entities.Skioprema;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class OrderGear extends HttpServlet {

    private static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
            
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
        String[] gear = request.getParameterValues("order");
        
        String date = request.getParameter("date");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Februar2017PU");
        EntityManager em = emf.createEntityManager();
        
        HttpSession session = request.getSession();
        
        try {
            ProfileBean profileBean = (ProfileBean)session.getAttribute("profileBean");
            if (profileBean != null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date returnDate = format.parse(date);

                boolean discount = gear.length >= 3;
                Date today = getToday();
                
                em.setFlushMode(FlushModeType.COMMIT);
                em.getTransaction().begin();
                
                for (String item : gear) {
                    Skioprema gearItem = em.find(Skioprema.class, Integer.parseInt(item));
                    
                    Iznajmljivanje rent = new Iznajmljivanje();
                    rent.setDatumpreuz(today);
                    rent.setIdkorisnik(em.find(Korisnik.class, profileBean.getUsername()));
                    rent.setIdopreme(gearItem);
                    rent.setImapopust(discount);
                    rent.setRazduzeno(false);
                    rent.setUkupnoNaplata(null);
                    rent.setPlaniranovracanje(returnDate);
                    
                    double deposit = calculateDifference(today, returnDate) * gearItem.getCenapodanu() * (discount ? 0.7 : 1) * 0.3;
                    rent.setDepozit((int)deposit);
                    em.persist(rent);
                    
                    gearItem.setKolicina(gearItem.getKolicina() - 1);
                }

                profileBean.resetGear();
                profileBean.setShouldShowPaid(false);
                session.setAttribute("profileBean", profileBean);
                
                em.getTransaction().commit();
            }
            
            response.sendRedirect("profile.jsp");
        } catch (ParseException e) {
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
