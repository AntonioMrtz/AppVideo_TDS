package um.tds.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import um.tds.Lanzador;
import um.tds.controlador.Controlador;
import um.tds.dominio.Etiqueta;
import um.tds.dominio.Video;


public class PanelExplorar extends JPanel implements IWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel_3 = new JPanel();
	private JTextField textField;
	private JList list_1;
	
	private JList list;
	
	private DefaultListModel<String> d2 = new DefaultListModel<String>();
	
	
	
	
	public PanelExplorar() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblNewLabel_1 = new JLabel("Etiquetas disponibles\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		DefaultListModel<String> d = new DefaultListModel<String>();
		
		
		list=new JList<String>(d);
		
		addEtiquetasList(d,list);
		
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {

		            // Double-click detected
		            //int index = list.locationToIndex(evt.getPoint());
		            
		            //System.out.println(list.getSelectedValue());
		        	String aux = (String) list.getSelectedValue();
		        	
		        	d2.addElement(aux);
		        	
		        }
		    }
		});
		
		//list.addMouseListener(mouseClicked);

		
		JScrollPane pane2 = new JScrollPane(list);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		panel.add(pane2, gbc_list);
		//panel.add(list, gbc_list);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 2;
		gbc_horizontalStrut_1.gridy = 2;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 3;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel lblNewLabel_2 = new JLabel("Buscar Etiquetas");
		lblNewLabel_2.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		list_1 = new JList<String>(d2);
		JScrollPane pane3 = new JScrollPane(list_1);
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 1;
		gbc_list_1.gridy = 5;
		panel.add(pane3, gbc_list_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 7;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		//JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Buscar Título:");
		lblNewLabel.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		panel_2.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_1.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Nueva Búsqueda");
		panel_4.add(btnNewButton_1);
		
		JScrollPane pane = new JScrollPane(panel_3);
		panel_1.add(pane, BorderLayout.CENTER);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {   // BOTON NUEVA BÚSQUEDA
			
			   public void actionPerformed(ActionEvent e) {
				  
				  
				   cleanVideos();
				   d2.clear(); 
			   }
			   
	    }); 
		
		
		btnNewButton.addActionListener(new ActionListener() {   // BOTON BUSCAR
			
			   public void actionPerformed(ActionEvent e) {
				  
				   cleanVideos();
				   loadVideos();
				   
			   }
			   
	    }); 

	}
	
	
	public void enter() {
		

	
		
	}
	
	public void exit() {
		
		/*Lanzador.videoWeb.cancel();
		panel_3.remove(Lanzador.videoWeb);*/
		
		cleanVideos();
		textField.setText("");
		d2.clear(); 
		
	}
	
	
	public void cleanVideos() {
		
		for(Component c:panel_3.getComponents()) {
			
			panel_3.remove(c);
		}
		
		panel_3.repaint();
		Controlador.getUnicaInstancia().stopVideo();
		//textField.setText("");
		
	
		
		
	}
	
	public void loadVideos() {
		
		
		cleanVideos();
		
				
		
		List<String> etiquetas = new ArrayList<String>() ;
		
		
		
		for(int i=0;i<list_1.getModel().getSize();i++) {
			
			etiquetas.add(d2.getElementAt(i));
						
		}
		
		
		String titulo=textField.getText().trim();
		
		Collection<Video> set=Controlador.getUnicaInstancia().filterVideo(titulo,etiquetas);
		
		
		for(Video v:set) {
			
			JButton boton= new JButton();
			boton.setBackground(Color.gray);
			boton.setActionCommand(v.getUrl());
		
			ImageIcon thumb = Lanzador.videoWeb.getSmallThumb(v.getUrl());
			
			boton.setIcon(thumb);
			boton.addActionListener(listenerButtons);
			
			//panel_3.add(boton);
			panel_3.add(boton);
		}
		
		panel_3.revalidate();
		textField.setText("");
		d2.clear(); 
	}
	

	
	public void addEtiquetasList(DefaultListModel<String> d,JList<String> j) {
		
		HashSet<String> set = new HashSet<String>();
		
		for(Etiqueta et:Controlador.getUnicaInstancia().getEtiquetas()) {
			
			set.add(et.getNombre());
			d.addElement(et.getNombre());
		}
		
		d.addAll(set);
		
	}
	
	

	
	private ActionListener listenerButtons= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			cleanVideos();
			panel_3.add(Lanzador.videoWeb);
			Controlador.getUnicaInstancia().playVideo(arg0.getActionCommand());
			
		}
	};
	

}
