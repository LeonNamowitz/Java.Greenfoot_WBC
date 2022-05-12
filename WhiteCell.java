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
    public int scoreValue = 0;

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
    }

    private void checkCollision()
    {
        Bloodstream bloodstream = (Bloodstream) getWorld();
        if (isTouching(Bacteria.class)) {
            removeTouching(Bacteria.class);
            Greenfoot.playSound("slurp.wav");
            scoreValue++;
            bloodstream.changeScore(scoreValue);
        }
        else if (isTouching(Virus.class))  {
            Greenfoot.playSound("game-over.wav");
            PopUp ending = new PopUp("GameOver");
            bloodstream.addObject(ending, bloodstream.getWidth()/2, bloodstream.getHeight()/2);
            removeTouching(WhiteCell.class);
            Greenfoot.stop();
        } 
    }
}
