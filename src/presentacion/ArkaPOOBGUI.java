package presentacion;

import aplicacion.ArkaPOOB;
import aplicacion.ArkaPOOBException;
import aplicacion.Registro;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ArkaPOOBGUI extends JFrame{
	public static final Dimension DIMENSION_PREFERIDA;
	private static ArkaPOOB arkaPOOB;
	private static VentanaJuego juego;
	private static ArkaPOOBGUI partida;
	private static ArkaMenu menu;
	
	
	static {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		DIMENSION_PREFERIDA = new Dimension(screenSize.width/2,screenSize.height/2);
	}
	
	
	
	private ArkaPOOBGUI(){
		prepareElementos();
		prepareAcciones();
    }
	

	
	private void prepareElementos(){
		
		setTitle("ArkaPOOB");
		setSize(DIMENSION_PREFERIDA);
		setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("src/Imagenes/logo.png");
		setIconImage(img.getImage());
		//juego  =  new VentanaJuego(); 
		//getContentPane().add(juego, BorderLayout.CENTER);
		getContentPane().add(new Interfaz(), BorderLayout.CENTER);
		
		menu = new ArkaMenu();
		setJMenuBar(menu);
	}
	
	
	private static void limpiar() {
		partida.getContentPane().removeAll();
		partida.setVisible(false);
	}
	
	public static void empezarJuego(int estado) {
		limpiar();
		ArkaPOOB.nuevoJuego(estado);
		arkaPOOB = ArkaPOOB.demeArkaPOOB(estado);
		juego = new VentanaJuego();
		pintarJuego();
		
	}
	
	private static void pintarJuego(){
		try{
			partida.getContentPane().add(juego, BorderLayout.CENTER);
			partida.repaint();
			partida.setVisible(true);
		} catch(NullPointerException e1) {
			Registro.registre(e1);
		}
	}
	
	public static ArrayList<ArrayList<String>> demeJuegoInfo(){
		return arkaPOOB.demeBloques();
	} 
	
	
	private void prepareAcciones() {
		
		
	}
	
	
	public static double[][] demeInfoPlataformas(){
		return arkaPOOB.infoPlataformas();
	}
	
	public static ArrayList<ArrayList<String>> demeInfoBolas() {
		return arkaPOOB.demeInfoBolas();
	}



	public static void moverPlataformaAIzquierda() {
		arkaPOOB.moverPlataformaAIzquierda();
		arkaPOOB.comenzarSimulacion();
		
	}



	public static void moverPlataformaADerecha() {
		arkaPOOB.moverPlataformaADerecha();
		arkaPOOB.comenzarSimulacion();
	}
	
	public static void nuevoJuego() {
		terminarJuego();
		partida.setVisible(false);
		partida = new ArkaPOOBGUI();
		partida.setVisible(true);
	}
	
	public static void terminarJuego() {
		if(arkaPOOB!=null) {
			arkaPOOB.terminarJuego();
		}
	}
	
	public static boolean estaTerminado() {
		return arkaPOOB.isOver();
	}

	public static void main(String[] args) {
		partida = new ArkaPOOBGUI();
		partida.setVisible(true);
	}
	 
	public static int puntos() {
		return ArkaPOOB.getPuntos();
	}



	public static void moverPlataformaBIzquierda() {
		arkaPOOB.moverPlataformaBIzquierda();
		
	}
	
	public static void moverPlataformaBDerecha() {
		arkaPOOB.moverPlataformaBDerecha();
		
	}



	public static void opcionAbrir() {
		try {
			JFileChooser panel = new JFileChooser();
			int a  = panel.showOpenDialog(null);
			if(JFileChooser.CANCEL_OPTION != a) {
				File file = panel.getSelectedFile();
				if(!ArkaPOOB.esArchivoDat(file)) {
					JOptionPane.showMessageDialog(null, "Solo archivos con extensión .dat");
				} else {
					arkaPOOB = ArkaPOOB.abrir(panel.getSelectedFile());
					limpiar();
					pintarJuego();
				}
			}
		} catch (ArkaPOOBException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	
	
	public static void opcionSalvar() {
		JFileChooser panel = new JFileChooser();
		int a  = panel.showSaveDialog(null);
		if(JFileChooser.CANCEL_OPTION != a) {
			File file = panel.getSelectedFile();
			if(!ArkaPOOB.esArchivoDat(file)) {
				JOptionPane.showMessageDialog(null, "Solo archivos con extensión .dat");
			} else {
				try {
					ArkaPOOB.salve(file);
				} catch (ArkaPOOBException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
					
		}
	}
	
}



