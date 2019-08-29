package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private String elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public String darElemento(int i) {
<<<<<<< HEAD
			if(i<tamanoAct)
			{
				return elementos[i];
			}
=======
			// TODO implementar
>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
			return null;
		}

		public String buscar(String dato) {
<<<<<<< HEAD
			String respuesta = null;
			for(int i =0;i<tamanoMax;i++)
			{
				if(elementos[i].compareTo(dato)==0)
				{
					respuesta = elementos[i];

				}
			}
			return respuesta;
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		
		}

		public String eliminar(String dato) {
			// DONE implementar
			String datosAEliminar = null;
			int a;
			int b;
			for(a=0;a<tamanoMax;a++)
			{
				if(elementos[a].compareTo(dato)==0)
				{
					datosAEliminar= elementos[a];
					for(b=a; b< tamanoMax;b++)
					{
						elementos[b] = elementos[b+1];
					}
				}
			}
=======
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			return null;
		}

		public String eliminar(String dato) {
			// TODO implementar
>>>>>>> 0aa8aa2a0dcb8ef0a26b1bf9254318a971fe539c
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			return null;
		}

}
