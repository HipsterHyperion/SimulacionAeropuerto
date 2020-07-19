package modeloaeropuerto.aeropuerto;

import java.util.ArrayList;

public class EventoArribo extends Evento{
    
    public EventoArribo(float tiempo,Item item){
		super(Evento.ARRIBO,tiempo,item);
    } 
        
    @Override
    public void planificarEvento(ArrayList<Servidor> servidor, ArrayList<Queue> queue){
        //planifico el evento de arribo
        Fel fel = Fel.getFel();
        Item itemActual =  super.getItem();
        int tipoActual = itemActual.getTipo();
        float tiempoActual = super.getTiempo();
        if(tipoActual==Item.VUELO_MEDIANO){
            int i = 2;
            for(i=2; i<6; i++){
                if(!(servidor.get(i).isEstado()))
                    {break;}
            }
            if(i==6)
                {ponerEnCola(queue, itemActual);}
            else
                {ponerEnServidor(servidor.get(i), tiempoActual, itemActual, i);}
        }
        else{
            if(!(servidor.get(tipoActual).isEstado())){
                ponerEnServidor(servidor.get(tipoActual), tiempoActual, itemActual, tipoActual);
            }
            else{ 
                itemActual.setServidor(tipoActual);
                queue.get(tipoActual).insertarCola(itemActual); 
            }
        }
        int tea = GeneradorTiempos.getTiempoEntreArribos(tipoActual,tiempoActual);
        Item nuevo = new Item(Item.getCantidadItems(Item.VUELO_GENERAL)+1, tiempoActual + tea, tipoActual);
        nuevo.setTea(tea);
        fel.insertarFel(new EventoArribo(nuevo.getTiempoArribo(), nuevo));
    }
    
    private void ponerEnCola(ArrayList<Queue> queue, Item itemActual){
        int i, max, pos;
        max = queue.get(2).getCanidad();
        pos = 2;
        for (i=3;i<6;i++){
            if( max < queue.get(i).getCanidad()){
                max = queue.get(i).getCanidad();
                pos = i;
            }
        }
        itemActual.setServidor(pos);
        queue.get(pos).insertarCola(itemActual);
    }
  
    private void ponerEnServidor(Servidor servidor, float tiempoActual, Item itemActual, int serv){
        itemActual.setServidor(serv);
        servidor.setEstado(true);
        servidor.incrementarCantidad();
        servidor.setItem(itemActual);
        servidor.setTiempoOcioso(tiempoActual - servidor.getTiempoInicioOcio());
        Fel.getFel().insertarFel(new EventoSalida(tiempoActual + itemActual.tds(), itemActual));
    }
    
}
