package um.tds;

import java.awt.EventQueue;

import um.tds.gui.VentanaPrincipal;

public class Lanzador {

	public static void main(final String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	
					VentanaPrincipal ventana = new VentanaPrincipal();
					ventana.mostrarVentana();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}