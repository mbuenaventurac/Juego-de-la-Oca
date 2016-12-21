package oca;

import java.util.ArrayList;
import java.util.Iterator;

public class Controlador {
    
    private ArrayList<Jugador> jugador;
    private Dau dau;
    private Tauler tauler;
    private InterficieUsuari iu;

    //El constructor Controlador inicialitza el tauler, el dau, la interficieUsuari que se li passi per referència i la llista gestiona de Jugadors.
    public Controlador(InterficieUsuari iu){
        this.tauler = new Tauler();
        this.dau = new Dau();
        this.iu = iu;
        this.jugador = new ArrayList<Jugador>();
    }  
       
    //Aquest mètode afageix el jugador desitjat. Si el color introduit ja està utilitzat, llança la excepció ColorFitxaExisteixException.
    public void afegeixJugador(String nom, String color) throws ColorFitxaExisteixException {
        Jugador j = new Jugador(nom, color, dau, tauler);
        Iterator <Jugador> i = jugador.iterator();
        int a;
        while(i.hasNext()) {
            Jugador j2 = i.next();
            a = color.compareTo(j2.getFitxa().getColor());
            if(a == 0) throw new ColorFitxaExisteixException("Aquest color ja existeix.");
        }
        jugador.add(j);
    }    
    
    //Busca el jugador que té aquest color i l'elimina. Si no hi ha cap jugador amb aquest color, llança l'excepció ColorFitxaNoExisteixException
    public void eliminaJugador(String color) throws ColorFitxaNoExisteixException{
        Iterator <Jugador> i = jugador.iterator();
        int a, r = 0;
        while(i.hasNext()){
            Jugador j2 = i.next();
            a = color.compareTo(j2.getFitxa().getColor());
            if(a == 0) {
                jugador.remove(j2);
                r = 1;
                iu.mostraPerPantalla("S'ha eliminat el jugador!");
            }
        }
        if (r == 0) throw new ColorFitxaNoExisteixException("Aquest color no existeix");
    }
    //Retorna la casella amb el número introduït per referència
    public Casella getCasella(int numero){
       return tauler.getCasella(numero);
    }
    
    //Comprova que hi ha dos o més jugadors donats d'alta, sino es aixi, llança FaltenJugadorsException. 
    //Inicialitza la casella de totes les fitxes a 1. 
    public void jugarPartida() throws FaltenJugadorsException{
        int b = 1;
        ArrayList<String> mssg = new ArrayList<String>();
        if(jugador.size() < 2) throw new FaltenJugadorsException("No hi ha suficients jugadors");
        Jugador jg = new Jugador(null, null, dau, tauler);
        Iterator<Jugador> i = jugador.iterator();
        while(i.hasNext()){
            Jugador j1 = i.next();
            j1.mouFitxa(1); 
        }
        boolean guanya = false; 
        
        while(!guanya){ //mentres no hi hagi un jugador guanyador, segueix en el while i els jugadors van tirant.
            Iterator<Jugador> it = jugador.iterator(); //Quan passa per aquí és perquè ja ha passat un torn, llavors torna a tirar el primer jugador.
            while(it.hasNext() && !guanya){ 
                Jugador j2 = it.next(); //El torn és del següent jugador
                iu.mostraPerPantalla("\nTorn número " + b +":");
                iu.mostraPerPantalla("Juga el seu torn " + j2.getNom());
                iu.mostraPerPantalla("Controla la fitxa de color " + j2.getFitxa().getColor());
                iu.mostraPerPantalla("Situada a la casella " + j2.numeroCasellaFitxaJugador() + " (" + j2.getFitxa().getCasella().getDescripcio() + ")");
                //Una vegada mostrat per pentalla el torn, el nom, el color, i la casella on es situa el jugador que li toca tirar, es comproba si pot tirar (si no està a la presó)
                if(j2.potTirar()){ //si no està a la presó, tirar el dau i el mou a la casella corresponent
                    guanya = j2.jugarTorn(); //Si algú arriba a 63, guanya sera true
                    iu.mostraPerPantalla("Valor del dau: " + j2.getDau().getValor());
                    iu.mostraPerPantalla("Castella destí " + j2.numeroCasellaFitxaJugador()+ " (" + j2.getFitxa().getCasella().getDescripcio() + ")");
                    if(guanya == true) jg = j2; //si el jugador arriba a la última casella, guanya es true i es surt del while
                    else if(j2.getFitxa().getCasella().completaJugada(j2, mssg)){ //es crida al mètode completaJugada, per que en el cas de que el jugador hagi caigut en una casella especial, faci el que hagi de fer.
                        jg = j2;                                                 //només serà true si el jugador a caigut a la casella 59 i d'oca en oca arriba a la última (i guanya)
                        guanya = true; 
                    }
                }
                else { //si no pot tirar, s'informa al jugador de que encara està a la presó.
                    iu.mostraPerPantalla("Segueixes a la presó.");
                    j2.decrementaTornsSenseTirar();
                }
                presentaMensajes(mssg);
            } b++; //s'incrementa el torn
        } 
        iu.mostraPerPantalla("\nEl jugador " + jg.getNom() + " ha guanyat la partida!!!\n");
    }

    //Aquest mètode mostra per pantalla els missatges enviats al jugador durant la partida
    public void presentaMensajes(ArrayList<String> missatges){
        Iterator<String> i = missatges.iterator();
        while(i.hasNext()){
            String s = i.next();
            iu.mostraPerPantalla(s);
        }
        missatges.clear();
    }
}