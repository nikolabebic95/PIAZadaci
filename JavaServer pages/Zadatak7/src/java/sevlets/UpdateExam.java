/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevlets;

import beans.MessageBean;
import beans.PassedExamBean;
import beans.PassedExamsListBean;
import entities.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
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
public class UpdateExam extends HttpServlet {

    private static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
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
        String studentId = request.getParameter("studentId");
        String examName = request.getParameter("examName");
        String grade = request.getParameter("grade");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zadatak7PU");
        EntityManager em = emf.createEntityManager();
        
        HttpSession session = request.getSession();
        
        try {
            Student student = em.find(Student.class, Integer.parseInt(studentId));
            
            if (student == null) {
                MessageBean messageBean = new MessageBean("Student does not exist");
                session.setAttribute("messageBean", messageBean);
                response.sendRedirect("index.jsp");
            } else {
                em.setFlushMode(FlushModeType.COMMIT);
                em.getTransaction().begin();

                Query query = em.createQuery("SELECT e FROM Exam e WHERE e.name = :name");
                query.setParameter("name", examName);

                Exam exam;
                try {
                    exam = (Exam)query.getSingleResult();
                } catch (NoResultException e) {
                    exam = new Exam();                
                }

                exam.setName(examName);
                exam.setGrade(Integer.parseInt(grade));
                exam.setDate(getToday());
                exam.setStudentId(student);
                em.persist(exam);
                em.getTransaction().commit();

                query = em.createQuery("SELECT e FROM Exam e WHERE e.studentId.id = :id AND e.grade > 5");
                query.setParameter("id", Integer.parseInt(studentId));
                List<Exam> exams = query.getResultList();

                PassedExamsListBean passedExamsListBean = new PassedExamsListBean();

                for (int i = 0; i < exams.size(); i++) {
                    Exam e = exams.get(i);
                    passedExamsListBean.add(new PassedExamBean(e));
                    if (e.getName().equals(examName)) {
                        passedExamsListBean.setAddedIndex(i);
                    }
                }

                session.setAttribute("passedExamsListBean", passedExamsListBean);
                session.setAttribute("messageBean", null);

                response.sendRedirect("show.jsp");
            }
        } catch (NumberFormatException e) {
            MessageBean messageBean = new MessageBean("Number format not correct");
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
