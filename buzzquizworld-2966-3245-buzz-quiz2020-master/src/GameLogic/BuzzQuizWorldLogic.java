package GameLogic;

import GameLogic.In_Game.*;
import GameLogic.Menu.MainMenu;
import GameLogic.Menu.ReadyMenu;
import GameLogic.Menu.SingleMenu;

import java.util.ArrayList;
import java.util.Random;

public class BuzzQuizWorldLogic extends GameData {
    //Game Menus
    protected MainMenu mainMenu;
    protected SingleMenu singleMenu;
    protected ReadyMenu readyMenu;
    //Type of rounds
    protected CorrectAnswerRound correctRound;
    protected StopTheTimeRound stopRound;
    protected BetRound betRound;
    //////////////////////////////////////////////////////////////
    //Temporary Variables changing according to Player response
    protected String current_open_menu;
    protected String player_name;
    protected int rounds;
    public int questions_per_round;
    protected ArrayList<QuizQuestion> game_Questions;
    protected String type_Round;
    protected int current_question;
    protected int current_round;
    protected String player_answer;
    protected int player_score;

    protected Random random;


    public BuzzQuizWorldLogic()
    {

        super();
        //Game Menus
        mainMenu = new MainMenu();
        singleMenu = new SingleMenu();
        readyMenu = new ReadyMenu();
        //Type of rounds
        correctRound = new CorrectAnswerRound();
        stopRound = new StopTheTimeRound();
        betRound = new BetRound();

        //The default values of the variables that change according to the Players response
        current_open_menu= mainMenu.getTitle();
        player_name="Player";
        rounds=6;
        questions_per_round=5;
        game_Questions =new ArrayList<>();
        type_Round=type_of_round[0];
        current_round=0;
        current_question=0;
        player_answer="";
        player_score=0;
        random=new Random(System.currentTimeMillis());
    }

    //NUmber of Rounds
    protected void setRounds(int number_rounds)
    {
        rounds=number_rounds;
        if(rounds>6)
        {
            rounds=6;
        }
        else if(rounds<1)
        {
            rounds=1;
        }
    }
    //Questions per round
    protected void setQuestions_per_round(int number_questions)
    {
        questions_per_round=number_questions;
        if(questions_per_round>5)
        {
            questions_per_round=5;
        }
        else if (questions_per_round<1)
        {
            questions_per_round=1;
        }
    }
    //Player Answer
    public void setPlayer_answer(String player_answer) {
        this.player_answer = player_answer;
    }
    public void setPlayer_answer(int answer)
    {
        player_answer=game_Questions.get(current_question).getAnswer()[answer];
    }
    //Round type but setting it to a random type
    public void setType_Round()
    {
        type_Round=type_of_round[random(3)];
    }

    /**
     * This methods sets an Array List with the in games questions randomly.It depends at the number of rounds and questions per round the user has given
     * The questions and the category are randomly determined
     */
    public void set_game_Questions()
    {
        ArrayList<QuizQuestion> temp=new ArrayList<>(getTotalQuizQuestions()); //Creating a new Array List based on the totalQuizQuestions

        String random_category=type_of_round[0];
        int random_question=0;

        for(int i=0;i<rounds;i++)
        {
            for (int j=0;j<questions_per_round;j++)
            {
                random_question=random.nextInt(temp.size());
                game_Questions.add(temp.get(random_question));
            }
        }
    }

    /**
     * This method sets the Round type randomly.
     */
    public int random(int bound)
    {
        Random rand = new Random(System.currentTimeMillis());
        int k=rand.nextInt(3);
        return k;
    }
}
