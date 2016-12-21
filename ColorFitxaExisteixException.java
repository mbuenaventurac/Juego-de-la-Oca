
package oca;

public class ColorFitxaExisteixException extends Exception{

    public ColorFitxaExisteixException() {
        super();
    }

    public ColorFitxaExisteixException(String msg) {
        super(msg);
    }
    
}
//Aquesta excepcio es llança quan es vol introduir un jugador amb un color que ja està utilitzat per un altre jugador