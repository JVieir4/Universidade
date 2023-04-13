package aula3;

import java.util.Arrays;

public class Exercicio2 {
    private int TextStorage; 
    private int PicStorage;
    private int AppStorage;
    private int OccStorage; //bytes
    private int Fotos;
    private int Aplicações;
    private String[] apps;
    private int msgs = 0;
    private int Total;
    private String mensagens[] = new String[this.msgs];

    public Exercicio2 (int textstor, int picstor, int appstor, int occ, int fotos, int aplis, String[] a, int ttl){
        this.TextStorage = textstor;
        this.PicStorage = picstor;
        this.AppStorage = appstor;
        this.OccStorage = occ;
        this.Fotos = fotos;
        this.Aplicações = aplis;
        this.apps = a;
        this.Total = ttl;
    }

    public Exercicio2(){
        this.TextStorage = 20;
        this.PicStorage = 20;
        this.AppStorage = 40;
        this.OccStorage = 80;
        this.Fotos = 500;
        this.Aplicações = 15;
        this.Total = 150;
        this.apps = new String[] {"Facebook", "Instagram", "Reddit", "Twitter", "Snapchat", "Youtube", "WhatsApp", "TikTok", "Spotify", "Blackboard", "Betclick", "Netflix", "Disney+", "Messenger","Slack"};
    }

    public Exercicio2(Exercicio2 tele){
        this.TextStorage = tele.getTextStorage();
        this.PicStorage = tele.getPicStorage();
        this.AppStorage = tele.getAppStorage();
        this.OccStorage = tele.getOccStorage();
        this.Fotos = tele.getFotos();
        this.Aplicações = tele.getAplis();
        this.apps = tele.getApps();
        this.Total = tele.getTotal();
    }

    public String[] getApps() {
        return this.apps;
    }

    public int getTotal() {
        return this.Total;
    }

    public int getAplis() {
        return this.Aplicações;
    }

    public int getFotos() {
        return this.Fotos;
    }

    public int getOccStorage() {
        return this.OccStorage;
    }

    public int getAppStorage() {
        return this.AppStorage;
    }

    public int getPicStorage() {
        return this.PicStorage;
    }

    public int getTextStorage() {
        return this.TextStorage;
    }

    @Override
    public String toString(){
        return "\nTotalStorage: " + Total + "\nTextStorage: " + TextStorage + "\nPicStorage: " + PicStorage + "\nAppStorage: " + AppStorage + "\nOccStorage: " + OccStorage + "(Equivalente à soma dos 3 espaços anteriores)" + "\nNº de Fotos: " + Fotos + "\nNº de Apps: " + Aplicações +"\nApps: " + Arrays.toString(apps);
    }

    public boolean existeEspaco(int numeroBytes){
        if (numeroBytes <= (this.Total - this.OccStorage)){
            return true;
        }
        else{
            return false;
        }
    }

    public void instalaApp(String nome, int tamanho){
        int Free = this.Total- this.OccStorage;
        if(tamanho <= Free){
            this.AppStorage += tamanho;
            this.OccStorage += tamanho;
            Free -= tamanho;
            this.apps = adiciona(this.Aplicações, this.apps, nome);
            this.Aplicações++;
            System.out.println("Aplicações instaladas: " + Arrays.toString(this.apps));
            System.out.println("Espaço Livre: " + Free + "\n");
            System.out.println("Espaço Ocupado por Aplicações: " + this.AppStorage + "\n");
        }
        else{
            System.out.println("Espaço de armazenamento insuficiente.\n");
        }
    }

    private String[] adiciona(int napps, String[] apli, String nome){
        int i; 
        String newArray[] = new String[napps + 1]; 
        for (i = 0; i < napps; i++) 
              newArray[i] = apli[i]; 
        newArray[napps] = nome; 
        return newArray;
    }

    public void recebeMsg(String msg){
        int Free = this.Total- this.OccStorage;
        if(msg.length() <= Free){
            this.TextStorage += msg.length();
            this.OccStorage += msg.length();
            Free -= msg.length();
            this.mensagens = adiciona(this.msgs,this.mensagens, msg);
            this.msgs++;
            System.out.println("Mensagem guardada na lista de mensagens: " + Arrays.toString(mensagens) + "\n");
            System.out.println("Espaço Livre: " + Free + "\n");
            System.out.println("Espaço Ocupado por Mensagens: " + this.TextStorage + "\n");
        }
        else{
            System.out.println("Espaço de armazenamento insuficiente.\n");
        }
    }

    public String maiorMsg(){
        String maior = "";
        for(int i = 0; i < this.msgs; i++){
            if(this.mensagens[i].length() > maior.length()){
                maior = this.mensagens[i];
            }
        }
        return maior;
    }

    public double tamMedioApps(){
        return (this.AppStorage / this.Aplicações);
    }

    public void removeApp(String nome, int tamanho){
        String newArray[] = new String[this.Aplicações - 1];
        for(int i = 0; i < this.Aplicações; i++){
            if(this.apps[i] != nome){
                adiciona(i,newArray,this.apps[i]);
                
            }
        }
        this.apps = newArray;
        this.Aplicações--;
        this.AppStorage -= tamanho;
        this.OccStorage -= tamanho;
        int Free = this.Total- this.OccStorage;
        System.out.println("Aplicações instaladas: " + Arrays.toString(this.apps));
        System.out.println("Espaço Livre: " + Free + "\n");
        System.out.println("Espaço Ocupado por Aplicações: " + this.AppStorage + "\n");
    }
}
