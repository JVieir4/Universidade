package aula1;
import java.util.Scanner;

public class MainFicha1{
    
    public static void main(String[] args){
        Ficha1 f = new Ficha1();
        java.util.Scanner s = new Scanner(System.in);
        System.out.println("Qual exercício?");
        int exec = s.nextInt();
        if(exec == 1){
            System.out.println("Introduza a temperatura em graus ceslius.");
            double c = s.nextDouble();
            System.out.println(c + " graus celsius equivalem a " + f.celsiusparafarenheit(c) + " graus farenheit.");
        }
        if(exec == 2){
            System.out.println("Introduza dois números inteiros.");
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println("O maior entre " + a + " e " + b + " é " + f.maximoNumeros(a,b));
        }
        if(exec == 3){
            System.out.println("Introduza o seu nome.");
            String n = s.nextLine();
            System.out.println("Introduza o seu saldo.");
            double d = s.nextDouble();
            System.out.println(f.criadescricaoconta(n,d));
        }
        s.close();
    }
}