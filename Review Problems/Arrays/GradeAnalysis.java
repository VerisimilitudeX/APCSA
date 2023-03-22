package Arrays;
public class GradeAnalysis {
    public static int rowSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static int[] rowsMax(int[] arr) {
        int[] returnArray = new int[2];
        int biggest = arr[0];
        int numElements = arr.length;
        for (int i = 0; i < numElements; i++) {
            if (arr[i] > biggest) {
                biggest = arr[i];
            }
        }
        returnArray[0] = biggest;
        returnArray[1] = numElements;
        return returnArray;
    }

    public static boolean isFair(int[][] arr) {
        int highestScore = arr[0][0];
        int sumEverything = 0;
        int numElementsAll = 0;
        for (int[] row : arr) {
            int rowSumResponse = rowSum(row);
            int[] rowsMaxResponse = rowsMax(row);
            if (rowsMaxResponse[0] > highestScore) {
                highestScore = rowsMaxResponse[0];
            }
            sumEverything += rowSumResponse;
            numElementsAll += rowsMaxResponse[1];
        }
        double average = (double) (sumEverything / (double) numElementsAll);
        if (Math.abs(average - highestScore) <= 15) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] array = {{60, 70, 80, 70, 92}, {80, 70, 90, 90, 90}, {70, 80, 80, 90, 50}}; 
        System.out.println(isFair(array));
    }
}
