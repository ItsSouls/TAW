package com.example.demo1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/iguales")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String parametro1, parametro2;
        String mensaje;

        parametro1 = request.getParameter("param1");
        parametro2 = request.getParameter("param2");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(parametro1.equals(parametro2)){
            mensaje = "SON IGUALES";
        }else{
            mensaje = "DIFERENTES";
        }
        out.println("<h1>" + "Los dos parametros recibidos son" + "</h1>");
        out.println("<h1>" + mensaje + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}