package mx.uam.ayd.proyecto.presentacion.muestraVistaMOp;

import java.awt.Color;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

public class Desktop extends JInternalFrame {
	
	public Desktop(String title, JPanel panel) {
		super(title);
		setMaximizable(true);
		UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.black ));
		setBorder(new LineBorder(Color.DARK_GRAY, 4, true));
		setBackground(Color.WHITE);
		
		setResizable(true);

		try {
			setClosed(true);
		} catch (PropertyVetoException e) {
		
			e.printStackTrace();
		}
		setClosable(true);
		setBounds(100, 100, 100, 100);
		setBackground(Color.white);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		//setVisible(true);

	}
}
