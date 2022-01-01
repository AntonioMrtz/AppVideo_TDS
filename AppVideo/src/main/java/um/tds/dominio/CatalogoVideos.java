package um.tds.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;
import um.tds.persistencia.IAdaptadorVideoDAO;

public class CatalogoVideos {

	private static final int NUM_VIDEOS_TOP=10;
	
	
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
	
	Comparator<Video> compareByNumRepro = new Comparator<Video>() {
		@Override
		public int compare(Video o1, Video o2) {
			
			Integer v1 = o1.getNumRepro();
			Integer v2 = o2.getNumRepro();
			
			return v1.compareTo(v2);
			
		}

	};
	
	
	
	public List<Video> getTop10Videos() { //TODO COMPROBAR
		
		ArrayList<Video> aux = new ArrayList<>();
		ArrayList<Video> top10 = new ArrayList<>();
		
		for (Video v : videos.values()) {
			
			aux.add(v);
			
		}
		
		Collections.sort(aux,compareByNumRepro);
		
		int cont=0;
		
		for(Video v :aux) {
			
			if(cont==10) break;
			
			top10.add(v);
			
			cont++;
		}
		
		return top10;
		
	}
	
	
	public Collection<Video> filterVideo(Filtro f,String titulo,Etiqueta e ){
		
		Collection<Video> set = filterFilter(f);
		
		
		set.retainAll(filterTitle(titulo));
		
		if(e!=null)set.retainAll(filterEtiqueta(e));
		
		
		/*set.addAll(filterFilter(f));
		if(titulo!=null)set.addAll(filterTitle(titulo));
		if(e!=null)set.addAll(filterEtiqueta(e));*/
		
		return set;
		
		
	}
	
	public Collection<Video> filterFilter(Filtro f){
		
		HashSet<Video> set = new HashSet();
		
		for(Video v:videos.values()) {
			
			if(f.isVideoOk(v)) set.add(v);
		}
		
		
		return set;
		
	}
	
	
	public Collection<Video> filterTitle(String s){
		
		HashSet<Video> set = new HashSet();
		
		for(Video v:videos.values()) {
			
			if(v.getTitulo().indexOf(s)>=0) set.add(v);
			
		}
			
		return set;
		
	}
	
	
	
	public Collection<Video> filterEtiqueta(Etiqueta e){
		
		HashSet<Video> set = new HashSet();
		
		for(Video v:videos.values()) {
			
			for(Etiqueta et : v.getEtiquetas()) {
				
				if(et.getNombre().equals(e.getNombre()))  set.add(v);
			}
			
		}
			
		return set;
		
	}
	
	
	/*Recupera todos los videos para trabajar con ellos en memoria*/
	private void cargarCatalogo() throws DAOException {
		
		 List<Video> videosBD = adaptadorVideo.recuperarTodosVideos();
		 
		 for (Video v: videosBD) 
			 videos.put(v.getUrl(),v);
		 
	}
	
	
	
}
