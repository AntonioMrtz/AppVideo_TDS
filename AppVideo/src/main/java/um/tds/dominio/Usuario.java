package um.tds.dominio;

import java.time.LocalDate;




public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String email;
	private boolean esPremium;
	private String usuario;
	private String password;
	private LocalDate fechaNacimiento;
	
	private Filtro filtroActual;
	
	private int id;
	
	//private List<Videos> listareproduccion;
	
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
		
		
		filtroActual=new FiltroNoFilter(); // establecemos filtro default
	
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
	
	public String getPassword() {
		
		return password;
	}
	
	public Filtro getFiltroActual(){
		
		return filtroActual;
	}
	
	public void setFiltroActual(Filtro f) {
	
		filtroActual=f;
		
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
	
	/*
	public void addVideo(Video v) {
		ventas.add(v);
	}

	public List<ListaVideos> getListasVideos() {
		return ventas;
	}
	*/

	// añadir lista , añadir videos a lista etc

	
	/*--------------------------------------------*/
	
	
	@Override
	public String toString() {
		return getUsuario()+" "+getId();
	}
	
}



