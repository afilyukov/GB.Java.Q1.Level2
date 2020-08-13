import java.util.Arrays;

public class ArrayThreading {
    static final int SIZE = 100000;
    static final int H = SIZE / 2;
    float[] arr = new float[SIZE];

    public ArrayThreading()  {
        Arrays.fill(arr, 1);
    }

    public void doMathSync() {
        long start = System.currentTimeMillis();
        doArrayMath(arr);
        long end = System.currentTimeMillis() - start;
        System.out.println("Math took: " + end);
    }

    public void doMathAsync() {
        long start = System.currentTimeMillis();
        float[] halfOfArray1 = new float[SIZE / 2];
        float[] halfOfArray2 = new float[SIZE / 2];
        System.arraycopy(arr, 0, halfOfArray1, 0, H);
        System.arraycopy(arr, H, halfOfArray2, 0, H);

        Thread thread1 = new Thread(new Runnable() { //внутренний класс, как в прошлом уроке
            @Override
            public void run() {
                synchronized (halfOfArray1) {
                    doArrayMath(halfOfArray1);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() { //внутренний класс, как в прошлом уроке
            @Override
            public void run() {
                synchronized (halfOfArray2) {
                    doArrayMath(halfOfArray2);
                }
            }
        });

        thread1.start();
        thread2.start();

        mergeArrays(halfOfArray1, halfOfArray2);

        long end = System.currentTimeMillis() - start;
        System.out.println("Async math took: " + end);
    }

    private void doArrayMath(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private void mergeArrays(float[] arr1, float[] arr2) {
        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);
    }
}
