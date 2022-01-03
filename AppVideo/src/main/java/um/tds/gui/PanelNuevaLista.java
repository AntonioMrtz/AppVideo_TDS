package um.tds.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Color;
import um.tds.Lanzador;
import um.tds.controlador.Controlador;
import um.tds.dominio.ListaVideos;
import um.tds.dominio.Video;
import javax.swing.BoxLayout;


public class PanelNuevaLista extends JPanel implements IWindow{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtBuscarTtuloi;
	private JPanel panel_5;
	private ListaVideos lista;
	private JPanel panel_6 ;

	public PanelNuevaLista(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(Color.GRAY);
		add(panelIzq, BorderLayout.WEST);
		GridBagLayout gbl_panelIzq = new GridBagLayout();
		gbl_panelIzq.columnWidths = new int[]{215, -26, 0, 0, 0};
		gbl_panelIzq.rowHeights = new int[]{87, 0, 147, 0, -29, 0, 0, 0, 0};
		gbl_panelIzq.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelIzq.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				   
				   ListaVideos aux = Controlador.getUnicaInstancia().findLista(textField.getText());
				   
				   if(aux!=null) {
					   
					   
					   showVideos(panel_6, Controlador.getUnicaInstancia().getVideos(), "R");
					   showVideos(panel_5,aux.getVideos(),"I");
					   
					   lista=aux;
				   }
				   else {
					   
					   
					   JOptionPane.showConfirmDialog(null, "¿Desea añadir lista?");
					   
					   if(JOptionPane.OK_OPTION==0) {
						   
						   lista= new ListaVideos(Controlador.getUnicaInstancia().getUsuarioActual(), textField.getText());
						   
					   }
					   
					   
				   }
			
					   	
	 
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
				   
				 
				   textField.setText("");
				   lista=null;
				   
	 
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
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.GRAY);
		JScrollPane scroll = new JScrollPane(panel_5,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panelIzq.add(scroll, gbc_panel_5);

		
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
				   
				   
					 //System.out.println(lista);
				   
				   if(lista!=null) {
					   
					   
					   
					   ListaVideos aux = Controlador.getUnicaInstancia().findLista(textField.getText());
					   
					   if(aux!=null) {
						   
						   
						   Controlador.getUnicaInstancia().registrarListaVideos(aux.getNombre(), aux.getVideos());
						   
					   }
					   else {
						   
						   
						   Controlador.getUnicaInstancia().registrarListaVideos(lista.getNombre(), lista.getVideos());
						   
						   
						   
						   
						   
						   
					   }
					   
				   }
				   
				   
				   
				   cleanAll();
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
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 0;
		gbc_verticalStrut_5.gridy = 6;
		panelIzq.add(verticalStrut_5, gbc_verticalStrut_5);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 7;
		panelIzq.add(horizontalStrut, gbc_horizontalStrut);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.GRAY);
		add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[]{0, 0};
		gbl_panelCentral.rowHeights = new int[]{92, 0, 0};
		gbl_panelCentral.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCentral.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelCentral.setLayout(gbl_panelCentral);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
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
				   
				 
				   String titulo=txtBuscarTtuloi.getText().trim();
				  
				   clearRightPanel();
				   
				   Collection<Video> videos=Controlador.getUnicaInstancia().filterVideo(titulo, null);
				   
				   showVideos(panel_6,videos,"D");
				   
				   txtBuscarTtuloi.setText("");
	 
			   }
			   
	    });  
		
		
		GridBagConstraints gbc_btnBuscar_1 = new GridBagConstraints();
		gbc_btnBuscar_1.gridx = 1;
		gbc_btnBuscar_1.gridy = 0;
		panel_4.add(btnBuscar_1, gbc_btnBuscar_1);
		
		JButton btnNuevaBusqueda = new JButton("Nueva Busqueda");
		
		btnNuevaBusqueda.addActionListener(new ActionListener() {   // BOTON NUEVA BUSQUEDA
			
			   public void actionPerformed(ActionEvent e) {
				   
				   
				   
					   
				   	cleanAll();
				   
				   
	 
			   }
			   
	    });  
		GridBagConstraints gbc_btnNuevaBusqueda = new GridBagConstraints();
		gbc_btnNuevaBusqueda.gridx = 0;
		gbc_btnNuevaBusqueda.gridy = 3;
		panel.add(btnNuevaBusqueda, gbc_btnNuevaBusqueda);
		
		panel_6 = new JPanel();
		JScrollPane scroll2 = new JScrollPane(panel_6,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_6.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		panelCentral.add(scroll2, gbc_panel_6);
		
		
		
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		
		cleanAll();
		

		
	}
	
	
	private void clearLeftPanel() {
		

		for(Component c:panel_5.getComponents()) {
			
			panel_5.remove(c);
		}
		
	}
	
	private void clearRightPanel() {
		
		for(Component c:panel_6.getComponents()) {
			
			panel_6.remove(c);
		}
		
	}
	
	
	private void cleanAll() {
		

		clearLeftPanel();
		clearRightPanel();
		
		textField.setText("");
		txtBuscarTtuloi.setText("");
		
		panel_5.revalidate();
		panel_6.revalidate();
		panel_5.repaint();
		panel_6.repaint();
	}
	
	private void showVideos(JPanel j,Collection<Video> videos,String s) {
		
		
		for(Video v:videos) {
			
			
			
			
			JButton boton= new JButton();
			boton.setBackground(Color.gray);
			boton.setActionCommand(v.getUrl());
		
			ImageIcon thumb = Lanzador.videoWeb.getSmallThumb(v.getUrl());
			
			boton.setIcon(thumb);
			
			if(s.equals("I")) boton.addActionListener(listenerButtonsLeftPanel);
			
			else boton.addActionListener(listenerButtonsRightPanel);
			
			int control=0;
			
			if(j==panel_5) {
				
				
				for(Component c:panel_5.getComponents()) {
					
					
					if(c instanceof JButton) {
						
						if(((JButton) c).getActionCommand().equals(v.getUrl())) {
							
							control=1;
						}
						
					}
				}
				
				if(control==0) j.add(boton);
				
			}
			
			else j.add(boton);
			
			
			
			
		}
		
		j.revalidate();
		j.repaint();
		
	}
	
	private ActionListener listenerButtonsRightPanel= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//meter urls a la lista
			
			
			if(lista!=null) {
				
				
				Video v=Controlador.getUnicaInstancia().findVideo(arg0.getActionCommand());
				
				lista.addVideo(Controlador.getUnicaInstancia().findVideo(arg0.getActionCommand()));
				
				Collection<Video> listv = new HashSet<Video>();
				listv.add(v);
				
				
				showVideos(panel_5, listv, "I");
				
				
			}
			
			else {
				
				JOptionPane.showInternalMessageDialog(null, "Primer debes seleccionar una lista");
				
			}
			
			
		}
	};

	
	private ActionListener listenerButtonsLeftPanel= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			Video v=Controlador.getUnicaInstancia().findVideo(arg0.getActionCommand());
			
			lista.delVideo(v);
			
			for(Component c:panel_5.getComponents()) {
				
				
				if(c instanceof JButton) {
					
					if(((JButton) c).getActionCommand().equals(arg0.getActionCommand())){
						
						panel_5.remove(c);
						panel_5.revalidate();
						panel_5.repaint();
					}
					
				}
			}
			
			
		}
	};
}
