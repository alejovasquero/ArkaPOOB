package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

import aplicacion.ArkaPOOB;

public class Interfaz extends JPanel {
	private static Image imagen;
	
	private BotonInterfaz unJugador;
	private BotonInterfaz dosJugadores;
	private BotonInterfaz pvp;
    private JPanel botones;
	
	public Interfaz() {
		setBackground(Color.RED);
		setPreferredSize(new Dimension( ArkaPOOB.ANCHO, ArkaPOOB.LARGO));
		imagen = Toolkit.getDefaultToolkit().getImage("src\\Imagenes\\interfaz.png");
        prepareElementos();
        prepareAcciones();
	}
	
	
	
	
	private void prepareAcciones() {
		unJugador.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArkaPOOBGUI.empezarJuego(ArkaPOOB.UN_JUGADOR);
			}
			
		});
		dosJugadores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArkaPOOBGUI.empezarJuego(ArkaPOOB.COOP);
				
			}
		});
	}




	private void prepareElementos() {
		setLayout(new BorderLayout());
		prepareBotones();
		add(botones, BorderLayout.SOUTH);
	}




	private void prepareBotones() {
		botones =  new JPanel();
		botones.setOpaque(false);
		botones.setLayout(new FlowLayout());
		unJugador = new BotonInterfaz("Un Jugador");
		dosJugadores =  new BotonInterfaz("Cooperativo");
		pvp = new BotonInterfaz("COM") ;
		
		botones.add(unJugador);
		botones.add(dosJugadores);
		botones.add(pvp);
	}




	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHints(TablaInformacion.renderizado);
        g2.drawImage(imagen, 0, 0,getSize().width, getSize().height, this);
        
	    
	    
	        
	}
}
