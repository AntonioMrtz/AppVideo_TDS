package um.tds.dominio;

import um.tds.controlador.Controlador;

public class FiltroMisListasFilter extends Filtro{

	
	// SI EL VIDEO ESTA EN UNA LISTA DEL USUARIO DEVUELVE VERDADERO
	
	
	public static final String FILTRO="um.tds.dominio.FiltroMisListasFilter" ;
	
	@Override
	public boolean isVideoOk(Video v) {

		return Controlador.getUnicaInstancia().getListas().stream()
				.flatMap(l-> l.getVideos().stream())
				.anyMatch(video-> video.getTitulo().equals(v.getTitulo()));
	}

	
	@Override
	public String toString() {
		return FILTRO;
	}
}
