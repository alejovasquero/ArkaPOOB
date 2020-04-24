package aplicacion;

import java.io.Serializable;

public class Jugador implements Dividible, Serializable{
	private Plataforma plataforma;
	
	public Jugador(int posX, int posY) {
		plataforma = new Plataforma(posX, posY);
	}
	
	public void moverPlataformaDerecha() {
		plataforma.moverDerecha();
	}
	
	public void moverPlataformaIzquierda() {
		plataforma.moverIzquierda();;
	}
	
	public double[] demeInfoPlataforma() {
		return plataforma.demeInfo();
		
	}
	
	public void asignarPlataforma(Plataforma nueva) {
		nueva.asignarX(plataforma.getX());
		nueva.asignarY(plataforma.getY());
		plataforma = nueva;
	}
	
	
	public void asignarBola(Bola a) {
		if(plataforma instanceof PlataformaPegajosa) {
			((PlataformaPegajosa)plataforma).asignarBola(a);
		}
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	
}
