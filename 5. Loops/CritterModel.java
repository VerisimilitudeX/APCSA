// Stuart Reges
// 1/26/00
//
// Class CritterModel keeps track of the state of the critter simulation.

import java.util.*;
import java.awt.*;

public class CritterModel {
    private int myHeight;
    private int myWidth;
    private Critter[][] myGrid;
    private char[][] display;
    private Map<Critter, Point>myList;
    private SortedMap<String, Integer>critterCount;

    public CritterModel(int width, int height) {
        myWidth = width;
        myHeight = height;
        myGrid = new Critter[width][height];
        display = new char[width][height];
        updateDisplay();
        myList = new HashMap<Critter, Point>();
        critterCount = new TreeMap<String, Integer>();
    }

    @SuppressWarnings("rawtypes")
	public void add(int number, Class critter) {
        if (myList.size() + number > myWidth * myHeight)
            throw new RuntimeException("adding too many critters");
        for (int i = 0; i < number; i++) {
            Object instance;
            try {
                instance = critter.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("no zero-argument constructor for "
                                           + critter);
            }
            if (!(instance instanceof Critter)) {
                throw new RuntimeException(critter
                                           + " does not implement Critter");
            }
            Critter next = (Critter)instance;
            int x, y;
            do {
                x = randomInt(0, myWidth - 1);
                y = randomInt(0, myHeight - 1);
            } while (myGrid[x][y] != null);
            myGrid[x][y] = next;
            display[x][y] = next.getChar();
            myList.put(next, new Point(x, y));
        }
        String name = critter.getName();
        if (!critterCount.containsKey(name))
            critterCount.put(name, number);
        else
            critterCount.put(name, critterCount.get(name) + number);
    }

    private static int randomInt(int low, int high) {
        return low + (int)(Math.random() * (high - low + 1));
    }

    public int getWidth() {
        return myWidth;
    }

    public int getHeight() {
        return myHeight;
    }

    public char getChar(int x, int y) {
        return display[x][y];
    }

    // We want to ask each critter once on each round how to display it.
    // This method does the asking, storing the result in display.
    private void updateDisplay() {
        // set it to all dots
        for (int x = 0; x < myWidth; x++) 
            for (int y = 0; y < myHeight; y++)
                if (myGrid[x][y] == null)
                    display[x][y] = '.';
                else
                    display[x][y] = myGrid[x][y].getChar();
    }

    public void update() {
        Critter[][] newGrid = new Critter[myWidth][myHeight];
        Object[] list = myList.keySet().toArray();
        Collections.shuffle(Arrays.asList(list));
        for (int i = 0; i < list.length; i++) {
            Critter next = (Critter) list[i];
            Point p = myList.get(next);
            int move = next.getMove(new Info(p.x, p.y));
            movePoint(p, move);
            if (newGrid[p.x][p.y] != null) {
                String c = newGrid[p.x][p.y].getClass().getName();
                critterCount.put(c, critterCount.get(c) - 1);
                myList.remove(newGrid[p.x][p.y]);
            }
            newGrid[p.x][p.y] = next;
        }
        myGrid = newGrid;
        updateDisplay();
    }

    public Set<Map.Entry<String, Integer>> getCounts() {
        return Collections.unmodifiableSet(critterCount.entrySet());
    }

    // translates a point's coordinates 1 unit in a particular direction
    private void movePoint(Point p, int direction) {
        if (direction == Critter.NORTH)
            p.y = (p.y + myHeight - 1) % myHeight;
        else if (direction == Critter.SOUTH)
            p.y = (p.y + 1) % myHeight;
        else if (direction == Critter.EAST)
            p.x = (p.x + 1) % myWidth;
        else if (direction == Critter.WEST)
            p.x = (p.x + myWidth - 1) % myWidth;
        else if (direction != Critter.CENTER)
            throw new RuntimeException("Illegal direction");
    }

    // an object used to query a critter's state (position, neighbors)
    private class Info implements CritterInfo {
        private int x;
        private int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public char getNeighbor(int direction) {
            Point other = new Point(x, y);
            movePoint(other, direction);
            return display[other.x][other.y];
        }

        public int getHeight() {
            return myHeight;
        }

        public int getWidth() {
            return myWidth;
        }
    }
}
