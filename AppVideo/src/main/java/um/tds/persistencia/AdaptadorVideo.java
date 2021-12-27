package um.tds.persistencia;

import java.util.ArrayList;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.dominio.Video;

public class AdaptadorVideo implements IAdaptadorVideoDAO {
	
	
	private static ServicioPersistencia servPersistencia = null;
	private static AdaptadorVideo unicaInstancia = null;
	
	private static final String VIDEO="Video";
	
	private static final String URL="Url";
	private static final String NUM_REPRO="Num_repro";
	private static final String TITULO="Titulo";
	
	//private static final String ETIQUETAS="Etiquetas";
	
	private enum Properties{
		
		URL,NUM_REPRO,TITULO;
	}
	
	
	public AdaptadorVideo() {
		
		servPersistencia= FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	public static AdaptadorVideo getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorVideo();
		else
			return unicaInstancia;
		
	}
	
	
	// AUXILIARES
	
	public Entidad buildEntity(Video v) {
		
		Entidad e= new Entidad();
		
		e.setNombre(VIDEO);
		
		
		ArrayList<Propiedad> array= new ArrayList<>();
		
		array.add(new Propiedad(TITULO,v.getTitulo()));
		array.add(new Propiedad(NUM_REPRO,Integer.toString(v.getNumRepro())));
		array.add(new Propiedad(URL,v.getUrl()));

		e.setPropiedades(array);
		
		
		return e;
	}
	
	
	public Video buildVideo(Entidad e) {
		
		if(e==null)return null;
		
		String titulo=servPersistencia.recuperarPropiedadEntidad(e, TITULO);
		String url=servPersistencia.recuperarPropiedadEntidad(e, URL);
		String numrepro=servPersistencia.recuperarPropiedadEntidad(e, NUM_REPRO);

		Video v = new Video(url, titulo);
		v.setNumRepro(Integer.parseInt(numrepro));
		v.setId(e.getId());
		
		
		return v;
	}
	
	
	
	
	
	// METODOS
	
	
	@Override
	public boolean addVideo(Video v) {
		
		Entidad e = null;
		
		try {
			
			e  = servPersistencia.recuperarEntidad(v.getId());
			
		
		} catch (NullPointerException ex) {
			
		
			//existe=false;
		}
		
		if(e!=null)return false;
		
		e=buildEntity(v);
		
		e=servPersistencia.registrarEntidad(e);
		
		v.setId(e.getId());
		
		
		
		return true;

	}

	@Override
	public boolean removeVideo(Video v) {


		Entidad e = servPersistencia.recuperarEntidad(v.getId());
		
		if(e==null)return true;
		
		//TODO BORRAR ETIQUETAS
		
		return servPersistencia.borrarEntidad(e);
	}

	@Override
	public void modificarVideo(Video v) {
		// TODO Auto-generated method stub

	}

	@Override
	public Video findVideo(int id) {


		return buildVideo(servPersistencia.recuperarEntidad(id));

	}

	@Override
	public List<Video> recuperarTodosVideos() {
			
	
		List<Video> videos = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades(VIDEO);
		
		
		for (Entidad e : ent) {
			
			Entidad eaux=servPersistencia.recuperarEntidad(e.getId());
			videos.add(buildVideo(eaux));
			
		}
		
		return videos;
		
	}

}
