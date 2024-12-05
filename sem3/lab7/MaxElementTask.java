package lab7;

class MaxElementTask extends Thread {
    private int[] row;
    private int max;

    public MaxElementTask(int[] row) {
        this.row = row;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        max = row[0];
        for (int num : row) {
            if (num > max) {
                max = num;
            }
        }
    }
}
