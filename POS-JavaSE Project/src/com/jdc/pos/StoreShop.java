package com.jdc.pos;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class StoreShop implements Initializable {

	@FXML
	private VBox nav;

	private boolean hide;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		nav.setOnMouseClicked(event -> {
			if (hide) {
				show();
			} else {
				hide();
			}

		});

	}

	private void hide() {
		hide = true;
		ScaleTransition scale = new ScaleTransition(Duration.millis(500), nav);
		scale.setFromX(1);
		scale.setToX(0.2);
		scale.setAutoReverse(false);
		scale.setCycleCount(1);

		TranslateTransition trans = new TranslateTransition(Duration.millis(500), nav);
		trans.setFromX(0);
		trans.setToX(-100);

		ParallelTransition parallel = new ParallelTransition(scale, trans);
		parallel.play();
	}

	private void show() {
		hide = false;

		ScaleTransition scale = new ScaleTransition(Duration.millis(500), nav);
		scale.setFromX(0.2);
		scale.setToX(1);
		scale.setAutoReverse(false);
		scale.setCycleCount(1);

		TranslateTransition trans = new TranslateTransition(Duration.millis(500), nav);
		trans.setFromX(-100);
		trans.setToX(0);

		ParallelTransition parallel = new ParallelTransition(scale, trans);
		parallel.play();
	}

}
