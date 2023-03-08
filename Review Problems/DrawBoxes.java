public class DrawBoxes {
    public static void drawBoxes(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < cols; k++) {
                System.out.print("----");
            }
            System.out.print("-\n");
            for (int j = 0; j < cols; j++) {
                System.out.print("|   ");
            }
            System.out.println("|");
        }
        for (int l = 0; l < cols; l++) {
            System.out.print("----");
        }
        System.out.println("-");
    }

    public static void main(String[] args) {
        drawBoxes(3, 4);
    }
}