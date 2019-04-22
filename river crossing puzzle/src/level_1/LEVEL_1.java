package level_1;

import java.awt.MouseInfo;
import java.awt.Point;

import StartMenu.start_page;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import spirites.Sprite;

public class LEVEL_1 {
	Stage stage;
	Scene scene;
	start_page startpage;
	public LEVEL_1(Stage stage) {
		this.stage= stage;
	}
	public void scene_build() {
		//Group root = new Group();
		Pane root = new Pane();
		Canvas canvas = new Canvas(2000,2000);
		root.getChildren().add(canvas);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		Image image = new Image("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/StartMenu/background.png");
        gc.drawImage(image, 0, 0);
    	scene = new Scene (root,800,600);
    	Image image2 = new Image("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/StartMenu/raft.png");
    	gc.drawImage(image2, 350, 320);
    	Image farmer_img = new Image("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/spirites/farmer.png");
    	Sprite farmer = new Sprite(farmer_img);
    	farmer.setPositionX(150);
    	farmer.setPositionY(410);
    	farmer.render(gc);
    	Image wolf_img = new Image ("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/spirites/wolf.png");
    	Sprite wolf = new Sprite(wolf_img);
    	wolf.setPositionX(190);
    	wolf.setPositionY(410);
    	wolf.render(gc);
        Image goat_img = new Image ("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/spirites/sheep.png");
    	Sprite goat = new Sprite(goat_img);
    	goat.setPositionX(380);
    	goat.setPositionY(410);
    	goat.render(gc);
    	Image plant_img = new Image ("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/spirites/plant.png");
    	Sprite plant = new Sprite(plant_img);
    	plant.setPositionX(290);
    	plant.setPositionY(410);
    	plant.render(gc);
    	Button farmerbtn = new Button();

    	scene.setOnMouseClicked((MouseEvent)->
    	{
    		Point p = MouseInfo.getPointerInfo().getLocation();

    		if((p.x>=farmer.getPositionX())&&(p.x<=farmer.getPositionX()+farmer.getWidth())||(p.y>=farmer.getPositionY())&&(p.y<=farmer.getPositionY()+farmer.getHeight())) {
    	farmer.setPositionX(380);
    	farmer.setPositionY(310);
    	gc.clearRect(0, 0, 2000, 2000);
    	 gc.drawImage(image, 0, 0);
     	gc.drawImage(image2, 350, 320);
        farmer.render(gc);
        goat.render(gc);
        plant.render(gc);
        wolf.render(gc);
    		}
    	}
    	);
    	
    	
    			}
	public Scene getScene() {
		return this.scene;
		}
		public void setlevel_1(start_page startpage) {
		this.startpage = startpage;
		}
}
