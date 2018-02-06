/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevlets;

import beans.ExamBean;
import beans.ExamsListBean;
import beans.MessageBean;
import entities.Exam;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class ShowPassed extends HttpServlet {

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
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        HttpSession session = request.getSession();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zadatak7PU");
        EntityManager em = emf.createEntityManager();
        
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date firstDate = format.parse(first);
            Date secondDate = format.parse(second);
            
            Query query = em.createQuery("SELECT e from Exam e WHERE e.date >= :firstDate AND e.date <= :secondDate AND e.grade > 5");
            query.setParameter("firstDate", firstDate);
            query.setParameter("secondDate", secondDate);
            
            List<Exam> exams = query.getResultList();
            
            ExamsListBean examsListBean = new ExamsListBean();
            exams.forEach(exam -> examsListBean.add(new ExamBean(exam)));
            
            session.setAttribute("examsListBean", examsListBean);
            session.setAttribute("messageBean", null);
            response.sendRedirect("exams.jsp");
        } catch (ParseException e) {
            MessageBean messageBean = new MessageBean("Date format not correct");
            session.setAttribute("messageBean", messageBean);
            response.sendRedirect("index.jsp");
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
