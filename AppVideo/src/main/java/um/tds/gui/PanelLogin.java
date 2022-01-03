package um.tds.gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import um.tds.controlador.Controlador;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLogin extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField password;
	private JLabel alerta; // alerta error
	
	
	public PanelLogin() {
		setForeground(Color.WHITE);
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_16 = new GridBagConstraints();
		gbc_horizontalStrut_16.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_16.gridx = 5;
		gbc_horizontalStrut_16.gridy = 0;
		add(horizontalStrut_16, gbc_horizontalStrut_16);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 12;
		gbc_verticalStrut_5.gridy = 0;
		add(verticalStrut_5, gbc_verticalStrut_5);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 12;
		gbc_verticalStrut_4.gridy = 1;
		add(verticalStrut_4, gbc_verticalStrut_4);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 12;
		gbc_verticalStrut_3.gridy = 2;
		add(verticalStrut_3, gbc_verticalStrut_3);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 12;
		gbc_verticalStrut_2.gridy = 4;
		add(verticalStrut_2, gbc_verticalStrut_2);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 5;
		add(horizontalStrut, gbc_horizontalStrut);
		
		Component horizontalStrut_18 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_18 = new GridBagConstraints();
		gbc_horizontalStrut_18.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_18.gridx = 3;
		gbc_horizontalStrut_18.gridy = 5;
		add(horizontalStrut_18, gbc_horizontalStrut_18);
		
		Component horizontalStrut_19 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_19 = new GridBagConstraints();
		gbc_horizontalStrut_19.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_19.gridx = 4;
		gbc_horizontalStrut_19.gridy = 5;
		add(horizontalStrut_19, gbc_horizontalStrut_19);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 5;
		add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_15 = new GridBagConstraints();
		gbc_horizontalStrut_15.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_15.gridx = 6;
		gbc_horizontalStrut_15.gridy = 5;
		add(horizontalStrut_15, gbc_horizontalStrut_15);
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_17 = new GridBagConstraints();
		gbc_horizontalStrut_17.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_17.gridx = 8;
		gbc_horizontalStrut_17.gridy = 5;
		add(horizontalStrut_17, gbc_horizontalStrut_17);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_10 = new GridBagConstraints();
		gbc_horizontalStrut_10.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_10.gridx = 9;
		gbc_horizontalStrut_10.gridy = 5;
		add(horizontalStrut_10, gbc_horizontalStrut_10);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_11 = new GridBagConstraints();
		gbc_horizontalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_11.gridx = 10;
		gbc_horizontalStrut_11.gridy = 5;
		add(horizontalStrut_11, gbc_horizontalStrut_11);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_12 = new GridBagConstraints();
		gbc_horizontalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_12.gridx = 11;
		gbc_horizontalStrut_12.gridy = 5;
		add(horizontalStrut_12, gbc_horizontalStrut_12);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 12;
		gbc_lblNewLabel.gridy = 5;
		add(lblNewLabel, gbc_lblNewLabel);
		
		nombre = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 13;
		gbc_textField.gridy = 5;
		add(nombre, gbc_textField);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 12;
		gbc_lblNewLabel_1.gridy = 6;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		password = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 13;
		gbc_textField_1.gridy = 6;
		add(password, gbc_textField_1);
		password.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 12;
		gbc_verticalStrut.gridy = 7;
		add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 12;
		gbc_verticalStrut_1.gridy = 8;
		add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 9;
		add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 5;
		gbc_horizontalStrut_3.gridy = 9;
		add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 6;
		gbc_horizontalStrut_5.gridy = 9;
		add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 17;
		gbc_horizontalStrut_2.gridy = 9;
		add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 0;
		gbc_horizontalStrut_6.gridy = 10;
		add(horizontalStrut_6, gbc_horizontalStrut_6);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_7.gridx = 5;
		gbc_horizontalStrut_7.gridy = 10;
		add(horizontalStrut_7, gbc_horizontalStrut_7);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
		gbc_horizontalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_8.gridx = 6;
		gbc_horizontalStrut_8.gridy = 10;
		add(horizontalStrut_8, gbc_horizontalStrut_8);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 7;
		gbc_verticalStrut_6.gridy = 10;
		add(verticalStrut_6, gbc_verticalStrut_6);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_9 = new GridBagConstraints();
		gbc_horizontalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_9.gridx = 8;
		gbc_horizontalStrut_9.gridy = 10;
		add(horizontalStrut_9, gbc_horizontalStrut_9);
		
		Button button = new Button("Aceptar");
		button.setForeground(Color.WHITE);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 12;
		gbc_button.gridy = 10;
		add(button, gbc_button);
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_13 = new GridBagConstraints();
		gbc_horizontalStrut_13.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_13.gridx = 13;
		gbc_horizontalStrut_13.gridy = 10;
		add(horizontalStrut_13, gbc_horizontalStrut_13);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_14 = new GridBagConstraints();
		gbc_horizontalStrut_14.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_14.gridx = 14;
		gbc_horizontalStrut_14.gridy = 10;
		add(horizontalStrut_14, gbc_horizontalStrut_14);
		
		Button button_1 = new Button("Cancelar");
		button_1.setForeground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 18;
		gbc_button_1.gridy = 10;
		add(button_1, gbc_button_1);
		
		 button_1.addActionListener(new ActionListener() {   // BOTON CANCELAR
				
			   public void actionPerformed(ActionEvent e) {
				   
				   System.exit(0);
				   
				   
			   }
			   
	    });  
		
		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.insets = new Insets(0, 0, 5, 5);
		gbc_verticalGlue.gridx = 7;
		gbc_verticalGlue.gridy = 11;
		add(verticalGlue, gbc_verticalGlue);
		
		
		alerta=new JLabel("Los campos Dni y Nombre son obligtorios",JLabel.CENTER);
		alerta.setForeground(Color.RED);
		alerta.setMinimumSize(new Dimension(238, 30));
		alerta.setMaximumSize(new Dimension(225, 30));
		alerta.setPreferredSize(new Dimension(238, 30));
		alerta.setVisible(false);
		GridBagConstraints gbc_alerta = new GridBagConstraints();
		gbc_alerta.gridwidth = 8;
		gbc_alerta.insets = new Insets(0, 0, 5, 5);
		gbc_alerta.gridx = 12;
		gbc_alerta.gridy = 12;
		add(alerta, gbc_alerta);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue_1 = new GridBagConstraints();
		gbc_verticalGlue_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalGlue_1.gridx = 7;
		gbc_verticalGlue_1.gridy = 13;
		add(verticalGlue_1, gbc_verticalGlue_1);
		
		/* handlers */
		
		 button.addActionListener(new ActionListener() {   // BOTON ACEPTAR
				
			   public void actionPerformed(ActionEvent e) {
				  
				   
				   String nomAux=nombre.getText().trim();	
				   String passAux=password.getText().trim();
				   
				   
				   if (nomAux.isEmpty()||passAux.isEmpty()) {
					   
					   alerta.setVisible(true);
					   
					   
				   }
					else { alerta.setVisible(false);
					
						   if(Controlador.getUnicaInstancia().loginUsuario(nomAux, passAux)){
							   
							   JOptionPane.showMessageDialog(null,"Cliente logeado correctamente","Login cliente",JOptionPane.PLAIN_MESSAGE);
							   int i=VentanaPrincipal.setLoginName();/////////////////
						   }
						   
						   else {
							   
							   JOptionPane.showMessageDialog(null,"Usuario no existe","Login cliente",JOptionPane.PLAIN_MESSAGE);
							   
						   }
						   
						   nombre.setText(""); password.setText(""); alerta.setVisible(false); 
					}
		 
			   
			   }
			   
			   
	    });  
		
		
	}
	

}
