package GameLogic.Menu;
/**
 * This class represents the common characteristics of every kind of menu
 */

public abstract class Menu {
    private String title;
    private int numberofoptions;
    private String[]nameofoptions;

    public Menu()
    {
        title="";
    }
    public Menu(String title, int numberofoptions, String[]nameofoptions)
    {
        this.title=title;
        this.numberofoptions=numberofoptions;
        this.nameofoptions=nameofoptions;
    }
    //Setters and Getters
    //Title
    public String getTitle() {
        return title;
    }
    //Number of Options
    public int getNumberofoptions() {
        return numberofoptions;
    }
    //String Array name of options
    public String[] getNameofoptions() {
        return nameofoptions;
    }

    //Useful for Command Line
    //Show Menu and adjust print
    public String adjust(String s)
    {
        String mys="| "+s;
        for(int i=mys.length();i<35;i++)
        {
            mys=mys+" ";
        }
        mys=mys+" ";
        return mys;
    }
    public void show()
    {
        System.out.println("+------------------------------------------------+");
        System.out.println(adjust("       "+getTitle() +"                        |"));
        System.out.println("|                                                |");
        for(int i=0;i<getNumberofoptions();i++)
        {
            System.out.println(adjust(getNameofoptions()[i]) + " --------> "+i+ " |");
            System.out.println("|                                                |");
        }
        System.out.println("+------------------------------------------------+");
    }
    //Show Press options
    public void showPress()
    {
        for(int i=0;i<numberofoptions;i++)
        {
            System.out.println("Press "+i+" for "+nameofoptions[i]);
        }
    }

}