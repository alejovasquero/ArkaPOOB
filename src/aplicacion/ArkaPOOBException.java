package aplicacion;
import java.io.*;

public class ArkaPOOBException extends Exception implements Serializable{
	public static final String EN_CONSTRUCCION = "Opción …  en construcción";
	public static final String ARCHIVO_NO_ENCONTRADO = "No fue posible encontrar el archivo";
	public static final String ERROR_PERSISTENCIA = "No se pudo cargar el archivo correctamente";
	public static final String CLASE_NO_ENCONTRADA = "El archivo no es compatible con la clase requerida";
	public static final String ERROR_LECTURA = "El archivo suministrado no cumple con las especificaciones de lectura";
	public static final String PARAMETROS_INCORRECTOS =	"Los parametros suministrados no son correspondientes a la clase suministrada";
	public static final String PARAMETROS_INSUFICIENTES = "Los parametros no son suficientes para la entrega";
	public static final String CLASE_NO_RECONOCIDA = "No se encontró la clase solicitada";
	public static final String CONSTRUCTOR_NO_ECONTRADO = "No se encontró el constructor de la clase";
	public static final String ACCESO_ILEGAL = "No es posible acceder a la creación de la clase solicitada";
	
	public ArkaPOOBException(String a) {
		super(a);
	}
}
