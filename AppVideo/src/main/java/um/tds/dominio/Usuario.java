package um.tds.dominio;

public class Usuario {
	
	private String nombre;
	private String email;
	private boolean esPremium;
	//private List<Venta> ventas;

	public Usuario(String nombre, String email) {  // se crean los usuarios como no premium , cambiar si necesario

		this.nombre=nombre;
		this.email=email;
		this.esPremium=false;
		//ventas = new LinkedList<Venta>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public boolean isEsPremium() {
		return esPremium;
	}

	/*
	public void addVideo(Video v) {
		ventas.add(v);
	}

	public List<ListaVideos> getListasVideos() {
		return ventas;
	}
	*/

	

}



