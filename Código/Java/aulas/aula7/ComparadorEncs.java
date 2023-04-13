package aula7;

import java.util.Comparator;

public class ComparadorEncs implements Comparator<EncEficiente>{
    @Override
    public int compare(EncEficiente e1, EncEficiente e2){
        return e1.compareTo(e2);
    }
}
