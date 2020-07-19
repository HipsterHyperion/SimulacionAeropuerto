package modeloaeropuerto.aeropuerto;

import java.util.ArrayList;

public class Servidor {
	private Item item;
	private boolean estado;
	private float tiempoOcioso;
	private float tiempoInicioOcio;
	private int cantidad;
        
	public Servidor(){
		item=null; //No hay items en el servidor
		estado=false; //Desocupado
		tiempoOcioso=0;//No hay tiempo Ocioso
                tiempoInicioOcio=0;//Inicio de Ocio en 0
                cantidad=0; //Nunca fue ocupado
        }
	
        public int getCantidad(){
            return this.cantidad;
        }
        
        public void setCantidad(int cantidad){
            this.cantidad = cantidad;
        }
        
        public void incrementarCantidad(){
            this.cantidad++;
        }
        
	/**
	 * @return Returns the item.
	 */
	public Item getItem() {
		return item;
	}
	
        /**
	 * @param item The item to set.
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return Returns the estado.
	 */
	public boolean isEstado() {
		return estado;
	}
        
	public String isEstado2() {
            String cadena = "Libre";
            if(estado) 
                {cadena="Ocupado";}
            return cadena;
	}
        
        /**
	 * @param estado The estado to set.
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * @return Returns the tiempoOcioso.
	 */
	public float getTiempoOcioso() {
		return tiempoOcioso;
	}
	
	/**
	 * @param tiempoOcioso The tiempoOcioso to set.
	 */
	public void setTiempoOcioso(float tiempoOcioso) {
		//calcular el tiempo de inicio de ocio
                this.tiempoOcioso+=tiempoOcioso;
	}

	/**
	 * @return Returns the tiempoInicioOcio.
	 */
	public float getTiempoInicioOcio() {
		return tiempoInicioOcio;
	}

	/**
	 * @param tiempoInicioOcio The tiempoInicioOcio to set.
	 */
	public void setTiempoInicioOcio(float tiempoInicioOcio) {
		this.tiempoInicioOcio = tiempoInicioOcio;
	}
        
}
