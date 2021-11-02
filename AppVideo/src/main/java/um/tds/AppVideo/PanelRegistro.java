package um.tds.AppVideo;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class PanelRegistro extends JPanel {


	// hola iwiwei 
	
	public PanelRegistro() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);

	}

}
