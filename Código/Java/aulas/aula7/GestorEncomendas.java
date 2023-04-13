package aula7;

import java.util.*;
import java.util.stream.Collectors;


public class GestorEncomendas {
    
    private Map<String,EncEficiente> map;
    //private Set<EncEficiente> encSet;

    public GestorEncomendas(){
        this.map = new HashMap<>();
        //ComparadorEncs compEncs = new ComparadorEncs();
        //this.encSet = new TreeSet<>(compEncs);
    }

    public GestorEncomendas(Map<String,EncEficiente> map){
        this.map = new HashMap<>();

        //iterador por chave/valor
        for(Map.Entry<String,EncEficiente> entry : map.entrySet()){
            this.map.put(entry.getKey(), entry.getValue().clone());
        }
        //opcao com streams
        this.map = map.entrySet().stream()
                    .collect(Collectors.toMap((e) -> e.getKey(),(e) -> e.getValue().clone()));
                    
        /* //iterar pelas chaves
        Set<String> keys = this.map.keySet();
        for(String str : keys){

        }

        //iterar pelos valores
        Collection<EncEficiente> colecao = this.map.values();
        for(EncEficiente enc : colecao){

        } */

    }

    /* public Set<Integer> todosCodigosEnc(){
        for(Map.Entry<String,EncEficiente> entry : map.entrySet()){
        
        }
        
    } */

    public void addEncomenda(EncEficiente enc){

    }

}
