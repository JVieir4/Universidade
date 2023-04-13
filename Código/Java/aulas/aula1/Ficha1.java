package aula1;
public class Ficha1{

    public double celsiusparafarenheit(double graus){
        double f = graus * 1.8 + 32;
        return f;
    }

    public int maximoNumeros(int a, int b){
        int f = Math.max(a,b);
        return f;
    }

    public String criadescricaoconta(String nome, double saldo){
        String f = ("O seu nome é " + nome + " e tem um saldo igual a " + saldo);
        return f;
    }
}