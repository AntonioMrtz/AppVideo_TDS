package um.tds.dominio;

import java.util.ArrayList;
import java.util.List;

public class ListaVideos {
	
	private int id;
	
	private Usuario user;
	private String nombre;
	private List<Video> videos;
	
	
	public ListaVideos(Usuario us,String nom,List<Video> list) {
		
		user=us;
		nombre=nom;
		videos=list;
		
		id=0;
	}
	
	public ListaVideos(Usuario us,String nom) {
		
		this(us,nom,new ArrayList<>());
	}

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Video> getVideos() {
		return videos;
	}
	
	

	
	
	public boolean addVideo(Video v) {
		
		return videos.add(v);
	}
	
	
	public boolean delVideo(Video v) {
		
		return videos.remove(v);
		
		
	}
	

	@Override
	public String toString() {
		return "nombre "+getNombre()+" videos = "+getVideos();
	}
	
}
