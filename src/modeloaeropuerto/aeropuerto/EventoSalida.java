package modeloaeropuerto.aeropuerto;

import java.util.ArrayList;

public class EventoSalida extends Evento {
	
    public EventoSalida(float tiempo,Item item){
	super(Evento.SALIDA,tiempo,item);
    }
        
    @Override
    public void planificarEvento(ArrayList<Servidor> servidor, ArrayList<Queue> queue) {
        //planifico evento de salida
        Fel fel = Fel.getFel();
        Item itemActual =  super.getItem();
        int serv = itemActual.getServidor();
        float tiempoActual = super.getTiempo();
        queue.get(serv).setTiempoEspera(tiempoActual - itemActual.tds() - itemActual.getTiempoArribo());
        Item.setTiempoTransito(tiempoActual, itemActual.getTiempoArribo(), itemActual.getTipo());
        if(queue.get(serv).HayCola()){
            Item itemNuevo = queue.get(serv).suprimirCola();
            servidor.get(serv).incrementarCantidad();
            servidor.get(serv).setItem(itemNuevo);
            fel.insertarFel(new EventoSalida(tiempoActual+ itemNuevo.tds(), itemNuevo));
        }
        else{
            servidor.get(serv).setEstado(false);
            servidor.get(serv).setTiempoInicioOcio(tiempoActual);
        }
    }
    
}
