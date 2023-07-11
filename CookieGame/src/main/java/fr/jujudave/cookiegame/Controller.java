package fr.jujudave.cookiegame;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Controller {

    private boolean isAnimated = false;

    private int number = 0;

    @FXML
    private Label numberText;

    @FXML
    private ImageView cookieImage;

    @FXML
    protected void onClick() {

        if (!isAnimated) {
            number++;
            numberText.setText(String.valueOf(number));
            cookieImage.setFitHeight(150);
            cookieImage.setFitWidth(200);

            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(80), cookieImage);

            scaleTransition.setByX(-0.1);
            scaleTransition.setByY(-0.1);
            scaleTransition.setCycleCount(2);
            scaleTransition.setAutoReverse(true);

            scaleTransition.setOnFinished(event -> {
                cookieImage.setScaleX(1);
                cookieImage.setScaleY(1);
                isAnimated = false;
            });

            isAnimated = true;
            scaleTransition.play();
        }

    }

}