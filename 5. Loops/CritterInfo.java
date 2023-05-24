// Stuart Reges
// 5/22/06
//
// The CritterInfo interface defines a set of methods for querying the
// state of a critter simulation.  The getX and getY methods return a
// critter's current location in the world.  The getNeighbor method
// takes a direction as a parameter (one of the constants NORTH,
// SOUTH, EAST, WEST or CENTER from the Critter interface).  It
// returns the display character for the critter that is one unit away
// in that direction (a period if the square is empty).  The getHeight
// and getWidth methods return the height and width of the world.

public interface CritterInfo {
    public int getX();
    public int getY();
    public char getNeighbor(int direction);
    public int getHeight();
    public int getWidth();
}
