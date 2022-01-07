package um.tds.controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import um.tds.Lanzador;
import um.tds.componente.CargadorVideos;
import um.tds.componente.VideoListener;
import um.tds.componente.Videos;
import um.tds.componente.VideosEvent;
import um.tds.dominio.CatalogoEtiquetas;
import um.tds.dominio.CatalogoUsuarios;
import um.tds.dominio.CatalogoVideos;
import um.tds.dominio.Etiqueta;
import um.tds.dominio.ListaVideos;
import um.tds.dominio.Usuario;
import um.tds.dominio.Video;
import um.tds.persistencia.AdaptadorVideo;
import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;
import um.tds.persistencia.IAdaptadorEtiquetasDAO;
import um.tds.persistencia.IAdaptadorListaVideosDAO;
import um.tds.persistencia.IAdaptadorUsuarioDAO;
import um.tds.persistencia.IAdaptadorVideoDAO;




public class Controlador implements VideoListener{
	
	
	//Patron singleton para tener un solo controlador
	private static Controlador unicaInstancia;
	
	// Adaptadores correspondientes para acceder a las diferentes entidades del servidor

	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorVideoDAO adaptadorVideo;
	private IAdaptadorEtiquetasDAO adaptadorEtiqueta;
	private  IAdaptadorListaVideosDAO adaptadorListaVideo;

	// Catálogos locales
	
	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoVideos catalogoVideos;
	private CatalogoEtiquetas catalogoEtiquetas;

	
	private Usuario usuarioActual;
	
	
	
	private CargadorVideos cargadorVideos;

	
	
	private Controlador()  { // Cargamos datos del servidor e inicializamos adaptadores
	
		

		usuarioActual=null;
		
		inicialiarAdaptadores();
		inicializarCatálogos();
		
		cargadorVideos = CargadorVideos.getUnicaInstancia();
		cargadorVideos.attach(this); // añadimos el controlador como unico listener
		
	}
	
	public static Controlador getUnicaInstancia(){
		
		
		if(unicaInstancia==null)
			unicaInstancia=new Controlador();
		
		return unicaInstancia;
	}
	
	
	/* REPRODUCTOR VIDEO */
	
	
	public void playVideo(Video v) { // Unificacion para reproducir video y contar reproducciones
		
		Lanzador.videoWeb.playVideo(v.getUrl());
		v.incrementarRepro();
		adaptadorVideo.modificarVideo(v);
		
		usuarioActual.addVideoHistorial(v);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		
		
		
	}
	
	public void playVideo(String s) { // Igual que el anterior pero solo con url
		
		Video v = findVideo(s);
		v.incrementarRepro();
		
		Lanzador.videoWeb.playVideo(v.getUrl());
		adaptadorVideo.modificarVideo(v);
		
		usuarioActual.addVideoHistorial(v);
		adaptadorUsuario.modificarUsuario(usuarioActual);
		
		
	}
	
	public void stopVideo() {
		
		Lanzador.videoWeb.cancel();
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
		
		usuarioActual=u;		// NADA MAS REGISTRAR YA SE INICIA SESION
		
		return true;
	}
	
	
	public Video registrarVideo(String url,String titulo) {
		
		Video v = new Video(url, titulo);

		//si hay etiquetas default ponerlas aqui
		
		adaptadorVideo.addVideo(v);
		catalogoVideos.addVideo(v);
		
		return v;
		
	}

	public void registrarListaVideos(String nombre,List<Video> videos) {  // Realiza tambien la funcion de actualizar la lista
		
		
		if(usuarioActual.addLista(nombre,videos)) {
			
			adaptadorUsuario.modificarUsuario(usuarioActual);
			
		}
		
		
	}
	
	public Etiqueta registrarEtiqueta(String e) {
		
		Etiqueta et=new Etiqueta(e);
		
		adaptadorEtiqueta.registrarEtiqueta(et);
		catalogoEtiquetas.addEtiqueta(et);
		
		return et;
		
		
	}
	
	
	
	/* FIND */
	
	public Video findVideo(Video v) {
		
		return catalogoVideos.getVideo(v.getUrl());
	}
	
	public Video findVideo(String url) {
		
		return catalogoVideos.getVideo(url);
		
	}
	
	public Usuario findUser(Usuario us) {
		
		return catalogoUsuarios.getUsuario(us.getUsuario());
		
	}
	
	public Etiqueta findEtiqueta(Etiqueta e) {
		
		return catalogoEtiquetas.getEtiqueta(e.getNombre());
	}
	
	public ListaVideos findLista(String s) {
		
		
		for(ListaVideos l:usuarioActual.getListas()) {
			
			if (l.getNombre().equals(s)) return l;
		}
		return null;
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
	
	
	

	public boolean removeLista(ListaVideos l) {
		
		if(usuarioActual.removeLista(l)) {
			
			adaptadorUsuario.modificarUsuario(usuarioActual);
			
			return true;
		}
		
		return false;
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
	
	
	
	
	public List<Video> getTop10(){
		
		
		return catalogoVideos.getTop10Videos();
	}
	
	
	
	public List<ListaVideos> getListas(){ // Obtenemos todas las listas para el usuario
		
		if(usuarioActual!=null) {
			
			return usuarioActual.getListas();
			
		}
		
		return null;
		
	}
	
	public List<Video> getLista(String s){
		
		for(ListaVideos l : usuarioActual.getListas()) {
			
			if (l.getNombre().equals(s)) {
				
				return l.getVideos();
			}
			
		}
		
		return null;
		
	}
	
	
	public List<Video> getRecientes(){ // Devuelve historial
		
		if(usuarioActual!=null) {
			
			return usuarioActual.getRecientes();
			
		}
		
		return null;
		
	}
	
	public void modifyUser(Usuario us) {
		
		adaptadorUsuario.modificarUsuario(us);
	}

	
	/*				CARGADOR VIDEOS			*/
	
	//Cargamos los videos en el servidor y catalogo local
	
	@Override
	public void enteradoCambios(EventObject e) {
		

		if (e instanceof VideosEvent) {
			
			try {
				AdaptadorVideo adaptadorVideo = (AdaptadorVideo) FactoriaDAO.getInstancia().getVideoDAO();
			} catch (DAOException e1) {
				
				e1.printStackTrace();
			} ///CUIDADIN ? casteo
		
			
			
			for (Video v : getVideosFromXml(((VideosEvent) e).getVideos())) {
				
				adaptadorVideo.addVideo(v);
				catalogoVideos.addVideo(v);
				

				
			}
		}
		
	}
	
	
	public static List<Video> getVideosFromXml(Videos videos){
		
		List<Video> l = new LinkedList<>();
		for (um.tds.componente.Video v : videos.getVideo()) {
			
			
			Video vid = new Video(v.getURL(),v.getTitulo() );
			vid.addEtiquetasString(v.getEtiqueta());
			l.add(vid);
			
		}
		
		return l;
		
	}
	
	
	public boolean getVideosFromXml(String xml) {
		
		return cargadorVideos.setFileVideo(xml);
	}
	
	
	
	public Collection<Video> filterVideo(String titulo,List<String> e) {
		
		return CatalogoVideos.getUnicaInstancia().filterVideo(usuarioActual.getFiltroActual(),titulo,e);
		
		
	}
	
	public void addEtiquetaVideo(Video v,String et) {
		
		
		registrarEtiqueta(et);
		

		v.addEtiqueta(findEtiqueta(new Etiqueta(et)));
		
		
		catalogoVideos.modifyVideo(v);
		adaptadorVideo.modificarVideo(v);
		
	}
	
	
	public void generarPdf() throws DocumentException, IOException {
		
		 if(Controlador.getUnicaInstancia().getUsuarioActual()!=null) {
			   
			   
			 Document doc = new Document();
			
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("AppVideo-pdf.pdf"));
			
			   
			  doc.open();
			  
			  
			  Image logo = Image.getInstance("src/main/java/recursos/AppVideo (1).png");
			  
			  doc.add(logo);
			  
			  for(ListaVideos l:usuarioActual.getListas()) {
				  
				  
				  doc.add(new Paragraph(l.getNombre().toUpperCase()));
				  doc.add(new Paragraph(" "));
				  
				  for(Video v:l.getVideos()) {
					  
					  
					  doc.add(new Paragraph("    "+v.getTitulo()));
					  
				  }
				  
				  
				  
				  doc.add(new Paragraph(" "));
			  }
			  
			  doc.close();
			  
		 }
	
	}
	
	
	
}
