package es.votaciones.controllers;

import es.votaciones.persistence.models.entities.Tema;

public interface EliminarTemaController extends ListarTodosController {
    public void eliminar(Tema tema);
}
