package vineel.noel.com.benchmarkactivity;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BenchmarkActivity extends AppCompatActivity {
    private static final String TAG = BenchmarkActivity.class.getSimpleName();
    EditText etArraySize;
    TextView tvDisplayArray, tvSelection, tvBubble, tvInsertion, tvQuick, tvMerge, tvHeap;
    RadioGroup rgComplexity;
    RadioButton rbBestCase, rbAverageCase, rbWorstCase;
    Button btnGenerateArray, btnSelection, btnBubble, btnInsertion, btnQuick, btnMerge, btnHeap, btnBenchmarkAll, btnStartOver, btnExit;
    GridLayout glAlgos;
    int[] array;

    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if(msg.arg1 == 1)
                Toast.makeText(getApplicationContext(),"Please enter size of Array", Toast.LENGTH_SHORT).show();
        }
    };

    public void initialization(){
        etArraySize = (EditText) findViewById(R.id.etArraySize);
        tvDisplayArray = (TextView) findViewById(R.id.tvDisplayArray);
        tvSelection = (TextView) findViewById(R.id.tvSelection);
        tvBubble = (TextView) findViewById(R.id.tvBubble);
        tvInsertion = (TextView) findViewById(R.id.tvInsertion);
        tvQuick = (TextView) findViewById(R.id.tvQuick);
        tvMerge = (TextView) findViewById(R.id.tvMerge);
        tvHeap = (TextView) findViewById(R.id.tvHeap);
        rgComplexity = (RadioGroup) findViewById(R.id.rgComplexity);
        rbBestCase = (RadioButton) findViewById(R.id.rbBestCase);
        rbAverageCase = (RadioButton) findViewById(R.id.rbAverageCase);
        rbWorstCase = (RadioButton) findViewById(R.id.rbWorstCase);
        btnGenerateArray = (Button) findViewById(R.id.btnGenerateArray);
        btnSelection = (Button) findViewById(R.id.btnSelection);
        btnBubble = (Button) findViewById(R.id.btnBubble);
        btnInsertion = (Button) findViewById(R.id.btnInsertion);
        btnQuick = (Button) findViewById(R.id.btnQuick);
        btnMerge = (Button) findViewById(R.id.btnMerge);
        btnHeap = (Button) findViewById(R.id.btnHeap);
        btnBenchmarkAll = (Button) findViewById(R.id.btnBenchmarkAll);
        btnStartOver = (Button) findViewById(R.id.btnStartOver);
        btnExit = (Button) findViewById(R.id.btnExit);
        glAlgos = (GridLayout) findViewById(R.id.glAlgos);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benchmark_layout);
        initialization();
        rbAverageCase.setChecked(true);
    }

    public void generateArray(View view){
        try{
            String stringArraySize = etArraySize.getText().toString();
            int arraySize = Integer.parseInt(stringArraySize);
            array = new int[arraySize];

            switch (rgComplexity.getCheckedRadioButtonId()){
                case R.id.rbBestCase:
                    int num = 1;
                    for (int i = 0; i < array.length; i++) {
                        array[i] = num;
                        num++;
                    }
                    tvDisplayArray.setText("You have choosen "+rbBestCase.getText().toString()+" of array size "+stringArraySize);
                    break;
                case R.id.rbAverageCase:
                    for (int i = 0; i < array.length; i++) {
                        array[i] = (int) (100.0 * Math.random());
                    }
                    tvDisplayArray.setText("You have choosen "+rbAverageCase.getText().toString()+" of array size "+stringArraySize);
                    break;
                default:
                    num = array.length;
                    for (int i = 0; i < array.length; i++) {
                        array[i] = num;
                        num--;
                    }
                    tvDisplayArray.setText("You have chosen "+rbWorstCase.getText().toString()+" of array size "+stringArraySize);
            }

            glAlgos.setVisibility(View.VISIBLE);
        }catch (Exception e){
//            tvDisplayArray.setText("Please enter the size of the Array!");
            glAlgos.setVisibility(View.INVISIBLE);
            Message msg = handler.obtainMessage();
            msg.arg1 = 1;
            handler.sendMessage(msg);
        }
    }

    public void selectionAlgorithm(View view){
        generateArray(findViewById(R.id.btnGenerateArray));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SelectionSort selectionSort = new SelectionSort(array);
                long startTime = System.currentTimeMillis();
                selectionSort.sort();
                final long totalTime = System.currentTimeMillis()-startTime;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvSelection.setText(totalTime+"ms");
                    }
                });
            }
        });
        t1.start();
    }

    public void bubbleAlgorithm(View view){
        generateArray(findViewById(R.id.btnGenerateArray));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                BubbleSort bubbleSort = new BubbleSort(array);
                long startTime = System.currentTimeMillis();
                bubbleSort.sort();
                final long totalTime = System.currentTimeMillis()-startTime;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvBubble.setText(totalTime+"ms");
                    }
                });
            }
        });
        t1.start();
    }

    public void insertionAlgorithm(View view){
        generateArray(findViewById(R.id.btnGenerateArray));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                InsertionSort insertionSort = new InsertionSort(array);
                long startTime = System.currentTimeMillis();
                insertionSort.sort();
                final long totalTime = System.currentTimeMillis()-startTime;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvInsertion.setText(totalTime+"ms");
                    }
                });
            }
        });
        t1.start();
    }

    public void quickAlgorithm(View view){
        generateArray(findViewById(R.id.btnGenerateArray));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                QuickSort quickSort = new QuickSort(array,0,array.length-1);
                long startTime = System.currentTimeMillis();
                quickSort.sort();
                final long totalTime = System.currentTimeMillis()-startTime;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvQuick.setText(totalTime+"ms");
                    }
                });
            }
        });
        t1.start();
    }

    public void mergeAlgorithm(View view){
        generateArray(findViewById(R.id.btnGenerateArray));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                MergeSort mergeSort = new MergeSort();
                long startTime = System.currentTimeMillis();
                mergeSort.sort(array);
                final long totalTime = System.currentTimeMillis()-startTime;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvMerge.setText(totalTime+"ms");
                    }
                });
            }
        });
        t1.start();
    }

    public void heapAlgorithm(View view){
        generateArray(findViewById(R.id.btnGenerateArray));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                HeapSort heapSort = new HeapSort(array);
                long startTime = System.currentTimeMillis();
                heapSort.sort();
                final long totalTime = System.currentTimeMillis()-startTime;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvHeap.setText(totalTime+"ms");
                    }
                });
            }
        });
        t1.start();
    }

    public void benchmarkAll(View view){
        Thread selection = new Thread(new Runnable() {
            @Override
            public void run() {
                selectionAlgorithm(findViewById(R.id.btnSelection));
            }
        });
        Thread bubble = new Thread(new Runnable() {
            @Override
            public void run() {
                bubbleAlgorithm(findViewById(R.id.btnBubble));
            }
        });
        Thread insertion = new Thread(new Runnable() {
            @Override
            public void run() {
                insertionAlgorithm(findViewById(R.id.btnInsertion));
            }
        });
        Thread quick = new Thread(new Runnable() {
            @Override
            public void run() {
                quickAlgorithm(findViewById(R.id.btnQuick));
            }
        });
        Thread merge = new Thread(new Runnable() {
            @Override
            public void run() {
                mergeAlgorithm(findViewById(R.id.btnMerge));
            }
        });
        Thread heap = new Thread(new Runnable() {
            @Override
            public void run() {
                heapAlgorithm(findViewById(R.id.btnHeap));
            }
        });

        selection.start();
        bubble.start();
        insertion.start();
        quick.start();
        merge.start();
        heap.start();
        Log.i(TAG,"In benchmarkAll method");
    }

    public void startOver(View view){
        etArraySize.setText("");
        tvDisplayArray.setText("");
        tvSelection.setText("");
        tvBubble.setText("");
        tvInsertion.setText("");
        tvQuick.setText("");
        tvMerge.setText("");
        tvHeap.setText("");
        rbAverageCase.setChecked(true);
        glAlgos.setVisibility(View.INVISIBLE);
    }

    public void exit(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }
}
