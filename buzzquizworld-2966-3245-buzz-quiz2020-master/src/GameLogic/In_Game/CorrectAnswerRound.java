package GameLogic.In_Game;

public class CorrectAnswerRound extends Round{
    public CorrectAnswerRound()
    {
        super();
        type="Correct Answer Round";
    }

    //Bonus correct
    public void setBonus(boolean correct)
    {
        if(correct)
        {
            bonus=1000;
        }
        else
        {
            bonus=0;
        }
    }

    //Useful Command Line method
    public void show()
    {
        {
            System.out.println("+------------------------------------------------+");
            System.out.println("|            Correct Answer Round                |");
            System.out.println("|                                                |");
            System.out.println("| If you answer correct you get 1000 bonus points|");
            System.out.println("|                                                |");
        }
    }
}
