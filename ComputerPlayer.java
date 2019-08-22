public class ComputerPlayer
{
   private int[][] preferredMoves = {
         {1, 1}, {0, 0}, {2, 2}, {2, 0}, {0, 2},
         {0, 1}, {1, 0}, {1, 2}, {2, 1}};
   private Board board;
   
   public ComputerPlayer(Board board)
   {
       this.board = board;
   }
   
   public int[] generateMove() 
   {
   	for (int[] move : preferredMoves) 
   	{
            if (board.getCell(move[0], move[1]).equals(" ")) 
            {
                return move;
            }
         }
        return null;
   }
   
   public void setBoard(Board board)
   {
       this.board = board;
   }
   
   public String getPhrase()
   {
       int phrase = (int)(Math.random() * 3 + 1);
       if(phrase == 1)
       {
           return "It looks like the computer won, better luck next time.";
       }
       if(phrase == 2)
       {
           return "It looks like the computer is smarter, better luck next time.";
       }
       else
       {
           return "This is why the computers are going to take over.";
       }
   }
}