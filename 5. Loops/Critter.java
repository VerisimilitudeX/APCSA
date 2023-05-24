// Stuart Reges
// 12/03/04
//
// The Critter interface defines the methods necessary for an animal
// to participate in the critter simulation.  It must return a
// character when getChar is called that is used for displaying it on
// the screen.  The getMove method must return a legal move (one of
// the constants NORTH, SOUTH, EAST, WEST, CENTER).  See the
// CritterInfo interface for a description of its methods.

public interface Critter {
    public char getChar();
    public int getMove(CritterInfo info);

    public static final int NORTH = -1;
    public static final int SOUTH = 3;
    public static final int EAST = 8;
    public static final int WEST = 11;
    public static final int CENTER = 42;
}
