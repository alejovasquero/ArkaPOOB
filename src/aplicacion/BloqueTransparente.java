package aplicacion;

import java.io.Serializable;

public class BloqueTransparente extends Bloque implements Serializable{
	private Bola bolaAtrapada;
	/**
	 * Crea un bloque transparente
	 * @param x Posicion en x
	 * @param y Posicion en y
	 */
	public BloqueTransparente(float x, float y) {
		super(x, y);
		setColor(null);
		setVida(1);
		setPuntos(1000);
		bolaAtrapada = null;
	}
	
	
	@Override
	public void golpear(Bola a) {
		if(bolaAtrapada == a) {
			asignarBola(a);
		} else if(bolaAtrapada!=null){
			bolaAtrapada.ignicion();
			super.golpear(a);
		}
	}

	/**
	 * Asigna una bola al bloque
	 * @param a Bola a atrapar
	 */
	private void asignarBola(Bola a) {
		bolaAtrapada = a;
		bolaAtrapada.hacerVelocidadNula();
		
	}
}
