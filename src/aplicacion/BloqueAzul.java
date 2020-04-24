package aplicacion;

import java.io.Serializable;

public class BloqueAzul extends Bloque implements Serializable{
	/**
	 * Crea un bloque Azul
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public BloqueAzul(float x, float y) {
		super(x, y);
		setColor("Blue");
		setVida(1);
		setPuntos(300);
	}
}
