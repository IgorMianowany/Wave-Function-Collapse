package wfc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import tiles.TileFactory;

import java.io.IOException;

public class GUI extends Application {

    private final int FIT_WIDTH = 200;

    private final TileFactory tileFactory = new TileFactory();



    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        ImageView cornerCopy1 = tileFactory.create("corner").getChoice();
        ImageView cornerCopy2 = tileFactory.create("corner").getChoice();
        ImageView cornerCopy3 = tileFactory.create("corner").getChoice();
        ImageView cornerCopy4 = tileFactory.create("corner").getChoice();

        grid.add(tileFactory.create("corner").getChoice(),0,0);
        grid.add(tileFactory.create("line").getChoice(),1,0);
        grid.add(tileFactory.create("line").getChoice(),2,0);
        grid.add(tileFactory.create("line").getChoice(),3,0);
        grid.add(tileFactory.create("line").getChoice(),1,1);
        grid.add(tileFactory.create("line").getChoice(),2,1);
        grid.add(tileFactory.create("line").getChoice(),3,1);

        cornerCopy1.getTransforms().add(new Rotate(180,100,100));
        cornerCopy2.getTransforms().add(new Rotate(270,100,100));
        cornerCopy3.getTransforms().add(new Rotate(90,100,100));

        grid.add(cornerCopy1,4,0);
        grid.add(cornerCopy2,4,1);
        grid.add(cornerCopy3,0,1);
        grid.add(tileFactory.create("corner").getChoice(),0,2);
        grid.add(tileFactory.create("line").getChoice(),1,2);
        grid.add(tileFactory.create("line").getChoice(),2,2);
        grid.add(tileFactory.create("line").getChoice(),3,2);;


        Scene scene = new Scene(grid, 1000, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}