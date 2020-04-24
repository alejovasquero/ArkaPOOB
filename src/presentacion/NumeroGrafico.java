package presentacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.ArkaPOOB;

public class NumeroGrafico extends JPanel {
	private char numero ='0';
	private static Image[] numeros;
	public NumeroGrafico() {
		super();
		setLayout(null);
	}
	
	public void setNumero(char nuevo){
		numero = nuevo;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D t = (Graphics2D) g;
		t.setRenderingHints(TablaInformacion.renderizado);
		
		try {
			t.drawImage(numeros[numero-48] ,0 ,0,getWidth(), getHeight(), this);
		} catch(ArrayIndexOutOfBoundsException e) {
			t.drawImage(numeros[8] ,0 ,0,getWidth(), getHeight(), this);
		}
		
	}
	
	

	static {
		numeros = new Image[10];
		for(int i=0; i<numeros.length;i++) {
			numeros[i] = Toolkit.getDefaultToolkit().getImage("src/Imagenes/"+i+".png");
		}
		
	}
}
