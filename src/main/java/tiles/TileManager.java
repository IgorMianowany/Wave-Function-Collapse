package tiles;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileManager {
   private final Tile[][] tiles = new Tile[5][5];
   private Tile[][] tilesLeft = new Tile[5][5];
   private final TileFactory factory = new TileFactory();
   private int lowestEntropyTileX;
   private int lowestEntropyTileY;
   private int lowestEntropyTileEntropy = 1000;

   public TileManager(){
       for(int i = 0; i<5; i++){
           for(int j = 0; j<5; j++){
               Tile tile = factory.create("corner");
               tiles[i][j] = tile;
               tilesLeft[i][j] = tile;
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
        limitEntropy();
        tilesLeft[0][0] = null;

        for(int i = 0; i<5;i++){
            for(int j = 0; j<5; j++){
                findLowestEntropyTile().collapse();
            }
        }
    }

    private Tile findLowestEntropyTile() {
       List<Tile> toCollapse = new ArrayList<>();
       lowestEntropyTileEntropy = 10;
       for(int i = 0; i<5;i++){
            for(int j = 0; j<5; j++){
                if(!tiles[j][i].isCollapsed() && tiles[j][i].getCurrentOptions().size() < lowestEntropyTileEntropy){
                    toCollapse.add(tiles[j][i]);
                    System.out.println("Adding to toCollapse tile on: (" + j + ";" + i + ")" );
                    lowestEntropyTileEntropy = tiles[j][i].getCurrentOptions().size();
                    lowestEntropyTileX = j;
                    lowestEntropyTileY = i;
                }
            }
       }
       System.out.println("toCollapse size: " + toCollapse.size());
        if(toCollapse.size()>0){
            return toCollapse.get(new Random().nextInt(0, toCollapse.size()));
        }
        else{
            return tiles[lowestEntropyTileX][lowestEntropyTileY];
        }
   }

    public void limitEntropy(){

        List<ImageView> optionsToRemove = new ArrayList<>();
        List<ImageView> originalOptions;
        for(int i = 0; i<5;i++){
            for(int j = 0; j<5; j++){
                if(!tiles[j][i].isLimited()){
                    if(j>0){
                        if(i==0){
                            if(tiles[j-1][i].getRightConnector() == 1){
                                originalOptions = tiles[j][i].getOriginalOptions();
                                optionsToRemove.add(originalOptions.get(0));
                                optionsToRemove.add(originalOptions.get(1));
                                optionsToRemove.add(originalOptions.get(2));
                            }
                        }
                        else{
                            originalOptions = tiles[j][i].getOriginalOptions();
                            if(tiles[j-1][i].getRightConnector() == 0 && tiles[j][i-1].getDownConnector() == 0){
                                optionsToRemove.add(originalOptions.get(0));
                                optionsToRemove.add(originalOptions.get(1));
                                optionsToRemove.add(originalOptions.get(3));
                                optionsToRemove.add(originalOptions.get(4));
                            }
                            else if(tiles[j-1][i].getRightConnector() == 1 && tiles[j][i-1].getDownConnector() == 0){
                                optionsToRemove.add(originalOptions.get(0));
                                optionsToRemove.add(originalOptions.get(1));
                                optionsToRemove.add(originalOptions.get(2));
                            }
                            else if(tiles[j-1][i].getRightConnector() == 1 && tiles[j][i-1].getDownConnector() == 1){
                                optionsToRemove.add(originalOptions.get(0));
                                optionsToRemove.add(originalOptions.get(2));
                                optionsToRemove.add(originalOptions.get(3));
                                optionsToRemove.add(originalOptions.get(4));
                            }
                            else if(tiles[j-1][i].getRightConnector() == 0 && tiles[j][i-1].getDownConnector() == 1){
                                optionsToRemove.add(originalOptions.get(1));
                                optionsToRemove.add(originalOptions.get(2));
                                optionsToRemove.add(originalOptions.get(3));
                                optionsToRemove.add(originalOptions.get(4));
                            }
                        }
                    }
                    else{
                        if (i > 0){
                            if(tiles[j][i-1].getDownConnector() == 1){
                                originalOptions = tiles[j][i].getOriginalOptions();
                                optionsToRemove.add(originalOptions.get(1));
                                optionsToRemove.add(originalOptions.get(2));
                                optionsToRemove.add(originalOptions.get(3));
                                optionsToRemove.add(originalOptions.get(4));
                            }
                            if(tiles[j][i-1].getDownConnector() == 0){
                                originalOptions = tiles[j][i].getOriginalOptions();
                                optionsToRemove.add(originalOptions.get(0));
                                optionsToRemove.add(originalOptions.get(1));
                            }
                        }

                    }
                    tiles[j][i].limitOptions(optionsToRemove);
                    optionsToRemove.clear();
                }
            }
        }
    }
}
