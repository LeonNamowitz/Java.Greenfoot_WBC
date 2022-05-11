import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopUp extends Actor
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    public PopUp(String type)
    {
        if (type == "GameOver") {
            gameOver();
        }
    }

    public void gameOver()
    {
        GreenfootImage end = new GreenfootImage("GAME OVER", 40, Color.WHITE, Color.BLACK);
        setImage(end);
    }

}
