package model.logic;

<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.Cola;
import model.data_structures.IArregloDinamico;
import model.data_structures.Pila;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
=======
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
/**
 * Definicion del modelo del mundo
 *
 */
<<<<<<< HEAD
public class MVCModelo <Integer extends Comparable<Integer>>
{
	/**
	 * Atributos del modelo del mundo
	 */
	private ArregloDinamico datos;

	private Cola datosCola;

	private Pila datosPila;

=======
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	
>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ArregloDinamico(7);
	}
<<<<<<< HEAD

=======
	
>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public MVCModelo(int capacidad)
	{
<<<<<<< HEAD
		datos = new <Viajes>ArregloDinamico(capacidad);
	}

=======
		datos = new ArregloDinamico(capacidad);
	}
	
>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
<<<<<<< HEAD

=======
	
>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}
<<<<<<< HEAD

=======
	
>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}

<<<<<<< HEAD
	public static void read(String[] args) {

		CSVReader reader = null;
		try {

			reader = new CSVReader(new FileReader("./data/ bogota-cadastral-2018-1-All-MonthlyAggregate.csv"));
			for(String[] nextLine : reader) {
				nextLine[0].split(",");
				System.out.println("col1: " + nextLine[0] + ", col2: "+ nextLine[1]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void cargarDatos()
	{
		String archCSV = "./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv";
		CSVReader csvReader = new CSVReader(new FileReader(archCSV));
		String[] fila = null;
		int cont=0;
		Nodo primerNodo;
		Nodo temp= primerNodo;
		while((fila = csvReader.readNext()) != null) {
			int cantidadDeViajes;
			if(cont<1){
				cont++;
			}
			else if (temp==null){
				double sa = (double)(Integer.parseInt(fila[0])) ;
				cantidadDeViajes++;
				temp = new Nodo((double)(Integer.parseInt(fila[0])));
			}
			else {
				cantidadDeViajes++;
				temp=temp.darSiguiente();
				temp = new Nodo((double)(Integer.parseInt(fila[0])));
			}

		}

		csvReader.close();
	}

	public int totalViajesPila() throws IOException
	{
		int respuesta =0;
		String archCSV = "./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv";
		CSVReader csvReader = new CSVReader(new FileReader(archCSV));
		String[] fila = null;
		while((fila = csvReader.readNext()) != null) 
		{
			respuesta ++;

		}
		return respuesta;
	}
	public int totalViajesCola() throws IOException
	{
		int respuesta =0;
		String archCSV = "./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv";
		CSVReader csvReader = new CSVReader(new FileReader(archCSV));
		String[] fila = null;
		while((fila = csvReader.readNext()) != null) 
		{
			respuesta ++;

		}
		return respuesta;
	}
=======

>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
}
