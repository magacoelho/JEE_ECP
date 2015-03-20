package es.votaciones.controllers;



public interface EliminarTemaController extends ListarTodosController {
    public void eliminar(Integer idTema);
    public boolean validarClave(Integer claveBorrado);
}
