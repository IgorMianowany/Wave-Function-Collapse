package wfc;

import javafx.scene.image.ImageView;

public class CopyImageView {
    public static ImageView copy(ImageView imageView){
        ImageView copy = new ImageView();
        copy.setImage(imageView.getImage());
        copy.setFitWidth(imageView.getFitWidth());
        copy.setPreserveRatio(imageView.isPreserveRatio());
        return copy;
    }
}
