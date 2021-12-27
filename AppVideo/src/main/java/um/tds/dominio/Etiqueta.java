package um.tds.dominio;

public class Etiqueta {
	
	private String nombre;
	private int id;
	
	public Etiqueta(String nombre) {
		
		this.nombre=nombre;
		this.id=0;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return getNombre()+" "+getId();
	}
	
	
	
}
