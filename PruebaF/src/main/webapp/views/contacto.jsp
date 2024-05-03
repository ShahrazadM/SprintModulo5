<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="mimenu.jsp" %> <!-- Incluye el menú -->
<title>FormularioContacto</title>
</head>
<body>

    <h1>Formulario de Contacto</h1>
    <form method="post" action="ContactoServlet" onsubmit="return validarFormulario();">
        Nombre: <input type="text" id="nombre" name="nombre"><br>
        Email: <input type="email" name="email"><br>
        Mensaje: <textarea name="mensaje"></textarea><br>
        <input type="submit" value="Enviar">
    </form>
   <script>
function validarFormulario() {
    var nombre = document.getElementById("nombre").value;
    var detalle = document.getElementById("detalle").value;
    // Validación de campos
    if (nombre.trim() === "" || detalle.trim() === "") {
        alert("Por favor, complete todos los campos.");
        return false;
    }
    return true;
}
</script>
</body>
</html>