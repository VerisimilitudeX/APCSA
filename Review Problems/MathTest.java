public class MathTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int rand1 = 2 + (int) (Math.random() * 6) + (int) (Math.random() * 6);
            System.out.println(rand1);
        }
    }
}
