package aplicacion;

import java.io.Serializable;

public class BloqueRosado extends Bloque implements Serializable{
	/**
	 * Crea un bloque Rosado
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public BloqueRosado(float x, float y) {
		super(x, y);
		setColor("Pink");
		setVida(1);
		setPuntos(0);
	}
}
