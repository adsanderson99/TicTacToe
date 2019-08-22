public class Board 
{
    private static String[][] cells;
    private GameState game;
    
    public Board()
    {
        String[][] boardCells = {
        {" ", " ", " "},
        {" ", " ", " "},
        {" ", " ", " "}
        };
        cells = boardCells;
        game = GameState.NOT_PLAYING;
    }
    
    public GameState getGameState()
    {
        return game;
    }
    
    public void setGameState(GameState newState)
    {
        game = newState;
    }
    
    public String getCell(int x, int y)
    {
        return cells[x][y];
    }
    
    public void setCell(int a, int b, String move) throws IllegalMoveException
    {
        if(cells[a][b].equals(" "))
        {
            cells[b][a] = move;
        }
        else
        {
            IllegalMoveException exception = new IllegalMoveException("Move is illegal");
            throw exception;
        }
    }
    
    public String toString()
    {
        return "  0 1 2 \n" +
               "0 " + cells[0][0] + "|" + cells[0][1] + "|" + cells[0][2] + "\n" + 
               "  -----" + "\n" + 
               "1 " + cells[1][0] + "|" + cells[1][1] + "|" + cells[1][2] + "\n" +
               "  -----" + "\n" +
               "2 " + cells[2][0] + "|" + cells[2][1] + "|" + cells[2][2];
            
    }
    
    public String validMovePrint()
    {
        String text = "Possible Moves: ";
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(cells[x][y].equals(" "))
                {
                    text += x + ", " + y + "   ";
                }
            }
        }
        return text;
    }
    
    public String[][] getBoardCells()
    {
        return cells;
    }
}
