package um.tds.persistencia;

import java.util.List;

import um.tds.dominio.Filtro;

public interface IAdaptadorFiltroDAO {
	
	
	public void registrarFiltro(Filtro f);
	public void borrarFiltro(Filtro f);
	public void modificarFiltro(Filtro f);
	public Filtro findFiltro(int codigo);
	public List<Filtro> recuperarTodosFiltros();

}
