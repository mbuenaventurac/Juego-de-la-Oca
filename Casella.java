package oca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Casella {
    
    protected int numero;
    protected String descripcio;
    
    protected Set<Fitxa> fitxes;
    
    //El constructor Casella() inicialitza la casella amb el número, la seva descripció i també crea la llista de fitxes.
    public Casella(int numero, String descripcio){
        this.numero = numero;
        this.descripcio = descripcio;
        this.fitxes = new HashSet<Fitxa>();
        
    }
    //Retorna el String de descripció d'aquesta casella 
    public String getDescripcio(){
        return descripcio;
    }
    //Retorna el numero de la casella a la que fa referència
    public int getNumero(){
        return numero;
        //retorna el numero de la casella a la que fa referencia        
    }
    //Aquest mètode busca la fitxa que té el color que es busca: si hi ha una fitxa amb aquest color retorna f (la fitxa corresponent), i sino, null
    public Fitxa getFitxa(String color){
        Iterator<Fitxa> i = fitxes.iterator();
        int a;
        while(i.hasNext()){
            Fitxa f = i.next();
            a = color.compareTo(f.getColor());
            if(a == 1) return f;
        }
        return null;
        
    }
    //Permet situar la fitxa que passem per referència a la casella on ens trobem 
    public void situaFitxa (Fitxa fitxa){
        fitxes.add(fitxa);
    }
    //Aquest mètode permet eliminar la fitxa introduida per referència
    public void eliminaFitxa (Fitxa fitxa){
        fitxes.remove(fitxa);
    }   
    //Aquest mètode permet completar la jugada en el cas de les caselles no convencionals. En el cas de les convencionals, no ha de fer res i per tant només s'afageix el missatge a l'ArrayList i retorna sempre false
    public boolean completaJugada(Jugador jugador, ArrayList<String> messages){
        messages.add("Es troba en una casella convencional");
        return false;
    }
}
