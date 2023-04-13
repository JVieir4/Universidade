package aula7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class EncEficiente implements Comparable<EncEficiente>{
    private String nome;
    private String fiscal;
    private String morada;
    private int Nencomenda;
    private LocalDate data;
    ArrayList<LinhaEncomenda> linhas;

    public EncEficiente(){
        this.nome = "Jorge Borges";
        this.fiscal = "360393687";
        this.morada = "Rua Jorge I";
        this.Nencomenda = 1;
        this.data = null;
        this.linhas = new ArrayList<LinhaEncomenda>();
    }

    public EncEficiente(String nomecliente, String nif, String mor, int Nenc, LocalDate date, ArrayList<LinhaEncomenda> lines){
        this.nome = nomecliente;
        this.fiscal = nif;
        this.morada = mor;
        this.Nencomenda = Nenc; 
        this.data = date;
        this.linhas = lines;
    }

    public EncEficiente(EncEficiente enc){
        this.nome = enc.getNome();
        this.fiscal = enc.getFiscal();
        this.morada = enc.getMorada();
        this.Nencomenda = enc.getNenc();
        this.data = enc.getData();
        this.linhas = enc.getLinhas();
    }

    public String getNome(){
        return this.nome;
    }
    public String getFiscal(){
        return this.fiscal;
    }
    public String getMorada(){
        return this.morada;
    }
    public int getNenc(){
        return this.Nencomenda;
    }
    public LocalDate getData(){
        return this.data;
    }
    
    public ArrayList<LinhaEncomenda> getLinhas(){
        return (ArrayList<LinhaEncomenda>) this.linhas.stream()
                    .map(LinhaEncomenda::clone)
                    .collect(Collectors.toList());
    } /* 
    public double calculaValorTotal(){
        double vt = 0;
        for(int i = 0; i < linhas.size(); i++){
            vt += linhas.get(i).calculaValorLinhaEnc();
            System.out.println(linhas.get(i).calculaValorLinhaEnc());
        }
        return vt;
    } */

    public double calculaValorTotal(){
        return this.linhas.stream()
                .mapToDouble(LinhaEncomenda::calculaValorLinhaEnc)
                .sum();
    }

    public double calculaValorDesconto(){
        double vd = 0;
        for(int i = 0; i < linhas.size(); i++){
            vd += linhas.get(i).calculaValorDesconto();
        }
        return vd;
    }
    /* 
    public int numeroTotalProdutos(){
        int total = 0;
        for(int i = 0; i < linhas.size(); i++){
            total += linhas.get(i).getQuantidade();
        }
        return total;
    }
    */
    public int numeroTotalProdutos(){
        return this.linhas.stream()
                .mapToInt(LinhaEncomenda::getQuantidade)
                .sum();
    }
    /* 
    public boolean existeProdutoEncomenda(String refProduto){
        for (int i = 0; i < linhas.size(); i++){
            if(refProduto.equals(linhas.get(i).getReferencia())){
                return true;
            }
        }
        return false;
    } */

    public boolean existeProdutoEncomenda(String refProduto){
        return this.linhas.stream()
                .anyMatch((le) -> le.getReferencia().equals(refProduto));
    }
    /* 
    public void removeProduto(String codProd){
        LinhaEncomenda a = new LinhaEncomenda();
        a.remover = null;
        for(int i = 0; i < linhas.size() && a.remover == null; i++){
            LinhaEncomenda le = linhas.get(i);
            if(le.getReferencia().equals(codProd)){
                a.remover = le;
            }
        }
        if(a.remover != null){
            linhas.remove(a.remover);
        }
    } */

    public void removeProduto(String codProd){
        for(Iterator<LinhaEncomenda> it = linhas.iterator(); it.hasNext();){
            LinhaEncomenda le = it.next();
            if(le.getReferencia().equals(codProd)){
                it.remove();
            }
        }
    }

    public EncEficiente clone(){
        return new EncEficiente(this);
    }

    @Override
    public int compareTo(EncEficiente e){
        int ret=0;
        if(this.getNenc() > e.getNenc()){
            ret = 1;
        }
        if(this.getNenc() < e.getNenc()){
            ret = -1;
        }
        if(this.getNenc() == e.getNenc()){
            ret = 0;
        }
        return ret;
    }

    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        EncEficiente enc = (EncEficiente) o;
        return Nencomenda == enc.getNenc() && nome.equals(enc.getNome()) && fiscal.equals(enc.getFiscal()) && morada.equals(enc.getMorada()) && data == enc.getData() && linhas == enc.getLinhas();
    }
}