public class TwoDimensionalArray {
    public static void main(String[] args) {
        // How do you create a 2D array in Java?
        // Method1: int[][] array1 = new int[3][3];
        /* Method 2: */ int[][] array2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // How do you access an element in a 2D array?
        int accessedVar = array2[2][1];
        System.out.println(accessedVar);

        // How do you iterate over the elements of a 2D array?
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }

        // How do you find the number of rows and columns in a 2D array?
        int rows = 0;
        int columns = 0;
        for (int i = 0; i < array2.length; i++) {
            rows++;
            for (int j = 0; j < array2[i].length; j++) {
                columns++;
            }
        }
        // Divide columns by the numnber of rows since this method counts the number of
        // columns in each row contiguously
        columns /= rows;
        System.out.println("Rows: " + rows + " | Columns: " + columns);

        // Can you have a 2D array with a different number of elements in each row?
        int[][] diffNumElementsArray = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
        for (int i = 0; i < diffNumElementsArray.length; i++) {
            for (int j = 0; j < diffNumElementsArray[i].length; j++) {
                System.out.print(diffNumElementsArray[i][j] + " ");
            }
            System.out.println();
        }

        // Can you have a 2D array with rows of different data types?
        // int[][] diffDataTypeRows = {{1, "2", 3}}; No
    }
}