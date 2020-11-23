import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Rectangle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the rectangle's bounding rectangle.
 *
 * @author 1909148
 */
public class Rect extends ClosedShape {

    private int width;
    private int height;

    /**
     * Creates a rectangle.
     *
     * @param insertionTime The display component's creation time.
     * @param x             The display component's x position.
     * @param y             The display component's y position.
     * @param vx            The display component's x velocity.
     * @param vy            The display component's y velocity.
     * @param colour        The line colour or fill colour.
     * @param flashed       true if rectangle will flash a secondary colour, false if it doesn't flash a secondary colour.
     * @param flashColours  The display component's secondary colour.
     * @param isFilled      True if the rectangle is filled with colour, false if opaque.
     * @param height        The display component's height.
     * @param width         The display component's width.
     */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean flashed,
                Color flashColours, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, flashed, flashColours, isFilled);
        this.setWidth(width);
        setHeight(height);
    }

    /**
     * This method will draw a rectangle.
     *
     * @param g The graphics object associated with the drawing component.
     */
    public void draw(GraphicsContext g) {
        g.setStroke(colour);
        g.setFill(colour);
        if (isFilled) {
            g.fillRect(x, y, width, height);
        } else {
            g.strokeRect(x, y, width, height);
        }
    }

    /**
     * This method will return the width of rectangle.
     *
     * @return The width of a rectangle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * This method will return the height of rectangle.
     *
     * @return The height of rectangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter for rectangle.
     *
     * @param width Takes in the width of the rectangle.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Setter for rectangle.
     *
     * @param height takes in the height of rectangle.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * This method will return rectangle into string.
     *
     * @return The rectangle into string.
     */
    public String toString() {
        String result = "";
        result += super.toString();
        return result;
    }
}
