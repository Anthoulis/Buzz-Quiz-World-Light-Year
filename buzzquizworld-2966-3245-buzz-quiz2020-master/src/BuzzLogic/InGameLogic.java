package BuzzLogic;

import BuzzLogic.Rounds.Round;

import java.util.Random;

public class InGameLogic extends GameData {
    protected Player player;
    protected Player player2;
    protected Settings settings;
    protected int current_round;
    protected int current_question;
    protected QuizQuestion displayed_question;
    protected Random random;
    protected Round game_round;

    /**
     * Constructor is called when Single Player Mode Game Starts
     * @param name1 The Name of the Player
     * @param game_rounds The number of the round that were given in Single Player by the player
     * @param questions_per_round The number of questions per round that we given in Single Player by the player
     */
    public InGameLogic(String name1, int game_rounds, int questions_per_round)
    {
        super();
        player=new Player(name1);
        player2=new Player("Player");
        settings=new Settings(game_rounds,questions_per_round,"single");
        current_round=-1;
        current_question=0;
        displayed_question =new QuizQuestion();
        random=new Random(System.currentTimeMillis());
        game_round=new Round("Correct Answer");
    }
    /**
     * Constructor is called when Two Player Mode Game Starts
     * @param name1 The name of the first player
     * @param name2 The name of the second player
     * @param game_rounds The number of rounds that were given in Two Player mode by the players
     * @param questions_per_round The number of questions per round that were given in Two Player mode by the players
     */
    public InGameLogic(String name1, String name2, int game_rounds, int questions_per_round)
    {
        super();
        player=new Player(name1);
        player2=new Player(name2);
        settings=new Settings(game_rounds,questions_per_round,"two");
        current_round=-1;
        current_question=0;
        displayed_question =new QuizQuestion();
        random=new Random(System.currentTimeMillis());
    }
    /**
     * Set the values of the question that is displayed
     */
    public void setActive_question() {
        displayed_question =getTotalQuizQuestions().get(random.nextInt(getTotalQuizQuestions().size()));
    }

    /**
     * Single mode: If player has given his answer
     * Two mode: If both players have given the answer
     * @return If we are qualified to go to next question
     */
    public boolean shouldGoNextQuestion()
    {
        return player.isAnswer_given() && (player2.isAnswer_given() || settings.getMode().equals("single"));
    }

    /**
     * Steps in order to go next
     * 1. Change Score
     * 2. Increase current_question by 1
     * 3. Change if answer_given to false for each player
     * 4. Set the displayed_question to a new one
     */
    public void goNextQuestion()
    {
        if(player.getAnswer().equals(displayed_question.getCorrect_answer()))
        {
            player.setScore(player.getScore()+1000);
        }
        current_question++;
        player.setAnswer_given(false);
        if(settings.getMode().equals("two"))
        {
            player2.setAnswer_given(false);
            if(player2.getAnswer().equals(displayed_question.getCorrect_answer()))
            {
                player2.setScore(player2.getScore()+1000);
            }

        }
        setActive_question();
    }
    /**
     * If number of answer == game answers and last question has been answered then the game has ended
     */
    public boolean gameEnded()
    {
        return current_question >= settings.getNumberOfQuestions() - 1 && shouldGoNextQuestion();
    }
}
