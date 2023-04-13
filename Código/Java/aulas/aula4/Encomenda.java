package aula4;

import java.time.LocalDate;

public class Encomenda{
    private String nome;
    private String fiscal;
    private String morada;
    private int Nencomenda;
    private LocalDate data;
    private LinhaEncomenda[] linhas;

    public Encomenda(){
        nome = "Jorge Borges";
        fiscal = "360393687";
        morada = "Rua Jorge I";
        Nencomenda = 1;
        data = null;
        linhas = new LinhaEncomenda[] {};
    }

    public Encomenda(String nomecliente, String nif, String mor, int Nenc, LocalDate date, LinhaEncomenda[] lines){
        this.nome = nomecliente;
        this.fiscal = nif;
        this.morada = mor;
        this.Nencomenda = Nenc;
        this.data = date;
        this.linhas = lines;
    }

    public Encomenda(Encomenda enc){
        this.nome = enc.getNome();
        this.fiscal = enc.getFiscal();
        this.morada = enc.getMorada();
        this.Nencomenda = enc.getNenc();
        this.data = enc.getData();
        this.linhas = enc.getLinhas();
    }

    public LinhaEncomenda[] getLinhas() {
        return this.linhas;
    }

    public LocalDate getData() {
        return this.data;
    }

    public int getNenc() {
        return this.Nencomenda;
    }

    public String getMorada() {
        return this.morada;
    }

    public String getFiscal() {
        return this.fiscal;
    }

    public String getNome() {
        return this.nome;
    }

    public double calculaValorTotal(){
        double vt = 0;
        for(int i = 0; i < linhas.length; i++){
            vt += linhas[i].calculaValorLinhaEnc();
        }
        return vt;
    }

    public double calculaValorDesconto(){
        double vd = 0;
        for(int i = 0; i < linhas.length; i++){
            vd += linhas[i].calculaValorDesconto();
        }
        return vd;
    }

    public int numeroTotalProdutos(){
        int total = 0;
        for(int i = 0; i < linhas.length; i++){
            total += linhas[i].getQuantidade();
        }
        return total;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        for (int i = 0; i < linhas.length; i++){
            if(refProduto.equals(linhas[i].getReferencia())){
                return true;
            }
        }
        return false;
    }

    public void adicionaLinha(LinhaEncomenda linha){
        LinhaEncomenda[] novo = new LinhaEncomenda[linhas.length + 1];
        for(int i = 0; i < linhas.length; i++){
            novo[i] = linhas[i];
        }
        novo[linhas.length] = linha;
        this.linhas = novo;
    }

    public void removeProduto(String codProd){
        if(existeProdutoEncomenda(codProd)){
            System.out.println("Produto removido.");
            LinhaEncomenda[] novo = new LinhaEncomenda[linhas.length - 1];
        for(int i = 0, j = 0; i < linhas.length; i++){
            if(!codProd.equals(this.linhas[i].getReferencia())){
                novo[j] = linhas[i];
                j++;
            }
        }
        this.linhas = novo;
        }
        else{
            System.out.println("A referência que inseriu não corresponde a nenhuma encomenda da lista.");
        }
    }
}