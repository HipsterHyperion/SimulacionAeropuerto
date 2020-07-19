package modeloaeropuerto.aeropuerto;

import java.util.LinkedList;
import java.util.ListIterator;

public class Fel {
	private static Fel fel;
	private LinkedList<Evento> lista;
        
	private Fel(){
            lista=new LinkedList();
	}
	
	public static Fel getFel(){
		if(fel==null)
			fel=new Fel();
		return(fel);
	}
        
        public void reiniciarFel(float inicioSimulacion, float finSimulacion){
            lista.clear();
            lista.add(new EventoArribo(inicioSimulacion, new Item(1, inicioSimulacion, Item.VUELO_LIVIANO)));
            lista.add(new EventoArribo(inicioSimulacion, new Item(2, inicioSimulacion, Item.VUELO_PESADO)));
            lista.add(new EventoArribo(inicioSimulacion, new Item(3, inicioSimulacion, Item.VUELO_MEDIANO)));
            lista.add(new EventoFinSimulacion((finSimulacion)));
        }
	
	public void insertarFel(Evento e){
            int i = 0;
            while(i<lista.size()){
                if(((Evento)lista.get(i)).getTiempo() < e.getTiempo())
                    { i++; }
                else{
                    if(!(lista.get(i).getTiempo() > e.getTiempo() || lista.get(i).getTipo() == 0))
                        { i++; }
                    lista.add(i, e);
                    break;
                }
            }
	}

	public Evento suprimirFel(){
            return (Evento)lista.pop();
	}
	
	public void mostrarFel(){
            ListIterator<Evento> corre = lista.listIterator();
            String cadena = "|Lista de eventos futuros: [ "+corre.next().toString();
            while(corre.hasNext()){
                cadena = cadena+" , "+corre.next().toString();
            }
            cadena = cadena+" ]";
            System.out.println(cadena);
	}
	
	/**
	 * @return Returns the lista.
	 */
	public LinkedList getLista() {
		return lista;
	}

}
