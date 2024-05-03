package DAO;

import Model.Usuario;

public interface IUsuarioDAO {
    // Método para crear un usuario en la base de datos
    void create(Usuario usuario);

    // Método para leer un usuario de la base de datos por su identificador
    Usuario read(int id);

    // Método para actualizar un usuario en la base de datos
    void update(Usuario usuario);

    // Método para eliminar un usuario de la base de datos por su identificador
    void delete(int id);
}
