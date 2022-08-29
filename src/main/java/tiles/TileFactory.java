package tiles;

import javafx.scene.image.Image;
import tileconsts.Tiles;

public class TileFactory {

    public Tile create(String tile){
        switch (tile){
            case "corner" ->{
                return new Tile(new Image(Tiles.CORNER),1,1,0,0);
            }
            case "cross" ->{
                return new Tile(new Image(Tiles.CROSS),1,1,1,1);
            }
            case "empty" ->{
                return new Tile(new Image(Tiles.EMPTY),0,0,0,0);
            }
            case "line" ->{
                return new Tile(new Image(Tiles.LINE),0,1,1,0);
            }
            case "t" ->{
                return new Tile(new Image(Tiles.T),0,1,1,1);
            }
            default -> {
                return null;
            }
        }

    }



}
