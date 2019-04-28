package View;

import Level1Chars.Sprite;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LEVEL_2 {
	Stage stage;
	Scene scene;
	start_page startpage;

	public void set_start_page(start_page startpage) {
		this.startpage = startpage;
	}

	/**
	 * @return the scene
	 */
	public Scene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public LEVEL_2(Stage stage) {
		this.stage = stage;
	}

	public void scene_build() {
		Pane root1 = new Pane();
		Canvas canvas = new Canvas(600, 600);
		root1.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		scene = new Scene(root1, 600, 600);

		Sprite background = new Sprite(
				new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/background.png"));
		background.setPositionX(0);
		background.setPositionY(0);
		background.render(gc);

		Sprite raftSprite = new Sprite(
				new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/raft.png"));
		raftSprite.setPositionX(350);
		raftSprite.setPositionY(320);
		raftSprite.render(gc);

		Sprite boySprite = new Sprite(
				new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/el%20wad%20bdahro%20so8yr.png"));
		boySprite.setPositionX(100);
		boySprite.setPositionY(400);
		boySprite.render(gc);

		Sprite girlSprite = new Sprite(
				new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elbet%20bdhra.png"));
		girlSprite.setPositionX(200);
		girlSprite.setPositionY(400);
		girlSprite.render(gc);

		Sprite womanSprite = new Sprite(
				new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elset%20bdhraa.png"));
		womanSprite.setPositionX(300);
		womanSprite.setPositionY(400);
		womanSprite.render(gc);

		Sprite mansSprite = new Sprite(
				new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elragel%20bdhro.png"));
		mansSprite.setPositionX(400);
		mansSprite.setPositionY(400);
		mansSprite.render(gc);
	}

}
