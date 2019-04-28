package View;

import Level1Chars.Controller;
import Level1Chars.Sprite;
import Level1Chars.Strategy;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LEVEL_2 {
	    Stage stage;
	    Scene scene;
	    start_page startpage;
	    Strategy strategy1;
	    Controller controller;
	    public LEVEL_2() {
		}
	    public LEVEL_2(Stage stage) {
	        this.stage = stage;
	    }
	    public Scene getScene() {
	        return this.scene;
	    }

	    public void setlevel_2(start_page startpage) {
	        this.startpage = startpage;
	    }

	    private void showerror() {
	        Alert error = new Alert(Alert.AlertType.INFORMATION);
	        error.setHeaderText("Maximum number of rowers!");
	        error.setContentText("Only 2 characters can move on the raft!!");
	        error.showAndWait();
	    }

	    public void setStrategy(Strategy strategy) {
	        this.strategy1 = strategy;
	    }
	    public void setController(Controller controller) {
	        this.controller = controller;
	    }

		public void setStage(Stage primaryStage) {
			// TODO Auto-generated method stub
			this.stage = primaryStage;
		}

		public void setStartPage(start_page startpage2) {
			// TODO Auto-generated method stub
			this.startpage = startpage2;
		}
		 public void scene_build() {   Pane root = new Pane();
		   Group root1 = new Group();
	        Canvas canvas =new Canvas(600,600);
	        root.getChildren().add(canvas);
	        GraphicsContext gc = canvas.getGraphicsContext2D();
	        Scene scene = new Scene(root,600,600);

	        //Image background = new Image("Assets/BackGroundimg.png")
Sprite background = new Sprite(new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/background.png"));
background.setPositionX(0);
background.setPositionY(0);
background.render(gc);

	        Sprite raftSprite = new Sprite(new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/raft.png"));
	        raftSprite.setPositionX(350);
	        raftSprite.setPositionY(320);
	        raftSprite.render(gc);

	        Sprite boySprite = new Sprite(new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elwad%20bdahro.png"));
	        boySprite.setPositionX(100);
	        boySprite.setPositionY(400);
	        boySprite.render(gc);

	        Sprite girlSprite = new Sprite(new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elbet%20bdhra.png"));
	        girlSprite.setPositionX(200);
	        girlSprite.setPositionY(400);
	        girlSprite.render(gc);

	        Sprite womanSprite = new Sprite(new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elset%20bdhraa.png"));
	        womanSprite.setPositionX(300);
	        womanSprite.setPositionY(400);
	        womanSprite.render(gc);

	        Sprite mansSprite = new Sprite(new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elragel%20bdhro.png"));
	        mansSprite.setPositionX(400);
	        mansSprite.setPositionY(400);
	        mansSprite.render(gc);


	       

	    }
			 
		 }


