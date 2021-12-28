package um.tds.persistencia;

import java.util.List;

import um.tds.dominio.ListaVideos;

public interface IAdaptadorListaVideosDAO {
	
	public boolean registrarListaVideos(ListaVideos l);
	public boolean borrarListaVideo(ListaVideos l);
	public void modificarListaVideos(ListaVideos l);
	public ListaVideos recuperarListaVideos(int id);
	public List<ListaVideos> recuperarTodasListaVideos();

	

}
