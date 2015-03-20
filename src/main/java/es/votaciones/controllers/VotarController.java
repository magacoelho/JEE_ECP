package es.votaciones.controllers;

import es.votaciones.persistence.models.entities.Voto;

public interface VotarController extends ListarTodosController {

	public abstract void votar(Voto voto);

}
