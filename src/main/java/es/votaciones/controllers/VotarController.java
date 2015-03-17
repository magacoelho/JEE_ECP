package es.votaciones.controllers;

import java.util.List;

import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;

public interface VotarController {

	public abstract void votar(Voto voto);

	public abstract List<Tema> todosTemas();

}
