package um.tds.persistencia;

public final class TDSFactoriaDAO extends FactoriaDAO {

	// instancia concreta para el servidor de persistencia

	public TDSFactoriaDAO() {

	}

	@Override
	public IAdaptadorUsuarioDAO getUsuarioDAO() {

		return AdaptadorUsuario.getUnicaInstancia();

	}

	@Override
	public IAdaptadorVideoDAO getVideoDAO() {

		return AdaptadorVideo.getUnicaInstancia();
	}

	@Override
	public IAdaptadorEtiquetasDAO getEtiquetaDAO() {

		return AdaptadorEtiquetas.getUnicaInstancia();
	}

	@Override
	public IAdaptadorListaVideosDAO getListasDAO() {

		return AdaptadorListas.getUnicaInstancia();

	}

}
