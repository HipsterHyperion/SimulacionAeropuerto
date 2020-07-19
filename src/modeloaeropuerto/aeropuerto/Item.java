package modeloaeropuerto.aeropuerto;

public class Item  {
	private int numero;
        private int tipo; //0:Liviano, 1:Pesado, 2:Mediano.
        private int servidor;
	private float tiempoArribo;
	private float tiempoEntreArribo;
	private float tiempoDuracionServicio;
        
        public static final int VUELO_GENERAL = -1; 
        public static final int VUELO_LIVIANO = 0; 
        public static final int VUELO_PESADO = 1; 
        public static final int VUELO_MEDIANO = 2; 
        
	private static float tiempoTransito=0;
	private static int cantidadItems=0;
	private static float tiempoTransitoLiviano=0;
	private static int cantidadItemsLiviano=0;
	private static float tiempoTransitoPesado=0;
	private static int cantidadItemsPesado=0;
	private static float tiempoTransitoMediano=0;
	private static int cantidadItemsMediano=0;
        
        public Item(int numero,float tiempoArribo, int tipo){
		this.numero=numero;
		this.tiempoArribo=tiempoArribo;
                this.tipo=tipo;
                cantidadItems++;
                switch(tipo){
                    case VUELO_LIVIANO:
                        cantidadItemsLiviano++;
                        break;
                    case VUELO_PESADO:
                        cantidadItemsPesado++;
                        break;
                    case VUELO_MEDIANO:
                        cantidadItemsMediano++;
                        break;
                }
		this.tiempoDuracionServicio = GeneradorTiempos.getTiempoDuracionServicio(this.tipo);
	}
        
        public static void reiniciar(){
            tiempoTransito=0;
            cantidadItems=0;
            tiempoTransitoLiviano=0;
            cantidadItemsLiviano=0;
            tiempoTransitoPesado=0;
            cantidadItemsPesado=0;
            tiempoTransitoMediano=0;
            cantidadItemsMediano=0;
        }
        
        public int getServidor(){
            return this.servidor;
        }
        
        public void setServidor(int serv){
            this.servidor=serv;
        }
        
        public int getTipo(){
            return this.tipo;
        }
        
        public String getTipo2(){
            String cadena;
            switch(this.tipo){
                case VUELO_LIVIANO:
                    cadena = "Liviano";
                    break;
                case VUELO_PESADO:
                    cadena = "Pesado";
                    break;
                default:
                    cadena = "Mediano";
            }
            return cadena;
        }
        
        public String getTipo3(){
            String cadena;
            switch(this.tipo){
                case VUELO_LIVIANO:
                    cadena = "L";
                    break;
                case VUELO_PESADO:
                    cadena = "P";
                    break;
                default:
                    cadena = "M";
            }
            return cadena;
        }
        
        public static String getTipo4(int tipo){
            String cadena;
            switch(tipo){
                case VUELO_LIVIANO:
                    cadena = "Liviano";
                    break;
                case VUELO_PESADO:
                    cadena = "Pesado";
                    break;
                default:
                    cadena = "Mediano";
            }
            return cadena;
        }
        
        public static int monto(int tipo){
            int monto;
            switch(tipo){
                case VUELO_LIVIANO:
                    monto = 25000;
                    break;
                case VUELO_PESADO:
                    monto = 70000;
                    break;
                default:
                    monto = 45000;
            }
            return monto;
        }
        
        public void setTipo(int tipo){
            this.tipo=tipo;
        }
        
        public float tea(){
            return this.tiempoEntreArribo;
        }
        
        public void setTea(float tea){
            this.tiempoEntreArribo=tea;
        }
        
        public float tds(){
            return this.tiempoDuracionServicio;
        }
        
	/**
        * @param tipo
	* @return Returns the cantidadItems.
	*/
	public static int getCantidadItems(int tipo) {
                int cantidad;
                switch(tipo){
                    case VUELO_LIVIANO:
                        cantidad = cantidadItemsLiviano;
                        break;
                    case VUELO_PESADO:
                        cantidad = cantidadItemsPesado;
                        break;
                    case VUELO_MEDIANO:
                        cantidad = cantidadItemsMediano;
                        break;
                    default:
                        cantidad = cantidadItemsMediano;
                }
		return cantidad;
	}
	
        /**
	* @param cantidadItems The cantidadItems to set.
	*/
	public static void setCantidadItems(int cantidadItems) {
		Item.cantidadItems = cantidadItems;
	}
		
        /**
        * @param tipo
	* @return Returns the tiempoTransito.
	*/
	public static float getTiempoTransito(int tipo) {
                float cantidad = 0;
                switch(tipo){
                    case VUELO_LIVIANO:
                        cantidad = tiempoTransitoLiviano;
                        break;
                    case VUELO_PESADO:
                        cantidad = tiempoTransitoPesado;
                        break;
                    case VUELO_MEDIANO:
                        cantidad = tiempoTransitoMediano;
                        break;
                    default:
                        cantidad = tiempoTransitoMediano;
                }
		return cantidad;
	}
        
	public static void setTiempoTransito(float tiempoActual, float tiempoArribo, int tipo) {
			//calcular el tiempo de transito
                float acumulador =tiempoActual - tiempoArribo;
                tiempoTransito += acumulador;
                switch(tipo){
                    case VUELO_LIVIANO:
                        tiempoTransitoLiviano += tiempoActual - tiempoArribo;
                        break;
                    case VUELO_PESADO:
                        tiempoTransitoPesado += tiempoActual - tiempoArribo;
                        break;
                    case VUELO_MEDIANO:
                        tiempoTransitoMediano += tiempoActual - tiempoArribo;
                        break;
                }
	}
        
	/**
	 * @return Returns the numero.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero The numero to set.
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return Returns the tiempoArribo.
	 */
	public float getTiempoArribo() {
		return this.tiempoArribo;
	}

	/**
	 * @param tiempoArribo The tiempoArribo to set.
	 */
	public void setTiempoArribo(float tiempoArribo) {
		this.tiempoArribo=tiempoArribo;
	}

	/**
	 * @return Returns the tiempoDuracionServicio.
	 */
	public float getTiempoDuracionServicio() {
		return tiempoDuracionServicio;
	}

	/**
	 * @param tiempoDuracionServicio The tiempoDuracionServicio to set.
	 */
	public void setTiempoDuracionServicio(float tiempoDuracionServicio) {
		this.tiempoDuracionServicio = tiempoDuracionServicio;
	}
        
}
