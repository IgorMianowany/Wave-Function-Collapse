package tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tileconsts.Tiles;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tile {
    private final int FIT_WIDTH = 200;
    private ImageView choice;
    private int upConnector;
    private int rightConnector;
    private int leftConnector;
    private int downConnector;
    private boolean isCollapsed = false;
    private boolean isLimited = false;

    private final List<ImageView> originalOptions = new ArrayList<>();
    private List<ImageView> currentOptions = new ArrayList<>();
    private final List<ImageView> images = new ArrayList<>();

    public Tile() {
        ImageView imageView1 = new ImageView(new Image(Tiles.CORNER));
        imageView1.setFitWidth(FIT_WIDTH);
        imageView1.setPreserveRatio(true);
        ImageView imageView2 = new ImageView(new Image(Tiles.CROSS));
        imageView2.setFitWidth(FIT_WIDTH);
        imageView2.setPreserveRatio(true);
        ImageView imageView3 = new ImageView(new Image(Tiles.EMPTY));
        imageView3.setFitWidth(FIT_WIDTH);
        imageView3.setPreserveRatio(true);
        ImageView imageView4 = new ImageView(new Image(Tiles.LINE));
        imageView4.setFitWidth(FIT_WIDTH);
        imageView4.setPreserveRatio(true);
        ImageView imageView5 = new ImageView(new Image(Tiles.T));
        imageView5.setFitWidth(FIT_WIDTH);
        imageView5.setPreserveRatio(true);

        originalOptions.add(imageView1);
        originalOptions.add(imageView2);
        originalOptions.add(imageView3);
        originalOptions.add(imageView4);
        originalOptions.add(imageView5);

        currentOptions.addAll(originalOptions);

        setChoice(2);
    }

    public List<ImageView> getOriginalOptions() {
        return originalOptions;
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

    private void setUpConnector(int upConnector) {
        this.upConnector = upConnector;
    }

    private void setRightConnector(int rightConnector) {
        this.rightConnector = rightConnector;
    }

    private void setLeftConnector(int leftConnector) {
        this.leftConnector = leftConnector;
    }

    private void setDownConnector(int downConnector) {
        this.downConnector = downConnector;
    }

    public boolean isCollapsed() {
        return isCollapsed;
    }

    public void setCollapsed(boolean collapsed) {
        isCollapsed = collapsed;
    }

    private void setChoice(int choice) {
        this.choice = originalOptions.get(choice);
        switch (choice){
            case(0) ->{
                setUpConnector(1);
                setRightConnector(1);
                setDownConnector(0);
                setLeftConnector(0);
            }
            case(1) ->{
                setUpConnector(1);
                setRightConnector(1);
                setDownConnector(1);
                setLeftConnector(1);
            }
            case(2) ->{
                setUpConnector(0);
                setRightConnector(0);
                setDownConnector(0);
                setLeftConnector(0);
            }
            case(3) ->{
                setUpConnector(0);
                setRightConnector(1);
                setDownConnector(0);
                setLeftConnector(1);
            }
            case(4) ->{
                setUpConnector(0);
                setRightConnector(1);
                setDownConnector(1);
                setLeftConnector(1);
            }
        }
    }

    public void collapse(){
        Random random = new Random();
        ImageView chosen = currentOptions.get(random.nextInt(0, currentOptions.size()));
        setChoice(originalOptions.indexOf(chosen));
        this.setCollapsed(true);
    }

    public void limitOptions(List<ImageView> optionsToRemove){
        currentOptions.removeAll(optionsToRemove);
        this.isLimited = true;
    }

    public List<ImageView> getCurrentOptions() {
        return currentOptions;
    }

    public boolean isLimited() {
        return isLimited;
    }
}
