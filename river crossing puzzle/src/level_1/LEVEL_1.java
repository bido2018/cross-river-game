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
	//@SuppressWarnings("deprecation")
	public void scene_build() {
		Group root = new Group();
		Canvas canvas = new Canvas(600,600);
		root.getChildren().add(canvas);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		Image image = new Image("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/level_1/background.png");
        gc.drawImage(image, 0, 0);
    	scene = new Scene (root,600,600);
    	Image image2 = new Image("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/StartMenu/raft.png");
         Sprite raft = new Sprite (image2);
         raft.setPositionX(350);
         raft.setPositionY(320);
         raft.render(gc);
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
    	Image button_img = new Image ("file:///C:/Users/HP/eclipse-workspace/river%20crossing%20puzzle/src/StartMenu/button.png");
        gc.drawImage(button_img, 500, 0);
        
        
    	scene.setOnMouseClicked((MouseEvent)->
    	{
    	double x=	MouseEvent.getSceneX();
    	double y = MouseEvent.getSceneY();
    if((x>=farmer.getPositionX())&&(x<farmer.getPositionX()+farmer.getWidth())&&(y>=farmer.getPositionY())&&(y<farmer.getPositionY()+farmer.getHeight())) 
    {
    		farmer.setPositionX(380);
    	farmer.setPositionY(310);
    	gc.clearRect(0, 0, 600, 600);
      	 gc.drawImage(image, 0, 0);
       	gc.drawImage(image2, 350, 320);
          farmer.render(gc);
          goat.render(gc);
          plant.render(gc);
          wolf.render(gc);
          gc.drawImage(button_img, 500, 0);
    		}
    else if((x>=wolf.getPositionX())&&(x<wolf.getPositionX()+wolf.getWidth())&&(y>=wolf.getPositionY())&&(y<wolf.getPositionY()+wolf.getHeight())) {
		wolf.setPositionX(420);
	wolf.setPositionY(310);
	gc.clearRect(0, 0, 600, 600);
  	 gc.drawImage(image, 0, 0);
   	gc.drawImage(image2, 350, 320);
      farmer.render(gc);
      goat.render(gc);
      plant.render(gc);
      wolf.render(gc);
      gc.drawImage(button_img, 500, 0);

		}
    else  if((x>=plant.getPositionX())&&(x<plant.getPositionX()+plant.getWidth())&&(y>=plant.getPositionY())&&(y<plant.getPositionY()+plant.getHeight())) {
		plant.setPositionX(460);
	plant.setPositionY(310);
     gc.clearRect(0, 0, 600, 600);
  	 gc.drawImage(image, 0, 0);
   	gc.drawImage(image2, 350, 320);
      farmer.render(gc);
      goat.render(gc);
      plant.render(gc);
      wolf.render(gc);
      gc.drawImage(button_img, 500, 0);

		}
    else  if((x>=goat.getPositionX())&&(x<goat.getPositionX()+goat.getWidth())&&(y>=goat.getPositionY())&&(y<goat.getPositionY()+goat.getHeight())) {
		goat.setPositionX(500);
	goat.setPositionY(310);
	gc.clearRect(0, 0, 600, 600);
  	 gc.drawImage(image, 0, 0);
   	gc.drawImage(image2, 350, 320);
      farmer.render(gc);
      goat.render(gc);
      plant.render(gc);
      wolf.render(gc);
      gc.drawImage(button_img, 500, 0);
}
    else if ((x>=500)&&(x<500+button_img.getWidth())&&(y>=0)&&(y<0+button_img.getHeight())) {
    	if(raft.getPositionY()==320) {
    	 if(farmer.getPositionX()!=150) {
    		farmer.setPositionX(50);
    		farmer.setPositionY(100);
    		
    	}
    	  if (goat.getPositionX()!=380) {
    		goat.setPositionX(100);
    		goat.setPositionY(100);
    	}
    	  if(wolf.getPositionX()!=190) {
    		wolf.setPositionX(150);
    		wolf.setPositionY(100);
    	}
    	 if(plant.getPositionX()!=290) {
    		plant.setPositionX(250);
    		plant.setPositionY(100);
    	}
    	 gc.drawImage(image, 0, 0);
    	 raft.setPositionX(350);
    	 raft.setPositionY(260);
raft.render(gc);		     
farmer.render(gc);
		      goat.render(gc);
		      plant.render(gc);
		      wolf.render(gc);
		        gc.drawImage(button_img, 500, 0);

    }
    	else if (raft.getPositionY()==260) {
    		if(farmer.getPositionX()!=50) {
        		farmer.setPositionX(150);
        		farmer.setPositionY(410);
        		
        	}
        	  if (goat.getPositionX()!=100) {
        		goat.setPositionX(380);
        		goat.setPositionY(410);
        	}
        	  if(wolf.getPositionX()!=150) {
        		wolf.setPositionX(190);
        		wolf.setPositionY(410);
        	}
        	 if(plant.getPositionX()!=250) {
        		plant.setPositionX(290);
        		plant.setPositionY(410);
        	}
        	 gc.drawImage(image, 0, 0);
    		   	gc.drawImage(image2, 350, 260);
    		      farmer.render(gc);
    		      goat.render(gc);
    		      plant.render(gc);
    		      wolf.render(gc);
    		        gc.drawImage(button_img, 500, 0);
    	}
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
