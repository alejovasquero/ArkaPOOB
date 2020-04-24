package presentacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Logo extends JPanel{
		private BufferedImage imagen;
		public Logo() {
			File archivoImagen = new File("src/Imagenes/arkanoid.png");
	        try {
				imagen = ImageIO.read(archivoImagen);
			} catch (IOException e) {
				
			}
	        setOpaque(false);
		}
		@Override 
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
	        g2.setRenderingHints(TablaInformacion.renderizado);
	        g2.drawImage(imagen, 0, 0,getSize().width, getSize().height, this);
		}
}
