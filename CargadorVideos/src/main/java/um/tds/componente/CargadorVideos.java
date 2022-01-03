package um.tds.componente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBException;

public class CargadorVideos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CargadorVideos unicaInstancia;
	
	
	private String fileVideo = "";
	private List<VideoListener> listeners = new LinkedList<VideoListener>();
	
	

	public static CargadorVideos getUnicaInstancia() {
		
		if (unicaInstancia == null)
			unicaInstancia = new CargadorVideos();
		return unicaInstancia;
	}
	
	
	//constructor vacio
	
	private CargadorVideos() {
		
	}
	
	
	
	public boolean setFileVideo(String xmlFile) {
		String old = fileVideo;
		fileVideo = xmlFile;
		
		if (!old.equals(fileVideo)) {
			VideosEvent event = new VideosEvent(this, MapperVideosXMLtoJava.cargarVideos(fileVideo));
			update(event);
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	// Inspirado en : https://www.youtube.com/watch?v=HFkZb1g8faA&t=531s
	
	
	private void update(VideosEvent event) {
		List<VideoListener> lista;
		synchronized (this) {
			lista = new ArrayList<VideoListener>(listeners);
		}
		for (VideoListener listener : lista)
			listener.enteradoCambios(event);
	}
	
	
	// Añade y elimina oyentes de tipo VideoListener
	
	public synchronized void attach(VideoListener listener) {
		listeners.add(listener);
	}

		public synchronized void dettach(VideoListener listener) {
		listeners.remove(listener);
	}

}
