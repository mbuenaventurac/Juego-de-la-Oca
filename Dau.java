package oca;
import java.util.Random;

public class Dau {
    
    private int valor;
    
    //El constructor Dau() inicialitza el valor del dau a 1
     public Dau(){
        valor = 1;
    }
    //Aquest mètode permet obtenir un valor aleatori pel dau
    public void tirar(){
        Random r = new Random();
        valor = r.nextInt(6)+1;
    }
    //Retorna el valor que ha obtingut el dau
    public int getValor(){
        return valor;
    }
    
   
}
