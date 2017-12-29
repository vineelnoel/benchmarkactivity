package vineel.noel.com.benchmarkactivity;

/**
 * Created by Vinu on 14-09-2017.
 */

public class QuickSort {
    int[] array;
    int start, end;
    QuickSort(int[] array, int start, int end){
        this.start = start;
        this.end = end;
        int j=0;
        this.array = new int[array.length];
        for(int i: array){
            this.array[j] = i;
            j++;
        }
    }

    public void sort(){
        sort(array,start,end);
    }
    public void sort(int[] array, int start, int end){

        if(start<end){
            int partitionIndex = partition(array, start, end);
            sort(array, start, partitionIndex-1);
            sort(array, partitionIndex+1, end);
        }
    }
    public int partition(int[] array, int start, int end){
        int partitionIndex = start;
        int pivot = end;
        for(int i=start; i<end; i++){
            if(array[i]<array[pivot]){
                swap(array,i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array,partitionIndex,pivot);

        return partitionIndex;
    }

    public void swap(int[] array, int i, int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
