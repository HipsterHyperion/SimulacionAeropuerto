
package modeloaeropuerto.aeropuerto;

/**
 *
 * @author Marti
 */
public class Registro {
    
    private int numeroDeSimulacion;
    private float transitoLiviano;
    private float transitoPesado;
    private float transitoMediano;
    private float ociosoLiviano;
    private float ociosoPesado;
    private float ociosoMediano;
    private float esperaLiviano;
    private float esperaPesado;
    private float esperaMediano;
    
    public Registro(int numero,float mediaTransitoLiviano, float mediaTransitoPesado, float mediaTransitoMediano){
        this.numeroDeSimulacion = numero;
        this.transitoLiviano = mediaTransitoLiviano;
        this.transitoPesado = mediaTransitoPesado;
        this.transitoMediano = mediaTransitoMediano;
    }

    /**
     * @return the numeroDeSimulacion
     */
    public int getNumeroDeSimulacion() {
        return numeroDeSimulacion;
    }

    /**
     * @param numeroDeSimulacion the numeroDeSimulacion to set
     */
    public void setNumeroDeSimulacion(int numeroDeSimulacion) {
        this.numeroDeSimulacion = numeroDeSimulacion;
    }

    /**
     * @return the transitoLiviano
     */
    public float getTransitoLiviano() {
        return transitoLiviano;
    }

    /**
     * @param transitoLiviano the transitoLiviano to set
     */
    public void setTransitoLiviano(float transitoLiviano) {
        this.transitoLiviano = transitoLiviano;
    }

    /**
     * @return the transitoPesado
     */
    public float getTransitoPesado() {
        return transitoPesado;
    }

    /**
     * @param transitoPesado the transitoPesado to set
     */
    public void setTransitoPesado(float transitoPesado) {
        this.transitoPesado = transitoPesado;
    }

    /**
     * @return the transitoMediano
     */
    public float getTransitoMediano() {
        return transitoMediano;
    }

    /**
     * @param transitoMediano the transitoMediano to set
     */
    public void setTransitoMediano(float transitoMediano) {
        this.transitoMediano = transitoMediano;
    }

    /**
     * @return the ociosoLiviano
     */
    public float getOciosoLiviano() {
        return ociosoLiviano;
    }

    /**
     * @param ociosoLiviano the ociosoLiviano to set
     */
    public void setOciosoLiviano(float ociosoLiviano) {
        this.ociosoLiviano = ociosoLiviano;
    }

    /**
     * @return the ociosoPesado
     */
    public float getOciosoPesado() {
        return ociosoPesado;
    }

    /**
     * @param ociosoPesado the ociosoPesado to set
     */
    public void setOciosoPesado(float ociosoPesado) {
        this.ociosoPesado = ociosoPesado;
    }

    /**
     * @return the ociosoMediano
     */
    public float getOciosoMediano() {
        return ociosoMediano;
    }

    /**
     * @param ociosoMediano the ociosoMediano to set
     */
    public void setOciosoMediano(float ociosoMediano) {
        this.ociosoMediano = ociosoMediano;
    }

    /**
     * @return the esperaLiviano
     */
    public float getEsperaLiviano() {
        return esperaLiviano;
    }

    /**
     * @param esperaLiviano the esperaLiviano to set
     */
    public void setEsperaLiviano(float esperaLiviano) {
        this.esperaLiviano = esperaLiviano;
    }

    /**
     * @return the esperaPesado
     */
    public float getEsperaPesado() {
        return esperaPesado;
    }

    /**
     * @param esperaPesado the esperaPesado to set
     */
    public void setEsperaPesado(float esperaPesado) {
        this.esperaPesado = esperaPesado;
    }

    /**
     * @return the esperaMediano
     */
    public float getEsperaMediano() {
        return esperaMediano;
    }

    /**
     * @param esperaMediano the esperaMediano to set
     */
    public void setEsperaMediano(float esperaMediano) {
        this.esperaMediano = esperaMediano;
    }
    
}
