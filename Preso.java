
package oca;

import java.util.ArrayList;
import java.util.HashMap;

public class Preso extends Casella {
    
    public static final int TORNS_SENSE_TIRAR = 3;
    private HashMap<Fitxa, Integer> empresonades = new HashMap<Fitxa, Integer>();
    
    //Constructor que permet crear la casella (subclasse) presó
    public Preso(int numero, String descripcio) {
        super(numero, descripcio);
    }
    //Quan un jugador cau a la casella presó, els torns sense tirar es posen a 3 i retorna false.
    public boolean completaJugada(Jugador jugador, ArrayList<String> messages) {
        jugador.setTornsSenseTirar(TORNS_SENSE_TIRAR);
        messages.add("Has caigut a la presó.");
        
        return false;
    }
    
}
