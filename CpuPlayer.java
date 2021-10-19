/**
 * A class representing a computer-controlled tic-tac-toe player
 * Subclass of APlayer
 *
 * @author Eric Wnorowski
 * @version HW2
 */
public class CpuPlayer extends APlayer{
    
    /**
     * Constructor of CpuPlayer objects
     * 
     * @param game - the game CpuPlayer will join
     * @param symbol - the corresponding player's symbol
     */
    public CpuPlayer(Game game, char symbol){
        this.game = game;
        this.symbol = symbol;
    }
    
    /**
     * Generates new move based on computer generated row and column
     * use isValidMove() to check if the space is empty,
     * if not simply call pickMove() again so that it runs until a valid move is made
     * 
     * @return a Move - computer generated move, cpu must make a move.
     *                  can not return null
     */
    public Move pickMove(){
        
        while(true){
        int r = (int)(Math.random()*game.getBoardSize());
        int c = (int)(Math.random()*game.getBoardSize());
        Move cpuMove = new Move(r, c);
        
        if(game.isValidMove(cpuMove) == 'V'){
         return cpuMove;
        }
    }
}
}