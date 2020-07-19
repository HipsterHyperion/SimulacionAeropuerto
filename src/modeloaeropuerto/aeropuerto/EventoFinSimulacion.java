package modeloaeropuerto.aeropuerto;

import java.util.ArrayList;

public class EventoFinSimulacion extends Evento {
	
	public EventoFinSimulacion(float tiempo){
           super(Evento.FIN_SIMULACION,tiempo,null);
	}
        
        @Override
	public void planificarEvento(ArrayList<Servidor> servidor,ArrayList<Queue> queue){
            //No hacer nada
            servidor.forEach((s) -> {
                s.setTiempoOcioso(super.getTiempo() - s.getTiempoInicioOcio());
            }); 
	}
        
    @Override
    public String toString(){
        String cadena = "(FIN)";
        return cadena;
    }
}
