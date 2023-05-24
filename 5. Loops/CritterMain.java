// Stuart Reges
// 9/6/00
//
// CritterMain provides method main for a simple simulation program.

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame(100, 50);

        //frame.add(25, "Stone");
        frame.add(25, "Bird");
        frame.add(1, "Frog");
        frame.add(1, "OldTurtle");
        frame.add(1, "Turtle");
        frame.add(25, "Wolf");

        frame.start();
    }
}
