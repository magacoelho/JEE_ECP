package es.votaciones.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.votaciones.persistence.models.entities.Tema;

public class ArrayToListTransformer {
	
	public static Iterator<Tema> transform(String[][] arrayAtributos) {
        List<Tema> result = new ArrayList<Tema>();
        for (int i = 0; i < arrayAtributos.length; i++) {
        	Tema tema = null;
        	if(arrayAtributos!=null){
        		tema= new Tema(arrayAtributos[i][0],arrayAtributos[i][1] );
        	}
            result.add(tema);
        }
        return result.iterator();
    }

}
