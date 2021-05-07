package controllers;

import BuzzLogic.InGameLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class InGameController extends InGameLogic implements Initializable{
    /**
     * Create the controller for Single Player mode according to the parameters given at the Single Player Menu
     * @param name save the player's name
     * @param rounds save the number of rounds the player has chosen
     * @param questions save the number of question the player has chosen
     * @author Giannis Anthoulis 2966
     * @author Alexandros Seremetas Mpildiris 3245
     */
    public InGameController(String name,int rounds,int questions)
    {
        super(name,rounds,questions);
        question_label =new Label("Question");
        answer1_label =new Label("Answer1 constructor");
        answer2_label =new Label("Answer2 constructor");
        answer3_label =new Label("Answer3 constructor");
        answer4_label =new Label("Answer4 constructor");
        player_label=new Label("Player Constructor");
        player2_label=new Label("Player 2 Constructor");
        player_scoreLabel=new Label("0");
        player2_scoreLabel=new Label("0");
        mode_label=new Label("Single Player");
    }
    /**
     * Create the controller for Two Player mode according to the parameters given at the Two Player Menu
     * @param name1 save the first player's name
     * @param name2 save the second player's name
     * @param rounds save the number of rounds the players have chosen
     * @param questions save the number of questions per round the players have chosen
     */
    public InGameController(String name1,String name2,int rounds,int questions)
    {
        super(name1,name2,rounds,questions);
        question_label =new Label("Question");
        answer1_label =new Label("Answer1 constructor");
        answer2_label =new Label("Answer2 constructor");
        answer3_label =new Label("Answer3 constructor");
        answer4_label =new Label("Answer4 constructor");
        player_label=new Label("Player Constructor");
        player2_label=new Label("Player 2 Constructor");
        player_scoreLabel=new Label("0");
        player2_scoreLabel=new Label("0");
        mode_label=new Label("Two Players");
    }

    @FXML private Label question_label;
    @FXML private Label answer1_label;
    @FXML private Label answer2_label;
    @FXML private Label answer3_label;
    @FXML private Label answer4_label;
    @FXML private Label player_label;
    @FXML private Label player2_label;
    @FXML private Label player_scoreLabel;
    @FXML private Label player2_scoreLabel;
    @FXML private Label mode_label;
    /**
     * Initialize the values according to the our fields which have been initiated from the constructor
     * Set the player's name label,make visible. Set his score to 0 and make it visible
     * If it is Two Player mode set player's 2 name also. Set his score to 0 and make it visible
     * Then Set the FIRST QUESTION'S VALUES
     * @param url .
     * @param resourceBundle .
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //For Player
        player_label.setText(player.getName());
        player_label.setVisible(true);
        player_scoreLabel.setVisible(true);
        //For Second Player
        player2_label.setText(player2.getName());
        player2_label.setVisible(true);
        player2_scoreLabel.setVisible(true);
        //If Single mode
        if(settings.getMode().equals("single"))
        {
            player2_label.setVisible(false);
            player2_scoreLabel.setVisible(false);
            mode_label.setText("Single Player");
        }
        else
        {
            player2_label.setVisible(true);
            player2_scoreLabel.setVisible(true);
            mode_label.setText("Two Players");
        }
        // Set the First Question
        setActive_question();
        current_question=0;
        current_round=0;
        //Set the First Question GUI
        setQuestionGUI();
    }
    /**
     * Set the question's GUI  that is displayed
     */
    public void setQuestionGUI()
    {
        question_label.setText(displayed_question.getQuestion());
        int [] array=new int[4];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        array[3]=3;
        shuffleArray(array);
        answer1_label.setText(displayed_question.getAnswer()[array[0]]);
        answer2_label.setText(displayed_question.getAnswer()[array[1]]);
        answer3_label.setText(displayed_question.getAnswer()[array[2]]);
        answer4_label.setText(displayed_question.getAnswer()[array[3]]);
    }

    /**
     * The Player's controls   1  2  3  4
     * If 1 is pressed set the player's answer to the answer1 label, etc..
     * @param keyEvent It is the key pressed
     */
    public void player_setAnswer(KeyEvent keyEvent)
    {
        if(keyEvent.getCode()==KeyCode.DIGIT1)
        {
            player.setAnswer(answer1_label.getText());
        }
        else if(keyEvent.getCode()==KeyCode.DIGIT2)
        {
            player.setAnswer(answer2_label.getText());
        }
        else if(keyEvent.getCode()==KeyCode.DIGIT3)
        {
            player.setAnswer(answer3_label.getText());
        }
        else if(keyEvent.getCode()==KeyCode.DIGIT4)
        {
            player.setAnswer(answer4_label.getText());
        }
        player.setAnswer_given(true);

    }

    /**
     * The Player's 2 controls H  J  K  L
     * If H is pressed set the player's answer to the answer1 label, etc..
     * @param keyEvent It is the key pressed
     */
    public void player2_setAnswer(KeyEvent keyEvent)
    {
        if(keyEvent.getCode()== KeyCode.H)
        {
            player2.setAnswer(answer1_label.getText());
        }
        else if(keyEvent.getCode()==KeyCode.J)
        {
            player2.setAnswer(answer2_label.getText());
        }
        else if(keyEvent.getCode()==KeyCode.K)
        {
            player2.setAnswer(answer3_label.getText());
        }
        else if(keyEvent.getCode()==KeyCode.L)
        {
            player2.setAnswer(answer4_label.getText());
        }
        player2.setAnswer_given(true);
    }

    /**
     * When a key is pressed
     * If the key pressed == player's control save the answer the player given according to the key he entered
     * If the key pressed == player's2 control save the answer the player2 given according to the key he entered
     * Then run InGameLogic, if player gave answer in single mode or both players gave answer in Two mode , proceed to the next question
     * @param keyEvent Key pressed
     */
    public void on_key_pressed(KeyEvent keyEvent) {
        if(keyEvent.getCode()==KeyCode.DIGIT1 || keyEvent.getCode()==KeyCode.DIGIT2 || keyEvent.getCode()==KeyCode.DIGIT3 || keyEvent.getCode()==KeyCode.DIGIT4 )
        {
            player_setAnswer(keyEvent);
        }
        else if(keyEvent.getCode()==KeyCode.H || keyEvent.getCode()==KeyCode.J || keyEvent.getCode()==KeyCode.K || keyEvent.getCode()==KeyCode.L )
        {
            player2_setAnswer(keyEvent);
        }
        /*
            If both players have given their answer and Game isn't finished
            set the active_question to a new one and change the question gui
         */
        if(shouldGoNextQuestion() && !gameEnded())
        {
            goNextQuestion();
            setQuestionGUI();
            player_scoreLabel.setText(Integer.toString(player.getScore()));
            player2_scoreLabel.setText(Integer.toString(player2.getScore()));
        }
        else if(gameEnded())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Congratulations");
            if(settings.getMode().equals("single"))
            {
                alert.setContentText(player.getName()+"  "+player.getScore());
            }
            else
            {
                alert.setContentText(player.getName()+"  "+player.getScore()+" \n"+player2.getName()+"  "+player2.getScore());
            }
            alert.showAndWait();
        }
    }

    /**
     * If go to Main  Menu button is pressed change Scene to Menu.
     * If the button is pressed before the game ends, all progress will be lost
     * @param actionEvent the button
     * @throws IOException If it can't load the BuzzMenu.fxml
     */
    public void go_main_menu(ActionEvent actionEvent) throws IOException {
        //Load the In_Game Scene
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/BuzzMenu.fxml"));
        /*
         * We need to get the Stage so we can set the scene to in game Scene.
         * Because we don't have access to the Stage from this class we get the stage from the actionEvent
         * Initially we have it as a Node so we can get the Scene and then tha Stage
         */
        //Change the scene to the Menu scene
        Parent root=loader.load();
        Scene scene=new Scene(root);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    /**
     * Taken from stackoverflow
     * Shuffles an array
     * Credits to @Duncan_Jones
     * @param array
     */
    public static void shuffleArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }
}

