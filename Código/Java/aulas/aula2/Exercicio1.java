package aula2;

public class Exercicio1{

    public int minarray(int[] a){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            if(a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    public int[] arrayentre(int[] a, int i1, int i2){
        if(i1 > a.length || i2 > a.length || i2 < i1){
            return null;
        }
        int[] res = new int[i2-i1+1];
        System.arraycopy(a,i1,res, 0, i2-i1+1);
        return res;
    }

    public int[] comuns(int[] a, int[] b){
        int l = Math.max(a.length, b.length);
        int[] res= new int[l];
        int cnt = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                if(a[i] == b[j]){
                    res[cnt++] = a[i];
                }
            }
        }
        int[] tmp = new int[cnt];
        System.arraycopy(res, 0, tmp,0, cnt);
        return tmp;
    }
}

