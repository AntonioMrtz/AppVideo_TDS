package um.tds.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.dominio.Etiqueta;
import um.tds.dominio.Video;

public class AdaptadorVideo implements IAdaptadorVideoDAO {
	
	
	private static ServicioPersistencia servPersistencia = null;
	private static AdaptadorVideo unicaInstancia = null;
	
	private static final String VIDEO="Video";
	
	private static final String URL="Url";
	private static final String NUM_REPRO="Num_repro";
	private static final String TITULO="Titulo";
	
	private static final String ETIQUETAS="Etiquetas";
	
	private enum Properties{
		
		URL,NUM_REPRO,TITULO,ETIQUETAS;
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
		
		
		
		return servPersistencia.borrarEntidad(e);
	}

	@Override
	public void modificarVideo(Video v) {


		
		Entidad e = servPersistencia.recuperarEntidad(v.getId());
		
		
		for (Propiedad prop : e.getPropiedades()) {
			if (prop.getNombre().equals(TITULO)) {
				prop.setValor(String.valueOf(v.getTitulo()));
			} else if (prop.getNombre().equals(NUM_REPRO)) {
				prop.setValor(String.valueOf(v.getNumRepro()));
			} else if (prop.getNombre().equals(ETIQUETAS)) {
				
				prop.setValor(String.valueOf(getIdEtiquetas(v.getEtiquetas())));
			}
			servPersistencia.modificarPropiedad(prop);
		}
		
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
			
			
			//servPersistencia.borrarEntidad(e);
			
			Entidad eaux=servPersistencia.recuperarEntidad(e.getId());
			videos.add(buildVideo(eaux));
			
			
		}
		
		
		
		return videos;
		
	}
	
	
	
	// AUXILIARES
	
	public Entidad buildEntity(Video v) {
		
		Entidad e= new Entidad();
		
		e.setNombre(VIDEO);
		
		
		ArrayList<Propiedad> array= new ArrayList<>();
		
		array.add(new Propiedad(TITULO,v.getTitulo()));
		array.add(new Propiedad(NUM_REPRO,Integer.toString(v.getNumRepro())));
		array.add(new Propiedad(URL,v.getUrl()));
		
		
		
		for(Etiqueta et:v.getEtiquetas()) {
			
			try {
				FactoriaDAO.getInstancia().getEtiquetaDAO().registrarEtiqueta(et);
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		array.add(new Propiedad(ETIQUETAS,getIdEtiquetas(v.getEtiquetas())));
		
		

		e.setPropiedades(array);
		
		
		return e;
	}
	
	
	public Video buildVideo(Entidad e) {
		
		if(e==null)return null;
		
		String titulo=servPersistencia.recuperarPropiedadEntidad(e, TITULO);
		String url=servPersistencia.recuperarPropiedadEntidad(e, URL);
		String numrepro=servPersistencia.recuperarPropiedadEntidad(e, NUM_REPRO);
		String etiquetas=servPersistencia.recuperarPropiedadEntidad(e, ETIQUETAS);
		
		Video v = new Video(url, titulo);
		v.setNumRepro(Integer.parseInt(numrepro));
		v.setId(e.getId());
		
		//System.out.println("etiquetas ="+etiquetas);
		v.setEtiquetas(getEtiquetaFromId(etiquetas));
		
		//System.out.println(v.getEtiquetas());
		//ETIQUETAS RECUPERAR BIEN
		
		return v;
	}
	
	
	
	private String getIdEtiquetas(List<Etiqueta> etiquetas) {
		
		String aux="";
		
		for(Etiqueta e:etiquetas) {
			
			aux+=e.getId()+" ";
			
		}
	
		return aux.trim();
	}
	
	
	private List<Etiqueta> getEtiquetaFromId(String etiquetas){
		
		List<Etiqueta> et = new ArrayList<>();
		
		
		StringTokenizer strTok = new StringTokenizer(etiquetas," ");
		
		AdaptadorEtiquetas adaptadorEtiquetas = AdaptadorEtiquetas.getUnicaInstancia();
		
		while(strTok.hasMoreTokens()) {
			
			et.add(adaptadorEtiquetas.findEtiqueta(Integer.valueOf((String) strTok.nextElement())));
		}
		
		return et;
		
	}
	

}
