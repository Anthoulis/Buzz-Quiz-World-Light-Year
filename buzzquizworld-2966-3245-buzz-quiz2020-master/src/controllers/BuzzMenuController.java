package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The controller for the Menu
 * @author Giannis Anthoulis 2966
 * @author Alexandros Seremetas Mpildiris 3245
 */

public class BuzzMenuController {
    //Players' names for Single mode and Two player mode
    @FXML private TextField player_textField;
    @FXML private TextField player1_textField;
    @FXML private TextField player2_textField;
    //The menu Panes
    @FXML
    private GridPane single_pane;
    @FXML
    private GridPane two_pane;
    @FXML
    private HBox score_pane;
    //////////////////////////
    /**
     * Method that hides every pane
     */
   public void hidePane()
   {
       single_pane.setVisible(false);
       two_pane.setVisible(false);
       score_pane.setVisible(false);
   }
    /**
     * Set Single Player menu visible and hide all the others
     * @param actionEvent Single Player button is clicked
     */
    public void single_click(ActionEvent actionEvent) {
        //Set all other panes not visible
        hidePane();
        //Set Single Player pane visible
        single_pane.setVisible(true);
    }
    /**
     * Set Two Player menu visible and hide all the others
     * @param actionEvent Two Player button is clicked
     */
    public void two_click(ActionEvent actionEvent) {
        //Set all other panes not visible
        hidePane();
        //Set Two Player pane visible
        two_pane.setVisible(true);
    }

    /**
     * Set Scoreboard visible and hide all the others
     * @param actionEvent Scoreboard button is clicked
     */
    public void score_click(ActionEvent actionEvent) {
        //Set all other panes not visible
        hidePane();
        //Set Two Player pane visible
        score_pane.setVisible(true);
    }
    /**
     * When exit button is pressed close application
     * @param actionEvent Exit button is clicked
     */
    public void click_exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    /**
     * Load the InGame.fxml file
     * Create an InGameController for Single Player Mode using Player name , Number of Rounds , Number of Questions per round
     * Connect the controller to the InGame.fxml file
     * Then change scene to InGame.fxml
     * @param actionEvent Start game in Single mode
     * @throws IOException when it can't load fxml file
     */
    public void click_start_single(ActionEvent actionEvent) throws IOException {
        //Load the In_Game Scene
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/InGame.fxml"));
        //TODO : Fix rounds and questions number
        InGameController controller=new InGameController(player_textField.getText(),2,5);
        loader.setController(controller);
        /*
         * We need to get the Stage so we can set the scene to in game Scene.
         * Because we don't have access to the Stage from this class we get the stage from the actionEvent
         * Initially we have it as a Node so we can get the Scene and then tha Stage
         */
        //Change the scene to the In_Game scene
        Parent root=loader.load();
        Scene scene=new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    /**
     * Load the InGame.fxml file
     * Create an InGameController for Two Player Mode using Player1 name ,Player2 name, Number of Rounds , Number of Questions per round
     * Connect the controller to the InGame.fxml file
     * We change scene
     * @param actionEvent start game in Two player mode
     * @throws IOException if fxml file can't be loaded
     */
    public void start_game_two(ActionEvent actionEvent) throws IOException {
        //Load the In_Game Scene
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/InGame.fxml"));
        //Get In_Game
        //TODO : Fix rounds and questions number
        InGameController controller=new InGameController(player1_textField.getText(),player2_textField.getText(),2,5);
        loader.setController(controller);
        /*
         * We need to get the Stage so we can set the scene to in game Scene.
         * Because we don't have access to the Stage from this class we get the stage from the actionEvent
         * Initially we have it as a Node so we can get the Scene and then tha Stage
         */
        //Change the scene to the In_Game scene
        Parent root=loader.load();
        Scene scene=new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}
