package es.votaciones.persistence.models.daos.jpa.data;

import java.util.Iterator;

import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.utils.ArrayToListTransformer;



public class TemaDaoJpaTestData {
	
	
	public static final String [][] TEMAS ={{"DEPORTES","Actuación Michael Phelps en los Olimpicos 2002"}
	   , {"COCINA","Receta Tortilla de patata con morcillas de Burgos"},{"OCIO","Limpieza de las playas en Alicante"}
		,{"CIENCIA","Impacto del Bioelementos en el ecosistema"}};

   

    //Tema
    private Iterator<Tema> temasIterator;

    private Tema tema;

    private int numTemas = 0;
    
    public String message(){
    	
    	return "Tema --> "+ numTemas+" Tema :" +tema;
    }
    
    public TemaDaoJpaTestData() {
		temasIterator= ArrayToListTransformer.transform(TEMAS);
		this.nextTema();
		
	}
    
	private void nextTema() {
		numTemas++;
		tema= temasIterator.next();
	}
    
	
}
