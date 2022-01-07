package um.tds.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import um.tds.Lanzador;
import um.tds.controlador.Controlador;
import um.tds.dominio.ListaVideos;
import um.tds.dominio.Video;

public class PanelMisListas extends JPanel implements IWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<String> comboBox;
	private JPanel panel_4;
	private JTextField textField;
	private JPanel panel_7;
	private JPanel panel_1;

	private JLabel lblNewLabel_1;
	private JButton btnNewButton_2;

	private JPanel panel_8;

	private String videoSeleccionado = null;

	private JPanel panel_9;
	private JPanel panel_10;
	private JLabel lblNewLabel_3;
	private JPanel panel_11;
	private JLabel lblNewLabel_2;
	private JPanel panel_12;
	private JPanel panel_6;

	private JPanel panel_3;

	private JPanel video;

	/**
	 * Create the panel.
	 */
	public PanelMisListas() {
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
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 0;
		panel_3.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel = new JLabel("Seleccione la lista :");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);

		comboBox = new JComboBox<String>();
		comboBox.addItem("");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBox.getSelectedItem() != "") {

					showList(comboBox.getSelectedItem().toString());

				}

			}
		});

		JButton btnNewButton = new JButton("Reproducir");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		panel_3.add(btnNewButton, gbc_btnNewButton);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 4;
		gbc_horizontalStrut.gridy = 2;
		panel_3.add(horizontalStrut, gbc_horizontalStrut);

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel_3.add(comboBox, gbc_comboBox);

		btnNewButton.addActionListener(new ActionListener() { // BOTON REPRODUCIR

			public void actionPerformed(ActionEvent e) {

				if (comboBox.getSelectedItem().toString() != null && comboBox.getSelectedItem().toString() != ""
						&& videoSeleccionado != null) {

					addVideoPlayer();

				}

			}

		});

		panel_4 = new JPanel();
		JScrollPane scroll = new JScrollPane(panel_4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		// scroll.setHorizontalScrollBar(null);
		panel_4.setBackground(Color.GRAY);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.add(scroll, BorderLayout.CENTER);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1, BorderLayout.WEST);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GRAY);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_5.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() { // BOTON CANCELAR

			public void actionPerformed(ActionEvent e) {

				comboBox.setSelectedItem(0);
				cleanPanel();
			}

		});

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_8 = new JPanel();
		panel_8.setBackground(Color.GRAY);
		panel_1.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));

	}

	@Override
	public void enter() {

		if (Controlador.getUnicaInstancia().getListas().size() > 0) {

			for (ListaVideos l : Controlador.getUnicaInstancia().getListas()) {

				comboBox.addItem(l.getNombre());
			}

		}

		panel_3.revalidate();
		panel_3.repaint();

	}

	@Override
	public void exit() {

		cleanPanel();

	}

	private void addVideoPlayer() {

		cleanPanel();

		panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new BorderLayout(0, 0));

		panel_10 = new JPanel();
		panel_10.setBackground(Color.GRAY);
		panel_9.add(panel_10, BorderLayout.NORTH);

		lblNewLabel_3 = new JLabel(Controlador.getUnicaInstancia().findVideo(videoSeleccionado).getTitulo());
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.revalidate();
		lblNewLabel_3.setText(Controlador.getUnicaInstancia().findVideo(videoSeleccionado).getTitulo());
		lblNewLabel_3.paintImmediately(lblNewLabel_3.getVisibleRect());
		lblNewLabel_3.setVisible(true);
		panel_10.add(lblNewLabel_3);

		panel_11 = new JPanel();
		panel_11.setBackground(Color.GRAY);
		panel_9.add(panel_11, BorderLayout.CENTER);

		lblNewLabel_2 = new JLabel("Nº reproducciones "
				+ Integer.toString(Controlador.getUnicaInstancia().findVideo(videoSeleccionado).getNumRepro()));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setText("Nº reproducciones "
				+ Integer.toString(Controlador.getUnicaInstancia().findVideo(videoSeleccionado).getNumRepro()));
		lblNewLabel_2.revalidate();
		lblNewLabel_2.paintImmediately(lblNewLabel_2.getVisibleRect());
		lblNewLabel_2.setVisible(true);
		panel_11.add(lblNewLabel_2);

		panel_10.revalidate();
		panel_10.repaint();

		panel_11.revalidate();
		panel_11.repaint();

		panel_12 = new JPanel();
		panel_12.setBackground(Color.GRAY);
		panel_8.add(panel_12, BorderLayout.CENTER);

		panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_1.add(panel_6, BorderLayout.SOUTH);

		video = new JPanel();
		panel_8.add(video, BorderLayout.CENTER);

		panel_7 = new JPanel();
		panel_7.setBackground(Color.GRAY);
		panel_1.add(panel_7, BorderLayout.SOUTH);

		lblNewLabel_1 = new JLabel("Nueva Etiqueta:");
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_7.add(lblNewLabel_1);

		textField = new JTextField();
		panel_7.add(textField);
		textField.setColumns(10);

		btnNewButton_2 = new JButton("Añadir");
		panel_7.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() { // BOTON AÑADIR ETIQUETA

			public void actionPerformed(ActionEvent e) {

				if (textField.getText() != "" && textField.getText() != null) {

					Controlador.getUnicaInstancia().addEtiquetaVideo(
							Controlador.getUnicaInstancia().findVideo(videoSeleccionado), textField.getText());

				}
			}

		});

		video.add(Lanzador.videoWeb);
		video.setBackground(Color.gray);
		Controlador.getUnicaInstancia().playVideo(videoSeleccionado);

		panel_8.revalidate();
		panel_8.repaint();

	}

	private void cleanPanel() {
		for (Component c : panel_8.getComponents()) {

			panel_8.remove(c);
		}

		Controlador.getUnicaInstancia().stopVideo();

		panel_8.revalidate();
		panel_8.repaint();
	}

	private void showList(String lista) {

		for (Component c : panel_4.getComponents()) {

			panel_4.remove(c);
		}

		List<Video> l = Controlador.getUnicaInstancia().getLista(lista);

		if (l != null) {

			for (Video v : l) {

				if (v != null) {

					JButton boton = new JButton();
					boton.setBackground(Color.gray);
					boton.setActionCommand(v.getUrl());

					ImageIcon thumb = Lanzador.videoWeb.getSmallThumb(v.getUrl());

					boton.setIcon(thumb);
					boton.addActionListener(listenerButtons);

					panel_4.add(boton);

				}
			}

		}

		panel_4.revalidate();
		panel_4.repaint();
	}

	private ActionListener listenerButtons = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			videoSeleccionado = arg0.getActionCommand();

		}
	};

}