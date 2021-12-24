package um.tds.persistencia;

public final class TDSFactoriaDAO extends FactoriaDAO{
	
	// instancia concreta para el servidor de persistencia
	
	public  TDSFactoriaDAO() {
		
	}

	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {
		
		//return AdaptadorUsuario.getUnicaInstancia();
		return null;
	}

	@Override
	public IAdaptadorVideoDAO getVideoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAdaptadorEtiquetasDAO getEtiquetaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAdaptadorFiltroDAO getFiltroDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
