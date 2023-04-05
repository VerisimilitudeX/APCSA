package Loops;

public class CpuStressTest {
    public static void main(String[] args) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < numThreads; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        double x = 0;
                        for (int i = 0; i < 1000000; i++) {
                            x += Math.sqrt(Math.random());
                        }
                    }
                }
            }).start();
        }
    }
}