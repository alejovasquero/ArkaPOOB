package aplicacion;

import java.io.Serializable;

public class BloqueGris extends Bloque implements Serializable{
	/**
	 * Crea un bloque Gris
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public BloqueGris(float x, float y) {
		super(x, y);
		setColor("Gray");
		setVida(Integer.MAX_VALUE);
		setPuntos(0);
	}
	
	@Override
	public void golpear(Bola a) {
		
	}
}
