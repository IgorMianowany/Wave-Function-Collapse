package tiles;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class TileManager {
   private final Tile[][] tiles = new Tile[5][5];
   private final TileFactory factory = new TileFactory();

   public TileManager(){
       for(int i = 0; i<5; i++){
           for(int j = 0; j<5; j++){
               Tile tile = factory.create("corner");
               tiles[i][j] = tile;
           }
       }
       collapse();
   }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void collapse(){

        List<ImageView> optionsToRemove = new ArrayList<>();
        List<ImageView> originalOptions = tiles[0][0].getOriginalOptions();

        optionsToRemove.add(originalOptions.get(2));

        tiles[0][0].limitOptions(optionsToRemove);
        tiles[0][0].collapse();

        optionsToRemove.clear();

        for(int i = 0; i<5;i++){
            for(int j = 0; j<5; j++){
                if(j>0){
                    if(tiles[j-1][i].getRightConnector() == 1){
                        originalOptions = tiles[j][i].getOriginalOptions();
                        optionsToRemove.add(originalOptions.get(0));
                        optionsToRemove.add(originalOptions.get(2));
                        optionsToRemove.add(originalOptions.get(3));
                        tiles[j][i].limitOptions(optionsToRemove);
                        tiles[j][i].collapse();
                        optionsToRemove.clear();
                    }
                }

            }
        }
    }
}
