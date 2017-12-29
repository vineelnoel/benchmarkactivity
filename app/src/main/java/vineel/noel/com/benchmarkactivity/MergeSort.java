package vineel.noel.com.benchmarkactivity;

/**
 * Created by Vinu on 14-09-2017.
 */

public class MergeSort {
    private int[] tempArray;
    private int[] array;
    private int length;

    public void sort(int[] inputArray){
        this.array = inputArray;
        this.length = inputArray.length;
        this.tempArray = new int[length];
        mergeSort(0, length-1);
    }

    private void mergeSort(int start, int end){
        if(start<end){
            int middle = start + (end - start)/2;

            mergeSort(start, middle);
            mergeSort(middle+1,end);

            merge(start, middle, end);
        }
    }

    private void merge(int start, int middle, int end){
        for(int i=start; i<=end; i++)
            tempArray[i] = array[i];
        int i = start;
        int j = middle+1;
        int k = start;

        while(i<=middle && j<=end){
            if(tempArray[i]<tempArray[j]){
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while(i<=middle){
            array[k] = tempArray[i];
            i++;
            k++;
        }
    }
}
