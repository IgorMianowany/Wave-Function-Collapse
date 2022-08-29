package wfc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import tiles.Tile;
import tiles.TileFactory;
import tiles.TileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        TileManager tileManager = new TileManager();




        for(int i = 0; i<5; i++){
            for(int j = 0; j<4; j++){
                grid.add(tileManager.getTiles()[i][j].getChoice(),i,j);
            }
        }
        Scene scene = new Scene(grid, 1000, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}