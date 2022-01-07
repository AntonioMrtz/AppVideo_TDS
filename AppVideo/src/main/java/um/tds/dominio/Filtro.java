package um.tds.dominio;

public abstract class Filtro {

	// Clase abstracta filtro que obliga a definir una funcion para aceptar videos

	abstract public boolean isVideoOk(Video v);

}
