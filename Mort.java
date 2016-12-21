package oca;

import java.util.ArrayList;

public class Mort extends Casella{
    
    //el constructor de la subclasse Mort, permet crear la casella corresponent a la mort (desde tauler, quan s'inicialitza), que és la 58.
    public Mort(int numero, String descripcio) {
        super(numero, descripcio);
    }
    //Quan el jugador cau en la casella de la mort, es mou a la casella 1. Sempre retorna false.
    public boolean completaJugada(Jugador jugador, ArrayList<String> messages){
        Casella u = new Casella(1, "Casella Convencional");
        jugador.getFitxa().setCasella(u);
        
        messages.add("Has caigut a la casella mort. Torna a començar!");
        
        return false;
    }
}
