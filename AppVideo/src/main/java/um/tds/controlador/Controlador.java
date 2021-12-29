package um.tds.controlador;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import um.tds.dominio.CatalogoEtiquetas;
import um.tds.dominio.CatalogoUsuarios;
import um.tds.dominio.CatalogoVideos;
import um.tds.dominio.Etiqueta;
import um.tds.dominio.ListaVideos;
import um.tds.dominio.Usuario;
import um.tds.dominio.Video;
import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;
import um.tds.persistencia.IAdaptadorEtiquetasDAO;
import um.tds.persistencia.IAdaptadorUsuarioDAO;
import um.tds.persistencia.IAdaptadorVideoDAO;



public class Controlador {
	
	//singleton
	private static Controlador unicaInstancia;
	
	

	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorVideoDAO adaptadorVideo;
	private IAdaptadorEtiquetasDAO adaptadorEtiqueta;
	//TODO private IAdaptadorFiltroDAO adaptadorFiltro;
	//TODO LISTAS?
	
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoVideos catalogoVideos;
	private CatalogoEtiquetas catalogoEtiquetas;
	//TODO LISTAS?
	
	private Usuario usuarioActual;
	
	
	
	
	private Controlador()  {
		
		/*try {
			FactoriaDAO factoria = FactoriaDAO.getInstancia();
		} catch (DAOException e) {
			e.printStackTrace();
		}*/
		

		usuarioActual=null;
		
		inicialiarAdaptadores();
		inicializarCatálogos();
		
		
		
	}
	
	public static Controlador getUnicaInstancia(){
		
		
		if(unicaInstancia==null)
			unicaInstancia=new Controlador();
		
		return unicaInstancia;
	}
	
	
	/* LOGIN */
	
	public Usuario getUsuarioActual() {
		
		return usuarioActual;
	}
	
	
	public boolean loginUsuario(String nombre,String password) {
		
		Usuario us=CatalogoUsuarios.getUnicaInstancia().getUsuario(nombre);
		
		
		if(us!=null && us.checkLogin(password)){
			usuarioActual=us;
			return true;
			
		}
		
		return false;
		
	}
	
	
	public void logoutUsuario() {
		
		usuarioActual=null;
		
	}
	
	
	
	
	/* REGISTER */

	
	public boolean registrarUsuario(String n,String apellidos,String email,boolean prem,String contra,String usu,LocalDate fecha) {
		
		
		
		Usuario u = new Usuario(n, apellidos, email, prem, usu,contra, fecha);
		
	
		if(catalogoUsuarios.getUsuario(usu)!=null) {

			return false;
		}
	
		if(!adaptadorUsuario.addUsuario(u))return false;
		
		
		catalogoUsuarios.addUsuario(u);
		
		return true;
	}
	
	
	public void registrarVideo(String url,String titulo) {
		
		Video v = new Video(url, titulo);

		//si hay etiquetas default ponerlas aqui
		
		adaptadorVideo.addVideo(v);
		catalogoVideos.addVideo(v);
		
		
		
	}
	
	
	
	public void registrarEtiqueta(String e) {
		
		adaptadorEtiqueta.registrarEtiqueta(new Etiqueta("e"));
		catalogoEtiquetas.addEtiqueta(new Etiqueta(e));
		
		
	}
	
	
	/* FIND */
	
	public Video findVideo(Video v) {
		
		return catalogoVideos.getVideo(v.getUrl());
	}
	
	public Usuario findUser(Usuario us) {
		
		return catalogoUsuarios.getUsuario(us.getUsuario());
		
	}
	
	public Etiqueta findEtiqueta(Etiqueta e) {
		
		return catalogoEtiquetas.getEtiqueta(e.getNombre());
	}
	
	/* INICIALIZAR */
	
	private void inicialiarAdaptadores() {
		
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario= factoria.getUsuarioDAO();
		adaptadorVideo = factoria.getVideoDAO();
		adaptadorEtiqueta = factoria.getEtiquetaDAO();
		
		
	}
	

	
	private void inicializarCatálogos() {
		
		catalogoUsuarios = CatalogoUsuarios.getUnicaInstancia();
		catalogoEtiquetas =CatalogoEtiquetas.getUnicaInstancia();
		catalogoVideos= CatalogoVideos.getUnicaInstancia();
		
		
	}
	
	
	
	/* REMOVE */
	
	public void removeUsuario(Usuario u) {
		
		adaptadorUsuario.removeUsuario(u);
		catalogoUsuarios.removeUsuario(u);
		
	}
	
	
	public void removeVideo(Video v) {
		
		adaptadorVideo.removeVideo(v);
		catalogoVideos.removeVideo(v);
		
	}
	
	
	public void removeEtiqueta(Etiqueta e) {
		
		adaptadorEtiqueta.borrarEtiqueta(e);
		catalogoEtiquetas.removeEtiqueta(e);
	}
	
	
	
	
	public void addLista(ListaVideos l) {
		
		
		if(usuarioActual.addLista(l)) {
			
			adaptadorUsuario.modificarUsuario(usuarioActual);
			
		}
		
		
		
	}
	
	public void removeLista(ListaVideos l) {
		
		if(usuarioActual.removeLista(l)) {
			
			adaptadorUsuario.modificarUsuario(usuarioActual);
			
		}
		
	}
	
	
	
	

	/* GET */
	
	
	public List<Usuario> getUsuarios() {
		
		return catalogoUsuarios.getUsuarios();
	}
	public List<Video> getVideos() {

		return catalogoVideos.getVideos();
	}
	
	public List<Etiqueta> getEtiquetas() {

		return catalogoEtiquetas.getEtiquetas();
	}
	
	
	
	//TODO get top 10 SOLO premium
	
	public List<ListaVideos> getListas(){
		
		if(usuarioActual!=null) {
			
			return usuarioActual.getListas();
			
		}
		
		return null;
		
	}
	
	
	public List<Video> getRecientes(){
		
		if(usuarioActual!=null) {
			
			return usuarioActual.getRecientes();
			
		}
		
		return null;
		
	}
	
}
