package oca;
import java.util.Scanner;
public class InterficieUsuari {
    
    private Controlador c;
    private Scanner lector = new Scanner(System.in);

    //El constructor inicialitza els atributs de l'Interficie Usuari, en aquest cas, inciailitza el controlador
    public InterficieUsuari(){
        this.c = new Controlador(this);
    }
    //El mètode main és el que s'executa i, per tant, permet el desenvolupament del joc.
    public static void main(String[] args){
        InterficieUsuari iu = new InterficieUsuari();
        iu.run();
    }
    //És el mètode que conté totes les comandes del joc i permet seleccionar aquella que volem. A més, una vegada executada, ens permet seleccionar-ne una altra fins que sortim del joc
    public void run(){
        mostraPerPantalla("Benvinguts a l'aplicació del joc de la oca de MOO!");
        mostrarComandes();
        String comanda = lector.nextLine();
        while (!comanda.equals("surt")){
            try{ //S'executen les comandes desitjades i si alguna llança una excepcio, es passa directament al catch
                if(comanda.equals("ajuda")){
                    mostrarComandes();
                    comanda = lector.nextLine();
                }
                else if(comanda.equals("alta"))altaJugador();
                else if(comanda.equals("elimina"))eliminaJugador();
                else if(comanda.equals("inicia")) iniciarPartida();            
                else mostrarComandes();
            } //Es cacen les excepcions llançades, i mostra el corresponent missatge de cada una
            catch(ColorFitxaExisteixException | ColorFitxaNoExisteixException | FaltenJugadorsException ex1){
                mostraPerPantalla(ex1.getMessage());
            } //Es demana una nova comanda
            mostraPerPantalla("Introdueix una nova comanda: ");
            comanda = lector.nextLine();    
        } //Quan surt del joc, surt del while i s'informa de que està sortint
        mostraPerPantalla("Sortint del joc de la oca...");                
    }
    
    //Dóna d'alta un jugador mitjançant la classe afageixJugador() de Jugador, la qual comprova que el color de la fitxa d'aquest no estigui repetit
    public void altaJugador()throws ColorFitxaExisteixException{
        mostraPerPantalla("Nom:");
        String nom = lector.nextLine();
        
        mostraPerPantalla("Color:");
        String color = lector.nextLine();
        c.afegeixJugador(nom, color);
    }
    
    //Elimina el jugador seleccionat a través del mètode eliminaJugador() de la classe Jugador
    public void eliminaJugador()throws ColorFitxaNoExisteixException{
        mostraPerPantalla("Color:");
        String color = lector.nextLine();
        c.eliminaJugador(color);
    }
    
    //Mètode per començar la partida a través del mètode jugarPartida, el qual ja envia la corresponent excepcio si no hi ha suficients jugadors
    public void iniciarPartida()throws FaltenJugadorsException{
        c.jugarPartida();
    }
    
    //Fa aparèixer el missatge que se li passa per referència per pantalla
    public void mostraPerPantalla(String msg){
        System.out.println(msg);
    }
    //Fa aparèixer totes les comandes possibles, i una descripció d'aquestes, per pantalla
    public void mostrarComandes(){
        mostraPerPantalla("Introdueix una de les comandes de la llista:");
        mostraPerPantalla("\t ALTA - Afegeix un nou jugador a la partida ");
        mostraPerPantalla("\t ELIMINA - Elimina un dels jugadors afegits prèviament a la partida");
        mostraPerPantalla("\t INICIA - Inicia la partida amb els jugadors introduïts ");
        mostraPerPantalla("\t AJUDA - Mostra novament les comandes vàlides per a l'aplicació");
        mostraPerPantalla("\t SURT - Surt del joc de la oca");  
    }
}
