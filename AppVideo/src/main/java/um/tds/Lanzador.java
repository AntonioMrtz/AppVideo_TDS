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
					/*
					Entidad usuario= new Entidad();
					usuario.setNombre("Usuario");
					usuario.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad("nif", "12345678A"))));
					servPersistencia.registrarEntidad(usuario);
					
					System.out.println(servPersistencia.recuperarEntidades());*/
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}