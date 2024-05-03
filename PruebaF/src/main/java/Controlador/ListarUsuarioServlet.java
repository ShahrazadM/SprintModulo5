package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Cliente;
import Model.Profesional;
import Model.Administrativo;

@WebServlet("/ListarUsuarioServlet")
public class ListarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Listar Usuarios</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Listar Usuarios</h2>");
        out.println("<form action='ListarUsuarioServlet' method='post'>");
        out.println("<label>Seleccione el tipo de usuario:</label>");
        out.println("<select name='tipoUsuario'>");
        out.println("<option value='cliente'>Cliente</option>");
        out.println("<option value='profesional'>Profesional</option>");
        out.println("<option value='administrativo'>Administrativo</option>");
        out.println("</select>");
        out.println("<input type='submit' value='Listar'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoUsuario = request.getParameter("tipoUsuario");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (tipoUsuario.equals("cliente")) {
            Cliente[] clientes = Cliente.getClientes();
            out.println("<h2>Clientes</h2>");
            for (Cliente cliente : clientes) {
                out.println(cliente.toString() + "<br>");
            }
        } else if (tipoUsuario.equals("profesional")) {
            Profesional[] profesionales = Profesional.getProfesionales();
            out.println("<h2>Profesionales</h2>");
            for (Profesional profesional : profesionales) {
                out.println(profesional.toString() + "<br>");
            }
        } else if (tipoUsuario.equals("administrativo")) {
            Administrativo[] administrativos = Administrativo.getAdministrativos();
            out.println("<h2>Administrativos</h2>");
            for (Administrativo administrativo : administrativos) {
                out.println(administrativo.toString() + "<br>");
            }
        } else {
            out.println("<h2>Tipo de usuario no válido</h2>");
        }
    }
}