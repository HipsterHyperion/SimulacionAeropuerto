package modeloaeropuerto.aeropuerto;

import java.util.LinkedList;

public class Queue {
	private int cantidadItems;
        private float tiempoEspera;
	private LinkedList<Item> cola;
	
	public Queue(){
		cola=new LinkedList();
		cantidadItems=0;
                tiempoEspera=0;
	}
	
        public float getTiempoEspera(){
            return tiempoEspera;
        }
        
        public void setTiempoEspera(float tiempo){
            tiempoEspera += tiempo;
        }
        
	public void insertarCola(Item item){
		cola.addLast(item);
                cantidadItems++;
	}
	
	public Item suprimirCola(){
                cantidadItems--;
                return cola.remove();
	}
	
	public boolean HayCola(){
		return cantidadItems!=0;
	}
        public int getCanidad(){
                return this.cantidadItems;//size(?
        }
}
