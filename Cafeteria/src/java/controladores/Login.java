/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.UsuariosDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import modelo.Usuario;
//import com.google.gson.Gson;

/**
 *
 * @author PC
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    
    private UsuariosDAO usuariosDAO;

    public Login() {
        super();
        usuariosDAO = new UsuariosDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String usuario = "";
        
        HttpSession sesion = request.getSession(false);
        if(sesion != null && sesion.getAttribute("usuario") != null){
            usuario = (String)sesion.getAttribute("usuario");
        }
        
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(usuario);
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
        
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
          sb.append(line);
        }
        String jsonData = sb.toString();
        System.out.println(jsonData);
        
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
        
        String usuario = jsonObject.get("usuario").getAsString();
        String passwd = jsonObject.get("contrasena").getAsString();
        
        
        boolean loginSuccessful = true;
        String loginMessage = "";
        
        Usuario user = usuariosDAO.getByUserName(usuario);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        if(user != null){
            if(user.getContraseña().equals(passwd)){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("usuario", usuario);
                loginMessage = "Usuario logueado correctamente";
            }
            else{
                loginSuccessful = false;
                loginMessage = "La contraseña es incorrecta!";
            }
        }
        else{
            loginSuccessful = false;
            loginMessage = "El usuario no existe!";
        }
        
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("loginSuccessful", loginSuccessful);
        jsonResponse.addProperty("loginMessage", loginMessage);
        String jsonString = new Gson().toJson(jsonResponse);
        response.getWriter().write(jsonString);
    }

}
