package um.tds.componente;

import java.util.EventObject;

public class VideosEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Videos videos;
	
	public VideosEvent(Object o,Videos v) {
		
		super(o);
		videos=v;
		
	}
	
	public Videos getVideos() {
		
		return videos;
	}
	
}
