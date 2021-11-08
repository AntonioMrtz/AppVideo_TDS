package um.tds.AppVideo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class PanelMisListas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelMisListas frame = new PanelMisListas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelMisListas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzq = new JPanel();
		contentPane.add(panelIzq, BorderLayout.WEST);
		GridBagLayout gbl_panelIzq = new GridBagLayout();
		gbl_panelIzq.columnWidths = new int[]{0, 0};
		gbl_panelIzq.rowHeights = new int[]{0, 24, 31, 0, 0, 0};
		gbl_panelIzq.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelIzq.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelIzq.setLayout(gbl_panelIzq);
		
		JLabel lblIntroducirNombreLista = new JLabel("introducir nombre lista:");
		GridBagConstraints gbc_lblIntroducirNombreLista = new GridBagConstraints();
		gbc_lblIntroducirNombreLista.insets = new Insets(0, 0, 5, 0);
		gbc_lblIntroducirNombreLista.gridx = 0;
		gbc_lblIntroducirNombreLista.gridy = 0;
		panelIzq.add(lblIntroducirNombreLista, gbc_lblIntroducirNombreLista);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panelIzq.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		panelIzq.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnBuscar = new JButton("buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 0;
		panel.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnEliminar = new JButton("eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 0;
		panel.add(btnEliminar, gbc_btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		panelIzq.add(scrollPane, gbc_scrollPane);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.SOUTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panelIzq.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnAadir = new JButton("añadir");
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadir.gridx = 0;
		gbc_btnAadir.gridy = 0;
		panel_1.add(btnAadir, gbc_btnAadir);
		
		JButton btnQuitar = new JButton("quitar");
		GridBagConstraints gbc_btnQuitar = new GridBagConstraints();
		gbc_btnQuitar.insets = new Insets(0, 0, 5, 0);
		gbc_btnQuitar.gridx = 2;
		gbc_btnQuitar.gridy = 0;
		panel_1.add(btnQuitar, gbc_btnQuitar);
		
		JButton btnAceptar = new JButton("aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 1;
		panel_1.add(btnAceptar, gbc_btnAceptar);
		
		JPanel panelCent = new JPanel();
		contentPane.add(panelCent, BorderLayout.CENTER);
		GridBagLayout gbl_panelCent = new GridBagLayout();
		gbl_panelCent.columnWidths = new int[]{0, 0};
		gbl_panelCent.rowHeights = new int[]{75, 219, 0};
		gbl_panelCent.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCent.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelCent.setLayout(gbl_panelCent);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panelCent.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblBuscarTtulo = new JLabel("Buscar Título:");
		GridBagConstraints gbc_lblBuscarTtulo = new GridBagConstraints();
		gbc_lblBuscarTtulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscarTtulo.anchor = GridBagConstraints.EAST;
		gbc_lblBuscarTtulo.gridx = 0;
		gbc_lblBuscarTtulo.gridy = 0;
		panel_3.add(lblBuscarTtulo, gbc_lblBuscarTtulo);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_3.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("buscar");
		GridBagConstraints gbc_btnBuscar_1 = new GridBagConstraints();
		gbc_btnBuscar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar_1.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar_1.gridx = 2;
		gbc_btnBuscar_1.gridy = 0;
		panel_3.add(btnBuscar_1, gbc_btnBuscar_1);
		
		JButton btnNuevaBsqueda = new JButton("Nueva Búsqueda");
		GridBagConstraints gbc_btnNuevaBsqueda = new GridBagConstraints();
		gbc_btnNuevaBsqueda.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuevaBsqueda.gridx = 1;
		gbc_btnNuevaBsqueda.gridy = 1;
		panel_3.add(btnNuevaBsqueda, gbc_btnNuevaBsqueda);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panelCent.add(scrollPane_1, gbc_scrollPane_1);
	}

}
