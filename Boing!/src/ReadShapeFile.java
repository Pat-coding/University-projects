import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class reads a shape file and put it into the shape classes
 *
 * @author 1909148
 */
public class ReadShapeFile {

    /**
     * This method will read the input line for circle and add attributes for the class circle.
     *
     * @param newLine This is the line for circle from the input file.
     * @return The object of circle.
     */
    private static Circle constructCircle(Scanner newLine) {
        final int px = newLine.nextInt();
        final int py = newLine.nextInt();
        final int vx = newLine.nextInt();
        final int vy = newLine.nextInt();
        final boolean filled = newLine.nextBoolean();
        final int diameter = newLine.nextInt();
        final Color color = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final boolean flash = newLine.nextBoolean();
        final Color flashColours = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final int insertionTime = newLine.nextInt();
        return new Circle(insertionTime, px, py, vx, vy, diameter, color, flash, flashColours, filled);
    }

    /**
     * This method will read the input line for oval and add attributes for the class oval.
     *
     * @param newLine This is the line for oval from the input file.
     * @return The object of oval.
     */
    private static Oval constructOval(Scanner newLine) {
        final int px = newLine.nextInt();
        final int py = newLine.nextInt();
        final int vx = newLine.nextInt();
        final int vy = newLine.nextInt();
        final boolean filled = newLine.nextBoolean();
        final int width = newLine.nextInt();
        final int height = newLine.nextInt();
        final Color color = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final boolean flash = newLine.nextBoolean();
        final Color flashColours = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final int insertionTime = newLine.nextInt();
        return new Oval(insertionTime, px, py, vx, vy, width, height, color, flash, flashColours, filled);
    }

    /**
     * This method will read the input line for square and add attributes for the class square.
     *
     * @param newLine This is the line for square from the input file.
     * @return The object of square.
     */
    private static Square constructSquare(Scanner newLine) {
        final int px = newLine.nextInt();
        final int py = newLine.nextInt();
        final int vx = newLine.nextInt();
        final int vy = newLine.nextInt();
        final boolean filled = newLine.nextBoolean();
        final int diameter = newLine.nextInt();
        final Color color = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final boolean flash = newLine.nextBoolean();
        final Color flashColours = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final int insertionTime = newLine.nextInt();
        return new Square(insertionTime, px, py, vx, vy, diameter, color, flash, flashColours, filled);
    }

    /**
     * This method will read the input line for rectangle and add attributes for the class rectangle.
     *
     * @param newLine This is the line for rectangle from the input file.
     * @return The object of rectangle.
     */
    private static Rect constructRect(Scanner newLine) {
        final int px = newLine.nextInt();
        final int py = newLine.nextInt();
        final int vx = newLine.nextInt();
        final int vy = newLine.nextInt();
        final boolean filled = newLine.nextBoolean();
        final int width = newLine.nextInt();
        final int height = newLine.nextInt();
        final Color color = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final boolean flash = newLine.nextBoolean();
        final Color flashColours = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final int insertionTime = newLine.nextInt();
        return new Rect(insertionTime, px, py, vx, vy, width, height, color, flash, flashColours, filled);
    }

    /**
     * This method will read the input line for polygon and add attributes for the class polygon.
     *
     * @param newLine This is the line for polygon from the input file.
     * @return The object of polygon.
     */
    private static Polygon constructPolygon(Scanner newLine) {
        int px = newLine.nextInt();
        int py = newLine.nextInt();
        final int vx = newLine.nextInt();
        final int vy = newLine.nextInt();
        final boolean filled = newLine.nextBoolean();
        final int radius = newLine.nextInt();
        final Color color = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final boolean flash = newLine.nextBoolean();
        final Color flashColours = Color.rgb(newLine.nextInt(), newLine.nextInt(), newLine.nextInt());
        final int insertionTime = newLine.nextInt();
        final int points = newLine.nextInt();
        px = px + radius;
        py = py + radius;
        return new Polygon(insertionTime, px, py, vx, vy, color, flash, flashColours, filled, radius, points);
    }

    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner newLine = new Scanner(line);
            String shapes = newLine.next();
            switch (shapes) {
                case "circle":
                    shapeQueue.enqueue(constructCircle(newLine));
                    break;
                case "oval":
                    shapeQueue.enqueue(constructOval(newLine));
                    break;
                case "square":
                    shapeQueue.enqueue(constructSquare(newLine));
                    break;
                case "rect":
                    shapeQueue.enqueue(constructRect(newLine));
                    break;
                case "polygon":
                    shapeQueue.enqueue(constructPolygon(newLine));
                    break;
            }
        }
        return shapeQueue;
    }

    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     *
     * @param filename the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) throws FileNotFoundException {
        // HINT: You might want to open a file here.
        File file = new File(filename);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return ReadShapeFile.readDataFile(in);
    }
}
