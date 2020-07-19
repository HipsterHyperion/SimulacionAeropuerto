package modeloaeropuerto.aeropuerto;

import java.util.ArrayList;

public abstract class Evento {
	private int tipo;//0: Arribo - 1:Fin de Servicio - 2: Fin de Simulacion
	private float tiempo;
	private Item item;
        
        public static final int ARRIBO = 0;
        public static final int SALIDA = 1;
        public static final int FIN_SIMULACION = 2;
	
	public Evento(int tipo,float tiempo,Item item){
            this.tipo=tipo;
            this.tiempo=tiempo;
            this.item=item;
        }

        public Item getItem() {
            return this.item;
        }

        public void setItem(Item item) {
            this.item=item;
        }
	
	public float getTiempo() {
            return this.tiempo;
	}
        
	public float getTiempo2() {
            float t = (int)(this.tiempo*1000);
            t=t/1000;
            return t;
    }

	public void setTiempo(float tiempo) {
            this.tiempo=tiempo;
	}
	
	public int getTipo() {
            return this.tipo;
	}
	
	public String getTipo2() {
            String tipo;
            if(getTipo() == ARRIBO)
                { tipo = "Arribo"; }
            else 
                { tipo = "Salida"; }
            return tipo;
	}
        
	public String getTipo3() {
            String tipo;
            if(getTipo() == ARRIBO)
                { tipo = "A"; }
            else 
                { tipo = "S"; }
            return tipo;
	}
        
	public void setTipo(int tipo) {
            this.tipo=tipo;
	}
        
        @Override
        public String toString() {
            String cadena ="("+this.getItem().getNumero()+"_"+getTipo3()+"_"+this.getItem().getTipo3()+")";
            return cadena;
        }
        
	/**
	 *  Implementa la planiificaci�n de eventos.
	 */
	public abstract void planificarEvento(ArrayList<Servidor> servidor,ArrayList<Queue> queue);
}
