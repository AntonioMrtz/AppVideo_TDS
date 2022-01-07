package um.tds.dominio;

public class FiltroNoFilter extends Filtro {

	// SIEMPRE DEVUELVE VERDADERO

	public static final String FILTRO = "um.tds.dominio.FiltroNoFilter";

	@Override
	public boolean isVideoOk(Video v) {

		return true;

	}

	@Override
	public String toString() {
		return FILTRO;
	}

}
