package um.tds.dominio;

public class FiltroMisListasFilter extends Filtro{

	public static final String FILTRO="um.tds.dominio.FiltroMisListasFilter" ;
	
	@Override
	public boolean isVideoOk(Video v) {

		//TODO implementar
			
		return false;
	}

	@Override
	public String toString() {
		return FILTRO;
	}
}
