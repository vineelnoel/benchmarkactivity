package vineel.noel.com.benchmarkactivity;

/**
 * Created by Vinu on 14-09-2017.
 */

public class BubbleSort {
    int[] array;
    BubbleSort(int[] array){
        int j=0;
        this.array = new int[array.length];
        for(int i: array){
            this.array[j] = i;
            j++;
        }
    }
    public void sort(){
        int temp;
        for(int i=array.length-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }
        }
    }
}
