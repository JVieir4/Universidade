package aula3;

import java.util.Scanner;

public class Exercicio2teste {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Exercicio2 tele = new Exercicio2();
        System.out.println("Tele = " +tele+ "\n");
        System.out.println("------------------------------------");
        System.out.println("Tem algum espaço livre? " + tele.existeEspaco(5));
        System.out.println("------------------------------------");
        System.out.println("Instala a aplicação UMinho.\nOk.");
        tele.instalaApp("Uminho", 2);
        System.out.println("------------------------------------");
        System.out.println("Instala a aplicação Hay Day.\nOk.");
        tele.instalaApp("Hay Day", 10);
        System.out.println("------------------------------------");
        System.out.println("Instala um Terabite de memória.\nOk.");
        tele.instalaApp("Terabite", 1000);
        System.out.println("------------------------------------");
        System.out.println("Escreva uma mensagem:");
        String mensagem1 = s.nextLine();
        tele.recebeMsg(mensagem1);
        System.out.println("------------------------------------");
        System.out.println("Escreva uma mensagem:");
        String mensagem2 = s.nextLine();
        tele.recebeMsg(mensagem2);
        System.out.println("------------------------------------");
        System.out.println("Escreva uma mensagem:");
        String mensagem3 = s.nextLine();
        tele.recebeMsg(mensagem3);
        System.out.println("------------------------------------");
        System.out.println("Qual é a maior mensagem da lista de mensagens guardadas?\n" + tele.maiorMsg());
        System.out.println("------------------------------------");
        System.out.println("Qual é o tamanho médio das aplicações?\n" + tele.tamMedioApps());
        System.out.println("Remove a aplicação Betclick:\nOk.");
        tele.removeApp("Betclick", 5);
        s.close();
    }
}
