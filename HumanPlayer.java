import java.util.*;
/**
 * A class representing a user-controlled tic-tac-toe player
 * Subclass of APlayer
 *
 * @author Eric Wnorowski
 * @version HW2
 */
public class HumanPlayer extends APlayer{
    /**
     * Constructor of HumanPlayer objects
     * 
     * @param game - the game HumanPlayer will join
     * @param symbol - the corresponding player's symbol
     */
    public HumanPlayer(Game game, char symbol){
        this.game = game;
        this.symbol = symbol;
    }

    /**
     * Generates new move based on user input for row and column
     * use isValidMove() to check if the input is within the allowed range
     * and to confirm that the space is unoccupied (write appropriate error message for each case)
     * if not simply call pickMove() again so that it runs until a valid move is made
     * if the user writes quit at any point should return null
     * 
     * @return a Move - user generated move
     *      or null - user quits
     */
    public Move pickMove(){
        Scanner s = new Scanner(System.in); 
        
        while(true){
        System.out.println("Next Move (ex. a1):");
        String a = s.next();
        a.toUpperCase();
        a.toLowerCase();
        if(a.equals("quit") || a.equals("Quit")){
            return null;
        }

        if(a.length() == 2){
            char[] userInput = new char[2];
            userInput = a.toCharArray();
            char row = userInput[0];
            char col = userInput[1];

            if((row >= 'a' && row <= ('a' + (game.boardSize-1))) && (col >= '1' && col <= ('1' + (game.boardSize-1)))){
                Move uMove = new Move(row-('a'), col-('1'));
                if(game.isValidMove(uMove) == 'V'){
                    return uMove;
                }else{
                    System.out.println("Uh oh! That space is occupied!");
                    pickMove();
                }
            }else{
                System.out.println("Invalid Column: try again!"); 
                pickMove();
            }
        }else{
            System.out.println("Invalid Row: try again!");
            pickMove();
        }
    }
}
} 

