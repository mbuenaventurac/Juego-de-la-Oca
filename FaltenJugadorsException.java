package oca;

public class FaltenJugadorsException extends Exception{

    public FaltenJugadorsException() {
    }

    public FaltenJugadorsException(String msg) {
        super(msg);
    }    
}
//Aquesta expecio es llança quan es vol inicia la partida pero hi ha menys de dos jugadors.