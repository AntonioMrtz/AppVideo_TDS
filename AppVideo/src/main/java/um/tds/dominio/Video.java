package um.tds.dominio;

import java.util.List;

public class Video {

	// url ,titulo ,num rep
	
	private String url;
	private String titulo;
	private int numRepro;     //TODO TRATAR
	private List<Etiqueta> etiquetas;
	
	private int id;
	
	
	public Video(String url,String titulo) {  // no se meten en el constructor las etiquetas , cambiar si necesario
		
		this.url=url;
		this.titulo=titulo;
		
	}
	
	
	
	//////////////////
	
	public String getUrl() {
		return url;
	}
	public String getTitulo() {
		return titulo;
	}
	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	
	
	public int getNumRepro() {
		return numRepro;
	}
	
	
	private void setId(int i) {
		
		this.id=i;
	}
	
	private int getId() {
		
		
		return this.id;
	}
	
	
	
	///////////////////
	
	
	public void añadirEtiquetas(Etiqueta e) {
		
		
		etiquetas.add(e);
		
	}
	
	
	
	public void incrementarRepro() {
		
		numRepro+=1;
		
	}
	

	
}