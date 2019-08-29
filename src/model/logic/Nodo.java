	package model.logic;

public class Nodo<r> 
{
	private Nodo<r> cola;
	private Nodo<r> cabeza;
	private r elemento;
	private Nodo<r> siguiente;
	private Nodo<r> anterior;

	
	
	public Nodo (r elemento)
	{
		siguiente = null;
		anterior = null;
		this.elemento = elemento;
	}
	
	
	
	public Nodo<r> darSiguiente()
	{
		return siguiente;
	}
	
	public void cambiarSiguiente(Nodo<r> elemento)
	{
		this.siguiente = elemento;
		
	}
	
	public Nodo<r> darAnterior()
	{
		return anterior;
	}
	
	public void cambiarAnterior(Nodo<r> elemento)
	{
		this.anterior = elemento;
		
	}
	
	public Nodo<r> eliminar()
	{
		return null;
		
	}
	
	public r darElemento()
	{
		return elemento;
	}

	
	public Nodo<r> actual()
	{
		return this;
	}
	
	public Nodo<r> darCabeza()
	{
		return cabeza;
	}
	
	public Nodo<r> darCola()
	{
		return cola;
	}
}
