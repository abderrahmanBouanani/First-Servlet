package com.example;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ex2")
public class Ex2Servlet extends HttpServlet {
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
                    <title>Ex2 Servlet</title>
                </head>
                <body>
                <form method="post" action="ex2">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required>
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
        String htmlResponse = """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Ex2 Servlet - Response</title>
                </head>
                <body>
                """;
        if (username != null && !username.trim().isEmpty()) {
            htmlResponse += "<h1>Hello, " + username + "!</h1>";
        } else {
            htmlResponse += "<h1>No username provided!</h1>";
        }
        htmlResponse += "<a href=\"ex2\">Retour</a></body></html>";

        resp.getWriter().write(htmlResponse);
    }
}