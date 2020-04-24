package aplicacion;

import java.io.Serializable;

public class BloqueAmarillo extends Bloque implements Serializable{
	/**
	 * Crea un bloque Amarillo
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public BloqueAmarillo(float x, float y) {
		super(x, y);
		setColor("Yellow");
		setVida(1);
		setPuntos(0);
	}
}
