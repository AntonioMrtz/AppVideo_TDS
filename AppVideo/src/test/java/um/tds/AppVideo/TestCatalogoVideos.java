package um.tds.AppVideo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import um.tds.controlador.Controlador;
import um.tds.dominio.CatalogoVideos;
import um.tds.dominio.Etiqueta;
import um.tds.dominio.Filtro;
import um.tds.dominio.FiltroAdultFilter;
import um.tds.dominio.Video;

public class TestCatalogoVideos {

	public static CatalogoVideos catalogo ;
	public static LinkedList<Video> videos;
	public static Controlador controlador;
	
	
	@BeforeClass
	public static void setUpBefore() {
		
		catalogo=CatalogoVideos.getUnicaInstancia();
		
		controlador= Controlador.getUnicaInstancia();
		
		// Vaciamos lo que haya traido del servidor de persistencia
		
		for(Video v : catalogo.getVideos()) {
			
			catalogo.removeVideo(v);
		}
		
		
		videos= new LinkedList<Video>();
		
		
		Video v1= new Video("https://www.youtube.com/watch?v=6kguaGI7aZg","The End Of Evangelion" );
		v1.setId(23);
		v1.setNumRepro(0);
		videos.addLast(v1);
		
		Video v2 = new Video("https://www.youtube.com/watch?v=RRKJiM9Njr8","My Chemical Romance - Welcome To The Black Parade [Official Music Video] [HD]" );
		v2.setId(3);
		v2.setNumRepro(0);
		videos.addLast(v2);
		
		Video v3 = new Video("https://www.youtube.com/watch?v=a5uQMwRMHcs","Daft Punk - Instant Crush (Video) ft. Julian Casablancas" );
		v3.setId(833);
		v3.setNumRepro(0);
		videos.addLast(v3);
	}
	
	
	@Before
	public void testInsertar() {  // insertamos los videos y comprobamos que estan en el catalogo
		
		
		for(Video v:videos) {
			
			catalogo.addVideo(v);
		}
		
		Collection<Video> catalogoCopy = catalogo.getVideos();
		
		
		for(Video v :videos) {
			
			assertTrue(catalogoCopy.contains(v));
			
		}
		
		
	}
	
	

	@Test
	public void testRemoveVideo() { // borramos un video y comprobamos si se encuentra en el catalogo después
		
		for(Video v : videos) {
			
			catalogo.removeVideo(v);
			
		}
		
		Collection<Video> catalogoCopy = catalogo.getVideos();
		
		for(Video v:videos) {
			
			
			assertFalse(catalogoCopy.contains(v));
		}

	}

	@Test
	public void testGetTop10Videos() { // Segun el orden de la lista le damos mas reproducciones y comprobamos que nos devuelve ese patron en orden
		
		int contador=5;
		
		for(Video v : videos) {
			
			for(int i=0;i<contador;i++) {
				
				v.incrementarRepro();
				catalogo.modifyVideo(v);
				
			}
			
			contador++;
		}
		
	
		assertEquals(videos,catalogo.getTop10Videos());		
	}

	@Test
	public void testFilterVideo() { //Creamos un filtro y buscamos por titulo y etiqueta 
		
		Filtro f = new FiltroAdultFilter(); 
		Etiqueta e = new Etiqueta("Etiqueta1");
		String titulo = "The End Of Evangelion";
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Etiqueta1");
		
		Video v=videos.getFirst();
		v.addEtiqueta(e);
		
		Video v1=videos.getLast();
		v1.addEtiqueta(new Etiqueta("Adulto"));
		
		catalogo.modifyVideo(v1);
		catalogo.modifyVideo(v);
		
		// construimos la respuesta deseada
		
		
		Collection<Video> solucion = new HashSet<Video>();
		solucion.add(v);
		
		
		assertArrayEquals(solucion.toArray(), catalogo.filterVideo(f, titulo, a).toArray());
		
	}



	@Test
	public void testModifyVideo() { // Modificamos el valor de un video con un valor y lo recogemos de vuelta para ver si es el mismo
		
		int valorCambio = 1;
		
		Video v=videos.getFirst();
		
		int valorPrincipio = v.getNumRepro();
		
		v.setNumRepro(valorCambio);
			
		catalogo.modifyVideo(v);
		
		assertTrue(catalogo.getVideo(v.getUrl()).getNumRepro()==valorCambio);
		
		
	}

}
