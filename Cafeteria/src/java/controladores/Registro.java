/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.UsuariosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import modelo.Usuario;


/**
 *
 * @author PC
 */
@WebServlet(name = "registro", urlPatterns = {"/registro"})
public class Registro extends HttpServlet {

    private UsuariosDAO usuariosDAO;

    public Registro() {
        super();
        usuariosDAO = new UsuariosDAO();
    }
    
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
        //processRequest(request, response);
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
        
        String usuario = request.getParameter("usuario");
        String email = request.getParameter("email");
        String passwd = request.getParameter("passwd");        
        String ciudad = request.getParameter("ciudad");
        String direccion = request.getParameter("direccion");
        
        usuariosDAO.insert(new Usuario(usuario, email, passwd, ciudad, direccion));
        response.sendRedirect("iniciosesion.html");
    }

}
