package um.tds.persistencia;

import java.util.List;

import um.tds.dominio.Etiqueta;
import um.tds.dominio.Filtro;

public interface IAdaptadorEtiquetasDAO {
	
	public boolean registrarEtiqueta(Etiqueta e);
	public boolean borrarEtiqueta(Etiqueta e);
	/*public void modificarEtiqueta(Etiqueta e);*/
	public Etiqueta findEtiqueta(int codigo);
	public List<Etiqueta> recuperarTodasEtiquetas();

}
