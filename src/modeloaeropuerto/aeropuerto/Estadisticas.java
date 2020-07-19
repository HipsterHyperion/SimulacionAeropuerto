package modeloaeropuerto.aeropuerto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Estadisticas {
	
    private static int numeroDeSimulacion = 0;
    private static float transitoLivianoAcumulador = 0;
    private static float transitoPesadoAcumulador = 0;
    private static float transitoMedianoAcumulador = 0;
    private static float ociosoLivianoAcumulador = 0;
    private static float ociosoPesadoAcumulador = 0;
    private static float ociosoMedianoAcumulador = 0;
    private static float esperaLivianoAcumulador = 0;
    private static float esperaPesadoAcumulador = 0;
    private static float esperaMedianoAcumulador = 0;
    private static LinkedList<Registro> universal = new LinkedList<>();
    
    public static void mostrarEstadisticas(ArrayList<Servidor> servidor, ArrayList<Queue> queue, float tiempoSimulacion){
        
        numeroDeSimulacion++;
        
        float mediaTransitoLiviano = (Item.getTiempoTransito(Item.VUELO_LIVIANO) / Item.getCantidadItems(Item.VUELO_LIVIANO));
        float mediaTransitoPesado = (Item.getTiempoTransito(Item.VUELO_PESADO) / Item.getCantidadItems(Item.VUELO_PESADO));
        float mediaTransitoMediano  = (Item.getTiempoTransito(Item.VUELO_MEDIANO) / Item.getCantidadItems(Item.VUELO_MEDIANO));
        transitoLivianoAcumulador += mediaTransitoLiviano;
        transitoPesadoAcumulador += mediaTransitoPesado;
        transitoMedianoAcumulador += mediaTransitoMediano;
        Registro r = new Registro(numeroDeSimulacion, mediaTransitoLiviano, mediaTransitoPesado, mediaTransitoMediano);
        r.setOciosoLiviano(servidor.get(Item.VUELO_LIVIANO).getTiempoOcioso()/tiempoSimulacion);
        r.setOciosoPesado(servidor.get(Item.VUELO_PESADO).getTiempoOcioso()/tiempoSimulacion);
        float mediaOciosoMediano=(servidor.get(2).getTiempoOcioso()+servidor.get(3).getTiempoOcioso()+servidor.get(4).getTiempoOcioso()+servidor.get(5).getTiempoOcioso())/4;
        r.setOciosoMediano(mediaOciosoMediano/tiempoSimulacion);
        r.setEsperaLiviano(queue.get(Item.VUELO_LIVIANO).getTiempoEspera()/Item.getCantidadItems(Item.VUELO_LIVIANO));
        r.setEsperaPesado(queue.get(Item.VUELO_PESADO).getTiempoEspera()/Item.getCantidadItems(Item.VUELO_PESADO));
        r.setEsperaMediano(0);
        ociosoLivianoAcumulador += r.getOciosoLiviano();
        ociosoPesadoAcumulador += r.getOciosoPesado();
        ociosoMedianoAcumulador += r.getOciosoMediano();
        esperaLivianoAcumulador += r.getEsperaLiviano();
        esperaPesadoAcumulador += r.getEsperaPesado();
        esperaMedianoAcumulador += r.getEsperaMediano();
        universal.add(r);
        
        System.out.println("\n\n+-----------------------------------------------+-------------------------------------------------------+");
        System.out.printf("|\t   RECOLECCION DE ESTADISTICAS\t\t|\t\t NUMERO DE SIMULACION: %d\t\t|\n", numeroDeSimulacion);
        System.out.println("+-----------------------------------------------+-------------------------------------------------------+\n");
        for (int i = 0; i < 6; i++){
            System.out.println("+-----------------------+---------------+-------------------------------+-------------------------------+");
            System.out.printf("|VUELO: %s\t\t|PISTA: %d\t|SERVIDOR OCUPADO: %d veces\t|RECAUDADO: $%,d\t\t|\n", Item.getTipo4(i), i,
                    servidor.get(i).getCantidad(), (Item.monto(i))*(servidor.get(i).getCantidad()) );
            System.out.println("+-----------------------+---------------+-------+-----------------------+-------------------------------+");
            calcularEstadisticas(queue.get(i).getTiempoEspera(), Item.getTiempoTransito(i), 
                    servidor.get(i).getTiempoOcioso(), tiempoSimulacion, Item.getCantidadItems(i));
        }
        System.out.println("+-----------------------------------------------+-------------------------------------------------------+");
        
	}
        
    public static void estadisticasFinales(){
        
        int i;
        float zalfa = (float)1.645;
        float aux = (float)Math.sqrt(numeroDeSimulacion); 
        float transitoLivianoMedia, transitoPesadoMedia, transitoMedianoMedia;
        float transitoLivianoDesviacion=0, transitoPesadoDesviacion=0, transitoMedianoDesviacion=0;
        float transitoLivianoIntervalo, transitoPesadoIntervalo, transitoMedianoIntervalo;
        float ociosoLivianoMedia, ociosoPesadoMedia, ociosoMedianoMedia;
        float ociosoLivianoDesviacion=0, ociosoPesadoDesviacion=0, ociosoMedianoDesviacion=0;
        float ociosoLivianoIntervalo, ociosoPesadoIntervalo, ociosoMedianoIntervalo;
        float esperaLivianoMedia, esperaPesadoMedia, esperaMedianoMedia;
        float esperaLivianoDesviacion=0, esperaPesadoDesviacion=0, esperaMedianoDesviacion=0;
        float esperaLivianoIntervalo, esperaPesadoIntervalo, esperaMedianoIntervalo;
        transitoLivianoMedia = transitoLivianoAcumulador / numeroDeSimulacion;
        transitoPesadoMedia = transitoPesadoAcumulador / numeroDeSimulacion;
        transitoMedianoMedia = transitoMedianoAcumulador / numeroDeSimulacion;
        ociosoLivianoMedia = ociosoLivianoAcumulador / numeroDeSimulacion;
        ociosoPesadoMedia = ociosoPesadoAcumulador / numeroDeSimulacion;
        ociosoMedianoMedia = ociosoMedianoAcumulador / numeroDeSimulacion;
        esperaLivianoMedia = esperaLivianoAcumulador / numeroDeSimulacion;
        esperaPesadoMedia = esperaPesadoAcumulador / numeroDeSimulacion;
        esperaMedianoMedia = esperaMedianoAcumulador / numeroDeSimulacion;
        
        Registro r;
        ListIterator<Registro> corre = universal.listIterator();
        while(corre.hasNext()){
            r = corre.next();
            transitoLivianoDesviacion += Math.pow(r.getTransitoLiviano() - transitoLivianoMedia, 2) ;
            transitoPesadoDesviacion += Math.pow(r.getTransitoPesado() - transitoPesadoMedia, 2);
            transitoMedianoDesviacion += Math.pow(r.getTransitoMediano() - transitoMedianoMedia, 2);
            ociosoLivianoDesviacion += Math.pow(r.getOciosoLiviano() - ociosoLivianoMedia, 2);
            ociosoPesadoDesviacion += Math.pow(r.getOciosoPesado() - ociosoPesadoMedia, 2);
            ociosoMedianoDesviacion += Math.pow(r.getOciosoMediano() - ociosoMedianoMedia, 2);
            esperaLivianoDesviacion += Math.pow(r.getEsperaLiviano() - esperaLivianoMedia, 2);
            esperaPesadoDesviacion += Math.pow(r.getEsperaPesado() - esperaPesadoMedia, 2);
            esperaMedianoDesviacion += Math.pow(r.getEsperaMediano() - esperaMedianoMedia, 2);
        }
        transitoLivianoDesviacion /= (numeroDeSimulacion-1);
        transitoPesadoDesviacion /= (numeroDeSimulacion-1);
        transitoMedianoDesviacion /= (numeroDeSimulacion-1);
        ociosoLivianoDesviacion /= (numeroDeSimulacion-1);
        ociosoPesadoDesviacion /= (numeroDeSimulacion-1);
        ociosoMedianoDesviacion /= (numeroDeSimulacion-1);
        esperaLivianoDesviacion /= (numeroDeSimulacion-1);
        esperaPesadoDesviacion /= (numeroDeSimulacion-1);
        esperaMedianoDesviacion /= (numeroDeSimulacion-1);
        
        transitoLivianoDesviacion = (float)Math.sqrt(transitoLivianoDesviacion);
        transitoPesadoDesviacion = (float)Math.sqrt(transitoPesadoDesviacion);
        transitoMedianoDesviacion = (float)Math.sqrt(transitoMedianoDesviacion);
        ociosoLivianoDesviacion = (float)Math.sqrt(ociosoLivianoDesviacion);
        ociosoPesadoDesviacion = (float)Math.sqrt(ociosoPesadoDesviacion);
        ociosoMedianoDesviacion = (float)Math.sqrt(ociosoMedianoDesviacion);
        esperaLivianoDesviacion = (float)Math.sqrt(esperaLivianoDesviacion);
        esperaPesadoDesviacion = (float)Math.sqrt(esperaPesadoDesviacion);
        esperaMedianoDesviacion = (float)Math.sqrt(esperaMedianoDesviacion);
        
        transitoLivianoIntervalo = zalfa*transitoLivianoDesviacion/aux;
        transitoPesadoIntervalo = zalfa*transitoPesadoDesviacion/aux;
        transitoMedianoIntervalo = zalfa*transitoMedianoDesviacion/aux;
        ociosoLivianoIntervalo = zalfa*ociosoLivianoDesviacion/aux;
        ociosoPesadoIntervalo = zalfa*ociosoPesadoDesviacion/aux;
        ociosoMedianoIntervalo = zalfa*ociosoMedianoDesviacion/aux;
        esperaLivianoIntervalo = zalfa*esperaLivianoDesviacion/aux;
        esperaPesadoIntervalo = zalfa*esperaPesadoDesviacion/aux;
        esperaMedianoIntervalo = zalfa*esperaMedianoDesviacion/aux;
        
        /*
        System.out.println(transitoLivianoDesviacion);
        System.out.println(transitoLivianoIntervalo);
        System.out.println(transitoLivianoMedia);
        System.out.println(transitoMedianoDesviacion);
        System.out.println(transitoMedianoIntervalo);
        System.out.println(transitoMedianoMedia);
        System.out.println(transitoPesadoDesviacion);
        System.out.println(transitoPesadoIntervalo);
        System.out.println(transitoPesadoMedia);
        System.out.println(ociosoLivianoDesviacion);
        System.out.println(ociosoLivianoIntervalo);
        System.out.println(ociosoLivianoMedia);
        System.out.println(ociosoMedianoDesviacion);
        System.out.println(ociosoMedianoIntervalo);
        System.out.println(ociosoMedianoMedia);
        System.out.println(ociosoPesadoDesviacion);
        System.out.println(ociosoPesadoIntervalo);
        System.out.println(ociosoPesadoMedia);
        System.out.println(esperaLivianoDesviacion);
        System.out.println(esperaLivianoIntervalo);
        System.out.println(esperaLivianoMedia);
        System.out.println(esperaMedianoDesviacion);
        System.out.println(esperaMedianoIntervalo);
        System.out.println(esperaMedianoMedia);
        System.out.println(esperaPesadoDesviacion);
        System.out.println(esperaPesadoIntervalo);
        System.out.println(esperaPesadoMedia);

        */
        
    }
    
    private static void calcularEstadisticas(float tiempoEsperaCola, float tiempoTransito, float tiempoOcioso, 
			                                float tiempoFinSimulacion, int cantidadItems){
        
        System.out.printf("|TIEMPO TOTAL OCIOSO:\t      %,.2f    \t|PORCENTAJE OCIOSO:\t\t %.2f%s   \t\t|\n",
                        tiempoOcioso ,tiempoOcioso*100/tiempoFinSimulacion, "%");
        System.out.printf("|TIEMPO TOTAL ESPERA EN COLA: %,.2f\t\t|TIEMPO PROMEDIO ESPERA EN COLA: %.2f\t\t\t|\n",
                        tiempoEsperaCola, tiempoEsperaCola/cantidadItems);
        System.out.printf("|TIEMPO TOTAL TRANSITO:       %,.2f\t\t|TIEMPO PROMEDIO TRANSITO:\t %.2f   \t\t|\n",
                        tiempoTransito, tiempoTransito/cantidadItems); 
    }
    
}
