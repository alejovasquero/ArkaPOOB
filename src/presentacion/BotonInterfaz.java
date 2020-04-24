package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class BotonInterfaz extends JButton{
	public BotonInterfaz(String text) {
		super(text);
		setPreferredSize(new Dimension(300,200));
		setOpaque(false);
		setContentAreaFilled(false);
		//setBorderPainted(false);
		setFont(new Font("Rockwell", Font.ITALIC, 40));
		setForeground(Color.WHITE);
	}
}
