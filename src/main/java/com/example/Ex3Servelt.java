package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;

@WebServlet("/ex3")
public class Ex3Servelt extends HttpServlet {
    private HashSet<String> utilisateurs = new HashSet<>();

    public void init() {
        utilisateurs.add("Alice::password123");
        utilisateurs.add("Bob::securePass");
        utilisateurs.add("Charlie::charlie2024");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String htmlResponse = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Ex3 Servlet</title>
                </head>
                <body>
                <form method="post" action="ex3">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required>
                    <br>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                    <br>
                    <input type="submit" value="Submit">
                </form>
                """;
        resp.getWriter().write(htmlResponse);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String credential = username + ":" + password;
        if(utilisateurs.contains(credential)){
            resp.getWriter().write("<h1>Bienvenue " + username + "!</h1>");
        } else {
            resp.getWriter().write("<h1>Nom d'utilisateur ou mot de passe incorrect.</h1>");
        }
        resp.getWriter().write("<a href=\"ex3\">Retour</a></body></html>");


    }
}
