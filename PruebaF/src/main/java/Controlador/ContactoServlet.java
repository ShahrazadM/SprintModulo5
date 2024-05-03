package Controlador;

import java.io.IOException;
import Model.Contacto;
import Model.ContactoRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactoServlet")
public class ContactoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String mensaje = request.getParameter("mensaje");

        Contacto contacto = new Contacto(nombre, email, mensaje);

        ContactoRepository repositorio = new ContactoRepository();
        repositorio.agregarContacto(contacto);

        request.setAttribute("nombre", nombre);
        request.setAttribute("email", email);

        request.getRequestDispatcher("/views/mensajeconfirmacion.jsp").forward(request, response);
    }
}