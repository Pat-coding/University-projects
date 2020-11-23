import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * This is the polygon class where it constructs a polygon shape. It calculates the vertices(x, y) by
 * using a mathematic formula. It can be filled with colour or opaque. It has the option for being able
 * to flash for a secondary colour aswell.
 *
 * @author 1909148
 */
public class Polygon extends ClosedShape {

    private double[] polyX;
    private double[] polyY;
    private int radius; // diameter
    private double angle;
    private int points;

    /**
     * Creates a polygon.
     *
     * @param insertionTime The display component's creation time
     * @param x             The display component's x position.
     * @param y             The display component's y position.
     * @param vx            The display component's x velocity.
     * @param vy            The display component's y velocity.
     * @param colour        The line colour or fill colour.
     * @param flashed       true if polygon will flash a secondary colour, false if it doesn't flash a secondary colour.
     * @param flashColours  The display component's secondary colour.
     * @param isFilled      True if the polygon is filled with colour, false if opaque.
     * @param radius        The radius of the polygon.
     */
    public Polygon(int insertionTime, int x, int y, int vx, int vy, Color colour, boolean flashed, Color flashColours,
                   boolean isFilled, int radius, int points) {
        super(insertionTime, x, y, vx, vy, colour, flashed, flashColours, isFilled);
        setPoints(points);
        setRadius(radius);
        setAngle();
        setPolyX(x);
        setPolyY(y);
    }

    /**
     * The setter for the array of double PolyX.
     * The coordinates must be converted to centroid of the polygon in order for the formula to work.
     *
     * @param x takes in the top right X coordinate and convert it into the center coordinate X.
     */
    public void setPolyX(int x) {
        polyX = new double[getPoints()];
        x = x + radius;
        for (int i = 0; i < getPoints(); i++) {
            polyX[i] = (int) (x + radius * Math.sin(i * getAngle()));
        }

    }

    /**
     * The setter for the array of double PolyX.
     * The coordinates must be converted to centroid of the polygon in order for the formula to work.
     *
     * @param y takes in the top right Y coordinate and convert it into the center coordinate Y.
     */
    public void setPolyY(int y) {
        polyY = new double[getPoints()];
        y = y + radius;
        for (int i = 0; i < getPoints(); i++) {
            polyY[i] = (int) (y + radius * Math.cos(i * getAngle()));
        }

    }

    /**
     * This method will update the coordinates of PolyX and PolyY when it is called in the draw method.
     */
    public void updatePoints() {
        for (int i = 0; i < getPoints(); i++) {
            polyX[i] += xVec;
            polyY[i] += yVec;
        }
    }

    /**
     * This method will draw a polygon on the screen.
     *
     * @param g The graphics object associated with the drawing component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillPolygon(getPolyX(), getPolyY(), getPoints());
        } else {
            g.strokePolygon(getPolyX(), getPolyY(), getPoints());
        }
        updatePoints();
    }

    /**
     * Getter for PolyX.
     *
     * @return The array of X coordinates of the polygon.
     */
    public double[] getPolyX() {
        return polyX;
    }

    /**
     * Getter for PolyY.
     *
     * @return The array of Y coordinates of the polygon.
     */
    public double[] getPolyY() {
        return polyY;
    }

    /**
     * The method to return the width, the radius has to be converted to diameter.
     *
     * @return The width of the polygon.
     */
    public int getWidth() {
        return (getRadius() * 2);
    }

    /**
     * The method to return the height, the radius has to be converted to diameter.
     *
     * @return The height of the polygon.
     */
    public int getHeight() {
        return (getRadius() * 2);
    }

    /**
     * Getter for the radius.
     *
     * @return The radius of the polygon.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Setter for the radius.
     *
     * @param radius resets the radius.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Getter for the angle.
     *
     * @return The angle of a polygon.
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Setter for the angle to be used to find the vertices for a polygon.
     */
    public void setAngle() {
        angle = ((2 * (Math.PI)) / getPoints());
    }

    /**
     * Getter for the points of a polygon.
     *
     * @return The point of a polygon.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Setter for the points of a polygon.
     *
     * @param points Takes in the points of a polygon and set it.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * This method will convert polygon into string.
     *
     * @return
     */
    public String toString() {
        String result = "";
        result += "This is a polygon with " + getPoints() + " points\n";
        result += "The radius is " + getRadius() + " and the diameter is " + (getRadius() * 2) + "\n";
        return result;
    }
}
