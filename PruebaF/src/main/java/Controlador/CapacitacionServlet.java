package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CapacitacionDAOImpl;
import Model.Capacitacion;

@WebServlet("/CapacitacionServlet")
public class CapacitacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CapacitacionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	CapacitacionDAOImpl pDAO = new CapacitacionDAOImpl();
        List<Capacitacion> capacitaciones = pDAO.readAll();

        request.setAttribute("capacitaciones", capacitaciones);
     // Agregar un mensaje de registro para verificar si se obtienen las capacitaciones correctamente
        System.out.println("Capacitaciones obtenidas: " + capacitaciones);

        getServletContext().getRequestDispatcher("/views/listarcapacitacion.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}