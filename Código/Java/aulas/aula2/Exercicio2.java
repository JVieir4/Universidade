package aula2;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Exercicio2{
    private LocalDate[] datas;
    private int cnt;

    public Exercicio2(){
        cnt = 0;
        datas = new LocalDate[10];
    }

    public Exercicio2(int n){
        cnt = 0;
        datas = new LocalDate[n];
    }
    public void insereData(LocalDate d){
        if(cnt < datas.length){
            datas[cnt++] = d;
        }
    }
    public LocalDate datamaisproxima(LocalDate d){
        LocalDate res = null;
        long dist = Integer.MAX_VALUE;
        for(int i = 0; i < cnt; i++){
            long diasentre = d.until(datas[i], ChronoUnit.DAYS);
            diasentre = Math.abs(diasentre);
            if(diasentre < dist){
                res = datas[i];
                dist = diasentre;
            }
        }
        return res;
    }
    public String toString(){
        return Arrays.toString(datas);
    }
}