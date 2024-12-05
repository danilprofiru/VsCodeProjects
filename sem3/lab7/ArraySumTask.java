package lab7;

class ArraySumTask extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int sum;

    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }
}
