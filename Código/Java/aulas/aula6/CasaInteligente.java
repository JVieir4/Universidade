package aula6;

import java.util.ArrayList;
import java.util.Iterator;

import aula6.Lampada.Modo;

public class CasaInteligente {
    String NomeCasa;
    ArrayList<Lampada> lampadas;

    public CasaInteligente(){
        this.NomeCasa = "nome";
        this.lampadas = new ArrayList<>();
    }

    public CasaInteligente(CasaInteligente c){
        this.NomeCasa = c.getNome();
        this.lampadas = c.getLampadas();
    }

    public CasaInteligente(String nome, ArrayList<Lampada> lamps){
        this.NomeCasa = nome;
        this.lampadas = lamps;
    }

    public ArrayList<Lampada> getLampadas() {
        return this.lampadas;
    }

    public void setLampadas(ArrayList<Lampada> l){
        this.lampadas = l;
    }

    public String getNome() {
        return this.NomeCasa;
    }

    public void SetNome(String n){
        this.NomeCasa = n;
    }

    public void addLampada(Lampada l){
        lampadas.add(l.clone());
    }

    public void ligaLampada(int index){
        Lampada l = lampadas.get(index);
        l.lampON();
    }

    public void ligaLampadaEco(int index){
        Lampada l = lampadas.get(index);
        l.lampECO();
    }

    public int qtEmEco(){
        return (int)lampadas.stream()
                    .filter((l) -> l.getModo() == Modo.ECO)
                    .count();
    }

    public void removeLampada(int index){
        Lampada l = lampadas.get(index);
        for(Iterator<Lampada> it = lampadas.iterator(); it.hasNext();){
            Lampada f = it.next();
            if(l == f){
                it.remove();
            }
        }
        
    }

    public void ligaTodasEco(){
        lampadas.forEach(Lampada::lampECO); 
    }

    public void ligaTodasMax(){
        lampadas.forEach(Lampada::lampON); 
    }

    public double consumoTotal(){
        return lampadas.stream()
            .mapToDouble(Lampada::getConsumoTotal)
            .sum();
    }

    public Lampada maisGastadora(){
        Lampada l = lampadas.get(0);
        for(Iterator<Lampada> it = lampadas.iterator(); it.hasNext();){
            Lampada f = it.next();
            if(f.getConsumoTotal() > l.getConsumoTotal()){
                l = (Lampada) it;
            }
        }
        return l;
    }
    /* 
     public Set<Lampada> lampadasEmModoEco(){

    }

    public Set<Lampada> podiumEconomia(){

    }

    */

    public void reset(){
        lampadas.forEach(Lampada::resetPeriodo);
    }
}