import GameLogic.BuzzQuizWorldLogic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLine extends BuzzQuizWorldLogic {
    private int select;
    private int answer;

    public CommandLine()
    {
        select=-1;
        answer=-1;
    }
    /**
     * Starting our app in Command Line method
     */
    public void run()
    {
        while (true) {
            //If main menu is open
            if (current_open_menu.equals(mainMenu.getTitle())) {
                //Run Main Menu
                runMainMenu();
            }
            //If single menu is open
            else if (current_open_menu.equals(singleMenu.getTitle())) {
                //Run Single Menu
                runSingleMenu();
            }
            //If Get Ready Menu is open
            else if (current_open_menu.equals(readyMenu.getTitle())) {
                //Run Get Ready Menu
                runReadyMenu();
            }
        }
    }

    /**
     * Command Line running Menu Methods
     */
    public void runMainMenu()
    {
        mainMenu.show();
        select=readSelect();
        //Exit
        if(select==0)
        {
            System.exit(0);
        }
        //Open Single menu
        else if(select==1)
        {
            //Set Single menu the current open
            current_open_menu= singleMenu.getTitle();
        }
        //If option not valid show the valid options
        else
        {
            mainMenu.showPress();
        }
    }
    public void runSingleMenu() {
        singleMenu.show(player_name);
        select = readSelect();
        //If Go back to main menu is selected set current menu open the Main menu
        if (select == 0) {
            current_open_menu= mainMenu.getTitle();
        }
        //If Enter Name is selected set Name and do not change current open
        else if (select == 1) {
            System.out.println("Enter Name : ");
            Scanner sc = new Scanner(System.in);
            player_name=sc.nextLine();
        }
        //Open GetReadyMenu
        else if (select == 2) {
            current_open_menu= readyMenu.getTitle();
        }
        //If option not valid show SingleMenu valid options
        else {
            singleMenu.showPress();
        }
    }
    public void runReadyMenu()
    {
        readyMenu.show(rounds,questions_per_round);
        select=readSelect();
        if(select==0) //Go back to main menu
        {
            current_open_menu= mainMenu.getTitle();
        }
        else if(select==1) //Set number of rounds
        {
            System.out.println("Enter Number of Rounds : ");
            int n=readSelect();
            setRounds(n);
        }
        else if(select==2)//Set number of questions
        {
            System.out.println("Enter Number of Questions Per round : ");
            int n=readSelect();
            setQuestions_per_round(n);
        }
        else if(select==3)
        {
            System.out.println("Starting Game...");
            runInGame();
            current_open_menu=readyMenu.getTitle();
            System.out.println("Good job             ");
            System.out.println("You scored     "+player_score+"  points");
        }
        else
        {
            //If option not valid show SingleMenu valid options
            readyMenu.showPress();
        }
    }

    /**
     * Command Line Running In Game
     */
    public void runInGame()
    {
        //Setting our one game data
        set_game_Questions();
        current_question=0;
        for(int i=0;i<rounds;i++)
        {
            setType_Round();//Setting a random type Round and running the right one
            if(type_Round.equals(type_of_round[0]))
            {
                runCorrectRound();
            }
            else if(type_Round.equals(type_of_round[1]))
            {
                runStopTheTimeRound();
            }
            else if(type_Round.equals(type_of_round[2]))
            {
                runBetRound();
            }
            else
            {
                System.out.println("runInGame type round not found");
                System.exit(1);
            }
        }
    }
    public void runCorrectRound()
    {
        //Runs until the round ends.It depends at the number of questions per round
        for(int i=0;i<questions_per_round;i++)
        {
            correctRound.show();
            game_Questions.get(current_question).show();
            setPlayer_answer(readAnswer());
            if(player_answer.equals(game_Questions.get(current_question).getCorrectanswer()))
            {
                player_score=player_score+1000;
            }
            System.out.println("Score : " +player_score);

            //Do not forget to increase the current question
            current_question=current_question+1;
        }
    }
    public void runStopTheTimeRound()
    {
        //Runs until the round ends.It depends at the number of questions per round
        for(int i=0;i<questions_per_round;i++)
        {
            stopRound.show();
            game_Questions.get(current_question).show();
            setPlayer_answer(readAnswer());
            if(player_answer.equals(game_Questions.get(current_question).getCorrectanswer()))
            {
                player_score=player_score+500;
            }
            System.out.println("Score : " +player_score);

            //Do not forget to increase the current question
            current_question=current_question+1;
        }
    }
    public void runBetRound()
    {
        //Runs until the round ends.It depends at the number of questions per round
        for(int i=0;i<questions_per_round;i++)
        {
            betRound.show();
            int bet=0;
            int betselect=0;
            game_Questions.get(current_question).show();
            System.out.println("|Enter you bet : ");
            betselect=readSelect();
            System.out.println("|Enter your answer : ");
            if(betselect==0||betselect==250)
            {
                bet=250;
            }
            else if(betselect==1||betselect==500)
            {
                bet=500;
            }
            else if(betselect==2||betselect==750)
            {
                bet=750;
            }
            else if(betselect==3||betselect==1000)
            {
                bet=1000;
            }
            else
            {
                bet=250;
            }

            /////////////////////////////////////////////

            setPlayer_answer(readAnswer());
            if(player_answer.equals(game_Questions.get(current_question).getCorrectanswer()))
            {
                player_score=player_score+bet;
            }
            else
            {
                player_score=player_score-bet;
            }
            System.out.println("Score : " +player_score);

            //Do not forget to increase the current question
            current_question=current_question+1;
        }
    }
    //Methods
    //Command Line Methods
    //Read from keyboard
    public int readSelect() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
    public int readAnswer()
    {
        Scanner sc=new Scanner(System.in);
        int k= sc.nextInt();
        while (k<0||k>3)
        {
            System.out.println("Give answer 0 or 1 or 2 or 3");
            k=sc.nextInt();
        }
        return k;
    }

}
