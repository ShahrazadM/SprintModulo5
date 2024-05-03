package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CapacitacionDAOImpl;
import Model.Capacitacion;

public class CrearCapacitacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/crearcapacitacion.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int identificador = Integer.parseInt(request.getParameter("identificador"));
            int rutCliente = Integer.parseInt(request.getParameter("rutCliente"));
            String dia = request.getParameter("dia");
            String hora = request.getParameter("hora");
            String lugar = request.getParameter("lugar");
            String duracion = request.getParameter("duracion");
            int cantidadAsistentes = Integer.parseInt(request.getParameter("cantidadAsistentes"));

            Capacitacion nuevaCapacitacion = new Capacitacion(identificador, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);

            CapacitacionDAOImpl capacitacionDAO = new CapacitacionDAOImpl();
            capacitacionDAO.create(nuevaCapacitacion);

            List<Capacitacion> todasLasCapacitaciones = capacitacionDAO.readAll();
            request.setAttribute("capacitaciones", todasLasCapacitaciones);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listarcapacitacion.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Los valores ingresados no son válidos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); 
            request.setAttribute("error", "Se produjo un error al procesar la solicitud");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}