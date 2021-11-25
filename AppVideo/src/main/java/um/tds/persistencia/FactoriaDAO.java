package um.tds.persistencia;

public abstract class FactoriaDAO {
	
	private static FactoriaDAO unicaInstancia;

	
	public static final String DAO_TDS = "persistencia.TDSFactoriaDAO";
	
	public static FactoriaDAO getInstancia(String tipo) throws DAOException{
		if (unicaInstancia == null)
			try { unicaInstancia=(FactoriaDAO) Class.forName(tipo).newInstance();
			} catch (Exception e) {	
				throw new DAOException(e.getMessage());
			} 
		return unicaInstancia;
	}
	
	public static FactoriaDAO getInstancia() throws DAOException{
		if (unicaInstancia == null) return getInstancia (FactoriaDAO.DAO_TDS);
				else return unicaInstancia;
	}
	
	
	
	protected FactoriaDAO (){}
	
	public abstract IAdaptadorUsuarioDAO getUsuarioDAO();
	
//TODO	public abstract IAdaptadorVideoDAO getVideoDAO();
	
	
	//Es realmente necesario en etiqueta¿
//TODO	public abstract IAdaptadorEtiquetaDAO getEtiquetaDAO();

	
	
	
}