import java.util.*;
import java.util.Scanner;

/**
 * A class that implements Game object, initliazes a new game, 
 * and loops to create a continuous game of tic-tac-toe
 *
 * @author Eric Wnorowski
 * @version HW2
 */
public class Game extends Object{
    /** 
     * represents the game board as a 2d array
     */
    char[][] board;
    
    /** 
     * represents the board size used to create board
     */
    final int boardSize;
    
    /** 
     * represents an array of players
     */
    APlayer[] players = new APlayer[2];
    
    /** 
     * represents blank space on the game board
     */
    final char SYMBOL_BLANK = ' ';
    
    /** 
     * represents cpu's symbol on the game board
     */
    final char SYMBOL_CPU = 'O';
    
    /** 
     * represents human's symbol on the game board
     */
    final char SYMBOL_HUMAN = 'X';

    /**
     * Constructor for game objects
     * @param  size of the board user inputs
     */
    public Game(int boardSize){ 
        this.boardSize = boardSize;
        char boardSized = (char)boardSize;

        this.board = new char[boardSized][boardSized];

        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++){
                board[i][j] = (SYMBOL_BLANK);
            }
        }
    }

    /**
     * Simply returns the board size of the game
     * 
     * @return the user's choosen board size
     */
    public int getBoardSize(){
        return this.boardSize;
    }

    /**
     * Resets game state once the game is over
     * resets the game board to all empty spaces
     * 
     */
    protected void resetGame(){
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++){
                board[i][j] = (SYMBOL_BLANK);
            }
        }

        System.out.println(board);
    }

    /**
     * Checks to see if the move by computer/human is possible
     * @param a Move - to be checked
     * @return 'V' for valid, 'O' for occupied space, 
     *      'C' for invalid column input, 'R' for invalid row input
     */
    public char isValidMove(Move move){
        int row = move.row;
        int col = move.col;
        Move checkMove = move;
        
        if(row < 0 || row > boardSize){
            return 'R';
        }else if(col < 0 || col > boardSize){
            return 'C';
        }else if(!(board[row][col] == ' ')){
            return 'O';
        }else{
            return 'V';
        }
    }

    /**
     * Marks the game board at the specificed location via Move with a symbol
     * calls isValidMove(Move) to determine if Move can be executed
     * 
     * @param a Move - Move to be executed
     * @param symbol - object player's symbol
     * @return true if move was properly executed, false if move was invalid
     */
    protected boolean executeMove(Move move, char symbol){
        int row = move.row;
        int col = move.col;
        Move execMove = move;

        if(!(isValidMove(execMove) == 'V')){
            return false;
        }else{
            board[row][col] = symbol;
            return true;
        }

    }

    /**
     * Evaluates the game board to determine if the game is over
     * Iterates through the rows, columns, and diagnols of the board
     * if row, column, or diagnol have all same symbol, if they do player with that symbol wins
     * returns winning players symbol, or T if tie, or ? if game is not over
     * 
     * @return '?' if game is not over, 'T' if game ends in tie, or 'X'/'O' if user/cpu wins
     */
    public char getGameStatus(){
        int numO = 0;
        int numX = 0;

        //rows

        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    numX++;
                }else if(board[i][j] == 'O'){
                    numO++;
                }
            }
            if(numX == boardSize){
                return  'X';
            }else if(numO == boardSize){
                return 'O';
            }
            numX = 0;
            numO = 0;
        }

        //cols
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if(board[j][i] == 'X'){
                    numX++;
                }else if(board[j][i] == 'O'){
                    numO++;
                }
            }
            if(numX == boardSize){
                return  'X';
            }else if(numO == boardSize){
                return 'O';
            }
            numX = 0;
            numO = 0;
        }

        //left-diagonal

        for(int i=0; i < board.length; i++){
            if(board[i][i] == 'X'){
                numX++;
            }else if(board[i][i] == 'O'){
                numO++;
            }
            if(numX == boardSize){
                return  'X';
            }else if(numO == boardSize){
                return 'O';
            }
        }
        numX = 0;
        numO = 0;

        //right-diagonal
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if((i + j) == board.length-1){
                    if(board[i][j] == 'X'){
                        numX++;
                    }else if(board[i][j] == 'O'){
                        numO++;
                    }
                }
            }
            if(numX == board.length){
                return  'X';
            }else if(numO == board.length){
                return 'O';
            }
        }
        numX = 0;
        numO = 0;

        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if(board[i][j] == ' '){
                    return '?';
                }
            }
        }

        return 'T';
    }

    /**
     * Creates a neat textual representation of the game board
     * 
     * @return A String that represents the current game board
     */
    public String toString(){
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        char a = 'A';
        int numCols = 0;

        for(int j=0; j<board[0].length; j++){
            numCols++;
            if(j == 0){
                s3 += "  " + numCols + "  ";  
            }else if (j == board[0].length-1){
                s3+= " " + numCols + " " + "\n";
            }else{
                s3 += " " + numCols + "  ";   
            }

        }
        s4 += s3;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(i == board.length-1){
                    if(j == 0){
                        s1 += ((char)(a + i)) + " " + board[i][j] + " |";
                    }else if(j == board[0].length-1){
                        s1 += " " + board[i][j] + " ";
                    }else{
                        s1 += " " + board[i][j] + " |";
                    }

                } else if(j == 0){
                    s1 += ((char)(a + i)) + " " + board[i][j] + " |";
                    s2 += " ---|";
                } else if(j == board[0].length-1){
                    s1 += " " + board[i][j] + " " + "\n";
                    s2 += "---" + "\n";
                } else{
                    s1 += " " + board[i][j] + " " + "|";
                    s2 += "---|";
                }
            }

            s4 += s1 + s2;
            s1 = "";
            s2 = "";
        }

        return s4;
    }

    /**
     * Plays a single game of tic-tac-toe by:
     * deciding if user or player goes first,
     * if cpu goes first, cpu generates (row, col), executes move, and prints board
     * if user goes first, user enters (row, col), executes move, and prints board
     * loops this process for as long as the game is not over, returns symbol that shows result
     * 
     * @return 'H' if user wins, 'C' if computer wins, 'T' if game ends in tie, or 'Q' if user quits
     * 
     */
    public char playSingleGame(){
        APlayer cpu = new CpuPlayer(this, SYMBOL_CPU);
        APlayer user = new HumanPlayer(this, SYMBOL_HUMAN);

        char cpuSymbol = cpu.symbol;
        char userSymbol = user.symbol;
        double goesFirst;
        goesFirst = Math.random();
        Scanner s = new Scanner(System.in);

        if(goesFirst < 0.5){
            players[0] = cpu;
            players[1] = user;
        }else{
            players[0] = user;
            players[1] = cpu;
        }

        do{
            Move player1 = players[0].pickMove();
            if(player1 == null){
                return 'Q';
            }else{
                executeMove(player1, players[0].getSymbol());
                System.out.println(this);
            }
            if(getGameStatus() == '?'){
                Move player2 = players[1].pickMove();
                if(player2 == null){
                    return 'Q';
                }else{
                    executeMove(player2, players[1].getSymbol());
                    System.out.println(this);
                }
            }
        }while(getGameStatus() == '?');

        char result = ' ';

        if(getGameStatus() == 'X'){
            //human wins
            result = 'H';
        }else if(getGameStatus() == 'O'){
            //cpu wins
            result = 'C';
        }else if(getGameStatus() == 'T'){
            //tie game
            result ='T';
        }else{
            System.out.println("unknown error 1");
        }

        return result;
    }

    /**
     * Runs consecutive tic-tac-toe games by implement playSingleGame()
     * Continuosly runs game until user quits
     * once user quits it should display the GameStats for that sequence of games
     * 
     * @param arg - user entered boardsize, should be [1, 9] if not default to 3x3
     * @throws IndexOutOfBoundsException if boardsize not in range
     */
    public static void main(String[] args){
        System.out.println("Welcome to Tic-Tac-Toe!");

        int boardSize = Integer.parseInt(args[0]);

        try{
            if(boardSize > 0 && boardSize <= 9 ){
                boardSize = boardSize;
            }else{
                boardSize = 3;
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("Invalid Board Size");
        }

        Game userGame = new Game (boardSize);
        System.out.println(userGame);

        GameStats userGameStats = new GameStats();

        while(true){

            char singleGame = userGame.playSingleGame();

            if(singleGame == 'H'){
                //human wins
                System.out.println("You won! Congratulations!");
                userGameStats.recordWin();
                userGame.resetGame();
                System.out.println(userGame);
            }else if(singleGame == 'C'){
                //cpu wins
                System.out.println("CPU won :( try again!");
                userGameStats.recordLoss();
                userGame.resetGame();
                System.out.println(userGame);
            }else if(singleGame == 'T'){
                //tie game
                System.out.println("Tie Game! Play again!");
                userGameStats.recordTie();
                userGame.resetGame();
                System.out.println(userGame);
            }else if(singleGame == 'Q'){
                System.out.println("User Quit" + "\n" + "User Record:");
                System.out.println(userGameStats);
                break;
            }
        }
    }
}