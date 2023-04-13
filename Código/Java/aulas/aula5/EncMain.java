package aula5;

import java.util.Scanner;

public class EncMain {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        EncEficiente enc = new EncEficiente();
        /*for(int i = 0; i < 5; i++){
            System.out.println("Insira referência.");
            LinhaEncomenda le = new LinhaEncomenda(s.nextLine(), String.valueOf(i), i, 2*i,0.25,0.1);
            //enc.adicionaLinha(le);
        }
        imprime(enc); */
        System.out.println("Valor total = " + enc.calculaValorTotal());
        System.out.println("Valor de Desconto = " + enc.calculaValorDesconto());
        System.out.println("Número Total de Produtos = " + enc.numeroTotalProdutos());
        System.out.println("Insira a referência do produto que pretende que verificar se será encomendado:");
        String refProduto1 = s.nextLine();
        System.out.println("O produto vai ser encomendado? " + enc.existeProdutoEncomenda(refProduto1));
        System.out.println("Indique a referência do produto que pretende remover.");
        enc.removeProduto(s.nextLine());
        imprime(enc);
        System.out.println("Insira a referência do produto que pretende que verificar se será encomendado:");
        String refProduto2 = s.nextLine();
        System.out.println("O produto vai ser encomendado? " + enc.existeProdutoEncomenda(refProduto2));
        s.close();
    }

    public static void imprime(EncEficiente enc){
        System.out.println("Lista de produtos na linha de encomendas.");
        //for(int i = 0; i < enc.getLinhas().length; i++){
            //System.out.println(enc.getLinhas()[i]);
        //}
    }
}
