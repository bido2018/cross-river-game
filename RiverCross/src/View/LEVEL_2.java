package View;

import Level1Chars.Controller;
import Level1Chars.Sprite;
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
     Controller controller;
	public void set_start_page(start_page startpage) {
		this.startpage=startpage;
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
		Pane root = new Pane();
        Canvas canvas = new Canvas(600, 600);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        scene = new Scene(root, 600, 600);
        Image bckgrndImage = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/background.png");
        Sprite background = new Sprite(bckgrndImage);
        background.setPositionX(0);
        background.setPositionY(0);
        background.render(gc);
        
        Image saveimg = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/save%20button.png");
        Sprite savebtn = new Sprite(saveimg);
        savebtn.setPositionX(150);
        savebtn.setPositionY(0);
        savebtn.render(gc);
        Image loadimg = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/loadbtn.png");
        Sprite loadbtn = new Sprite(loadimg);
        loadbtn.setPositionX(250);
        loadbtn.setPositionY(0);
        loadbtn.render(gc);
        Image showimg = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/show.png");
        Sprite showbtn = new Sprite(showimg);
        showbtn.setPositionX(400);
        showbtn.setPositionY(0);
        showbtn.render(gc);
        
        

      

        Image boyImage= new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/el%20wad%20bdahro%20so8yr.png");
        Sprite boy= new Sprite(boyImage);
        boy.setPositionX(120);
        boy.setPositionY(410);
        boy.render(gc);

        Image girlImage = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elbet%20bdhra.png");
        Sprite girl = new Sprite(girlImage);
        girl.setPositionX(200);
        girl.setPositionY(410);
        girl.render(gc);

        Image womanImage1 = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elset%20bdhraa.png");
        Sprite woman = new Sprite(womanImage1);
        woman.setPositionX(460);
        woman.setPositionY(410);
        woman.render(gc);

        Image raftImage = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/raft.png");
        Sprite raft = new Sprite(raftImage);
        raft.setPositionX(350);
        raft.setPositionY(320);
        raft.render(gc);

        Image manImage = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/elragel%20bdhro.png");
        Sprite man = new Sprite(manImage);
        man.setPositionX(310);
        man.setPositionY(410);
        man.render(gc);

        Image bagImage = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/jhubweo.png");
        Sprite bag = new Sprite(bagImage);
        bag.setPositionX(50);
        bag.setPositionY(450);
        bag.render(gc);

        Image button_img = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/button.png");
        Sprite movebtn = new Sprite(button_img);
        movebtn.setPositionX(500);
        movebtn.setPositionY(0);
        movebtn.render(gc);


           
        Image resetimg = new Image("file:///C:/Users/HP/eclipse-workspace/RiverCross/src/Assets/reset-button.png");
        Sprite resetbtn = new Sprite(resetimg);
        resetbtn.setPositionX(0);
        resetbtn.setPositionY(0);
        resetbtn.render(gc);

        scene.setOnMouseClicked((MouseEvent) -> {
            double x = MouseEvent.getSceneX();
            double y = MouseEvent.getSceneY();

            if ((x >= showbtn.getPositionX()) && (x < showbtn.getPositionX() + showbtn.getWidth())
                    && (y >= showbtn.getPositionY()) && (y < showbtn.getPositionY() + showbtn.getHeight())) {
                Alert rulealert = new Alert(Alert.AlertType.INFORMATION);
                rulealert.setHeaderText("RULE ");
                rulealert.setContentText(
                        " 1- max wieght is 100 kg\n "
                                + "2- all can row except the bag \n"
                                + " 3- the raft can left only two crossers");
                rulealert.showAndWait();
            }

           if ((x >= resetbtn.getPositionX()) && (x < resetbtn.getPositionX() + resetbtn.getWidth())
                    && (y >= resetbtn.getPositionY()) && (y < resetbtn.getPositionY() + resetbtn.getHeight())) {
                gc.clearRect(0, 0, 600, 600);
                raft.setPositionX(350);
                raft.setPositionY(320);
                boy.setPositionX(120);
                boy.setPositionY(410);
                boy.setRank(0);
                girl.setPositionX(460);
                girl.setPositionY(410);
                woman.setPositionX(310);
                woman.setPositionY(410);
                man.setPositionX(200);
                man.setPositionY(410);
                boy.setRank(0);
                // reset sprites's locaiton
                boy.setLocation(1);
                man.setLocation(1);
                woman.setLocation(1);
                girl.setLocation(1);
                // **************

                background.render(gc);
                savebtn.render(gc);
                raft.render(gc);
                boy.render(gc);
                girl.render(gc);
                woman.render(gc);
                loadbtn.render(gc);
                movebtn.render(gc);
                resetbtn.render(gc);
                man.render(gc);
                showbtn.render(gc);

                controller.resetGame();
            }
            boolean riftLocation;
			int numOfSails = 0;
			if ((x >= loadbtn.getPositionX()) && (x < loadbtn.getPositionX() + loadbtn.getWidth())
                    && (y >= loadbtn.getPositionY()) && (y < loadbtn.getPositionY() + loadbtn.getHeight())) {

                if (controller.check_load()) {
                    controller.loadGame();
                    boy.setPositionX(controller.x1.getPositionX());
                    boy.setPositionY(controller.x1.getPositionY());
                    raft.setPositionX(controller.x2.getPositionX());
                    raft.setPositionY(controller.x2.getPositionY());
                    girl.setPositionX(controller.x3.getPositionX());
                    girl.setPositionY(controller.x3.getPositionY());
                    man.setPositionX(controller.x4.getPositionX());
                    man.setPositionY(controller.x4.getPositionY());
                    woman.setPositionX(controller.x5.getPositionX());
                    woman.setPositionY(controller.x5.getPositionY());
                    boy.setRank(controller.x1.getRank());
                    numOfSails = boy.getRank();
                    boy.setLocation(controller.x1.getLocation());
                    raft.setLocation(controller.x2.getLocation());
                    girl.setLocation(controller.x3.getLocation());
                    man.setLocation(controller.x4.getLocation());
                    woman.setLocation(controller.x5.getLocation());

                    gc.clearRect(0, 0, 600, 600);
                    background.render(gc);
                    savebtn.render(gc);
                    raft.render(gc);
                    boy.render(gc);
                    girl.render(gc);
                    woman.render(gc);
                    loadbtn.render(gc);
                    man.render(gc);
                    movebtn.render(gc);
                    resetbtn.render(gc);
                    showbtn.render(gc);

                } else {
                    Alert nosavealert = new Alert(Alert.AlertType.INFORMATION);
                    nosavealert.setHeaderText("ATTENtion");
                    nosavealert.setContentText("no previous saved games");
                    nosavealert.showAndWait();

                }

            }
            if ((x >= savebtn.getPositionX()) && (x < savebtn.getPositionX() + savebtn.getWidth())
                    && (y >= savebtn.getPositionY()) && (y < savebtn.getPositionY() + savebtn.getHeight())) {
                //controller.saveGame(boy, raft, girl, man, woman);

            }
            if (raft.getPositionY() == 320) {
                System.out.println("the raft locatioon is "+raft.getPositionY()+"da5lllll");
                if ((x >= boy.getPositionX()) && (x < boy.getPositionX() + boy.getWidth())
                        && (y >= boy.getPositionY()) && (y < boy.getPositionY() + boy.getHeight()&&(boy.getLocation()==1))
                        && (raft.getPositionY() == 320)) {
                    //controller.setCrossersMovingUp("boy");
                    //if (controller.CrosserOnRift()) {
                        boy.setPositionX(380);
                        boy.setPositionY(310);

                        boy.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        gc.drawImage(raftImage, 350, 320);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        bag.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        System.out.println("the raft locatioon is "+raft.getPositionY());

                        showbtn.render(gc);

                        savebtn.render(gc);
                        movebtn.render(gc);
                        // moveSprite(farmer, wolf, goat, plant, gc, image, image2, button_img);
                 //       System.out.println(controller.canMove(controller.getCrossers(), true));
                //    } 
                //else {
                  //      showerror();
                   // }

                }
                else if ((x >= bag.getPositionX()) && (x < (bag.getPositionX() + bag.getWidth()))
                        && (y >= bag.getPositionY()) && (y < bag.getPositionY() + bag.getHeight()&&(girl.getLocation()==1))
                        && (raft.getPositionY() == 320)) {
                    
                    //controller.setCrossersMovingUp("girl");
                    //controller
                }
                
                else if ((x >= girl.getPositionX()) && (x < (girl.getPositionX() + girl.getWidth()))
                        && (y >= girl.getPositionY()) && (y < girl.getPositionY() + girl.getHeight()&&(girl.getLocation()==1))
                        && (raft.getPositionY() == 320)) {
                    //controller.setCrossersMovingUp("girl");
                 //   if (controller.CrosserOnRift()) {
                        girl.setPositionX(370);
                        girl.setPositionY(310);
                        girl.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                      //  gc.drawImage(image2, 350, 320);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        movebtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("the raft locatioon is "+raft.getPositionY());

                        // moveSprite(goat, wolf, farmer, plant, gc, image, image2, button_img);
                  //      System.out.println(controller.canMove(controller.getCrossers(), true));
                   // } else {
                     //   showerror();
                    //}
                } else if ((x >= man.getPositionX()) && (x < man.getPositionX() + man.getWidth())
                        && (y >= man.getPositionY()) && (y < man.getPositionY() + man.getHeight()&&(man.getLocation()==1))
                        && (raft.getPositionY() == 320)) {
                    //controller.setCrossersMovingUp("man");
                    //if (controller.CrosserOnRift()) {
                        man.setPositionX(360);
                        man.setPositionY(310);
                        man.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("the raft locatioon is "+raft.getPositionY());

                        movebtn.render(gc);
                        // moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                     //   System.out.println(controller.canMove(controller.getCrossers(), true));
                    //} else {
                      //  showerror();
                    //}

                } else if ((x >= woman.getPositionX()) && (x < woman.getPositionX() + woman.getWidth())
                        && (y >= woman.getPositionY()) && (y < woman.getPositionY() + woman.getHeight()&&(woman.getLocation()==1))
                        && (raft.getPositionY() == 320)) {
                    //controller.setCrossersMovingUp("woman");
                    //if (controller.CrosserOnRift()) {
                        woman.setPositionX(360);
                        woman.setPositionY(310);
                        woman.setLocation(2);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("the raft locatioon is "+raft.getPositionY());

                        movebtn.render(gc);
                        // moveSprite(plant, wolf, goat, farmer, gc, image, image2, button_img);
                   //     System.out.println(controller.canMove(controller.getCrossers(), true));
                    //} else {
                      //  System.out.println(controller.getCrossers().size());
                        //System.out.println(controller.canMove(controller.getCrossers(), true));
                        //showerror();
                    //}
                } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0)
                        && (y < 0 + button_img.getHeight())) {
                    //if (controller.canMove(controller.getCrossers(), true)) {

                        if (boy.getPositionX() != 120) {
                            boy.setPositionX(50);
                            boy.setPositionY(100);
                            boy.setLocation(4);
                            //System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        if (girl.getPositionX() != 200) {
                        	
                            girl.setPositionX(150);
                            girl.setPositionY(100);
                            girl.setLocation(4);
                            //System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        if (man.getPositionX() != 310) {
                            man.setPositionX(250);
                            man.setPositionY(100);
                            man.setLocation(4);
                            //System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        if (woman.getPositionX() != 460) {
                            woman.setPositionX(350);
                            woman.setPositionY(100);
                            woman.setLocation(4);
                            //System.out.println("the raft locatioon is "+raft.getPositionY());

                        }
                        riftLocation = true;
                        numOfSails++;
                        boy.setRank(numOfSails);
                        //controller.clearcrossers();

                        background.render(gc);
                        raft.setPositionX(350);
                        raft.setPositionY(260);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        bag.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);

                        man.render(gc);
                        movebtn.render(gc);
                        System.out.println("raft location is "+raft.getPositionY());
                      /*  if (controller.success()) {
                            boy.setFinish(1);
                            boy.setRank(numOfSails);

                            Alert successalert = new Alert(Alert.AlertType.INFORMATION);
                            successalert.setHeaderText("Congratulations!! ");

                            if (boy.getRank() == 7) {
                                successalert.setContentText("Your rank is: \n ***");
                                successalert.showAndWait();

                            } else if ((boy.getRank() <= 11) && (boy.getRank() > 7)) {
                                successalert.setContentText("Your rank is: \n **");
                                successalert.showAndWait();

                            }

                            else {
                                successalert.setContentText("Your rank is: \n *");
                                successalert.showAndWait();

                            }
                            controller.saveGame(boy, raft, girl, man, woman);
                            controller.loadGame();
                            controller.resetGame();
                            startpage.scene_build();

                            stage.setScene(startpage.getScene());
                            raft.setPositionX(350);
                            raft.setPositionY(320);
                            boy.setPositionX(120);
                            boy.setPositionY(410);
                            girl.setPositionX(460);
                            girl.setPositionY(410);
                            woman.setPositionX(310);
                            woman.setPositionY(410);
                            man.setPositionX(200);
                            man.setPositionY(410);

                            // reset sprites's locaiton
                            boy.setLocation(1);
                            man.setLocation(1);
                            woman.setLocation(1);
                            girl.setLocation(1);
                            // **************

                            background.render(gc);
                            savebtn.render(gc);
                            raft.render(gc);
                            boy.render(gc);
                            girl.render(gc);
                            woman.render(gc);
                            loadbtn.render(gc);
                            movebtn.render(gc);
                            resetbtn.render(gc);
                            man.render(gc);
                            showbtn.render(gc);

                        }

                    }*/
                    /*else {
                        Alert error = new Alert(Alert.AlertType.INFORMATION);
                        error.setHeaderText("Invalid Move");
                        error.setContentText("Something will get eaten!! :)");
                        error.showAndWait();
                    }*/
                }
            } else if (raft.getPositionY() == 260) {
                System.out.println("the raft location is "+raft.getPositionY()+" da5l el 260");
                if ((x >= boy.getPositionX()) && (x < boy.getPositionX() + boy.getWidth())
                        && (y >= boy.getPositionY()) && (y < boy.getPositionY() + boy.getHeight())&&(boy.getLocation()==4)) {
                  //  controller.setCrossersMovingDown("farmer");
                    //if (controller.CrosserOnRift()) {
                        boy.setPositionX(350);
                        boy.setPositionY(260);
                        boy.setLocation(3);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        // gc.drawImage(image2, 260, 320);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("raft location is "+raft.getPositionY());

                        man.render(gc);
                        movebtn.render(gc);
                        // moveSprite(farmer, wolf, goat, plant, gc, image, image2, button_img);
                    //    System.out.println(controller.canMove(controller.getCrossers(), true));
                    //} else {
                      //  showerror();
                    //}

                } else if ((x >= girl.getPositionX()) && (x < (girl.getPositionX() + girl.getWidth()))
                        && (y >= girl.getPositionY()) && (y < girl.getPositionY() + girl.getHeight())&&(girl.getLocation()==4)) {
                    //controller.setCrossersMovingDown("goat");
                    //if (controller.CrosserOnRift()) {
                        girl.setPositionX(360);
                        girl.setPositionY(260);
                        girl.setLocation(3);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        // gc.drawImage(image2, 350, 320);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        man.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("raft location is "+raft.getPositionY());

                        gc.drawImage(button_img, 500, 0);
                        // moveSprite(goat, wolf, farmer, plant, gc, image, image2, button_img);
                      //  System.out.println(controller.canMove(controller.getCrossers(), true));
                   // } else {
                     //   showerror();
                    //}
                } else if ((x >= man.getPositionX()) && (x < man.getPositionX() + man.getWidth())
                        && (y >= man.getPositionY()) && (y < man.getPositionY() + man.getHeight())&&(man.getLocation()==4)) {
                    //controller.setCrossersMovingDown("wolf");
                    //if (controller.CrosserOnRift()) {
                        man.setPositionX(360);
                        man.setPositionY(260);
                        man.setLocation(3);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("raft location is "+raft.getPositionY());

                        woman.render(gc);
                        man.render(gc);
                        movebtn.render(gc);
                        // moveSprite(wolf, farmer, farmer, plant, gc, image, image2, button_img);
                     //   System.out.println(controller.canMove(controller.getCrossers(), true));
                    //} else {
                    //    showerror();
                    //}

                } else if ((x >= woman.getPositionX()) && (x < woman.getPositionX() + woman.getWidth())
                        && (y >= woman.getPositionY()) && (y < woman.getPositionY() + woman.getHeight())&&(woman.getLocation()==4)) {
                    //controller.setCrossersMovingDown("plant");
                    //if (controller.CrosserOnRift()) {
                        woman.setPositionX(360);
                        woman.setPositionY(260);
                        woman.setLocation(3);
                        gc.clearRect(0, 0, 600, 600);
                        background.render(gc);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        woman.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("raft location is "+raft.getPositionY());

                        man.render(gc);
                        movebtn.render(gc);
                        // moveSprite(plant, wolf, goat, farmer, gc, image, image2, button_img);
                    //    System.out.println(controller.canMove(controller.getCrossers(), true));
                    /*} else {
                        System.out.println(controller.getCrossers().size());
                        System.out.println(controller.canMove(controller.getCrossers(), true));
                        showerror();
                    }*/
                } else if ((x >= 500) && (x < 500 + button_img.getWidth()) && (y >= 0)
                        && (y < 0 + button_img.getHeight())) {
                    //if (controller.canMove(controller.getCrossers(), true)) {
                        raft.setPositionY(320);

                        if (boy.getPositionX() != 50) {
                            boy.setPositionX(120);
                            boy.setPositionY(410);
                            boy.setLocation(1);

                        }
                        if (girl.getPositionX() != 150) {
                            girl.setPositionX(200);
                            girl.setPositionY(410);
                            girl.setLocation(1);
                        }
                        if (man.getPositionX() != 250) {
                            man.setPositionX(310);
                            man.setPositionY(410);
                            man.setLocation(1);
                        }
                        if (woman.getPositionX() != 350) {
                            woman.setPositionX(460);
                            woman.setPositionY(410);
                            woman.setLocation(1);
                        }
                        //controller.clearcrossers();
                        numOfSails++;
                        boy.setRank(numOfSails);
                        riftLocation = false;
                        background.render(gc);
                        raft.setPositionX(350);
                        raft.setPositionY(320);
                        raft.render(gc);
                        boy.render(gc);
                        girl.render(gc);
                        savebtn.render(gc);
                        resetbtn.render(gc);
                        loadbtn.render(gc);
                        showbtn.render(gc);
                        System.out.println("raft location is "+raft.getPositionY());

                        woman.render(gc);
                        man.render(gc);
                        movebtn.render(gc);
                    /*} else {
                        Alert error = new Alert(Alert.AlertType.INFORMATION);
                        error.setHeaderText("Invalid Move");
                        error.setContentText("Something will get eaten!! :)");
                        error.showAndWait();
                    }*/
                }
            }
        });

	}

	private void showerror() {
		Alert error = new Alert(Alert.AlertType.INFORMATION);
		error.setHeaderText("Maximum number of rowers!");
		error.setContentText("Only 2 characters can move on the raft!!");
		error.showAndWait();
	}
}
