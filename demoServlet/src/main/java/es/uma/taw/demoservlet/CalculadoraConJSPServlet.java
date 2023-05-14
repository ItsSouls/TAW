package es.uma.taw.demoservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CalculadoraConJSPServlet", value = "/CalculadoraConJSP")
public class CalculadoraConJSPServlet extends HttpServlet {
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

        request.setAttribute("result", resultado);

        RequestDispatcher rd = request.getRequestDispatcher("calculadora.jsp");
        rd.forward(request, response);
    }


}
