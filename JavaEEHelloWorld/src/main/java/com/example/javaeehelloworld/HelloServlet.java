p   ackage com.example.javaeehelloworld;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static java.lang.System.out;

@WebServlet(name = "helloServlet", value = "/iguales")
public class HelloServlet extends HttpServlet {
    private String mensaje;

    public void init() {
        mensaje = "Hello World!";
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
        if (parametro1.equals(parametro2)) {
            mensaje = "SON IGUALES";
        } else {
            mensaje = "DIFERENTES";

        }
        out.println("<h1> LOS DOS PARAMETROS RECIBIDOS SON: </h1>");
        out.println("<h1>" + mensaje + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String nombre;
         String apellido1;
         String apellido2;
         int edad = 0;
         String [] a;

        response.setContentType("text/html");
        nombre = request.getParameter("Nombre");
        apellido1 = request.getParameter("Apellido1");
        apellido2 = request.getParameter("Apellido2");
        edad = Integer.parseInt(request.getParameter("Edad"));
        a = request.getParameterValues("aficiones");

        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        mensaje = "Tu Nombre es: </br>" + nombre + " " + apellido1 + " " + apellido2;
        out.println("<h1>" + mensaje + "</h1>");
        for (String aficion : a) {
            out.println("<h1>" + aficion + "<h1>");
        }
        out.println("</body><html>");
    }

    public void destroy() {
    }
}