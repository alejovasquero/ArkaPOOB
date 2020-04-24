package aplicacion;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class ArkaPOOB implements Runnable, Serializable{
	public static int ANCHO=1000;
	public static int LARGO=700;
	private static ArkaPOOB juego = null;
	
	private int bloquesActuales;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private ArrayList<Bola> bolas;
	private ArrayList<Poder> poderes;
	private Bloque[][] bloques;
	
	public static final int UN_JUGADOR = 1;
	public static final int COOP = 2;
	public static final int PVE = 3;
	
	private static int modoActual;
	private boolean juegoTerminado;
	private Thread hilo;
	
	private static int puntos;
	
	/**
	 * Constructor de videojuego ArkaPOOB
	 */
	private ArkaPOOB(int modo) {
		bloques = new Bloque[8][12];
		bolas =  new ArrayList<Bola>();
		modoActual = modo;
		juegoTerminado = false;
		generarBloques();
		prepareBolas();
		preparePlataformas();
		puntos = 0;
		
	}
	
	/**
	 * Crea un nuevo juego
	 * @param modo Modo del juego(jugadores)
	 */
	public static void nuevoJuego(int modo) {
		juego = new ArkaPOOB(modo);
	}
	
	
	/**
	 * Genera una configuracion aleatoria de bloques
	 */
	private void generarBloques() {
		for(int i=0;i<bloques.length;i++) {
			for(int j=0;j<bloques[0].length;j++) {
				bloques[i][j] = demeBloqueAleatorio(Bloque.BASE*j, LARGO-Bloque.ALTURA*i);
			}
		}
	}
	
	/**
	 * Retorna un bloque de cualquier tipo de manera aleatoria
	 * @param i posicion en x del nuevo bloque
	 * @param j posicion en y del nuevo bloque
	 * @return Bloque de cualquier tipo
	 */
	private Bloque demeBloqueAleatorio(int i, int j) {
		Bloque ans = null;
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100) + 1;
		if(randomInt>0 && randomInt<=10) {
			ans = new BloqueAzul(i,j);
		} else if(randomInt>10 && randomInt<=20) {
			ans = new BloqueAmarillo(i, j);
		} else if(randomInt>20 && randomInt<=22) {
			ans  = new BloqueRosado(i, j);
		} else if(randomInt >22 && randomInt <=42) {
			ans  = new BloqueGris(i, j);
		} else if(randomInt >42 && randomInt <=62) {
			ans  = new BloqueVerde(i, j);
		} else {
			ans  = new BloqueRojo(i, j);
		}
		return ans;
	}
	
	/**
	 * Retorna el juego actual de la clase
	 * @return juego ArkaPOOB (solo existe un juego) 
	 */
	public static ArkaPOOB demeArkaPOOB(int modo) {
		if(juego == null) {
			juego = new ArkaPOOB(modo);
		}
		return juego;
	}
	/**
	 * Retorna un arraylist con la informacion de cada bloque 
	 * @return arraylist con la siguiente informacion [x,y,width,height, vida, color]
	 */
	public ArrayList<ArrayList<String>> demeBloques(){
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		for(Bloque[] z: bloques) {
			for(Bloque t: z) {
				ArrayList<String> pib = new ArrayList<String>();
				pib.add(Double.toString(t.getX()));
				pib.add(Double.toString(t.getY()));
				pib.add(Double.toString(t.getWidth()));
				pib.add(Double.toString(t.getHeight()));
				pib.add(Double.toString(t.getVida()));
				pib.add(t.getColor());
				ans.add(pib);
			}
		}
		return ans;
	}
	
	/**
	 * Prepara la posicion de las plataforma dentro del tablero
	 */
	private void preparePlataformas() {
		if(modoActual == UN_JUGADOR) {
			jugadorA = new Jugador((ANCHO - Plataforma.ANCHO)/2,10+Plataforma.ALTO);
			
			jugadorB =  null;
		} else {
			jugadorA = new Jugador(ANCHO/2 - Plataforma.ANCHO -30 , 10+Plataforma.ALTO);
			jugadorB = new Jugador(ANCHO/2 + 30 ,10+Plataforma.ALTO);
			jugadorB.asignarPlataforma(new PlataformaPegajosa(0,0));
			jugadorB.asignarBola(bolas.get(0));
		}
		jugadorA.asignarPlataforma(new PlataformaPegajosa(0,0));
		jugadorA.asignarBola(bolas.get(0));
		bolas.get(0).reflejar(jugadorA, null);
	}
	
	/**
	 * Crea las bolas necesarias para el juego
	 */
	private void prepareBolas() {
		bolas.add(new Bola(0,0));
	}
	
	/**
	 * Retorna una matriz con la información de las plataformas 
	 * @return Matriz donde cada indice representa una plataforma [x,y,w,h]
	 */
	public double[][] infoPlataformas() {
		double ans[][];
		if(modoActual == UN_JUGADOR) {
			ans = new double[1][4];
			ans[0] = jugadorA.demeInfoPlataforma();
		} else {
			ans = new double[2][4];
			ans[0] = jugadorA.demeInfoPlataforma();
			ans[1] = jugadorB.demeInfoPlataforma();
			
		}
		
		
		return ans;
	}
	
	/**
	 * Retorna un arreglo con la información de las Bolas
	 * @return Arreglo con información de todas las bolas (x,y,radio)
	 */
	public ArrayList<ArrayList<String>> demeInfoBolas() {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		for(Bola a: bolas) {
			ArrayList<String> b = new ArrayList<String>();
			b.add(Double.toString(a.getX()));
			b.add(Double.toString(a.getY()));
			b.add(Double.toString(Bola.radio));
			ans.add(b);
		}
		return ans;
	}
	
	/**
	 * Mueve la plataforma del jugador A a la derecha
	 */
	public void moverPlataformaADerecha() {
		jugadorA.moverPlataformaDerecha();
	}
	
	/**
	 * Mueve la plataforma del jugador A a la izquierda
	 */
	public void moverPlataformaAIzquierda() {
		jugadorA.moverPlataformaIzquierda();
	}
	
	/**
	 * Mueve la plataforma del jugador B(si hay jugador B) a la derecha
	 */
	public void moverPlataformaBDerecha() {
		if(modoActual == COOP) {
			jugadorB.moverPlataformaDerecha();
		
		}
	}
	/**
	 * Mueve la plataforma del jugador B(si hay jugador B) a la izquierda
	 */
	public void moverPlataformaBIzquierda() {
		if(modoActual== COOP) {
			jugadorB.moverPlataformaIzquierda();
		
		}
	}
	/**
	 * Aumenta la puntuacion del juego
	 */
	public void aumentarPuntuacion() {
		
	}

	@Override
	public void run() {
		
		while(!juegoTerminado) {
			moverBolas();
			
		}
		
	}
	
	/**
	 * Hace que todas las bolas avancen. Avanzar significa detectar golpes y mover en la direccion correspondiente
	 */
	private void moverBolas() {
		for(Bola a: bolas) {
			avanzar(a);
		}
		
	}
	
	/**
	 * Detecta los golpes con el escenario y cambia la dirección de la bola
	 * @param a Bola para detectar golpes y mover
	 */
	private void avanzar(Bola a) {
		boolean choca = chocaParedes(a);
		if(!choca) {
			choca = chocaPlataformas(a);
		}
		if(!choca) {
			choca =  chocaBloques(a);
			
		}
		a.avanzar();
		
	}
	
	
	/**
	 * Detecta si la bola se choca con los bloques del escenario y cambia su dirección
	 * @param a Bola para detectar colisiones
	 * @return Si la bola choca con algún bloque
	 */
	private boolean chocaBloques(Bola a) {
		double puntoDeRebote = Integer.MAX_VALUE;
		Dividible visto =a.getdividible();
		
		Bloque choque=null;
		for(Bloque[] i: bloques) {
			for(Bloque j: i) {
				
				if(visto!=j && a.intersects(j.demeFigura()) && a.distanciaMinima(j)< puntoDeRebote && j.getVida()>0) {
					
					choque = j;
					puntoDeRebote = a.distanciaMinima(j);
					//System.out.println(choque.getX() + "    "+choque.getY());
					
					
				}
			}
		}
		
		if(choque!=null) {
			
			choqueBola(a,choque);
			
		}
		return choque!=null;
	}
	
	/**
	 * Cambia la dirección de la bola dado el choque con el bloque
	 * @param a Bola de detección
	 * @param b Bloque de detección
	 */
	private void choqueBola(Bola a, Bloque b) {
		double distancia = a.distanciaPerpendicular(b);
		double xc = a.getX();
		double yc = a.getY();
		double xr = b.getX();
		double yr = b.getY();
		double w = b.getWidth();
		double h = b.getHeight();
		
		if(Math.abs(distancia-Math.abs(yc-yr))<0.00000001 || Math.abs(distancia-Math.abs(yc-(yr-h)))<0.00000001) {
			a.reflejar(b, Pared.demeParedSuperior());
			b.golpear(a);
		} else if(Math.abs(distancia - Math.abs(xr+w-xc))<0.00000001 || Math.abs(distancia-Math.abs(xr-xc))<0.00000001){
			a.reflejar(b, Pared.demeParedDerecha());
			b.golpear(a);
		} else {
			//System.out.println(distancia);
		}
		
	}
	
	
	
	
	/**
	 * Verifica si la bola ha chocado contra alguna de las plataformas y realiza acciones si esto ha pasado
	 * @param a Bola para verificar choque con las plataformas
	 * @return Si la bola choca contra alguna de las plataformas
	 */
	private boolean chocaPlataformas(Bola a) {
		boolean choca = false;
		Dividible visto =  a.getdividible();
		
		if(visto!= jugadorA){
			choca = chocaPlataforma(a, jugadorA);
		} 
		if((modoActual == COOP || modoActual==PVE) && !choca) {
			choca =  chocaPlataforma(a, jugadorB);
		}
		return choca;
	}
	
	
	/**
	 * Verifica si la bola choa con la plataforma de jugador
	 * @param a Bola para verificar choque
	 * @param b Jugador que posee la plataforma
	 * @return Si la bola choca contra la plataforma del jugador
	 */
	private boolean chocaPlataforma(Bola a, Jugador b) {
		boolean choca = false;
		
		if(a.intersects(b.getPlataforma().demeFigura()) && a.getdividible()!=b) {
			choca = true;
			a.reflejar(b,Pared.demeParedInferior());
			b.asignarBola(a);
		}
		return choca;
	}
	
	
	
	/**
	 * Detecta si la bola choca con alguna de las paredes del escenario y cambia la dirección si es necesario
	 * @param a Bola para detectar colisiones
	 * @return Si la bola choca con las paredes
	 */
	public boolean chocaParedes(Bola a) {
		Pared b =  puntoDeRebote(a);
		a.reflejar(b,b);
		return b!=null;
		
	}
	
	
	
	
	/**
	 * Retorna la pared en la que la bola choca con el escenario
	 * @param a Bola de colision
	 * @return Pared del colision (null si no hay colision)
	 */
	public Pared puntoDeRebote(Bola a) {
		double x  = a.getX();
		double y = a.getY();
		int r = Bola.radio;
		//System.out.println(x+"     "+y);
		Pared ans = null;
		double maximo = Integer.MAX_VALUE;
		Dividible tomada = a.getdividible();
		if(x+r>=ArkaPOOB.ANCHO && Math.abs(x-ArkaPOOB.ANCHO)< maximo && Pared.demeParedDerecha()!= tomada) {
			ans =  Pared.demeParedDerecha();
			maximo = Math.abs(x-ArkaPOOB.ANCHO);
		} if(x-r<=0 && Math.abs(x)< maximo && Pared.demeParedizquierda()!= tomada) {
			ans = Pared.demeParedizquierda();
			maximo = Math.abs(x);
		} if(y+r >= ArkaPOOB.LARGO && Math.abs(y-ArkaPOOB.LARGO)< maximo && Pared.demeParedSuperior()!= tomada) {
			ans = Pared.demeParedSuperior();
			maximo = Math.abs(y-ArkaPOOB.LARGO);
		} if(y-r <=0 && Math.abs(y)< maximo && Pared.demeParedInferior()!= tomada) {
			ans = Pared.demeParedInferior();
		}
		return ans;
	}

	/**
	 * Comienza el hilo de simulacion del juego
	 */
	public void comenzarSimulacion() {
		if(hilo==null) {
			hilo = new Thread(this);
			hilo.start();
		}
	}

	/**
	 * Retorna si el juego ya ha terminado
	 * @return Si el juego ha terminado
	 */
	public boolean isOver() {
		return juegoTerminado;
	}
	
	/**
	 * Termina el juego
	 */
	public void terminarJuego() {
		juegoTerminado = true;
	}

	/**
	 * Suma puntos a la puntuación total
	 * @param puntosN Puntos a sumar
	 */
	public static void darPuntos(int puntosN) {
		puntos+=puntosN;
		
	}

	/**
	 * Retorna los puntos del juego
	 * @return Puntos del juego
	 */
	public static int getPuntos() {
		return puntos;
	}
	
	/**
	 * Retorna si el archivo dado tiene extension .dat
	 * @param file Archivo a analizar
	 * @return Si el archivo tiene extension .dat
	 */
	public static boolean esArchivoDat(File file) {
		Pattern z = Pattern.compile(".*\\.+(dat)$");
		return z.matcher(file.getName().trim()).matches();
	}
	
	/**
	 * Abre una nueva partida de juego
	 * @param pib Archivo a leer
	 * @return nueva partida
	 * @throws ArkaPOOBException
	 */
	public static ArkaPOOB abrir(File pib) throws ArkaPOOBException{
		
		   try {
			   ObjectInputStream in  = new ObjectInputStream(new FileInputStream(pib));
			   juego = (ArkaPOOB) in.readObject();
			   
		   } catch(ClassNotFoundException e) {
			   throw new ArkaPOOBException(ArkaPOOBException.CLASE_NO_ENCONTRADA);
		   } catch (IOException | SecurityException e) {
			   throw new ArkaPOOBException(ArkaPOOBException.ERROR_PERSISTENCIA);
		   } catch (NullPointerException e) {
			   throw new ArkaPOOBException(ArkaPOOBException.ARCHIVO_NO_ENCONTRADO);
		   }
		   
		return juego;
	}
	
	/**
	 * Guarda el juego en un archivo con extensión .dat
	 * @param pib Archivo a guardar el archivo
	 * @throws ArkaPOOBException
	 */
	public static void salve(File pib) throws ArkaPOOBException{
		try {
			if(juego!=null) {
				ObjectOutputStream out =  new ObjectOutputStream(new FileOutputStream(pib));
				juego.terminarJuego(); 
				out.writeObject(juego);
				out.close();
			}
		} catch (FileNotFoundException | NullPointerException e) {
			
			throw new ArkaPOOBException(ArkaPOOBException.ARCHIVO_NO_ENCONTRADO);
		} catch (IOException | SecurityException e) {
			throw new ArkaPOOBException(ArkaPOOBException.ERROR_PERSISTENCIA);
		}
	}
	
	
	
}
