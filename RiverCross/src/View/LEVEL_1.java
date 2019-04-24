package View;

import Level1Chars.Controller;
import Level1Chars.Sprite;
import Level1Chars.Strategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LEVEL_1 implements java.io.Serializable {
    Stage stage;
    Scene scene;
    start_page startpage;
    Strategy strategy1;
    Controller controller;


    public LEVEL_1() {
	}

	public boolean getRiftLocation() {
        return riftLocation;
    }

    //*******************************************************************************************************
    boolean riftLocation = false; //false lower, true upper

    public int getNumOfSails() {
        return numOfSails;
    }

    int numOfSails = 0;
    //*******************************************************************************************************
    public LEVEL_1(Stage stage) {
        this.stage = stage;
    }

    public void scene_build() {
        //Group root = new Group();
        Pane root = new Pane();
        Canvas canvas = new Canvas(600, 600);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image image = new Image("Assets/background.png");
        Sprite background = new Sprite(image);
        background.setPositionX(0);
        background.setPositionY(0);
        background.render(gc);
        Image saveimg = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/save%20button.png");
       Sprite savebtn = new Sprite (saveimg);
       savebtn.setPositionX(150);
       savebtn.setPositionY(0);
       savebtn.render(gc);
     Image loadimg = new Image ("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/loadbtn.png");
     Sprite loadbtn = new Sprite(loadimg);
     loadbtn.setPositionX(250);
     loadbtn.setPositionY(0);
     loadbtn.render(gc);
     
     scene = new Scene(root, 600, 600);

        Image farmer_img = new Image("Assets/farmer.png");
        Sprite farmer = new Sprite(farmer_img);
        farmer.setPositionX(120);
        farmer.setPositionY(410);
        farmer.render(gc);

        Image wolf_img = new Image("Assets/wolf.png");
        Sprite wolf = new Sprite(wolf_img);
        wolf.setPositionX(200);
        wolf.setPositionY(410);
        wolf.render(gc);

        Image goat_img = new Image("Assets/sheep.png");
        Sprite goat = new Sprite(goat_img);
        goat.setPositionX(460);
        goat.setPositionY(410);
        goat.render(gc);

        Image image2 = new Image("Assets/raft.png");
        Sprite raft = new Sprite(image2);
        raft.setPositionX(350);
        raft.setPositionY(320);
        raft.render(gc);

        Image button_img = new Image("Assets/button.png");
        Sprite movebtn = new Sprite(button_img);
        movebtn.setPositionX(500);
       	movebtn.setPositionY(0);
       	movebtn.render(gc);

        Image plant_img = new Image("Assets/plant.png");
        Sprite plant = new Sprite(plant_img);
        plant.setPositionX(310);
        plant.setPositionY(410);
        plant.render(gc);

        Image resetimg = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/reset-button.png");
        Sprite resetbtn = new Sprite(resetimg);
        resetbtn.setPositionX(0);
        resetbtn.setPositionY(0);
        resetbtn.render(gc);
      
        scene.setOnMouseClicked((MouseEvent) ->
        {
            double x = MouseEvent.getSceneX();
            double y = MouseEvent.getSceneY();
           
            	
            	
            if((x >= resetbtn.getPositionX()) && (x < resetbtn.getPositionX() + resetbtn.getWidth())
                    && (y >= resetbtn.getPositionY()) && (y < resetbtn.getPositionY() + resetbtn.getHeight()))
              {  gc.clearRect(0, 0, 600, 600);
            	raft.setPositionX(350);
                raft.setPositionY(320);
                farmer.setPositionX(120);
                farmer.setPositionY(410);
                goat.setPositionX(460);
                goat.setPositionY(410);
                plant.setPositionX(310);
                plant.setPositionY(410);
                wolf.setPositionX(200);
                wolf.setPositionY(410);
                
                //reset sprites's locaiton
                farmer.setLocation(1);
                wolf.setLocation(1);
                plant.setLocation(1);
                goat.setLocation(1);
                //**************
                
                background.render(gc);
                savebtn.render(gc);
                raft.render(gc);
                farmer.render(gc);
                goat.render(gc);
                plant.render(gc);
                loadbtn.render(gc);
                movebtn.render(gc);
               	resetbtn.render(gc);
                wolf.render(gc);
                controller.resetGame();}
            if((x >= loadbtn.getPositionX()) && (x < loadbtn.getPositionX() + loadbtn.getWidth())
                    && (y >= loadbtn.getPositionY()) && (y < loadbtn.getPositionY() + loadbtn.getHeight()))
            {
              controller.loadGame();
             farmer.setPositionX(controller.x1.getPositionX());
              farmer.setPositionY(controller.x1.getPositionY());
              raft.setPositionX(controller.x2.getPositionX());
              raft.setPositionY(controller.x2.getPositionY());
              goat.setPositionX(controller.x3.getPositionX());
              goat.setPositionY(controller.x3.getPositionY());
              wolf.setPositionX(controller.x4.getPositionX());
              wolf.setPositionY(controller.x4.getPositionY());
              plant.setPositionX(controller.x5.getPositionX());
              plant.setPositionY(controller.x5.getPositionY());
              
              farmer.setLocation(controller.x1.getLocation());
              raft.setLocation(controller.x2.getLocation());
              goat.setLocation(controller.x3.getLocation());
              wolf.setLocation(controller.x4.getLocation());
              plant.setLocation(controller.x5.getLocation());
              
            	gc.clearRect(0, 0, 600, 600);
                background.render(gc);
                savebtn.render(gc);
                raft.render(gc);
                farmer.render(gc);
                goat.render(gc);
                plant.render(gc);
                loadbtn.render(gc);
                wolf.render(gc);
                movebtn.render(gc);
               	resetbtn.render(gc);
            	
            }
            if((x >= savebtn.getPositionX()) && (x < savebtn.getPositionX() + savebtn.getWidth())
                        && (y >= savebtn.getPositionY()) && (y < savebtn.getPositionY() + savebtn.getHeight())) {
            	controller.saveGame(farmer,raft,goat,
            			wolf,plant);
            }
             if (raft.getPositionY() == 320) {
                if ((x >= farmer.getPositionX()) && (x < farmer.getPositionX() + farmer.getWidth())
                        && (y >= farmer.getPositionY()) && (y < farmer.getPositionY() + farmer.getHeight())) {
                    controller.setCrossersMovingUp("farmer");
                    if (controller.CrosserOnRift()) {
                        farmer.setPositionX(380);
                        farmer.setPositionY(310);

                        farmer.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        gc.drawImage(image2, 350, 320);
                        farmer.render(gc);
                        goat.render(gc);
                        plant.render(gc);
                        wolf.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        

                        savebtn.render(gc);
                       	movebtn.render(gc);
                        //moveSprite(farmer, wolf, goat, plant, gc, image, image2, button_img);
                        System.out.println(controller.canMove(controller.getCrossers(), true));
                    } else {
                        showerror();
                    }

                } else if ((x >= goat.getPositionX()) && (x < (goat.getPositionX() + goat.getWidth()))
                        && (y >= goat.getPositionY()) && (y < goat.getPositionY() + goat.getHeight())) {
                    controller.setCrossersMovingUp("goat");
                    if (controller.CrosserOnRift()) {
                        goat.setPositionX(370);
                        goat.setPositionY(310);
                        goat.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        gc.drawImage(image2, 350, 320);
                        farmer.render(gc);
                        goat.render(gc);
                        plant.render(gc);
                        wolf.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);

                       	movebtn.render(gc);
                        //moveSprite(goat, wolf, farmer, plant, gc, image, image2, button_img);
                        System.out.println(controller.canMove(controller.getCrossers(), true));
                    } else {
                        showerror();
                    }
                } else if ((x >= wolf.getPositionX()) && (x < wolf.getPositionX() + wolf.getWidth())
                        && (y >= wolf.getPositionY()) && (y < wolf.getPositionY() + wolf.getHeight())) {
                    controller.setCrossersMovingUp("wolf");
                    if (controller.CrosserOnRift()) {
                        wolf.setPositionX(360);
                        wolf.setPositionY(310);
                        wolf.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        farmer.render(gc);
                        goat.render(gc);
                        plant.render(gc);
                        wolf.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);

                       	movebtn.render(gc);
                        //  moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                        System.out.println(controller.canMove(controller.getCrossers(), true));
                    } else {
                        showerror();
                    }

                } else if ((x >= plant.getPositionX()) && (x < plant.getPositionX() + plant.getWidth())
                        && (y >= plant.getPositionY()) && (y < plant.getPositionY() + plant.getHeight())) {
                    controller.setCrossersMovingUp("plant");
                    if (controller.CrosserOnRift()) {
                        plant.setPositionX(360);
                        plant.setPositionY(310);
                        plant.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        farmer.render(gc);
                        goat.render(gc);
                        plant.render(gc);
                        wolf.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);

                       	movebtn.render(gc);
                        //  moveSprite(plant, wolf, goat, farmer, gc, image, image2, button_img);
                        System.out.println(controller.canMove(controller.getCrossers(), true));
                    } else {
                        System.out.println(controller.getCrossers().size());
                        System.out.println(controller.canMove(controller.getCrossers(), true));
                        showerror();
                    }
                } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0) && (y < 0 + button_img.getHeight())) {
                    if (controller.canMove(controller.getCrossers(), true)) {
                        if (farmer.getPositionX() != 120) {
                            farmer.setPositionX(50);
                            farmer.setPositionY(100);
                            farmer.setLocation(4);

                        }
                        if (goat.getPositionX() != 460) {
                            goat.setPositionX(100);
                            goat.setPositionY(100);
                            goat.setLocation(4);
                        }
                        if (wolf.getPositionX() != 200) {
                            wolf.setPositionX(150);
                            wolf.setPositionY(100);
                            wolf.setLocation(4);
                        }
                        if (plant.getPositionX() != 310) {
                            plant.setPositionX(250);
                            plant.setPositionY(100);
                            plant.setLocation(4);
                        }
                        riftLocation = true;
                        numOfSails++;
                        controller.clearcrossers();

                        background.render(gc);
                        raft.setPositionX(350);
                        raft.setPositionY(260);
                        raft.render(gc);
                        farmer.render(gc);
                        goat.render(gc);
                        plant.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);

                        wolf.render(gc);
                       	movebtn.render(gc);
                       	if(controller.success())
                        {
                            System.out.println("dakhal kosom elcondition " + numOfSails);

                            Alert successalert = new Alert(Alert.AlertType.INFORMATION);
                            successalert.setHeaderText("Congratulations!! ");
                            
                        	if(numOfSails == 7)
                        	{
                        		farmer.setRank(3);
                        		successalert.setContentText("Your rank is: \n ***");
                        		successalert.showAndWait();
                        	}
                        	else if ((numOfSails <= 11)&&(numOfSails>7))
                        	{
                        		farmer.setRank(2);
                        		successalert.setContentText("Your rank is: \n **");
                        		successalert.showAndWait();
                        	}
                        		
                        	else
                        	{
                        		farmer.setRank(1);
                        		successalert.setContentText("Your rank is: \n *");
                        		successalert.showAndWait();
                        	}
                        	controller.saveGame(farmer,raft,goat,
                        			wolf,plant);
                        	controller.resetGame();
                        	
                        	stage.setScene(startpage.getScene());
                        	raft.setPositionX(350);
                            raft.setPositionY(320);
                            farmer.setPositionX(120);
                            farmer.setPositionY(410);
                            goat.setPositionX(460);
                            goat.setPositionY(410);
                            plant.setPositionX(310);
                            plant.setPositionY(410);
                            wolf.setPositionX(200);
                            wolf.setPositionY(410);
                            
                            //reset sprites's locaiton
                            farmer.setLocation(1);
                            wolf.setLocation(1);
                            plant.setLocation(1);
                            goat.setLocation(1);
                            //**************
                            
                            background.render(gc);
                            savebtn.render(gc);
                            raft.render(gc);
                            farmer.render(gc);
                            goat.render(gc);
                            plant.render(gc);
                            loadbtn.render(gc);
                            movebtn.render(gc);
                           	resetbtn.render(gc);
                            wolf.render(gc);
                        	}
                    } else {
                        Alert error = new Alert(Alert.AlertType.INFORMATION);
                        error.setHeaderText("Invalid Move");
                        error.setContentText("Something will get eaten!! :)");
                        error.showAndWait();
                    }
                }
            }
       else if (raft.getPositionY() == 260) {
            if ((x >= farmer.getPositionX()) && (x < farmer.getPositionX() + farmer.getWidth())
                    && (y >= farmer.getPositionY()) && (y < farmer.getPositionY() + farmer.getHeight())) {
                controller.setCrossersMovingDown("farmer");
                if (controller.CrosserOnRift()) {
                    farmer.setPositionX(350);
                    farmer.setPositionY(260);
                    farmer.setLocation(3);
                    gc.clearRect(0, 0, 600, 600);
                    background.render(gc);
                   // gc.drawImage(image2, 260, 320);
                    raft.render(gc);
                    farmer.render(gc);
                    goat.render(gc);
                    plant.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);

                    wolf.render(gc);
                   	movebtn.render(gc);
                    //moveSprite(farmer, wolf, goat, plant, gc, image, image2, button_img);
                    System.out.println(controller.canMove(controller.getCrossers(), true));
                } else {
                    showerror();
                }

            } else if ((x >= goat.getPositionX()) && (x < (goat.getPositionX() + goat.getWidth()))
                    && (y >= goat.getPositionY()) && (y < goat.getPositionY() + goat.getHeight())) {
                controller.setCrossersMovingDown("goat");
                if (controller.CrosserOnRift()) {
                    goat.setPositionX(360);
                    goat.setPositionY(260);
                    goat.setLocation(3);
                    gc.clearRect(0, 0, 600, 600);
                    background.render(gc);
                   // gc.drawImage(image2, 350, 320);
                    raft.render(gc);
                    farmer.render(gc);
                    goat.render(gc);
                    plant.render(gc);
                    wolf.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);

                    gc.drawImage(button_img, 500, 0);
                    //moveSprite(goat, wolf, farmer, plant, gc, image, image2, button_img);
                    System.out.println(controller.canMove(controller.getCrossers(), true));
                } else {
                    showerror();
                }
            } else if ((x >= wolf.getPositionX()) && (x < wolf.getPositionX() + wolf.getWidth())
                    && (y >= wolf.getPositionY()) && (y < wolf.getPositionY() + wolf.getHeight())) {
                controller.setCrossersMovingDown("wolf");
                if (controller.CrosserOnRift()) {
                    wolf.setPositionX(360);
                    wolf.setPositionY(260);
                    wolf.setLocation(3);
                    gc.clearRect(0, 0, 600, 600);
                    background.render(gc);
                    raft.render(gc);
                    farmer.render(gc);
                    goat.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);

                    plant.render(gc);
                    wolf.render(gc);
                    movebtn.render(gc);
                    //  moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                    System.out.println(controller.canMove(controller.getCrossers(), true));
                } else {
                    showerror();
                }

            } else if ((x >= plant.getPositionX()) && (x < plant.getPositionX() + plant.getWidth())
                    && (y >= plant.getPositionY()) && (y < plant.getPositionY() + plant.getHeight())) {
                controller.setCrossersMovingDown("plant");
                if (controller.CrosserOnRift()) {
                    plant.setPositionX(360);
                    plant.setPositionY(260);
                    plant.setLocation(3);
                    gc.clearRect(0, 0, 600, 600);
                    background.render(gc);
                    raft.render(gc);
                    farmer.render(gc);
                    goat.render(gc);
                    plant.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);

                    wolf.render(gc);
                    movebtn.render(gc);
                    //  moveSprite(plant, wolf, goat, farmer, gc, image, image2, button_img);
                    System.out.println(controller.canMove(controller.getCrossers(), true));
                } else {
                    System.out.println(controller.getCrossers().size());
                    System.out.println(controller.canMove(controller.getCrossers(), true));
                    showerror();
                }
            } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0) && (y < 0 + button_img.getHeight())) {
                if (controller.canMove(controller.getCrossers(), true)) {
                    if (farmer.getPositionX() != 50) {
                        farmer.setPositionX(120);
                        farmer.setPositionY(410);
                        farmer.setLocation(1);

                    }
                    if (goat.getPositionX() != 100) {
                        goat.setPositionX(460);
                        goat.setPositionY(410);
                        goat.setLocation(1);
                    }
                    if (wolf.getPositionX() != 150) {
                        wolf.setPositionX(200);
                        wolf.setPositionY(410);
                        wolf.setLocation(1);
                    }
                    if (plant.getPositionX() != 250) {
                        plant.setPositionX(310);
                        plant.setPositionY(410);
                        plant.setLocation(1);
                    }
                    controller.clearcrossers();
                    numOfSails++;
                    riftLocation = false;
                    background.render(gc);
                    raft.setPositionX(350);
                    raft.setPositionY(320);
                    raft.render(gc);
                    farmer.render(gc);
                    goat.render(gc);
                    savebtn.render(gc);
                    resetbtn.render(gc);
                    loadbtn.render(gc);

                    plant.render(gc);
                    wolf.render(gc);
                    movebtn.render(gc);
                } else {
                    Alert error = new Alert(Alert.AlertType.INFORMATION);
                    error.setHeaderText("Invalid Move");
                    error.setContentText("Something will get eaten!! :)");
                    error.showAndWait();
                }
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

    private void showerror() {
        Alert error = new Alert(Alert.AlertType.INFORMATION);
        error.setHeaderText("Maximum number of rowers!");
        error.setContentText("Only 2 characters can move on the raft!!");
        error.showAndWait();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy1 = strategy;
    }

    private void moveSprite(Sprite spritemoved, Sprite sprite2,
                            Sprite sprite3, Sprite sprite4,
                            GraphicsContext gc, Image image,
                            Image image2, Image button_img) {
        spritemoved.setPositionX(380);
        spritemoved.setPositionY(310);
        gc.clearRect(0, 0, 2000, 2000);
        gc.drawImage(image, 0, 0);
        gc.drawImage(image2, 350, 320);
        spritemoved.render(gc);
        sprite2.render(gc);
        sprite3.render(gc);
        sprite4.render(gc);
        gc.drawImage(button_img, 500, 0);
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
}
