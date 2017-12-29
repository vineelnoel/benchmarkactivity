package vineel.noel.com.benchmarkactivity;

/**
 * Created by Vinu on 14-09-2017.
 */

public class HeapSort {
    private static int N;
    int[] arr;

    HeapSort(int[] array){
        int j=0;
        arr = new int[array.length];
        for(int i: array){
            arr[j] = i;
            j++;
        }
    }

    public void sort(){
        sort(arr);
    }

    /* Sort Function */

    public void sort(int arr[])

    {

        heapify(arr);

        for (int i = N; i > 0; i--)

        {

            swap(arr,0, i);

            N = N-1;

            maxheap(arr, 0);

        }

    }

    /* Function to build a heap */

    public void heapify(int arr[])

    {

        N = arr.length-1;

        for (int i = N/2; i >= 0; i--)

            maxheap(arr, i);

    }

    /* Function to swap largest element in heap */

    public void maxheap(int arr[], int i)

    {

        int left = 2*i ;

        int right = 2*i + 1;

        int max = i;

        if (left <= N && arr[left] > arr[i])

            max = left;

        if (right <= N && arr[right] > arr[max])

            max = right;



        if (max != i)

        {

            swap(arr, i, max);

            maxheap(arr, max);

        }

    }

    /* Function to swap two numbers in an array */

    public void swap(int arr[], int i, int j)

    {

        int tmp = arr[i];

        arr[i] = arr[j];

        arr[j] = tmp;

    }
}
