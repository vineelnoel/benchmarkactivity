package vineel.noel.com.benchmarkactivity;

/**
 * Created by Vinu on 14-09-2017.
 */

public class SelectionSort {
    int[] array;

    SelectionSort(int[] array){
        int j=0;
        this.array = new int[array.length];
        for(int i: array){
            this.array[j] = i;
            j++;
        }
    }

    public void sort(){

        for(int i=0; i<array.length; i++){
            int min = i;
            for(int j=i+1; j<array.length; j++){
                if(array[j]<array[min])
                    min = j;
            }

            int small = array[min];
            array[min] = array[i];
            array[i] = small;
        }
    }
}
