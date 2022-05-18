import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a white blood cell. This kind of cell has the job to catch 
 * bacteria and remove them from the blood.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class WhiteCell extends Actor
{
    // public int scoreValue = 0;

    /**
     * Act: move up and down when cursor keys are pressed.
     */
    public void act() 
    {
        // scoreValue = 0;
        checkKeyPress();
        checkCollision();
    }
    
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-4);
        }    
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+4);
        }
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-4, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+4, getY());
        }
    }

    private void checkCollision()
    {
        Bloodstream bloodstream = (Bloodstream) getWorld();
        if (isTouching(Bacteria.class)) {
            removeTouching(Bacteria.class);
            Greenfoot.playSound("slurp.wav");
            bloodstream.changeScore(20);
        }
        else if (isTouching(Virus.class))  {
            removeTouching(Virus.class);
            bloodstream.changeScore(-100);
        } 
    }
}
