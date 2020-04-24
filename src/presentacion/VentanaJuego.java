package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import aplicacion.ArkaPOOB;

public class VentanaJuego extends JPanel implements KeyListener, Runnable{
	private TablaInformacion datos;
	private Tablero tablero;
	private HiloTablero hilo;
	
	
	
	
	
	
	
	public VentanaJuego(){
		setFocusable(true);
        prepareElementos();
		prepareAcciones();
		
    }
	

	
	private void prepareElementos(){
		setLayout(new BorderLayout());
		datos = new TablaInformacion();
		add(datos, BorderLayout.EAST);
		
		tablero =  Tablero.getTablero(this);
		tablero.setLayout(null);
		add(tablero, BorderLayout.WEST);
		
		setSize(ArkaPOOBGUI.DIMENSION_PREFERIDA);
		
		
		hilo = new HiloTablero(this);
		hilo.start();
		
		
	}

	
	
	
	
	
	
	
	
	
	private void prepareAcciones() {
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		addKeyListener(this);
		
	}
	
	
	



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		int b = e.getKeyCode();
		
		if(b == KeyEvent.VK_LEFT) {
			
			ArkaPOOBGUI.moverPlataformaAIzquierda();
		}else if(b == KeyEvent.VK_RIGHT) {
			ArkaPOOBGUI.moverPlataformaADerecha();
		} else if (b == KeyEvent.VK_A) {
			ArkaPOOBGUI.moverPlataformaBIzquierda();
		} else if(b == KeyEvent.VK_D) {
			ArkaPOOBGUI.moverPlataformaBDerecha();
		}
		tablero.repaint();
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void run() {
		while(!ArkaPOOBGUI.estaTerminado()) {
			tablero.repaint();
			datos.repaint();
			
		}
		
	}



	
	
	
}
