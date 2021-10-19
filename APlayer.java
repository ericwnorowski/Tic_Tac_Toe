/**
 * An abstract class representing a generic tic-tac-toe player
 * Parent class of CpuPlayer and HumanPlayer
 *
 * @author Eric Wnorowski
 * @version HW2
 */
abstract class APlayer extends Object{
 protected Game game;
 protected char symbol;
 
 /**
  * Empty constructor for APlayer objects
  * 
  */
 protected APlayer(){
     
    }
 
 /**
  * Constructor for APlayer objects
  * 
  * @param game - the game APlayer will join
  * @param symbol - the corresponding player's symbol
  */   
    protected APlayer(Game game, char symbol){
     this.game = game;
     this.symbol = symbol;
    }
    
 /**
  * Returns the players symbol
  * @return char symbol - a char representing the player's symbol
  */
    public char getSymbol(){
     return symbol;
    }
    
    /**
     * Constructor method for pickMove() in subclasses
     * 
     * @return null - signify's player wishes to quit game;
     */
 public Move pickMove(){
     return null;
    }
}