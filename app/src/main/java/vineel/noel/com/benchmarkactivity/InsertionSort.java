package vineel.noel.com.benchmarkactivity;

/**
 * Created by Vinu on 14-09-2017.
 */

public class InsertionSort {
    int[] array;
    InsertionSort(int[] array){
        int j=0;
        this.array = new int[array.length];
        for(int i: array){
            this.array[j] = i;
            j++;
        }
    }
    public void sort(){
        int temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}
