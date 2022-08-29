package tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    private final int FIT_WIDTH = 200;
    private ImageView choice;
    private final int upConnector;
    private final int rightConnector;
    private final int leftConnector;
    private final int downConnector;
    private final List<ImageView> options =
            new ArrayList<>();

    public Tile(Image image, int upConnector, int rightConnector, int leftConnector, int downConnector) {
        this.choice = new ImageView(image);
        choice.setFitWidth(FIT_WIDTH);
        choice.setPreserveRatio(true);

        this.upConnector = upConnector;
        this.rightConnector = rightConnector;
        this.leftConnector = leftConnector;
        this.downConnector = downConnector;
    }

    public ImageView getChoice() {
        return choice;
    }

    public int getUpConnector() {
        return upConnector;
    }

    public int getRightConnector() {
        return rightConnector;
    }

    public int getLeftConnector() {
        return leftConnector;
    }

    public int getDownConnector() {
        return downConnector;
    }
}
