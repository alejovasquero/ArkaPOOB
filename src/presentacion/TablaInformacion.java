package presentacion;


import aplicacion.ArkaPOOB;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.border.TitledBorder;

public class TablaInformacion extends JPanel {
	private Logo logo;
	private JPanel puntuacion;
	private JLabel nivel;
	private JPanel vidas;
	
	
	public static final RenderingHints renderizado = 
			new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	private BufferedImage imagen;
	
	public TablaInformacion() {
		File archivoImagen = new File("src/Imagenes/info.jpg");
        try {
			imagen = ImageIO.read(archivoImagen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        prepareElementos();
		
	}
		  
	private void prepareElementos() {
		setLayout(new GridLayout(4,1));
		setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - ArkaPOOB.ANCHO, 100));
		puntuacion = new JPanel();
		logo = new Logo();
		nivel = new JLabel();
		vidas =  new JPanel();
		add(logo);
		puntuacion.setLayout(new GridLayout(1,8));
		add(puntuacion);
		puntuacion.setOpaque(false);
		//add(nivel);
		//add(vidas);
		preparePuntuacion();
	}
	
	
	
	
	private void preparePuntuacion() {
		puntuacion.setLayout(new GridLayout(1,8));
		for(int i =0; i<8; i++) {
			puntuacion.add(new NumeroGrafico());
		}
	}
	
	private void pintePuntuacion(Graphics g) {
		
		
		String ans = String.format("%08d",ArkaPOOB.getPuntos());
		
		int i=0;
		
		for(Component a: puntuacion.getComponents()){
			
			
			if(a instanceof NumeroGrafico) {
				
				//((JLabel)a).setText("22");
				NumeroGrafico b =((NumeroGrafico)a);
				((NumeroGrafico) a).setNumero(ans.charAt(i));
				
				
				i++;
				
			}
			
		
			
		}
		//puntuacion.repaint();
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHints(renderizado);
        g.drawImage(imagen,0,0, getSize().width, getSize().height,null);
        pintePuntuacion(g2);
	}
	
	
}
