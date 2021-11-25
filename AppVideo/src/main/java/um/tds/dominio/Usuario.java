package um.tds.dominio;

import java.util.Date;


//! PARA REGISTRAR USUARIOS EL NOMBRE TIENE QUE SER UNICO , ACTUA COMO CODIGO

public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String email;
	private boolean esPremium;
	private String contraseña;
	private String usuario;
	private Date fechaNacimiento;
	
	//private List<Venta> ventas;

	public Usuario(String nombre,String apellidos, String email,boolean premium,String contraseña,Date fecha) {  // se crean los usuarios como no premium , cambiar si necesario

		this.nombre=nombre;
		this.email=email;
		this.esPremium=premium;
		this.contraseña=contraseña;
		this.apellidos=apellidos;
		this.fechaNacimiento=fecha;
		
		
		//ventas = new LinkedList<Venta>();
	}

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
	
	public Date getFechaNacimiento() {
		
		
		return fechaNacimiento;
	}
	
	public String getUsuario() {
		
		return usuario;
	}
	
	
	//TODO Esto hay que ponerlo?¿¿¿
	private String getContraseña() {
		
		
		return contraseña;
	}
	
	
	
	
	/*
	public void addVideo(Video v) {
		ventas.add(v);
	}

	public List<ListaVideos> getListasVideos() {
		return ventas;
	}
	*/

	

	@Override
	public String toString() {
		return getUsuario();
	}
	
}



