
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natsu
 */
public class GenerarAutomata {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Numero de automata: ");
        int num=sc.nextInt();
        sc.nextLine();
        
        System.out.println("Caracteres del alfabeto: ");
        String alfabeto=sc.nextLine();
        
        System.out.println("Numero de estados: ");
        int e=sc.nextInt();
        int estados[]=new int[e];
        for (int i = 0; i < estados.length; i++) {
            System.out.println("Estado: ");
            estados[i]=sc.nextInt();
        }
        
        System.out.println("Numero de estados de aceptacion: ");
        int ea=sc.nextInt();
        int estadosA[]=new int[ea];
        for (int i = 0; i < ea; i++) {
            System.out.println("Estado: ");
            estadosA[i]=sc.nextInt();
        }
        
        System.out.println("Matriz");
        int Mat[][]=new int[e][alfabeto.length()];
        for (int i = 0; i < e; i++) {
            System.out.println(alfabeto.length()+"Estado ");
            for (int j = 0; j < alfabeto.length(); j++) {
                Mat[i][j]=sc.nextInt();
            }
        }
        Automata a=new Automata(alfabeto, estados, estadosA, Mat);
        
        
        
        try {
            File arch = new File("C:\\Users\\SourceMan\\Documents\\ISC\\Automatas\\Automata"+num+".atm");
            FileOutputStream archiEs = new FileOutputStream(arch);
            ObjectOutputStream writter = new ObjectOutputStream(archiEs);
            writter.writeObject(a);
            writter.close();
            archiEs.close();
            System.out.println("Automata guardado");
        } catch (FileNotFoundException ex) {
            System.out.println("Achivo no encontrador");
        } catch (IOException ex) {
            System.out.println("Automata no guardado");
        }
    }
}
