
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natsu
 */
public class Automata implements Serializable{
    String Alfabeto="";
    int rInt=0;
    int Q[];
    int F[];
    int Mat[][];

    public Automata(String Alfabeto, int[] Q, int[] F, int[][] Mat) {
        this.Alfabeto=Alfabeto;
        this.Q = Q;
        this.F = F;
        this.Mat = Mat;
    }
    
   public boolean evaluar(String cad){
       int c, r, i;
       r=rInt;
       for (i = 0; i < cad.length(); i++) {
           char letra=cad.charAt(i);
           c=Alfabeto.indexOf(letra);
           r=Mat[r][c];
       }
       
       for (i = 0; i < F.length; i++) {
           if (F[i]==r) {
               return true;
           }
       }
       return false;
   } 
   
   public void verificar(){
       System.out.println(Alfabeto);
       for (int i = 0; i < Q.length; i++) {
           System.out.println(Q[i]+" ");
       }
       for (int i = 0; i < F.length; i++) {
           System.out.println(F[i]+" ");
       }
       for (int i = 0; i < Q.length; i++) {
           for (int j = 0; j < Alfabeto.length(); j++) {
               System.out.println(Mat[i][j]+" ");
           }
       }
   }
}
