package View;

import Level1Chars.Controller;
import Level1Chars.Strategy;
import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RIVER CROSSING");
        start_page startpage = new start_page(primaryStage);
        LEVEL_1 level_1 = new LEVEL_1(primaryStage);
        LEVEL_2 level_2 = new LEVEL_2(primaryStage);
        
        Strategy strategy1 = new Strategy();
        Controller controller = new Controller(level_1, strategy1, startpage);
        controller.setLowerBankCrossers();

        //startpage.scene_build();
        controller.MenuBuildScene();
        controller.Level1BuildScene();
        //level_1.scene_build();
        level_1.setStrategy(strategy1);
        level_1.setController(controller);
        startpage.setlevel_1(level_1);
        level_1.setStartPage(startpage);
        
        
        level_2.setStrategy(strategy1);
        level_2.setController(controller);
        startpage.setlevel_2(level_2);
        level_2.setStartPage(startpage);
        level_2.scene_build();
        
        primaryStage.setScene(startpage.getScene());
        primaryStage.show();


    }
}


