package es.votaciones.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;

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
	public static Iterator<Voto> transformVoto(String[][] arrayAtributos) {
        List<Voto> result = new ArrayList<Voto>();
        for (int i = 0; i < arrayAtributos.length; i++) {
        	Voto voto = null;
        	if(arrayAtributos!=null){
        		voto= new Voto(Integer.parseInt(arrayAtributos[i][0]),NivelEstudio.BACHILLERATO, arrayAtributos[i][2], null);
        	}
            result.add(voto);
        }
        return result.iterator();
    }

}
