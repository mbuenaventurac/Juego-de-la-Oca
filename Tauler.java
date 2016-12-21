package oca;

import java.util.ArrayList;
import java.util.Iterator;

public class Tauler {
    
    private Casella[] caselles;
    private ArrayList<Casella> ocas = new ArrayList<Casella>();
    //Les oques es situen als números 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54 i 59. 
    //La presó està situada al número 53 i la mort al 58. 
    //La resta de les caselles s'inicialitzem com a "Casella convencional"
    public Tauler(){
        caselles = new Casella[63];
        int i;
        for(i = 0; i < 63; i++ ){
            if (i == 52) {
                Preso p = new Preso(i+1, "Presó");
                caselles[i] = p;
            }
            else if (i == 57){
                Mort m = new Mort(i+1, "Mort");
                caselles[i] = m;
            }
            else if(i == 4 || i == 8 || i == 13 || i == 17 || i == 22 || i ==26 || i == 31 || i == 35 || i == 40 || i == 44 || i == 49 || i == 53 || i == 58 || i == 62){
                Oca o = new Oca(i+1, "Oca");
                ocas.add(o);
                caselles[i] = o;
            }
            else{
                Casella c = new Casella(i+1, "Casella convencional");
                caselles[i] = c;
            }
        }
    }
    //Retorna la casella que correspon al número introduit
    public Casella getCasella(int numero){
             return caselles[numero-1];
    }
    //Situa la fitxa que passem per referència a la casella amb el número indicat
    public void situaFitxa(Fitxa fitxa, int numero){
        caselles[numero-1].situaFitxa(fitxa);
    }
    //Elimina la fitxa que passem per referència i que està situada al número de casella indicat
    public void eliminaFitxa(Fitxa fitxa, int numero){
        caselles[numero-1].eliminaFitxa(fitxa);
    }
    //Aquest mètode retorna la següent oca del tauler. Per a fer-ho més simple, utilitzem la llista de oques.
    public Casella getSeguentOca(int numero){
        Iterator<Casella> it = ocas.iterator();
        while(it.hasNext()){
            Casella oc = it.next();
            
            if(oc.getNumero() == numero && it.hasNext()) return it.next();
        }
        return null; //si no en troba, retorna null
    }
}