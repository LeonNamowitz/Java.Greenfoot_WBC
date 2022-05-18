import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopUp extends Actor
{
    // public static final int WIDTH = 400;
    // public static final int HEIGHT = 300;

    public PopUp(String type, int value)
    {
        if (type == "GameOver") {
            badEnding();
        }
        if (type == "YouWon")   {
            goodEnding(value);
        }
    }

    public void badEnding()
    {
        GreenfootImage end = new GreenfootImage("GAME OVER", 40, Color.WHITE, Color.BLACK);
        setImage(end);
    }
    
    public void goodEnding(int value)
    {
        int width = 300;
        int height = 200;
        // GreenfootImage end = new GreenfootImage(width, height);
        // end.setColor(new Color(0, 0, 0, 255));
        // end.fillRect(0, 0, width, height);
        // Font font = end.getFont();
        // font = font.deriveFont(32);
        // end.setFont(font);
        // end.setColor(Color.WHITE);
        // end.drawString("You Won", 240, 220);
        // // end.drawImage(end, 200, 200);

        // setImage(end);

        GreenfootImage end = new GreenfootImage( width, height);

        end.setColor(new Color(0, 0, 0, 200));
        end.fillRect(0, 0, width, height);
        // end.setColor(new Color(0, 0, 0, 255));
        Font font = end.getFont();
        font = font.deriveFont(36);
        end.setFont(font);
        end.setColor(Color.RED);
        end.drawString("GAME OVER", 40, 70);
        end.setColor(Color.WHITE);
        end.drawString("Final Score: " + value, 40, 160);

        setImage(end);

    }
    
    
}
