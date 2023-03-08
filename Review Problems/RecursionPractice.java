public class RecursionPractice {
    public static void main(String[] args) {
        // sum
        int sumResult = sum(10);
        System.out.println(sumResult);
        
        // factorial
        int factorialResult = factorial(4);
        System.out.println(factorialResult);
    }

    private static int sum(int maxNum) {
        if (maxNum > 1) {
            return maxNum + sum(maxNum - 1);
        } else {
            return 0;
        }
    }

    private static int factorial(int maxNum) {
        if (maxNum > 1) {
            return maxNum * factorial(maxNum - 1);
        } else {
            return 1;
        }
    }
}