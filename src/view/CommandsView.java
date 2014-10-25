package view;

import java.util.List;

import model.CommandsList;
import model.Feature;
import model.VariablesList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CommandsView extends SideView {
	private static final int DELETE_BUTTON_X = 50;


	public CommandsView(InputView input, double width, double height) {
		super(input, width, height);
	}

	public void update(CommandsList commandsList, VariablesList variablesList) {
		List<String[]> instructions= commandsList.generate();
		String[] variables=variablesList.generate();
		
		myView.getChildren().clear();
		addLable("Default Commands:");
		for (String s : instructions.get(0)) {
			addTextBox(s);
		}
		addLable("User Defined Commands:");
		for (String s:instructions.get(1)){
			addTextBoxWithDeleteButton(s,commandsList);
		}
		addLable("Variables:");
		for (String s:variables){
			addTextBoxWithDeleteButton(s,variablesList);
		}
		
		
	}

	private void addLable(String s) {
		HBox h = new HBox();
		Text t = new Text(s+"\n");
		t.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		t.setFill(Color.BLUE);
		h.getChildren().add(t);
		myView.getChildren().add(h);
	}
	
	public void addTextBoxWithDeleteButton(String s, Feature f) {
		HBox h = new HBox();
		Text t = super.makeClickableText(s);
		Button delete=makeDeleteButton(s,f);
		h.getChildren().addAll(t,delete);
		myView.getChildren().add(h);
	}

	private Button makeDeleteButton(String s, Feature f) {
		Button b=new Button();
		b.setText("delete");
		b.setTranslateX(DELETE_BUTTON_X);
		b.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				myView.getChildren().remove(b.getParent());
				String key;
				if (f.getClass().getSimpleName().equals("CommandsList"))
					key=s;
				else key=":"+s.split(":")[0].trim();
				System.out.println(key);
				f.remove(key);
			}
		});
		return b;
	}

}
