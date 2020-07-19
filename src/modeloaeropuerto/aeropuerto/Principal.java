package modeloaeropuerto.aeropuerto;

import java.util.ArrayList;

public class Principal {
    private static int [] servidoresLPM = {1,1,4};
    private static final int numeroDeSimulacion = 50;
    private static final float inicioSimulacion = 0;
    private static final float tiempoSimulacion = 10080;
    
    public static void main(String[] args){
	Evento actual;
        Fel fel = Fel.getFel();//Creo la lista de eventos futuros
        ArrayList<Queue> queue = new ArrayList<>();//Creo la cola de espera
        ArrayList<Servidor> servidor = new ArrayList<>();//Creo el servidor
        for(int j = 0; j < numeroDeSimulacion; j++){
            boolean finSimulacion=false;
            Item.reiniciar();
            fel.reiniciarFel(inicioSimulacion, tiempoSimulacion);
            queue.clear();
            servidor.clear();
            for(int i = 0; i <6; i++){
                queue.add(new Queue());
                servidor.add(new Servidor());
            }
            while(!finSimulacion){
                actual = fel.suprimirFel();
                actual.planificarEvento(servidor, queue);
                if( actual.getTipo() == Evento.FIN_SIMULACION )
                    { finSimulacion = true; }
                /*
                else
                    { mostrarEstadoActual(actual, queue.get(actual.getItem().getServidor()).getCanidad()); }
                */
            }
            Estadisticas.mostrarEstadisticas(servidor, queue, tiempoSimulacion);
        }
        Estadisticas.estadisticasFinales();
    }
    
    private static void mostrarEstadoActual(Evento actual, int cantidadEnCola){
        String guiones = "------------------------------";
        Item itemActual = actual.getItem(); 
        System.out.println("|TIEMPO: "+actual.getTiempo2()+"    \t|ITEM: "+itemActual.getNumero()+" \t|EVENTO: "+actual.getTipo2()
                +"\t\t|VUELO: "+itemActual.getTipo2()+"\t|PISTA: "+itemActual.getServidor()
                +"\t|EN ESPERA: "+ cantidadEnCola
                +"\t|TEA : "+itemActual.tea()+"\t|TDS : "+itemActual.tds()); 
        System.out.println("+"+guiones+guiones+guiones+guiones+guiones+"+");
        Fel.getFel().mostrarFel();
        System.out.println("+"+guiones+guiones+guiones+guiones+guiones+"+");
    }
    
}
