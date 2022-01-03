package um.tds.dominio;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import um.tds.controlador.Controlador;
import um.tds.persistencia.AdaptadorUsuario;
import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;
import um.tds.persistencia.IAdaptadorListaVideosDAO;




public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String email;
	private boolean esPremium;
	private String usuario;
	private String password;
	private LocalDate fechaNacimiento;

	private final int NUM_RECIENTES=5;
	
	private Filtro filtroActual;
	
	private int id;
	
	private LinkedList<Video> recientes;
	private List<ListaVideos> listas;
	
	private static IAdaptadorListaVideosDAO adaptadorListaVideosDAO=null;
	
	
	
	//TODO listas de reproduccion de videos
	//TODO lista de videos recientes
	//TODO lista top 10 ! solo PREMIUM
	//TODO Filtro ! solo PREMIUM

	public Usuario(String nombre,String apellidos, String email,boolean premium,String user,String contraseña,LocalDate fecha) {  // se crean los usuarios como no premium , cambiar si necesario

		this.nombre=nombre;
		this.email=email;
		this.esPremium=premium;
		this.password=contraseña;
		this.apellidos=apellidos;
		this.fechaNacimiento=fecha;
		this.usuario=user;
		this.id=0;
		
		recientes= new LinkedList<Video>();
		listas= new ArrayList<ListaVideos>();
		filtroActual=new FiltroNoFilter(); // establecemos filtro default
		
		
		if(adaptadorListaVideosDAO==null) {
			
			try {
				adaptadorListaVideosDAO=FactoriaDAO.getInstancia().getListasDAO();
			} catch (DAOException e) {
				e.printStackTrace();
			}
			
		}
		
	
	}
	
	
	/*--------------------------------------------*/

	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public boolean isPremium() {
		return esPremium;
	}
	
	public void becomePremium(){
		
		esPremium=true;
	}
	public LocalDate getFechaNacimiento() {
		
		
		return fechaNacimiento;
	}
	
	public String getUsuario() {
		
		return usuario;
	}
	
	public LinkedList<Video> getRecientes() {
		return recientes;
	}


	public void setRecientes(List<Video> historial) {
		
		this.recientes = new LinkedList<Video>(historial);
	}


	public List<ListaVideos> getListas() {
		return listas;
	}


	public void setListas(List<ListaVideos> listas) {
		this.listas = listas;
	}


	public String getPassword() {
		
		return password;
	}
	
	public Filtro getFiltroActual(){
		
		return filtroActual;
	}
	
	public void setFiltroActual(Filtro f) {
	
		if(esPremium) {
			
			filtroActual=f;
			
		}
		
	}
	
	

	public boolean checkLogin(String password) {
		
		
		return password.equals(password);
	}
	
	public void setId(int i) {
		
		this.id=i;
	}
	
	public int getId() {
		
		
		return this.id;
	}
	
	
	
	/*--------------------------------------------*/
	
	public boolean addLista(String nombre,List<Video> videos) {
		
		
		if(actualizarListaVideos(nombre, videos)) return false; // se ha actualizado , no hace falta crear otra
		
		ListaVideos l = new ListaVideos(this,nombre,videos);
		listas.add(l);
		
		try {
			FactoriaDAO.getInstancia().getListasDAO().registrarListaVideos(l);
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		
		AdaptadorUsuario.getUnicaInstancia().modificarUsuario(Controlador.getUnicaInstancia().getUsuarioActual());
		
		return true;
		
	}
	
	public boolean removeLista(ListaVideos l) {
		
		if(!listas.remove(l))	return false;
		return adaptadorListaVideosDAO.borrarListaVideo(l);
			
	}
		
	
	
	
	public void addVideoHistorial(Video v) {
		
		if(recientes.size()>=NUM_RECIENTES) {
			
			recientes.removeLast();
		}
		
		recientes.addFirst(v);
	}
	

	public boolean actualizarListaVideos(String nombre, List<Video> videos) {
		
		for (ListaVideos l: listas)
			if (l.getNombre().equals(nombre)) {
				
				l.setVideos(videos);
				
				adaptadorListaVideosDAO.modificarListaVideos(l);
				return true;
			}
	
		return false;
	}
	
	
	

	
	/*--------------------------------------------*/
	
	
	//TODO FILTRAR
	
	
	/*--------------------------------------------*/
	
	
	@Override
	public String toString() {
		return getUsuario()+" "+getId()+" "+getListas();
	}
	
}



