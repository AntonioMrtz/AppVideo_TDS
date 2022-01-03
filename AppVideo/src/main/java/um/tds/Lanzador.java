package um.tds;

import java.awt.EventQueue;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import tds.video.VideoWeb;
import um.tds.gui.VentanaPrincipal;

public class Lanzador {
	
	public static VideoWeb videoWeb;

	public static void main(final String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	
					VentanaPrincipal ventana = new VentanaPrincipal();
					ventana.mostrarVentana();
					videoWeb= new VideoWeb();
					
					ServicioPersistencia servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();

					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}