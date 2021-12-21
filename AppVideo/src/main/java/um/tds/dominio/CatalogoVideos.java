package um.tds.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;
import um.tds.persistencia.IAdaptadorVideoDAO;

public class CatalogoVideos {

	
	private Map<String,Video> videos; 
	private static CatalogoVideos unicaInstancia = new CatalogoVideos();
	
	private FactoriaDAO dao;
	private IAdaptadorVideoDAO adaptadorVideo;
	
	
	
	private CatalogoVideos() {
			
		try {
  			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
  			adaptadorVideo = dao.getVideoDAO();
  			videos = new HashMap<String,Video>();
  			this.cargarCatalogo();
  		} catch (DAOException eDAO) {
  			eDAO.printStackTrace();
  		}
	}
	
	
	
	//////////////
	
	
	public static CatalogoVideos getUnicaInstancia(){
		return unicaInstancia;
	}
	
	
	public List<Video> getVideos(){
		ArrayList<Video> lista = new ArrayList<Video>();
		for (Video v:videos.values()) 
			lista.add(v);
		return lista;
	}
	
	
	public Video getVideo(String url) {
		for (Video v:videos.values()) {
			if (v.getUrl()==url) return v;
		}
		return null;
	}

	
	
	//////////////////
	
	
	public void addVideo(Video v) {
		videos.put(v.getUrl(),v);
	}
	public void removeVideo(Video v) {
		videos.remove(v.getUrl());
	}
	
	/*Recupera todos los clientes para trabajar con ellos en memoria*/
	private void cargarCatalogo() throws DAOException {
		 List<Video> videosBD = adaptadorVideo.recuperarTodosVideos();
		 for (Video v: videosBD) 
			 videos.put(v.getUrl(),v);
	}
	
	
	
}
