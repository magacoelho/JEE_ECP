package es.votaciones.controllers;

import java.util.List;

import es.votaciones.persistence.models.utils.MediaPorNivel;
import es.votaciones.persistence.models.utils.VotosPorTema;

public interface VerVotacionesController extends ListarTodosController{
    public List<VotosPorTema> votosPorTema();
    public List<MediaPorNivel> mediaPorNivel();
}
