package um.tds;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.gui.VentanaPrincipal;

public class Lanzador {

	public static void main(final String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	
					VentanaPrincipal ventana = new VentanaPrincipal();
					ventana.mostrarVentana();
					
					ServicioPersistencia servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();

					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}