package oca;

public class Fitxa {
    
    private String color;
    
    private Jugador jugador;
    private Casella ones;
    
    //El contructor Fitxa() inicialitza tots els atributs d'aquesta classse a través dels paràmentres color, jugador i casella
    public Fitxa(String color, Jugador jugador, Casella casella){
        this.color = color;
        this.jugador = jugador;
        this.ones = casella;
    }
    //Permet obtenir en quina Casella està situada la Fitxa
    public Casella getCasella(){
        return ones;
    }
    //Situa la Fitxa a la Casella introduida per referència
    public void setCasella (Casella casella){
        ones = casella;
    }
    //Retornar el Color d'aquesta Fitxa
    public String getColor(){
        return color;
    }
    //Retorna el Jugador que controla d'aquesta Fitxa
    public Jugador getJugador(){
        return jugador;
    
    }
}
