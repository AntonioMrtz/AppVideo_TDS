package um.tds.dominio;

public class FiltroImpopulares extends Filtro {
	
	
	// FILTRA POR MENOS POPULARES DE UN CIERTO NÚMERO DE VISITAS
	
	private final int NUM_VISITAS = 5;
	public static final String FILTRO="um.tds.dominio.FiltroImpopulares" ;

	@Override
	public boolean isVideoOk(Video v) {
		
		return v.getNumRepro()>=NUM_VISITAS;
	}

}
