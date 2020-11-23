import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * @author Dr D. Archambault, Modified  for JAVAFX by Dr J. L. Jones
 */
public class BouncingShapesWindow {

    private static final int ANIMATION_DELAY = 10;
    private static final String FRAME_TITLE = "Shape Booooiiinggg Frame";

    private GraphicsContext gc;
    private Queue<ClosedShape> shapesToAdd;
    private ArrayList<ClosedShape> activeShapes;
    private int currentTime = 0;
    private boolean flag = true;
    private Color currentColour;
    private Color color;
    private String filename;


    public BouncingShapesWindow(GraphicsContext gc, String filename) throws FileNotFoundException {
        this.gc = gc;
        activeShapes = new ArrayList<ClosedShape>();
        this.initShapes(filename);
        this.insertShapes();
        drawClosedShapes();
        actionPerformed();
        setBothColours();
    }

    public void setBothColours() {
        for (ClosedShape b : activeShapes) {
            setColor(b.getColour());
            setCurrentColour(b.getFlashColours());
        }
    }

    private void drawClosedShapes() {

        for (ClosedShape s : activeShapes) {
            s.draw(gc);
        }
    }

    private void initShapes(String filename) throws FileNotFoundException {
        shapesToAdd = ReadShapeFile.readDataFile(filename);
    }

    private void insertShapes() {
        //no more shapes to add, we are done
        if (shapesToAdd.isEmpty()) {
            return;
        }

        //add shapes if needed
        ClosedShape current = shapesToAdd.peek();
        while (!shapesToAdd.isEmpty() && (current.getInsertionTime() <= currentTime * ANIMATION_DELAY)) {
            activeShapes.add(current);
            shapesToAdd.dequeue();
            if (!shapesToAdd.isEmpty()) {
                current = shapesToAdd.peek();
            }
        }
    }

    public void actionPerformed() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), ae -> onTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void onTime() {
        currentTime++;
        changeColour();
        double h = gc.getCanvas().getHeight();
        double w = gc.getCanvas().getWidth();
        gc.clearRect(0, 0, w, h);
        moveShapes();
        insertShapes();
        drawClosedShapes();
    }

    public void changeColour() {
        if (currentTime % 400 == 0) {
            for (ClosedShape a : activeShapes) {
                a.changeColours();
            }
        }
    }

    public void moveShapes() {
        double dimsY = gc.getCanvas().getHeight();
        double dimsX = gc.getCanvas().getWidth();
        for (ClosedShape s : activeShapes) {
            s.move();

            // Move us back in and bounce if we went outside the drawing area.
            if (s.outOfBoundsX(dimsX)) {
                s.putInBoundsX(dimsX);
                s.bounceX();
            }

            if (s.outOfBoundsY(dimsY)) {
                s.putInBoundsY(dimsY);
                s.bounceY();
            }

        }
    }

    public Color getCurrentColour() {
        return currentColour;
    }

    public void setCurrentColour(Color currentColour) {
        this.currentColour = currentColour;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

