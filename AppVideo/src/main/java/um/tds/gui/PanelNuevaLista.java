package um.tds.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import um.tds.controlador.Controlador;


public class PanelNuevaLista extends JPanel implements IWindow{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtBuscarTtuloi;

	public PanelNuevaLista(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(Color.GRAY);
		add(panelIzq, BorderLayout.WEST);
		GridBagLayout gbl_panelIzq = new GridBagLayout();
		gbl_panelIzq.columnWidths = new int[]{215, -26, 0, 0, 0};
		gbl_panelIzq.rowHeights = new int[]{87, 0, 147, 0, -29, 0, 0};
		gbl_panelIzq.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelIzq.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelIzq.setLayout(gbl_panelIzq);
		
		JPanel superior = new JPanel();
		superior.setBackground(Color.GRAY);
		GridBagConstraints gbc_superior = new GridBagConstraints();
		gbc_superior.insets = new Insets(0, 0, 5, 5);
		gbc_superior.fill = GridBagConstraints.BOTH;
		gbc_superior.gridx = 0;
		gbc_superior.gridy = 0;
		panelIzq.add(superior, gbc_superior);
		GridBagLayout gbl_superior = new GridBagLayout();
		gbl_superior.columnWidths = new int[]{0, 167, 0};
		gbl_superior.rowHeights = new int[]{0, 15, 0, 0, 0};
		gbl_superior.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_superior.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		superior.setLayout(gbl_superior);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_2.gridx = 1;
		gbc_horizontalStrut_2.gridy = 0;
		superior.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		JLabel lblIntroducirNombreLista = new JLabel("Introducir nombre lista:");
		lblIntroducirNombreLista.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblIntroducirNombreLista = new GridBagConstraints();
		gbc_lblIntroducirNombreLista.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIntroducirNombreLista.insets = new Insets(0, 0, 5, 0);
		gbc_lblIntroducirNombreLista.anchor = GridBagConstraints.NORTH;
		gbc_lblIntroducirNombreLista.gridx = 1;
		gbc_lblIntroducirNombreLista.gridy = 1;
		superior.add(lblIntroducirNombreLista, gbc_lblIntroducirNombreLista);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 2;
		superior.add(verticalStrut_3, gbc_verticalStrut_3);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		superior.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		superior.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.addActionListener(new ActionListener() {   // BOTON BUSCAR lista
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
				   
				   //TODO  Coge nombre y comprueba si existe , si lo hace mostar elementos
				   //TODO si no emergente y popup con aceptar/cancelar para crear lista
					   
				   
	 
			   }
			   
	    });  
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 0;
		panel_1.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {   // BOTON ELIMINAR
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
				   //TODO  Elimina lista actual
				   //TODO  Borra videos pantalla
				   
	 
			   }
			   
	    });  
		
		
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.anchor = GridBagConstraints.EAST;
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 0;
		panel_1.add(btnEliminar, gbc_btnEliminar);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 3;
		gbc_verticalStrut.gridy = 0;
		panelIzq.add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 0;
		gbc_horizontalStrut_3.gridy = 1;
		panelIzq.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panelIzq.add(scrollPane, gbc_scrollPane);
		scrollPane.getViewport().setBackground(Color.GRAY);

		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 2;
		panelIzq.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 3;
		panelIzq.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JPanel inferior = new JPanel();
		inferior.setBackground(Color.GRAY);
		GridBagConstraints gbc_inferior = new GridBagConstraints();
		gbc_inferior.insets = new Insets(0, 0, 5, 5);
		gbc_inferior.fill = GridBagConstraints.BOTH;
		gbc_inferior.gridx = 0;
		gbc_inferior.gridy = 4;
		panelIzq.add(inferior, gbc_inferior);
		GridBagLayout gbl_inferior = new GridBagLayout();
		gbl_inferior.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_inferior.rowHeights = new int[]{0, 0, 0};
		gbl_inferior.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_inferior.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		inferior.setLayout(gbl_inferior);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		inferior.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{80, 80, 0};
		gbl_panel_2.rowHeights = new int[]{25, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnAadir_1 = new JButton("Añadir");
		btnAadir_1.addActionListener(new ActionListener() {   // BOTON AÑADIR
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
				  JOptionPane.showConfirmDialog(null, "¿Desea añadir lista?");
				   
				  if(JOptionPane.OK_OPTION==0) {
					
					  //TODO AÑADIR LISTA
				   }

				  
					   //TODO AÑADIMOS VIDEO DEL SCROLL DERECHO AL IZQUIERDO
				   
	 
			   }
			   
	    });  
		GridBagConstraints gbc_btnAadir_1 = new GridBagConstraints();
		gbc_btnAadir_1.fill = GridBagConstraints.BOTH;
		gbc_btnAadir_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnAadir_1.gridx = 0;
		gbc_btnAadir_1.gridy = 0;
		panel_2.add(btnAadir_1, gbc_btnAadir_1);
		
		JButton btnQuitar_1 = new JButton("Quitar");
		
		btnQuitar_1.addActionListener(new ActionListener() {   // BOTON QUITAR
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
					   //TODO QUITA EL VIDEO DE LA IZQUIERDA SELECCIONADO
				   
	 
			   }
			   
	    });  
		GridBagConstraints gbc_btnQuitar_1 = new GridBagConstraints();
		gbc_btnQuitar_1.fill = GridBagConstraints.BOTH;
		gbc_btnQuitar_1.gridx = 1;
		gbc_btnQuitar_1.gridy = 0;
		panel_2.add(btnQuitar_1, gbc_btnQuitar_1);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_4.gridx = 0;
		gbc_verticalStrut_4.gridy = 1;
		inferior.add(verticalStrut_4, gbc_verticalStrut_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 1;
		inferior.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{89, 0};
		gbl_panel_3.rowHeights = new int[]{25, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.addActionListener(new ActionListener() {   // BOTON ACEPTAR
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
					   //TODO CREA PLAYLIST NIVEL GLOBAL PARA USUARIO
				   		//TODO RESETEA SCROLL Y DERECHA
				   
	 
			   }
			   
	    });  
		
		
		
		GridBagConstraints gbc_btnAceptar_1 = new GridBagConstraints();
		gbc_btnAceptar_1.gridx = 0;
		gbc_btnAceptar_1.gridy = 0;
		panel_3.add(btnAceptar_1, gbc_btnAceptar_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 4;
		panelIzq.add(verticalStrut_2, gbc_verticalStrut_2);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 5;
		panelIzq.add(horizontalStrut, gbc_horizontalStrut);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.GRAY);
		add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[]{0, 0, 0};
		gbl_panelCentral.rowHeights = new int[]{92, 0, 0};
		gbl_panelCentral.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentral.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelCentral.setLayout(gbl_panelCentral);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panelCentral.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{114, 0};
		gbl_panel.rowHeights = new int[]{0, 15, 19, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 0;
		panel.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		JLabel lblBuscarTtulo = new JLabel("Buscar Título:");
		lblBuscarTtulo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblBuscarTtulo = new GridBagConstraints();
		gbc_lblBuscarTtulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBuscarTtulo.anchor = GridBagConstraints.NORTH;
		gbc_lblBuscarTtulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblBuscarTtulo.gridx = 0;
		gbc_lblBuscarTtulo.gridy = 1;
		panel.add(lblBuscarTtulo, gbc_lblBuscarTtulo);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		txtBuscarTtuloi = new JTextField();
		GridBagConstraints gbc_txtBuscarTtuloi = new GridBagConstraints();
		gbc_txtBuscarTtuloi.insets = new Insets(0, 0, 0, 5);
		gbc_txtBuscarTtuloi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBuscarTtuloi.gridx = 0;
		gbc_txtBuscarTtuloi.gridy = 0;
		panel_4.add(txtBuscarTtuloi, gbc_txtBuscarTtuloi);
		txtBuscarTtuloi.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {   // BOTON BUSCAR TITULO
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
				   //TODO BUSCAR POR TITULO Y MOSTRAR EN PANEL
					   
				   
	 
			   }
			   
	    });  
		
		
		GridBagConstraints gbc_btnBuscar_1 = new GridBagConstraints();
		gbc_btnBuscar_1.gridx = 1;
		gbc_btnBuscar_1.gridy = 0;
		panel_4.add(btnBuscar_1, gbc_btnBuscar_1);
		
		JButton btnNuevaBusqueda = new JButton("Nueva Busqueda");
		
		btnNuevaBusqueda.addActionListener(new ActionListener() {   // BOTON NUEVA BUSQUEDA
			
			   public void actionPerformed(ActionEvent e) {
				   
				 
					   //TODO LIMPIA PANEL TITULO , LOS 2 PANELES SCROLL Y BUSCAR
				   
	 
			   }
			   
	    });  
		GridBagConstraints gbc_btnNuevaBusqueda = new GridBagConstraints();
		gbc_btnNuevaBusqueda.gridx = 0;
		gbc_btnNuevaBusqueda.gridy = 3;
		panel.add(btnNuevaBusqueda, gbc_btnNuevaBusqueda);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_5.gridx = 1;
		gbc_horizontalStrut_5.gridy = 0;
		panelCentral.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panelCentral.add(scrollPane_1, gbc_scrollPane_1);
		scrollPane_1.getViewport().setBackground(Color.GRAY);
		
		
		
	}

	@Override
	public void enterExplorar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitExplorar() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void clearLeftPanel() {
		// TODO Auto-generated method stub
		
	}
	
	private void clearRightPanel() {
		// TODO Auto-generated method stub
		
	}
	
	

}
