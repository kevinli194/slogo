package view;

import javafx.scene.control.TextArea;

public class HistoryView extends TextArea {

	private static final double width = 200;
	private static final double height = 600;

	public HistoryView() {
		setPrefWidth(width);
		setPrefHeight(height);
		setMaxSize(width, height);
	}
}
