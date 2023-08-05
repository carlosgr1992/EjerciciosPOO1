package modelo;

import servicios.Validador;

public class Meteo {

    public static final double MIN_TEMPERATURA = -10.00;
    public static final double MAX_TEMPERATURA = 55.00;
    public static final int MIN_HUMEDAD = 0;
    public static final int MAX_HUMEDAD = 100;
    public static final int MIN_PRESION = 1013;
    public static final int MAX_PRESION = 2026;
    double temperatura;
    int humedad;
    int presionAtmosferica;

    public Meteo(double temperatura, int humedad, int presionAtmosferica) {
        setTemperatura(temperatura);
        setHumedad(humedad);
        setPresionAtmosferica(presionAtmosferica);
    }

    public double getTemperatura() {
        return temperatura;
    }

    public boolean probableLluvia(){

        return getTemperatura() > 10 && getHumedad() > 65 && getPresionAtmosferica() < 1650;
    }

    public boolean probableViento(){

        return getTemperatura() >= 15 && getTemperatura() <= 25 && getHumedad() >40 && getHumedad() < 80 && getPresionAtmosferica() > 1050;
    }

    public void setTemperatura(double temperatura) {

        if(temperatura < MIN_TEMPERATURA) {
            this.temperatura = MIN_TEMPERATURA;
        }else if(temperatura > MAX_TEMPERATURA){
            this.temperatura = MAX_TEMPERATURA;
        }
        else this.temperatura = temperatura;

    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {

        this.humedad = Math.min(MAX_HUMEDAD,Math.max(humedad,MIN_HUMEDAD));

    }

    public int getPresionAtmosferica() {
        return presionAtmosferica;
    }

    public void setPresionAtmosferica(int presionAtmosferica) {
        this.presionAtmosferica = Math.min(MAX_PRESION,Math.max(presionAtmosferica,MIN_PRESION));
    }

    public String parteMeteorologico(){

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("T: %.2f \t H: %d \t P: %d \t ¿Lluvias? %s \t ¿Vientos? %s ",getTemperatura(),getHumedad(),getPresionAtmosferica(),
                probableLluvia() ? "Alta probabilidad" : "Baja probabilidad",
                probableViento() ? "Alta probabilidad" : "Baja probabilidad"));

        return sb.toString();
    }
}
