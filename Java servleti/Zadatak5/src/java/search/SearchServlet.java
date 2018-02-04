/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikola
 */
public class SearchServlet extends HttpServlet {

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
        
        String browser = request.getParameter("browser");
        String term = request.getParameter("term");
        String redirectURL;
        
        switch (browser) {
            case "Google":
                redirectURL = encodeGoogle(term);
                break;
            case "Bing":
                redirectURL = encodeBing(term);
                break;
            default:
                redirectURL = encodeYahoo(term);
                break;
        }
        
        response.sendRedirect(redirectURL);
    }

    private String encodeGoogle(String param) {
        try {
            return "http://www.google.com/search?q=" + URLEncoder.encode(param, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return "http://www.google.com/search?q=" + param;
        }
    }
    
    private String encodeBing(String param) {
        try {
            return "http://www.bing.com/search?q=" + URLEncoder.encode(param, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return "http://www.bing.com/search?q=" + param;
        }
    }
    
    private String encodeYahoo(String param) {
        try {
            return "http://search.yahoo.com/bin/search?q=" + URLEncoder.encode(param, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return "http://search.yahoo.com/bin/search?q=" + param;
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
