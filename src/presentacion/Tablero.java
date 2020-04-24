package presentacion;

import aplicacion.ArkaPOOB;
import java.awt.*;

import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;





public class Tablero extends JPanel{

	private static BufferedImage imagen;
	private static Tablero principal;
    private static boolean painted = false;
	
    
	private Tablero() {
		setBackground(Color.RED);
		setPreferredSize(new Dimension( ArkaPOOB.ANCHO, ArkaPOOB.LARGO));
		File archivoImagen = new File("src/Imagenes/tablero.jpg");
        try {
			imagen = ImageIO.read(archivoImagen);
		} catch (IOException e) {
			e.printStackTrace();
		}
        


        
        
        
	}
	
	public static Tablero getTablero(JComponent juego){
        if(principal == null) {
            principal = new Tablero();
        }
        return principal;
    }

    public static void nuevoTablero() {
    	principal = new Tablero();
    	
    }
    
    
    
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHints(TablaInformacion.renderizado);
        g2.drawImage(imagen, 0, 0,getSize().width, getSize().height, this);
        pintarBloques(g2,ArkaPOOBGUI.demeJuegoInfo());
        pintarPlataformas(g2, ArkaPOOBGUI.demeInfoPlataformas());
        pintarBolas(g2, ArkaPOOBGUI.demeInfoBolas());
	    
	    
	        
	}
    
    
    
    
    
    private void pintarBolas(Graphics2D g2, ArrayList<ArrayList<String>> bolas) {
    	for(ArrayList<String> z: bolas) {
    		pintarBola(g2,z);
    	}
	}
    
    
    private void pintarBola(Graphics2D g2, ArrayList<String> caracteristicas) {
    	int x = (int)Double.parseDouble(caracteristicas.get(0));
    	int y = (int)Double.parseDouble(caracteristicas.get(1));
    	int r = (int)Double.parseDouble(caracteristicas.get(2));
    	
    	//g2.fillOval(x-r,ArkaPOOB.LARGO-  y-r,2*r, 2*r);
    	Image im = Toolkit.getDefaultToolkit().getImage("src/Imagenes/bola.png"); 
        g2.drawImage(im, x-r,ArkaPOOB.LARGO- y-r, 2*r, 2*r, this);
    }

	private void pintarBloques(Graphics2D g, ArrayList<ArrayList<String>> bloques) {
    	for(ArrayList<String> z: bloques) {
    		pintarBloque(g,z);
    	}
    }
	
    
    
    private void pintarBloque(Graphics2D g2, ArrayList<String> caracteristicas) {
    	int x = (int)Double.parseDouble(caracteristicas.get(0));
    	int y = (int)Double.parseDouble(caracteristicas.get(1));
    	int w = (int)Double.parseDouble(caracteristicas.get(2));
    	int h = (int)Double.parseDouble(caracteristicas.get(3));
    	int vida = (int)Double.parseDouble(caracteristicas.get(4));
    	String color =(String) caracteristicas.get(5);
    	g2.setColor(Color.BLACK);
    	if(vida>0) {
			Image im = Toolkit.getDefaultToolkit().getImage("src/Imagenes/"+color+".png"); 
    		Rectangle2D r = new Rectangle2D.Float(x,ArkaPOOB.LARGO- y, w, h);
    		//g2.draw(r);
            g2.drawImage(im, x,ArkaPOOB.LARGO- y, w, h, this);
            
		}
    }
    
    private void  pintarPlataformas(Graphics g, double[][] info) {
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setRenderingHints(TablaInformacion.renderizado);
    	for(double[] a: info) {
    		int x = (int)a[0];
    		int y = (int)a[1];
    		int w = (int)a[2];
    		int h = (int)a[3];
    		Image im = Toolkit.getDefaultToolkit().getImage("src/Imagenes/plataforma.png");
    		//g2.drawRect(x,ArkaPOOB.LARGO-  y, w, h);
    		g2.drawImage(im,(int) x,ArkaPOOB.LARGO- y-20, w, h+40, this);
    	}
    	
        
    }
    
    
}