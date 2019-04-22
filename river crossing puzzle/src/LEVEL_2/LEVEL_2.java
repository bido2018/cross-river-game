package LEVEL_2;

import StartMenu.start_page;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LEVEL_2 {
	Stage stage;
	Scene scene;
	start_page startpage;
	public LEVEL_2(Stage stage) {
		this.stage= stage;
	}
	public void scene_build() {
		
		
	}
	public Scene getScene() {
		return this.scene;
		}
		public void setLoginForm(start_page startpage) {
		this.startpage = startpage;
		}
}
