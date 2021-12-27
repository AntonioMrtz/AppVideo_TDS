package um.tds.dominio;

import java.util.ArrayList;
import java.util.List;

public class Video {

	
	
	private int id;
	private String url;
	private String titulo;
	private int numRepro;     
	private List<Etiqueta> etiquetas;

	
	
	public Video(String url,String titulo) {  // Creado sin etiquetas
		
		this.id=0;
		this.url=url;
		this.titulo=titulo;
		this.numRepro=0;
		
		etiquetas=new ArrayList<Etiqueta>();
	}
	
	
	
	//////////////////
	

	
	
	
	///////////////////
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public int getNumRepro() {
		return numRepro;
	}



	public void setNumRepro(int numRepro) {
		this.numRepro = numRepro;
	}



	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}




	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}



	public void añadirEtiqueta(Etiqueta e) {
		
		
		etiquetas.add(e);
		
		
	}
	
	
	
	public void incrementarRepro() {
		
		numRepro+=1;
		
	}
	
	@Override
	public String toString() {
		
		
		return getTitulo()+" "+getUrl()+" "+getNumRepro()+" "+getEtiquetas();
	}
	

	
}