package um.tds.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import um.tds.Lanzador;
import um.tds.controlador.Controlador;
import um.tds.dominio.Video;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Font;

public class PanelRecientes extends JPanel implements IWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel_4 ;
	private JPanel panel_1;
	private JPanel panel_3;
	
	private JPanel panel_6;
	private JPanel panel_5 ;

	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	
	private JComboBox<String> comboBox;
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	/**
	 * Create the panel.
	 */
	public PanelRecientes() {

		setBackground(Color.GRAY);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 0;
		panel_3.add(horizontalStrut, gbc_horizontalStrut);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		panel_3.add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 1;
		panel_3.add(verticalStrut_3, gbc_verticalStrut_3);

		JLabel lblNewLabel = new JLabel("Listas especiales:");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		 comboBox = new JComboBox<String>();
		comboBox.addItem("");
		comboBox.addItem("Recientes");
		
		
		
		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		       
		    	if(comboBox.getSelectedItem()==""){
		    		
		    		
		    		
		    	}
		    	
		    	else if(comboBox.getSelectedItem()=="Recientes"){
		    		
		    		cleanVideos();
		    		showVideos(Controlador.getUnicaInstancia().getRecientes());
		    		
		    	}
		    	
		    	else if(comboBox.getSelectedItem()=="Top 10"){
		    		
		    		cleanVideos();
		    		showVideos(Controlador.getUnicaInstancia().getTop10());
		    	}
		    	
		    	
		    }
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		panel_3.add(comboBox, gbc_comboBox);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 2;
		panel_3.add(horizontalStrut_1, gbc_horizontalStrut_1);


		panel_4 = new JPanel();
		JScrollPane scroll = new JScrollPane(panel_4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		panel_4.setBackground(Color.GRAY);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.add(scroll, BorderLayout.CENTER);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		 panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		 panel_8 = new JPanel();
		panel_8.setBackground(Color.GRAY);
		panel_7.add(panel_8, BorderLayout.CENTER);
		
	
		
		panel_9 = new JPanel();
		panel_9.setBackground(Color.GRAY);
		panel_7.add(panel_9, BorderLayout.SOUTH);
		

		
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_1.add(panel_6, BorderLayout.CENTER);
		add(panel_1, BorderLayout.CENTER);


	}

	@Override
	public void enter() {
		

		if(Controlador.getUnicaInstancia().getUsuarioActual().isPremium() && comboBox.getItemCount()==2) comboBox.addItem("Top 10");
		panel_3.revalidate();
		panel_3.repaint();
		
	}

	@Override
	public void exit() {
		
		for(Component c:panel_8.getComponents()) {
			
			panel_8.remove(c);
		}
		
		for(Component c:panel_9.getComponents()) {
			
			panel_9.remove(c);
		}
		
		for(Component c:panel_6.getComponents()) {
			
			panel_6.remove(c);
		}
		
		Controlador.getUnicaInstancia().stopVideo();
		
	}
	
	private void cleanVideos() {
		
		// limpiar panel izquierda
		
		for(Component c : panel_4.getComponents()) {
			
			panel_4.remove(c);
		}
		
		//Lanzador.videoWeb.cancel();
		Controlador.getUnicaInstancia().stopVideo();
		
		panel_4.revalidate();
		panel_4.repaint();
		

	}
	
	
	
	private void showVideos(List<Video> l) {
		
		for(Video v:l) {
			
				JButton boton= new JButton();
				boton.setBackground(Color.gray);
				boton.setActionCommand(v.getUrl());
				
				ImageIcon thumb = Lanzador.videoWeb.getSmallThumb(v.getUrl());
				
				boton.setIcon(thumb);
				boton.addActionListener(listenerButtons);
				
				panel_4.add(boton);
				
				

		
		}
	
	panel_4.revalidate();
	panel_4.repaint();
		
		
	}

private ActionListener listenerButtons= new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		exit();
		
		lblNewLabel_2 = new JLabel("Reproducciones "+Integer.toString(Controlador.getUnicaInstancia().findVideo(arg0.getActionCommand()).getNumRepro()));
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_9.add(lblNewLabel_2);
		
		lblNewLabel_1 =new JLabel(Controlador.getUnicaInstancia().findVideo(arg0.getActionCommand()).getTitulo());
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_8.add(lblNewLabel_1);
		
		
		
		panel_6.add(Lanzador.videoWeb);
		Controlador.getUnicaInstancia().playVideo(arg0.getActionCommand());
		panel_6.revalidate();
		panel_6.repaint();
		
		panel_8.revalidate();
		panel_8.repaint();
		
		panel_9.revalidate();
		panel_9.repaint();
		
	}
};

}
