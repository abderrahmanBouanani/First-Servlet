package com.example;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ex4")
public class Ex4Servelet extends HttpServlet {
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
                    <title>Ex4 Servlet</title>
                </head>
                <body>
                <form method="post" action="ex4">
                    <label for="number1">Entrer un nombre:</label>
                    <input type="number1" id="number1" name="number1" required>
                    <br>
                    
                    <label for="number2">Enter un nombre:</label>
                    <input type="number2" id="number2" name="number2" required>
                    <br>
                    
                    <label for="operation">Choisir une operation:</label>
                    <select id="operation" name="operation" required>
                        <option value="add">Addition</option>
                        <option value="subtract">Soustraction</option>
                        <option value="multiply">Multiplication</option>
                        <option value="divide">Division</option>
                    </select>
                    <br>    
                    <input type="submit" value="Submit">
                </form>
                """;

        resp.getWriter().write(htmlResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        double number1 = Double.parseDouble(req.getParameter("number1"));
        double number2 = Double.parseDouble(req.getParameter("number2"));
        String operation = req.getParameter("operation");
        double result = 0;
        switch (operation) {
            case "add" -> result = number1 + number2;
            case "subtract" -> result = number1 - number2;
            case "multiply" -> result = number1 * number2;
            case "divide" -> {
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    resp.getWriter().write("<h1>Erreur: Division par zéro n'est pas permise.</h1>");
                    return;
                }
            }
        }
        resp.getWriter().write("<h1>Le résultat est: " + result + "</h1>");
        resp.getWriter().write("<a href=\"ex4\">Retour</a></body></html>");
    }
}
