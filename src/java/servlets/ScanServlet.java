/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.ProductCatalogue;
import dao.ProductCatalogueDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Harleen Kaur
 */
public class ScanServlet extends HttpServlet {

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
            out.println("<title>Servlet CashRegister</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CashRegister at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. sets cart null for new customer
     * to start shopping
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<ProductCatalogue> cart = null;
        HttpSession session = request.getSession();
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method. scans item based on code
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = (Connection) request.getServletContext().getAttribute("conn");
        HttpSession session = request.getSession();
        ArrayList<ProductCatalogue> cart = (ArrayList<ProductCatalogue>) session.getAttribute("cart");
        String error = "";
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            error = "Please enter a code to scan. No code entered";
            session.setAttribute("error", error);

            session.setAttribute("cart", cart);

            request.getRequestDispatcher("scan_Result.jsp").forward(request, response);

        }

        if (cart == null) {
            cart = new ArrayList();
        }

        ProductCatalogue prod = ProductCatalogueDAO.getProductByCode(conn, code);
        if (prod == null) {
            error = "The entered item code " + code + "is invalid."
                    + "Enter a valid item code";
        } else {
            cart.add(prod);
            error = "";
        }
        session.setAttribute("error", error);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("scan_Result.jsp").forward(request, response);

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
