package es.votaciones.controllers;

import java.util.List;

import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.utils.NivelEstudio;

public interface ListarTodosController {

	public abstract List<Tema> todosTemas();

	public abstract List<NivelEstudio> todosNivelesEstudio();

}