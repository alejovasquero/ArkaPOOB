package aplicacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArkaPOOBTest {

	@Test
	void deberiaUbicarBola() {
		ArkaPOOB a = ArkaPOOB.demeArkaPOOB(ArkaPOOB.UN_JUGADOR);
		ArrayList<String> lis = a.demeInfoBolas().get(0);
		double[] b = a.infoPlataformas()[0];
		double y1 = Double.parseDouble(lis.get(1))-Bola.radio;
		double y2 = b[1];
		assertTrue(Math.abs(y2-y1)<0.00000000001);
	}
	
	@Test
	void deberiaChocarParedes() {
		ArkaPOOB a = ArkaPOOB.demeArkaPOOB(ArkaPOOB.UN_JUGADOR);
		Bola bola = new Bola(ArkaPOOB.ANCHO+1, ArkaPOOB.LARGO/2);
		assertTrue(a.puntoDeRebote(bola)==Pared.demeParedDerecha());
		
		bola = new Bola(0,ArkaPOOB.LARGO/2);
		assertTrue(a.puntoDeRebote(bola)==Pared.demeParedizquierda());
		
		bola = new Bola(ArkaPOOB.ANCHO/2,0);
		assertTrue(a.puntoDeRebote(bola)==Pared.demeParedInferior());
		
		bola = new Bola(ArkaPOOB.ANCHO/2,ArkaPOOB.LARGO);
		assertTrue(a.puntoDeRebote(bola)==Pared.demeParedSuperior());
	}
	
	@Test
	void deberiaHacerInterseccion() {
		Rectangle a = new Rectangle("Red", 100, 100);
		a.changeSize(50,100);
		
		Circle b = new Circle("Blue", 175, 150);
		b.changeSize(100);
		assertTrue(b.intersects(a));
	}

}
