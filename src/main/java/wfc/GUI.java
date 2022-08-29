package wfc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import tiles.TileManager;

import java.io.IOException;


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
        Button button = new Button();
        button.setText("Reset");
        button.setTranslateY(-90);
        grid.add(button,0,0);

        button.setOnAction(actionEvent -> {
            TileManager tileManager2 = new TileManager();
            grid.getChildren().clear();
            for(int i = 0; i<5; i++){
                for(int j = 0; j<4; j++){
                    grid.add(tileManager2.getTiles()[i][j].getChoice(),i,j);
                }
            }
            grid.add(button,0,0);
        });



        Scene scene = new Scene(grid, 1000, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}