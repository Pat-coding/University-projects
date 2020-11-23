import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square's bounding rectangle.
 *
 * @author 1909148
 */
public class Square extends ClosedShape {

    private int side;

    /**
     * Creates a square.
     *
     * @param insertionTime The display component's creation time
     * @param x             The display component's x position.
     * @param y             The display component's y position.
     * @param vx            The display component's x velocity.
     * @param vy            The display component's y velocity.
     * @param colour        The line colour or fill colour.
     * @param flashed       true if square will flash a secondary colour, false if it doesn't flash a secondary colour.
     * @param flashColours  The display component's secondary colour.
     * @param isFilled      True if the square is filled with colour, false if opaque.
     * @param side          The side length of a square.
     */
    public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean flashed,
                  Color flashColours, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, flashed, flashColours, isFilled);
        setSide(side);
    }

    /**
     * This method will draw a square.
     *
     * @param g The graphics object associated with the drawing component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillRect(x, y, side, side);
        } else {
            g.strokeRect(x, y, side, side);
        }

    }

    /**
     * This method will return the width of a square.
     *
     * @return The width of the square.
     */
    public int getWidth() {
        return side;
    }

    /**
     * This method will return the height of a square.
     *
     * @return The height of a square.
     */
    public int getHeight() {
        return side;
    }

    /**
     * getter for side.
     *
     * @return The side of a square.
     */
    public int getSide() {
        return side;
    }

    /**
     * Setter for side.
     *
     * @param side Take in side of a square.
     */
    public void setSide(int side) {
        this.side = side;
    }

    /**
     * This method will return the square class into string.
     *
     * @return The square class into string.
     */
    public String toString() {
        String result = "";
        result += super.toString();
        return result;
    }
}
