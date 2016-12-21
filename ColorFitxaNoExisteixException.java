
package oca;

public class ColorFitxaNoExisteixException extends Exception{
    
    public ColorFitxaNoExisteixException() {
        super();
    }

    public ColorFitxaNoExisteixException(String msg) {
        super(msg);
    }
}
//Aquesta classe Exception es llança quan es vol elimina un jugador i el color introduit no correspon a cap jugador donat d'alta