package com.example;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
// Annotation pour lier l'URL "/hello" à cette servlet
@WebServlet("/ex1")
public class Ex1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>Informations Personnelles\n</h1>");
        resp.getWriter().write("<h2>Nom : BOUANANI</h2>");
        resp.getWriter().write("<h2>Filiere : DLA 2</h2>");
    }
}