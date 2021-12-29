package um.tds.persistencia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.dominio.Etiqueta;
import um.tds.dominio.ListaVideos;
import um.tds.dominio.Usuario;
import um.tds.dominio.Video;

public class AdaptadorListas implements IAdaptadorListaVideosDAO {
	
	private static ServicioPersistencia servPersistencia = null;
	private static AdaptadorListas unicaInstancia = null;
	
	private static final String LISTA="Lista";
	
	private static final String NOMBRE="Nombre";
	private static final String USUARIO="Usuario";
	private static final String VIDEOS="Videos";
	
	
	private enum Properties{
		
		NOMBRE,USUARIO,VIDEOS;
	}
	
	
	public AdaptadorListas() {

		
		servPersistencia= FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		
	}
	
	public static AdaptadorListas getUnicaInstancia() {
		
		if (unicaInstancia == null)
			return new AdaptadorListas();
		else
			return unicaInstancia;
		
	}
	
	
	//METODOS

	@Override
	public boolean registrarListaVideos(ListaVideos l) {


		Entidad e = null;
		
		try {
			
			e  = servPersistencia.recuperarEntidad(l.getId());
			
		
		} catch (NullPointerException ex) {
			
		
			//existe=false;
		}
		
		if(e!=null)return false;
		
		
		
		e=buildEntidad(l);
		

		
		e=servPersistencia.registrarEntidad(e);
		
		l.setId(e.getId());
		
		
		return true;
		
	}

	@Override
	public boolean borrarListaVideo(ListaVideos l) {
		
		Entidad e = servPersistencia.recuperarEntidad(l.getId());
		
		if(e==null)return true;
		
		
		
		return servPersistencia.borrarEntidad(e);
		
		
	}

	@Override
	public void modificarListaVideos(ListaVideos l) {


		Entidad e = servPersistencia.recuperarEntidad(l.getId());
		
		
		servPersistencia.eliminarPropiedadEntidad(e, NOMBRE);
		servPersistencia.anadirPropiedadEntidad(e, NOMBRE,l.getNombre());
		
		servPersistencia.eliminarPropiedadEntidad(e, USUARIO);
		servPersistencia.anadirPropiedadEntidad(e, USUARIO,Integer.toString(l.getUser().getId()));
		
		servPersistencia.eliminarPropiedadEntidad(e, VIDEOS);
		servPersistencia.anadirPropiedadEntidad(e, VIDEOS,getIdVideos(l.getVideos()));
		
		
		
	}

	@Override
	public ListaVideos recuperarListaVideos(int id) {
		
		return buildLista(servPersistencia.recuperarEntidad(id));
	}

	@Override
	public List<ListaVideos> recuperarTodasListaVideos() {

		List<ListaVideos> listas = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades(LISTA);
		
		
		
		for (Entidad e : ent) {
			
			// servPersistencia.borrarEntidad(e);
			
			Entidad eaux=servPersistencia.recuperarEntidad(e.getId());
			listas.add(buildLista(eaux));
			
			
		}

		
		return listas;
		
	}
	
	
	
	// AUXILIARES
	
	private ListaVideos buildLista(Entidad e) {
		
		
		if(e==null) return null;
		
		
		Usuario u=AdaptadorUsuario.getUnicaInstancia().findUsuario(Integer.parseInt(servPersistencia.recuperarPropiedadEntidad(e, USUARIO)));
		String nombre=servPersistencia.recuperarPropiedadEntidad(e, NOMBRE);
		
		
		
		ListaVideos l= new ListaVideos(u, nombre);
		l.setId(e.getId());
		
		l.setVideos(getVideoFromId(servPersistencia.recuperarPropiedadEntidad(e, VIDEOS)));
		
		
		
		return l;
	}
	
	
	private Entidad buildEntidad(ListaVideos l) {
		
		Entidad e= new Entidad();
		
		e.setNombre(LISTA);
		
		ArrayList<Propiedad> array= new ArrayList<>();
		
		array.add(new Propiedad(NOMBRE,l.getNombre()));
		array.add(new Propiedad(USUARIO,String.valueOf(l.getUser().getId())));
		array.add(new Propiedad(VIDEOS,getIdVideos(l.getVideos())));
		
		e.setPropiedades(array);	
		
		return e;
	}

	
	
	public List<Video> getVideoFromId(String videos){
		
		List<Video> v = new ArrayList<>();
		
		
		StringTokenizer strTok = new StringTokenizer(videos," ");
		
		AdaptadorVideo adaptadorVideo = AdaptadorVideo.getUnicaInstancia();
		
		while(strTok.hasMoreTokens()) {
			
			v.add(adaptadorVideo.findVideo(Integer.valueOf((String) strTok.nextElement())));
		}
		
		return v;
		
	}


public String getIdVideos(List<Video> videos) {
	
	String aux="";
	
	for(Video v:videos) {
		
		aux+=v.getId()+" ";
		
	}

	return aux.trim();
}

}
