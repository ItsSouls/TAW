package es.uma.taw.calculadora;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String str;
        double op1, op2;
        double resultado = 0;
        char op;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        str = request.getParameter("operando1");
        op1 = Double.parseDouble(str);
        str = request.getParameter("operando2");
        op2 = Double.parseDouble(str);
        str = request.getParameter("operacion");
        op = str.charAt(0);


        switch (op) {
            case '+':
                resultado = op1 + op2;
                break;
            case '-':
                resultado = op1 - op2;
                break;
            case '*':
                resultado = op1 * op2;
                break;
            case '/':
                resultado = op1 / op2;
                break;
            default:
                System.out.println("Ningun operador seleccionado");
        }

        request.setAttribute("result", resultado);

        RequestDispatcher rd = request.getRequestDispatcher("calculadora.jsp");
        rd.forward(request,response);

    }

    public void destroy() {
    }
}