package model.logic;

import static org.junit.Assert.assertArrayEquals;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Framework: Cupi2Collections
 * Autor: Pablo Barvo - 9-May-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~
 */

import java.io.Serializable;
import java.util.Iterator;

import com.sun.corba.se.impl.logging.IORSystemException;



/**
 * Lista doblemente encadenada con cabeza y cola
 * @param <T> Tipo de datos a almacenar en la lista
 */
public class ListaEncadenada<r> implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
    /**
	 * Constante para la serializaci�n
	 */
	private static final long serialVersionUID = 1L;
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cabeza de la lista encadenada
     */
    private Nodo<r> primero;

    /**
     * �ltimo elemento de la lista encadenada
     */
    private Nodo<r> ultimo;

    /**
     * N�mero de elementos de la lista
     */
    private int numElem;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la lista vac�a. <br>
     * <b>post: </b> Se construy� una lista vac�a.
     */
    public ListaEncadenada( )
    {
        primero = null;
        ultimo = null;
        numElem = 0;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Busca un elemento en la lista encadenada. <br>
     * <b>post: </b> Se retorna el elemento o null si no existe.
     * @param modelo Modelo del elemento a buscar
     * @return Elemento en la lista, null si no existe
     */
    public Nodo<r> buscarNodo( r modelo )
    {
        for( Nodo<r> t = primero; t != null; t = t.darSiguiente() )
        {
            if( t.darElemento().equals( modelo ) )
            {
                return t;
            }
        }
        return null;
    }

    /**
     * Retorna la longitud (cantidad de elementos) de la lista encadenada. <br>
     * <b>post: </b> Se retorn� la longitud de la lista.
     * @return Longitud de la lista. 0 en caso que no tenga elementos.
     */
    public int darLongitud( )
    {
        return numElem;
    }

    /**
     * Retorna el primer nodo de la lista. <br>
     * <b>post: </b> Se retorn� el primer nodo de la lista.
     * @return Primer nodo de la lista. Null en caso que la lista sea vac�a.
     */
    public Nodo<r> darPrimero( )
    {
        return primero;
    }

    /**
     * Retorna el �ltimo nodo de la lista. <br>
     * <b>post: </b> Se retorn� el �ltimo nodo de la lista.
     * @return �ltimo nodo de la lista. Null en caso que la lista sea vac�a.
     */
    public Nodo<r> darUltimo( )
    {
        return ultimo;
    }

    /**
     * Inserta el elemento en la cabeza (inicio) de la lista. <br>
     * <b>post: </b> Se insert� el elemento en la cabeza de la lista. La cantidad de elementos aumenta <br>
     * En caso que la lista no sea vac�a, el nuevo elemento queda como el primero. Si la lista es vac�a el nuevo elemento es el primero y el �ltimo<br>
     * @param elemento Elemento a insertar
     */
    public void insertarCabeza( r elemento )
    {
        Nodo<r> nodo = new Nodo<r>( elemento );
        if( primero == null )
        {
            primero = nodo;
            ultimo = nodo;
        }
        else
        {
            primero.cambiarAnterior(nodo);
            primero = nodo;
        }
        numElem++;
    }

    /**
     * Inserta el elemento en la cola (final) de la lista. <br>
     * <b>post: </b> Se insert� el elemento en la cola de la lista. La cantidad de elementos aumenta <br>
     * En caso que la lista no sea vac�a, el nuevo elemento queda como el �ltimo. Si la lista es vac�a el nuevo elemento es el primero y el �ltimo<br>
     * @param elemento Elemento a insertar<br>
     */
    public void insertarCola( r elemento )
    {
        Nodo<r> nodo = new Nodo<r>( elemento );
        if( primero == null )
        {
            primero = nodo;
            ultimo = nodo;
        }
        else
        {
        	
            ultimo.cambiarSiguiente(nodo);
            nodo.cambiarAnterior(ultimo);
            ultimo = nodo;
        }
        numElem++;
    }

    /**
     * Elimina el nodo de la lista encadenada. <br>
     * <b>post: </b> Se elimin� el nodo especificado de la lista. La cantidad de elementos de la lista se reduce.<br>
     * @param nodo Nodo a ser eliminado de la lista<br>
     * @throws NoExisteException El nodo especificado no pertenece a la lista<br>
     */
    public void eliminarNodo( Nodo<r> nodo ) throws NoExisteException
    {
        if( buscarNodo( nodo.darElemento() ) == null )
        {
            throw new NoExisteException( "El nodo especificado no pertenece a la lista" );
        }
        else if( primero == nodo )
        {
        	if(primero.darSiguiente()!=null)
        	{
        		primero = primero.darSiguiente();
        		numElem--;
        		
        	}
        	else
        	{
        		primero = null;
        		numElem--;
        	}
        }
        else if(ultimo == nodo )
        {
            {
            	ultimo = ultimo.darAnterior();
            	numElem--;
            }
        }
        else
        {
        	Nodo<r> x = buscarNodo(nodo.darElemento());
        	Nodo<r> y = x.darSiguiente();
        	x.darAnterior().cambiarSiguiente(y);
        	numElem--;
        }
    }

    /**
     * Elimina el primer nodo (cabeza) de la lista y devuelve el elemento que conten�a. <br>
     * <b>post: </b> Se elimin� el primer nodo de la lista. Se retorn� el elemento contenido en el nodo eliminado. La cantidad de elementos se reduce en uno. Si la lista no
     * tiene nodos se retorna null.<br>
     * @return Elemento del nodo eliminado<br>
     */
    public r eliminarPrimero( )
    {
        if( primero == null )
        {
            return null;
        }
        else
        {
        	Nodo<r> x = primero;
        	primero = x.darSiguiente();
        	numElem--;
            return x.darElemento();
            
        }
    }

    /**
     * Elimina el ultimo nodo y devuelve el elemento que conten�a. <br>
     * <b>post: </b> Se elimin� el �ltimo nodo de la lista. Se retorn� el elemento contenido en el nodo eliminado. La cantidad de elementos se reduce en uno. Si la lista no
     * tiene nodos se retorna null.
     * @return Elemento del nodo eliminado
     */
    public r eliminarUltimo( )
    {
    	if( ultimo == null )
        {
            return null;
        }
        else
        {
        	Nodo<r> x = ultimo;
        	ultimo = x.darAnterior();
        	numElem--;
            return x.darElemento();
            
        }
    }

   

    /**
     * Inserta el elemento en la posici�n especificada. <br>
     * <b>post: </b> Se insert� el elemento en la posici�n especificada.<br>
     * @param elemento Elemento a insertar<br>
     * @param pos La posici�n en la que se va a insertar el elemento<br>
     * @throws IndiceFueraDeRangoException Excepci�n lanzada cuando se quiere agregar el elemento en una posici�n invalida<br>
     */
    public void insertar( r elemento, int x)
    {
        Nodo<r> nodoNuevo = new Nodo<r>( elemento );
   
            Nodo<r> aux = primero;
            int contador = 0;

            while(aux!=null)
            {
            	if(contador==x)
            	{
            		if(aux==primero)
            		{
            			insertarCabeza(elemento);
            		}
            		else if(aux==ultimo)
            		{
            			insertarCola(elemento);
            		}
            		else
            		{
            			Nodo<r> auxDos = aux;
            			aux.darAnterior().cambiarSiguiente(nodoNuevo);
            			nodoNuevo.cambiarSiguiente(auxDos);
            			nodoNuevo.cambiarAnterior(auxDos.darAnterior());
            			auxDos.cambiarAnterior(nodoNuevo);
            			
            		}
            	}
            	contador++;
            	aux = aux.darSiguiente();
            }
            
            
        
    }

 
    

    /**
     * Eval�a si la lista contiene el elemento que se pasa por par�metro<br>
     * @param modelo Modelo del elemento a buscar.<br>
     * @return True en caso que el elemento dado exista en la lista, false de lo contrario.<br>
     */
    public boolean contiene( r modelo )
    {
        return buscarNodo( modelo ) != null;
    }

    /**
     * Elimina todos los elementos de la lista.<br>
     * <b>post: </b> La lista ahora es vac�a. primero = null, ultimo=null, numElems = 0<br>
     */
    public void vaciar( )
    {
        primero = null;
        ultimo = null;
        numElem = 0;
    }

    
    
    
}