package um.tds.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;
import um.tds.persistencia.IAdaptadorEtiquetasDAO;


public class CatalogoEtiquetas {
	
	private Map<String,Etiqueta> etiquetas; 
	private static CatalogoEtiquetas unicaInstancia = new CatalogoEtiquetas();
	
	private FactoriaDAO dao;
	private IAdaptadorEtiquetasDAO adaptadorEtiquetasDAO;
	
	private CatalogoEtiquetas() {
		
		
		
	}
	
	
	public static CatalogoEtiquetas getUnicaInstancia() {
		
		return unicaInstancia;
	}
	
	public List<Etiqueta> getEtiquetas(){
		ArrayList<Etiqueta> lista = new ArrayList<Etiqueta>();
		for (Etiqueta e:etiquetas.values()) 
			lista.add(e);
		return lista;
	}
	
	
	public Etiqueta getEtiqueta(String et) {
		for (Etiqueta e:etiquetas.values()) {
			if (e.getEtiqueta()==et) return e;
		}
		return null;
	}
	
	
	public void addEtiqueta(Etiqueta e) {
		etiquetas.put(e.getEtiqueta(),e);
	}
	
	public void removeEtiqueta(Etiqueta u) {
		etiquetas.remove(u.getEtiqueta());
	}
	
	private void cargarCatalogo() throws DAOException {
		
		 List<Etiqueta> etiquet = adaptadorEtiquetasDAO.recuperarTodasEtiquetas();
		 for (Etiqueta e: etiquet) 
			 etiquetas.put(e.getEtiqueta(),e);
	}
	
	
}
