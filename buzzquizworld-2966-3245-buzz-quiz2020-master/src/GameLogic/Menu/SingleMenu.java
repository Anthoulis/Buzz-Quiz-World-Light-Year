package GameLogic.Menu;

public class SingleMenu extends Menu{
    public SingleMenu()
    {
        super("Single Player",3,new String[]{"Back to Main Menu","Enter Name","Continue"});
    }
    //Useful Command Line Method
    public void show(String player_name)
    {
        System.out.println("+------------------------------------------------+");
        System.out.println(adjust("       " + getTitle()) + "             |");
        System.out.println("|                                                |");
        System.out.println(adjust(getNameofoptions()[0]) + " --------> " + 0 + " |");
        System.out.println("|                                                |");
        System.out.println(adjust(getNameofoptions()[1] +": "+player_name) + " --------> " + 1 + " |");
        System.out.println("|                                                |");
        System.out.println(adjust(getNameofoptions()[2]) + " --------> " + 2 + " |");
        System.out.println("|                                                |");
        System.out.println("+------------------------------------------------+");
    }
}
