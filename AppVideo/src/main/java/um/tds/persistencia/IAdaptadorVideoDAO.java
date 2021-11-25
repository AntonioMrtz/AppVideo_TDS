package um.tds.persistencia;

import java.util.List;

import um.tds.dominio.Video;

public interface IAdaptadorVideoDAO {

	public void addVideo(Video v);
	public void removeVideo(Video v);
	public void modificarVideo(Video v);
	public void findVideo(String url);
	public List<Video> recuperarTodosVideos();
	
}
