package um.tds.dominio;

import java.time.LocalDate;
import java.util.Date;


//! PARA REGISTRAR USUARIOS EL NOMBRE TIENE QUE SER UNICO , ACTUA COMO CODIGO

public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String email;
	private boolean esPremium;
	private String contraseña;
	private String usuario;
	private LocalDate fechaNacimiento;
	private int id;
	
	//private List<Videos> listareproduccion;

	public Usuario(String nombre,String apellidos, String email,boolean premium,String contraseña,LocalDate fecha) {  // se crean los usuarios como no premium , cambiar si necesario

		this.nombre=nombre;
		this.email=email;
		this.esPremium=premium;
		this.contraseña=contraseña;
		this.apellidos=apellidos;
		this.fechaNacimiento=fecha;
		
		//ventas = new LinkedList<Venta>(); listas repro
	}
	
	
	//////////////

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
	
	
	//TODO Esto hay que ponerlo?¿¿¿
	private String getContraseña() {
		
		
		return contraseña;
	}
	
	private void setId(int i) {
		
		this.id=i;
	}
	
	private int getId() {
		
		
		return this.id;
	}
	
	
	
	//////////////////
	
	/*
	public void addVideo(Video v) {
		ventas.add(v);
	}

	public List<ListaVideos> getListasVideos() {
		return ventas;
	}
	*/

	// añadir lista , añadir videos a lista etc

	
	////////////////////////
	
	
	@Override
	public String toString() {
		return getUsuario();
	}
	
}



