package oca;

public class Jugador {
    
    private String nom;
    private Dau dau;
    private Tauler tauler;
    private Fitxa fitxa;
    private int tornsSenseTirar = 0;

    //El constructor Jugador() inicialitza els atributs de la classe amb els paràmestres nom, color, dau i tauler
    public Jugador (String nom, String color, Dau dau, Tauler tauler){
        this.nom = nom;
        this.dau = dau;
        this.tauler = tauler; 
        this.fitxa = new Fitxa(color, this, tauler.getCasella(1)); 
    }
    //Retorna el nom del jugador que fa referència el mètode
    public String getNom(){
        return nom; 
    }
    //Retorna la fitxa que controla el jugador al que fa referència el mètode
    public Fitxa getFitxa(){
        return fitxa; 
    }
    //Retorna el dau que pertany a aquest jugador
    public Dau getDau(){
        return dau; 
    }
    //Retorna el número de la casella on es troba la fitxa del jugador al que fa referència
    public int numeroCasellaFitxaJugador(){
        return fitxa.getCasella().getNumero(); 
    }
    //Crida al mètode tirar del dau (dau) i retorna el valor del número que ha obtingut
    public int tiraDau(){
        dau.tirar(); 
        return dau.getValor();
    }
    //Elimina la fitxa de la casella inicial i la col·loca a la casella de destí
    public void mouFitxa(int numCasellaDesti){ //elimina la fitxa de la casella inicial i la col·loca a la casella de destí
        tauler.eliminaFitxa(fitxa, this.numeroCasellaFitxaJugador());
        tauler.situaFitxa(fitxa, numCasellaDesti);
        fitxa.setCasella(tauler.getCasella(numCasellaDesti));
    }
    //Obté el valor del dau i el suma a la casella on es troba (si passa de 63 tira enrere) i mou la fitxa a la casella de desti
    public boolean jugarTorn(){
        if(potTirar()){
            int ncd = tiraDau() + numeroCasellaFitxaJugador();
            if (ncd > 63) {
                ncd = 63 - (ncd - 63);
                mouFitxa(ncd);
             }
            mouFitxa(ncd);
            if (fitxa.getCasella() == tauler.getCasella(63))  return true;
            else return false; //si la casella de desti es 63 retorna true, sinó retorna false
        }
        else decrementaTornsSenseTirar();
        return false;
    }
    //Aquest mètode retonra el tauler, ja que és privat i no és visible des d'altres classes
    public Tauler getTauler(){
        return tauler;
    }
    //Si el jugador està a la presó i encara li queden torns sense tirar, retorna false. Sinó, retorna true.
    public boolean potTirar(){
        if(this.tornsSenseTirar == 0){
            return true;
        }
        else return false;
    }
    //Decrementa els torns que li queden al jugador de la presó per poder tornar a jugar.
    public void decrementaTornsSenseTirar(){
        if(!this.potTirar()) tornsSenseTirar--;
    }
    //permet modificar el nomero de torns que el jugador ha destar sense tirar des d'altres classes.
    public void setTornsSenseTirar(int nTorns){
        this.tornsSenseTirar = nTorns;
    }
}
