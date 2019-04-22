package StartMenu;

import LEVEL_2.LEVEL_2;
import javafx.application.Application;
import javafx.stage.Stage;
import level_1.LEVEL_1;

public class game extends Application {

	public static void main(String[] args)   {
      launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("RIVER CROSSING");
		start_page  startpage = new start_page(primaryStage);
		LEVEL_1 level_1 = new LEVEL_1(primaryStage);
		LEVEL_2 level_2 = new LEVEL_2(primaryStage);

		startpage.scene_build();
		level_1.scene_build();
		level_2.scene_build();
		startpage.setlevel_1(level_1);
		startpage.setlevel_2(level_2);
		primaryStage.setScene(startpage.getScene());
		primaryStage.show();
		
		
	}
}

	
