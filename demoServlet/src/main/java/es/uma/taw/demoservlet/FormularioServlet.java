package es.uma.taw.demoservlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="FormularioServlet", urlPatterns={"/ProcesarFormulario"})
public class FormularioServlet extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");        

        String edad = request.getParameter("edad");
        String[] hobbies = request.getParameterValues("hobbies");

        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet que procesa un formulario b&aacute;sico</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + "Hola, " + nombre + " " + apellidos+  ":</h1>");
            out.println("Tu franja de edad es: " + edad + ", y tus hobbies son:");

            out.println("<ul>");
            for (String hobby : hobbies) {
                out.println("<li>" + hobby + "</li>");
            }
            out.println("</ul>");
            out.println("<br/>");
            out.println("Sobre ti has escrito: " + request.getParameter("yo"));
            out.println("<br/>");
            out.println("<br/>");
            out.println("<b>Este formulario ha sido invocado con los siguientes par&aacute;metros GET:</b><br/>");
            out.println(request.getQueryString());

            out.println("</body>");
            out.println("</html>");
            
        } finally { 
            out.close();
        }
    } 

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

}
