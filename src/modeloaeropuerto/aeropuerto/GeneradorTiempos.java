package modeloaeropuerto.aeropuerto;

import java.util.Random;

public class GeneradorTiempos {
	
    private static Random random;
        
    static{
        random=new Random(System.currentTimeMillis());
    }
    
    public static int getTiempoEntreArribos(int tipo, float t){
        float rand =  random.nextFloat();
        int tiempo=0;
        t=t%1440;
        if((t >= (60*7) && t <= (60*9)) || (t >= (60*20) && t <= (60*22))){
            switch(tipo){
                case Item.VUELO_LIVIANO:
                    if(rand > 0.65)
                        {tiempo = 50;}
                    else
                        {tiempo = 40;}
                    break;
                case Item.VUELO_PESADO:
                    if(rand > 0.6)
                        {tiempo = 90;}
                    else
                        {tiempo = 60;}
                    break;
                case Item.VUELO_MEDIANO:
                    if(rand > 0.5){
                        if (rand > 0.85)
                            {tiempo = 30;}
                        else
                            {tiempo = 20;}
                    }
                    else
                        {tiempo = 10;}
                    break;
            }
        }
        else{
            switch(tipo){
                case Item.VUELO_LIVIANO:
                    if(rand > 0.75)
                        {tiempo = 70;}
                    else
                        {tiempo = 60;}
                    break;
                case Item.VUELO_PESADO:
                    if(rand > 0.5)
                        {tiempo = 180;}
                    else
                        {tiempo = 120;}
                    break;
                case Item.VUELO_MEDIANO:
                    if(rand > 0.3){
                        if (rand > 0.7)
                            {tiempo = 40;}
                        else
                            {tiempo = 30;}
                    }
                    else
                        {tiempo = 20;}
                    break;
                    }
        }
        return tiempo;
    }
	
    public static float getTiempoDuracionServicio(int tipo){
        double rand =  random.nextDouble();
        float tiempo = 0;
        switch(tipo){
            case Item.VUELO_LIVIANO: //Exponencial Liviano
                tiempo = (float)((-30)*Math.log(1 - rand));
                break;
            case Item.VUELO_PESADO: //Convolucion Normal - Pesado
                double z;
                for(int i=0; i < 11; i++ ){
                    rand += random.nextDouble();
                }
                z=rand-6;
                tiempo = (float)(z*Math.sqrt(30) + 120);
                break;
            case Item.VUELO_MEDIANO: //Uniforme - Mediano
                tiempo = (float)(10 + 10*rand);
                break;
        }
        return tiempo;
    }
}
