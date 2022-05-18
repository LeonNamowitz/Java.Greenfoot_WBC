import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bloodstream is the setting for our White Blood Cell scenario. 
 * It's a place where blood cells, bacteria and viruses float around.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Bloodstream extends World
{
    int scoreValue = 0;
    Counter scoreCounter = new Counter(0);
    int time = 200;
    Counter timeCounter = new Counter(time);

    /**
     * Constructor: Set up the starting objects.
     */
    public Bloodstream()
    {    
        super(780, 360, 1); 
        setPaintOrder(PopUp.class, Counter.class, Border.class);
        prepare();
    }

    /**
     * Create new floating objects at irregular intervals.
     */
    public void act()
    {
        checkGameState();
        randomSpawning();
        updateCounters();
    }

    public void checkGameState()
    {
        if (scoreValue < 0) {
            looseGame();
        }
        if (time <= 0)  {
            winGame();
        }
    }

    public void randomSpawning()
    {
        if (Greenfoot.getRandomNumber(100) < 3) {
            addObject(new Bacteria(), getWidth()-1, Greenfoot.getRandomNumber(360));
        }
        if (Greenfoot.getRandomNumber(100) < 1) {
            addObject(new Lining(), getWidth(), 1);
            addObject(new Lining(), getWidth(), getHeight()-1);            
        }
        if (Greenfoot.getRandomNumber(100) < 1) {
            addObject(new Virus(), getWidth(), Greenfoot.getRandomNumber(getHeight()));
        }
        if (Greenfoot.getRandomNumber(100) < 6) {
            addObject(new RedCell(), getWidth()-1, Greenfoot.getRandomNumber(360));
        }
    }

    public void changeScore(int value)
    {
        scoreValue += value;
    }

    public void updateCounters()
    {
        scoreCounter.updateScoreCounter(scoreValue);  
        timeCounter.updateTimeCounter(time);
        time--; 
    }
    
    /**
     * Prepare the world for the start of the program. In this case: Create
     * a white blood cell and the lining at the edge of the blood stream.
     */
    private void prepare()
    {
        WhiteCell whitecell = new WhiteCell();
        addObject(whitecell, 100, 179);
        Lining lining = new Lining();
        addObject(lining, 126, 1);
        Lining lining2 = new Lining();
        addObject(lining2, 342, 5);
        Lining lining3 = new Lining();
        addObject(lining3, 589, 2);
        Lining lining4 = new Lining();
        addObject(lining4, 695, 5);
        Lining lining5 = new Lining();
        addObject(lining5, 114, 359);
        Lining lining6 = new Lining();
        addObject(lining6, 295, 353);
        Lining lining7 = new Lining();
        addObject(lining7, 480, 358);
        Lining lining8 = new Lining();
        addObject(lining8, 596, 359);
        Lining lining9 = new Lining();
        addObject(lining9, 740, 354);

        Border border = new Border();
        addObject(border, 0, 180);
        Border border2 = new Border();
        addObject(border2, 770, 180);

        addObject(scoreCounter, getWidth()/2, 15);
        addObject(timeCounter, 150, 15);
    }

    public void looseGame()
    {
        Greenfoot.playSound("game-over.wav");
        PopUp badEnding = new PopUp("GameOver", 0);
        addObject(badEnding, getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }

    public void winGame()
    {
        PopUp goodEnding = new PopUp("YouWon", scoreValue);
        addObject(goodEnding, getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
}
