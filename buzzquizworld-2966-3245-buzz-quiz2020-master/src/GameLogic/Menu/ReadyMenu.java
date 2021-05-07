package GameLogic.Menu;

public class ReadyMenu extends Menu{
    public ReadyMenu()
    {
        super("Get Ready!",4,new String[]{"Back to Main Menu","Enter Rounds : ","Enter Questions per round : ","Start Game"});
    }

    //Useful Command Line method
    public void show(int rounds, int questions_per_round)
    {
        System.out.println("+------------------------------------------------+");
        System.out.println(adjust("       "+getTitle()) +   "             |");
        System.out.println("|                                                |");
        System.out.println(adjust(getNameofoptions()[0]) + " --------> "+"0"+ " |");
        System.out.println("|                                                |");
        System.out.println(adjust(getNameofoptions()[1]+rounds) + " --------> "+"1"+ " |");
        System.out.println("|                                                |");
        System.out.println(adjust(getNameofoptions()[2]+questions_per_round) + " --------> "+"2"+ " |");
        System.out.println("|                                                |");
        System.out.println(adjust(getNameofoptions()[3]) + " --------> "+"3"+ " |");
        System.out.println("|                                                |");
        System.out.println("|Max number of rounds is 6!                      |");
        System.out.println("|Max number of questions per round is 7!         |");
        System.out.println("+------------------------------------------------+");
    }
}
