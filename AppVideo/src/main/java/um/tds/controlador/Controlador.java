package um.tds.controlador;

import java.time.LocalDate;
import java.util.List;

import um.tds.dominio.CatalogoEtiquetas;
import um.tds.dominio.CatalogoUsuarios;
import um.tds.dominio.CatalogoVideos;
import um.tds.dominio.Usuario;
import um.tds.dominio.Video;
import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;
import um.tds.persistencia.IAdaptadorEtiquetasDAO;
import um.tds.persistencia.IAdaptadorFiltroDAO;
import um.tds.persistencia.IAdaptadorUsuarioDAO;
import um.tds.persistencia.IAdaptadorVideoDAO;



public class Controlador {
	
	//singleton
	private static Controlador unicaInstancia;
	
	

	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorVideoDAO adaptadorVideo;
	private IAdaptadorEtiquetasDAO adaptadorEtiqueta;
	//TODO private IAdaptadorFiltroDAO adaptadorFiltro;
	
	
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoVideos catalogoVideos;
	private CatalogoEtiquetas catalogoEtiquetas;
	//TODO private CatalogoFiltros catalogoFiltros;
	
	private Usuario usuarioActual;
	
	
	
	
	private Controlador()  {
		
		/*try {
			FactoriaDAO factoria = FactoriaDAO.getInstancia();
		} catch (DAOException e) {
			e.printStackTrace();
		}*/
		

		
		inicialiarAdaptadores();
		inicializarCatálogos();
		
		
	}
	
	public static Controlador getUnicaInstancia(){
		
		
		if(unicaInstancia==null)
			unicaInstancia=new Controlador();
		
		return unicaInstancia;
	}
	
	
	/* LOGIN */
	
	
	public boolean loginUsuario(String nombre,String password) {
		
		Usuario us=CatalogoUsuarios.getUnicaInstancia().getUsuario(nombre);
		
		
		if(us!=null && us.checkLogin(password)){
			usuarioActual=us;
			return true;
			
		}
		
		return false;
		
	}
	
	
	
	
	/* REGISTER */

	
	//TODO METER PARTE SERVIDOR
	public boolean registrarUsuario(String n,String apellidos,String email,boolean prem,String contra,String usu,LocalDate fecha) {
		
		
		
		Usuario u = new Usuario(n, apellidos, email, prem, usu,contra, fecha);
		
	
	
		if(!adaptadorUsuario.addUsuario(u))return false;
		
		
		if(catalogoUsuarios.getUsuario(usu)!=null)return false;
		
		
		catalogoUsuarios.addUsuario(u);
		
		return true;
	}
	
	
	public void registrarVideo(String url,String titulo) {
		
		Video v = new Video(url, titulo);
		adaptadorVideo.addVideo(v);
		catalogoVideos.addVideo(v);
		
		
		
	}
	
	
	/* FIND */
	
	public Video findVideo(Video v) {
		
		return catalogoVideos.getVideo(v.getUrl());
	}
	
	public Usuario findUser(Usuario us) {
		
		return catalogoUsuarios.getUsuario(us.getUsuario());
		
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
		//adaptadorVideo = factoria.getVideoDAO();
		//adaptadorFiltro = factoria.getFiltroDAO();
		//adaptadorEtiqueta = factoria.getEtiquetaDAO();
		
		
	}
	
	
	
	private void inicializarCatálogos() {
		
		catalogoUsuarios = CatalogoUsuarios.getUnicaInstancia();
		//catalogoVideos= CatalogoVideos.getUnicaInstancia();
		//catalogoEtiquetas =CatalogoEtiquetas.getUnicaInstancia();
		//catalogoFiltros=CatalogoFiltros.getUnicaInstancia();
		
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
	
	

	/* GET */
	
	
	public List<Usuario> getUsuarios() {
		
		return catalogoUsuarios.getUsuarios();
	}
	public List<Video> getClientes() {

		return catalogoVideos.getVideos();
	}
	
}
