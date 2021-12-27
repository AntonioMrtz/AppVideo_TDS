package um.tds.dominio;

public class FiltroAdultFilter extends Filtro{

	/* Comprueba si una etiqueta del video es Adulto*/
	
	
	@Override
	public boolean isVideoOk(Video v) {
		

		for(Etiqueta e:v.getEtiquetas()) {
			
			
			if(e.getNombre().equals("Adulto"))return false;
		}
		
		return true;
	}

}
