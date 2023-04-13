package aula3;

public class Exercicio1{
    public static void main(String[] args){
        Exercicio1circulo c1 = new Exercicio1circulo();
        System.out.println("Circulo = " + c1);
        System.out.println("\nc1 == c1?\n" + c1.equals(c1));
        c1.setRaio(3);
        System.out.println("\nPerimetro " + c1.calculaperimetro() + "\narea " + c1.calculaarea());
        c1.setRaio(4);
        System.out.println("\nPerimetro " + c1.calculaperimetro() + "\narea " + c1.calculaarea());
        Exercicio1circulo c2 = c1.clone();
        System.out.println("\nc1= " + c1 + "\nc2 ? " + c2 + "\nc1 == c2?\n" + c1.equals(c2));
        c2.setRaio(5);
        System.out.println("\nc1= " + c1 + "\nc2 ? " + c2 + "\nc1 == c2?\n" + c1.equals(c2));
    }
}
     