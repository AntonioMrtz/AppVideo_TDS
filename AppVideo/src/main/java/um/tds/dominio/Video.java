package um.tds.dominio;

import java.util.List;

public class Video {

	// url ,titulo ,num rep
	
	private String url;
	private String titulo;
	//private int numRepro;     // posiblemente esto sea una calculada del servidor
	private List<Etiqueta> etiquetas;
	
	
	public Video(String url,String titulo) {  // no se meten en el constructor las etiquetas , cambiar si necesario
		
		this.url=url;
		this.titulo=titulo;
		
	}
	
	public String getUrl() {
		return url;
	}
	public String getTitulo() {
		return titulo;
	}
	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	
	/*  Se obtiene del servidor
	public int getNumRepro() {
		return numRepro;
	}*/
	
	

	
	public boolean añadirEtiquetas(Etiqueta e) {
		
		// implementar añadir
		return true;
		
	}
	
	
	

	
}