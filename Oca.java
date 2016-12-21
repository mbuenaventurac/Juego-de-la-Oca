package oca;

import java.util.ArrayList;
import java.util.List;

public class Oca extends Casella{

    public Oca(int numero, String descripcio) {
        super(numero, descripcio);
    }
    //Quan un jugador cau en una Oca, fa que es mogui fins la següent oca i des d'allà que el jugador torni a tirar.
    public boolean completaJugada(Jugador jugador, ArrayList<String> messages){
        Casella seguentoca = new Casella(0, null);
        messages.add("\nEts a la casella " + jugador.numeroCasellaFitxaJugador() + " (Oca)");
        messages.add("D'Oca a Oca i tiro perquè em toca!");
        if(jugador.numeroCasellaFitxaJugador() == 59){ //si està a la 59, la següent serà la 63, i retorna true perque a guanyat
            messages.add("Has arribat a la casella 63!");
            return true;
        }
        seguentoca = jugador.getTauler().getSeguentOca(this.numero);
        if(seguentoca != null){
            jugador.mouFitxa(seguentoca.getNumero());
            messages.add("Oca destí: " + jugador.numeroCasellaFitxaJugador());
            if(jugador.jugarTorn()) return true; //Si cau a la 63, guanya la partida i retorna true
            else{
                messages.add("El valor del dau és: " + jugador.getDau().getValor() + "\nLa casella destí és: " + jugador.getFitxa().getCasella().getNumero() + " (" + jugador.getFitxa().getCasella().getDescripcio() + ")");
                
            }
        }
        return false; //retonra false si no guanya
    }
}
