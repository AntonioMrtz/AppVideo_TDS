package um.tds.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import um.tds.controlador.Controlador;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class PanelRecientes extends JPanel implements IWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel_4 ;
	private JPanel panel_1;
	
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

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
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
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Recientes");
		
		
		if(Controlador.getUnicaInstancia().getUsuarioActual().isPremium()) comboBox.addItem("Top 10");
		
		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		       
		    	if(comboBox.getSelectedItem()!=""){
		    		
		    		
		    		
		    	}
		    	
		    	if(comboBox.getSelectedItem()!="Recientes"){
		    		
		    		
		    		
		    	}
		    	
		    	if(comboBox.getSelectedItem()!="Top 10"){
		    		
		    		
		    		
		    	}
		    	
		    	
		    }
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		panel_3.add(comboBox, gbc_comboBox);



		 panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.add(panel_4, BorderLayout.CENTER);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		add(panel_1, BorderLayout.CENTER);


	}

	@Override
	public void enterExplorar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitExplorar() {
		// TODO Auto-generated method stub
		
	}

}
