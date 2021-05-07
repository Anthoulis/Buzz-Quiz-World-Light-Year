package BuzzLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * All our Question are stored in totalQuizQuestions
 * @author Giannis Anthoulis 2966
 * @author Alexandros Seremetas Mpildiris 3245
 */
public class GameData {
    private ArrayList<QuizQuestion> totalQuizQuestions;

    public GameData()
    {
        //Our text file questions_data.txt contents registered in an ArrayList QuizQuestion type.
        totalQuizQuestions =new ArrayList<QuizQuestion>();
        setTotalQuestions();
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
            String [] my_array;
            /*
             * By the time the while ends all data from the file will have been transformed as QuestionQuiz objects
             * and will be saved in the totalQuizQuestions array list
             */
            while (scanner.hasNextLine())
            {
                my_array=scanner.nextLine().split(";",8); //We read each line and split it in a String array whenever the character ';' is found
                QuizQuestion temp=new QuizQuestion(my_array);
                totalQuizQuestions.add(temp);  //We add the QuizQuestion object we created to our Arraylist
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    //Get TotalQuizQuestions
    protected ArrayList<QuizQuestion> getTotalQuizQuestions(){return totalQuizQuestions;}
}
