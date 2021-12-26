package um.tds.persistencia;

import java.util.List;

import um.tds.dominio.Video;

public interface IAdaptadorVideoDAO {

	public boolean addVideo(Video v);
	public boolean removeVideo(Video v);
	public void modificarVideo(Video v);
	public Video findVideo(int id);
	public List<Video> recuperarTodosVideos();
	
}
