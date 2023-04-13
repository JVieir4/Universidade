package aula2;

import java.util.Arrays;
import java.util.Scanner;

public class TesteExercicio1{
    public static int[] lerarray(int n){
        int[] res = new int[n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            System.out.println("Introduza um inteiro.");
            res[i] = sc.nextInt();
            sc.close();
        }
        return res;
    }

    public static void main(String[] args){
        Exercicio1 e = new Exercicio1();
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza o nº de inteiros a ler.");
        int n = s.nextInt();
        int[] a = lerarray(n);
        //alinea a
        int min = e.minarray(a);
        System.out.println("min = " + min);

        //alinea b
        int i1, i2;
        System.out.println("Introduza o 1º indice.");
        i1 = s.nextInt();
        System.out.println("Introduza o 2º indice.");
        i2 = s.nextInt();

        int[] b = e.arrayentre(a, i1, i2);
        System.out.println(Arrays.toString(b));

        //alinea c
        s.close();
    }
}