package Berkeley;


public class Reloj {
    private int tiempo;
    private int retardoTransmision;

    public Reloj(int tiempo, int retardoTransmision) {
        this.tiempo = tiempo;
        this.retardoTransmision = retardoTransmision;
    }
    public void setTiempo(int intervaloTiempo) {
        this.tiempo = tiempo + intervaloTiempo;

    }

    public int getTiempo() {
        return tiempo;
    }

    public int getRetardoTransmision() {
        return retardoTransmision;
    }
}
