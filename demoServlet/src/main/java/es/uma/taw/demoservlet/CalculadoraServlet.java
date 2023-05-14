package es.uma.taw.demoservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculadoraServlet", value = "/Calcula")
public class CalculadoraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.procesar(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.procesar(request, response);
    }

    protected void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String str;
        double op1, op2, resultado = 0.0;
        char operacion;
        str = request.getParameter("op1");
        op1 = Double.parseDouble(str);

        str = request.getParameter("op2");
        op2 = Double.parseDouble(str);

        str = request.getParameter("operacion");
        operacion = str.charAt(0);

        switch (operacion) {
            case '+':
                resultado = op1+op2;
                break;
            case '-':
                resultado = op1-op2;
                break;
            case '*':
                resultado = op1*op2;
                break;
            case '/':
                resultado = op1/op2;
        }

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet que procesa un formulario b&aacute;sico</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> El resultado de la operación es: " + resultado + "</h1>");

            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }


    }


}
