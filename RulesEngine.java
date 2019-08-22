public class RulesEngine 
{
    private Board board;
    
    public RulesEngine(Board board)
    {
        this.board = board;
    }
    
    public void setBoard(Board board)
    {
       this.board = board;
    }
    
    public GameState didSomeoneWin()
    {
        if(board.getCell(0, 0).endsWith("X") && board.getCell(0, 1).endsWith("X") && board.getCell(0, 2).endsWith("X"))
            return GameState.X_WON;
        if(board.getCell(1, 0).endsWith("X") && board.getCell(1, 1).endsWith("X") && board.getCell(1, 2).endsWith("X"))
            return GameState.X_WON;
        if(board.getCell(2, 0).endsWith("X") && board.getCell(2, 1).endsWith("X") && board.getCell(2, 2).endsWith("X"))
            return GameState.X_WON;
        if(board.getCell(0, 0).endsWith("X") && board.getCell(1, 0).endsWith("X") && board.getCell(2, 0).endsWith("X"))
            return GameState.X_WON;
        if(board.getCell(0, 1).endsWith("X") && board.getCell(1, 1).endsWith("X") && board.getCell(2, 1).endsWith("X"))
            return GameState.X_WON;
        if(board.getCell(0, 2).endsWith("X") && board.getCell(1, 2).endsWith("X") && board.getCell(2, 2).endsWith("X"))
            return GameState.X_WON;
        if(board.getCell(0, 0).endsWith("X") && board.getCell(1, 1).endsWith("X") && board.getCell(2, 2).endsWith("X"))
            return GameState.X_WON;
        if(board.getCell(0, 2).endsWith("X") && board.getCell(1, 1).endsWith("X") && board.getCell(2, 0).endsWith("X"))
            return GameState.X_WON;
        if(board.getCell(0, 0).endsWith("O") && board.getCell(0, 1).endsWith("O") && board.getCell(0, 2).endsWith("O"))
            return GameState.O_WON;
        if(board.getCell(1, 0).endsWith("O") && board.getCell(1, 1).endsWith("O") && board.getCell(1, 2).endsWith("O"))
            return GameState.O_WON;
        if(board.getCell(2, 0).endsWith("O") && board.getCell(2, 1).endsWith("O") && board.getCell(2, 2).endsWith("O"))
            return GameState.O_WON;
        if(board.getCell(0, 0).endsWith("O") && board.getCell(1, 0).endsWith("O") && board.getCell(2, 0).endsWith("O"))
            return GameState.O_WON;
        if(board.getCell(0, 1).endsWith("O") && board.getCell(1, 1).endsWith("O") && board.getCell(2, 1).endsWith("O"))
            return GameState.O_WON;
        if(board.getCell(0, 2).endsWith("O") && board.getCell(1, 2).endsWith("O") && board.getCell(2, 2).endsWith("O"))
            return GameState.O_WON;
        if(board.getCell(0, 0).endsWith("O") && board.getCell(1, 1).endsWith("O") && board.getCell(2, 2).endsWith("O"))
            return GameState.O_WON;
        if(board.getCell(0, 2).endsWith("O") && board.getCell(1, 1).endsWith("O") && board.getCell(2, 2).endsWith("O"))
            return GameState.O_WON;
        else
            return GameState.PLAYING;
    }
    
    public GameState isDraw()
    {
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if (board.getCell(x, y).equals(" "))
                {
                    return GameState.PLAYING;
                }
            }
        }
        return GameState.DRAW;
    }
}
