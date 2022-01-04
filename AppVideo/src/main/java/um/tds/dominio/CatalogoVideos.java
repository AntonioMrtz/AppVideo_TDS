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
			
			
			if (v.getUrl().contentEquals(url)) return v;
		}
		return null;
	}

	
	
	//////////////////
	
	
	public void addVideo(Video v) {
		
		if(!videos.keySet().contains(v.getUrl())) {
			
			videos.put(v.getUrl(),v);
			
		}
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
	
	
	public Collection<Video> filterVideo(Filtro f,String titulo,List<String> e ){
		
		Collection<Video> set = filterFilter(f);
		
		
		set.retainAll(filterTitle(titulo));
		
		if(e!=null)set.retainAll(filterEtiqueta(e));
		
		
		return set;
		
		
	}
	
	public Collection<Video> filterFilter(Filtro f){
		
		HashSet<Video> set = new HashSet<Video>();
		
		for(Video v:videos.values()) {
			
			if(f.isVideoOk(v)) set.add(v);
		}
		
		
		return set;
		
	}
	
	
	public Collection<Video> filterTitle(String s){
		
		HashSet<Video> set = new HashSet<Video>();
		
		for(Video v:videos.values()) {
			
			if(v.getTitulo().contains(s)) {
				
				
				set.add(v);
			}
			
		}
		return set;
		
	}
	
	
	
	public Collection<Video> filterEtiqueta(List<String> e){
		
		HashSet<Video> set = new HashSet<Video>();
		int control=0;
		
		
		for(Video v:videos.values()) {
			
			for(Etiqueta et : v.getEtiquetas()) {
				
				for(String et2:e) {
					
					
					if(et2.equals(et.getNombre())) {
						
						control+=1;
						
					}
					
				}
			}
			
			if(e.size()==control) {
				
				set.add(v);
				
			}
			control=0;
		}
		
		return set;
		
	}
	
	
	public void modifyVideo(Video v) {
		
		videos.replace(v.getUrl(), v);
		
	}
	
	/*Recupera todos los videos para trabajar con ellos en memoria*/
	private void cargarCatalogo() throws DAOException {
		
		 List<Video> videosBD = adaptadorVideo.recuperarTodosVideos();
		 //System.out.println("cat vid"+videosBD);
		 
		 for (Video v: videosBD) 
			 videos.put(v.getUrl(),v);
		 
		 
		 
	}
	
	
	
}
