package um.tds.controlador;

import java.util.List;

import um.tds.dominio.Usuario;
import um.tds.dominio.Video;



public class Controlador {
	
	
	private static Controlador unicaInstancia;
	
	//TODO meter como atributos todos los adaptadores
	//TODO añadir catálogo de videos y de usuarios 
	
	
	//TODO algo como usuario actual?
	
	private Controlador() {
		
		inicialiarAdaptadores();
		inicializarCatálogos();
		
		
	}
	
	public static Controlador getUnicaInstancia() {
		
		// Singelton?¿
		if(unicaInstancia==null)
			unicaInstancia=new Controlador();
		
		return unicaInstancia;
	}
	
	
	public void registrarCliente() {
		
		
	}
	
	
	public void registrarVideo() {
		
		
	}
	
	
	
	
	public void findVideo() {
		//TODO devolver video
		
	}
	
	public void findUser() {
		//TODO devolver usuario
		
	}
	
	
	
	
	
	private void inicialiarAdaptadores() {
		
		
		
	}
	
	
	
	private void inicializarCatálogos() {
		
		
		
	}
	
	
	
	public void removeUsuario() {
		
		
	}
	
	
	public void removeVideo() {
		
		
	}
	
	
	public boolean existeCliente(String dni) {
//		return CatalogoUsuarios.getUnicaInstancia().getCliente(dni) != null;
		return false;
	}
	
	
	
	public List<Usuario> getUsuarios() {
//		return catalogoUsuarios.getUsuarios();
		return null;
	}
	public List<Video> getClientes() {
//		return catalogoVideos.getVideos();
		return null;
	}
	
}
