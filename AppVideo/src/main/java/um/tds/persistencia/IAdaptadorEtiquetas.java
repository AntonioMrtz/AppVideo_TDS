package um.tds.persistencia;

import java.util.List;

import um.tds.dominio.Etiqueta;
import um.tds.dominio.Filtro;

public interface IAdaptadorEtiquetas {
	
	public void registrarEtiqueta(Etiqueta e);
	public void borrarEtiqueta(Etiqueta e);
	public void modificarEtiqueta(Etiqueta ef);
	public Filtro findEtiquetas(int codigo);
	public List<Etiqueta> recuperarTodasEtiquetas();

}
