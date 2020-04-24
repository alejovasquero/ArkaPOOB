package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class ArkaMenu extends JMenuBar {
	private JMenu archivo;
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem salvarComo;
	private JMenuItem importar;
	private JMenuItem exportar;
	private JMenuItem salir;
	
	
	public ArkaMenu() {
		super();
		setOpaque(true);
		setBackground(Color.CYAN);
		prepareElementos();
		prepareAcciones();
		
	}


	private void prepareAcciones() {
		nuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArkaPOOBGUI.nuevoJuego();
				
			}
		});
		
		abrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArkaPOOBGUI.opcionAbrir();
				
			}
		});
		
		salvarComo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArkaPOOBGUI.opcionSalvar();
				
			}
		});
		
	}

	
	
	
	private void prepareElementos() {
		archivo = new JMenu("Archivo");
		add(archivo);
		prepareItems();
		archivo.add(nuevo);
		archivo.add(abrir);
		archivo.add(salvarComo);
		archivo.add(exportar);
		archivo.add(importar);
		archivo.add(salir);
	}


	private void prepareItems() {
		abrir = new JMenuItem("Abrir");
		nuevo = new JMenuItem("Nuevo");
		salvarComo = new JMenuItem("Salvar Como");
		importar = new JMenuItem("Importar");
		exportar = new JMenuItem("Exportar");
		salir = new JMenuItem("Salir");
	}
	
	
	
	
}
