package aula3;

public class Exercicio1circulo {
    private double x;
    private double y;
    private double raio;


    public Exercicio1circulo(double cx, double cy, double craio){
        this.x = cx;
        this.y = cy;
        this.raio = craio;
    }

    public Exercicio1circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    public Exercicio1circulo(Exercicio1circulo circulo){
        this.x = circulo.getX();
        this.y = circulo.getY();
        this.raio = circulo.getRaio();
    }
    

    private double getRaio() {
        return this.x;
    }

    private double getY() {
        return this.y;
    }

    private double getX() {
        return this.x;
    }

    @Override
    public String toString(){
        return "ex1{" + "x=" + x + ", y=" + y + ", raio=" + raio + '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if( obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Exercicio1circulo o = (Exercicio1circulo) obj;
        return this.x == o.getX() && this.y ==o.getY() && this.raio == o.getRaio();
    }

    public Exercicio1circulo clone(){
        return new Exercicio1circulo(this);
    }

    public double calculaperimetro(){
        return 2*Math.PI*this.raio;
    }

    public double calculaarea(){
        return Math.PI*Math.pow(this.raio,2);
    }

    public void setRaio(double i) {
        this.raio = i;
    }

    public void setX(double i) {
        this.x = i;
    }

    public void setY(double i) {
        this.y = i;
    }

    public void alteracentro(double x, double y){
        this.x = x;
        this.y = y;
    }
}