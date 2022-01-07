package um.tds.persistencia;

import java.util.List;

import um.tds.dominio.Etiqueta;

public interface IAdaptadorEtiquetasDAO {

	public boolean registrarEtiqueta(Etiqueta e);

	public boolean borrarEtiqueta(Etiqueta e);

	
	public Etiqueta findEtiqueta(int codigo);

	public List<Etiqueta> recuperarTodasEtiquetas();

}
