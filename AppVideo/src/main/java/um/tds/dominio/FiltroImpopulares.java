package um.tds.dominio;

public class FiltroImpopulares extends Filtro {
	
	private int visitas = 5;
	public static final String FILTRO="um.tds.dominio.FiltroImpopulares" ;

	@Override
	public boolean isVideoOk(Video v) {
		
		return v.getNumRepro()>=visitas;
	}

}
