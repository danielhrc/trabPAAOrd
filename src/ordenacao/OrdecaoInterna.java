package ordenacao;

public class OrdecaoInterna {
	public static void QuickSort(int v[], int esquerda, int direita) {
        int temp, pivo;
        int i, j;
        i = esquerda;
        j = direita;
        pivo = v[(esquerda + direita) / 2];
        while(i <= j) {
            while(v[i] < pivo && i < direita) {                
                i++;
            }
            while(v[j] > pivo && j > esquerda) {                
                j--;
            }
            if(i <= j) {            		
                temp = v[i];
                v[i] = v[j];
                v[j] = temp;
                i++;
                j--;
            }
        }
        if(j > esquerda){
            QuickSort(v, esquerda, j);            
        }
        if(i < direita){
            QuickSort(v, i, direita);            
        }
    }
}
