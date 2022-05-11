import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Virus are created on the right edge and move towards the left while rotating.
 * 
 * @author Leon Namowitz 
 * @version v1
 */
public class Virus extends Actor
{
    /**
     * Move along the Bloodstream, slowly rotating.
     */
    public void act()
    {
        setLocation(getX()-4, getY());
        turn(-1);
        
        if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }    
}
