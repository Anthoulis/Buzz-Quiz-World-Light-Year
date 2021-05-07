package GameLogic;

import GameLogic.In_Game.QuizQuestion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameData {
    //Array Lists
    public ArrayList<String> categories;
    public ArrayList<QuizQuestion> totalQuizQuestions;
    public String [] type_of_round;

    //Constructor
    public GameData()
    {
        //Our current Categories
        categories=new ArrayList<String>();
        categories.add("Food");
        categories.add("Technology");
        categories.add("Science");
        //Our text file questions_data.txt contents registered in an ArrayList QuizQuestion type.
        totalQuizQuestions =new ArrayList<QuizQuestion>();
        setTotalQuestions();   /** Here we call a method which  method registers all data from our txt file to an arraylist totalQuizQuestion
                                   so we can handle our data better*/
        //Type of round
        type_of_round=new String[3];
        type_of_round[0]="Correct Answer Round";
        type_of_round[1]="Stop the time Round";
        type_of_round[2]="Bet Round";
    }
    /**
     * This methods registers all data from our txt file to an arraylist totalQuizQuestion so we can handle our data better
     */
    private void setTotalQuestions()
    {
        //Set total Questions
        try
        {
            Scanner scanner = new Scanner(new File("src/questions_data.txt"));
            String [] myarray;
            /**
             * By the time the while ends all data from the file will have been transformed as QuestionQuiz objects
             * and will be saved in the totalQuizQuestions array list
             */
            ////////////////The Loop////////////////
            while (scanner.hasNextLine())
            {
                myarray=scanner.nextLine().split(";",8); //We read each line and split it in a String array whenever the character ',' is found
                QuizQuestion temp=new QuizQuestion(myarray);
                totalQuizQuestions.add(temp);  //We add the QuizQuestion object we created to our Arraylist
            }
            ////////////////End of Loop//////////////
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    //Setters Getters
    //totalQuizQuestions
    protected ArrayList<QuizQuestion> getTotalQuizQuestions(){return totalQuizQuestions;}

    //Methods
}
