import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class GamePane extends Application
{
    Board board = new Board();
    ComputerPlayer player = new ComputerPlayer(board);
    RulesEngine rules = new RulesEngine(board);
    
    private TextField title = new TextField();
    private TextField message = new TextField();
    private Text text0x = new Text("0");
    private Text text1x = new Text("1");
    private Text text2x = new Text("2");
    private Text text0y = new Text("0");
    private Text text1y = new Text("1");
    private Text text2y = new Text("2");
    private TextField cell1 = new TextField();
    private TextField cell2 = new TextField();
    private TextField cell3 = new TextField();
    private TextField cell4 = new TextField();
    private TextField cell5 = new TextField();
    private TextField cell6 = new TextField();
    private TextField cell7 = new TextField();
    private TextField cell8 = new TextField();
    private TextField cell9 = new TextField();
    private Text textX = new Text("X Value");
    private TextField inputX = new TextField();
    private Text textY = new Text("Y Value");
    private TextField inputY = new TextField();
    private EditableButton btStart = new EditableButton("Start");
    private Text tf = new Text("Start");
    private Button newGame = new Button("New Game");
    private String name;
    
    public void start(Stage primaryStage)
    {
        Pane VPane = new VBox(5);
        GridPane pane = new GridPane();
        GridPane inputs = new GridPane();
        GridPane buttons = new GridPane();
        title = new TextField("Welcome to Tic-Tak-Toe! Enter your name below and press \"Start\"");
        
        VPane.getChildren().add(title);
        VPane.getChildren().add(message);
        pane.add(text0x, 1, 0);
        pane.add(text1x, 2, 0);
        pane.add(text2x, 3, 0);
        pane.add(text0y, 0, 1);
        pane.add(text1y, 0, 2);
        pane.add(text2y, 0, 3);
        pane.add(cell1, 1, 1);
        pane.add(cell2, 2, 1);
        pane.add(cell3, 3, 1);
        pane.add(cell4, 1, 2);
        pane.add(cell5, 2, 2);
        pane.add(cell6, 3, 2);
        pane.add(cell7, 1, 3);
        pane.add(cell8, 2, 3);
        pane.add(cell9, 3, 3);
        inputs.add(textX, 0, 0);
        inputs.add(inputX, 1, 0);
        inputs.add(textY, 2, 0);
        inputs.add(inputY, 3, 0);
        buttons.add(btStart, 0, 0);
        buttons.add(newGame, 1, 0);
        
        VPane.getChildren().add(pane);
        VPane.getChildren().add(inputs);
        VPane.getChildren().add(buttons);
        
        btStart.setOnAction(this::processButtonPress);
        newGame.setOnAction(this::processNewGameButtonPress);
        
        VPane.setPadding(new Insets(15, 15, 15, 15));
        pane.setHgap(5);
        pane.setVgap(5);
        inputs.setHgap(5);
        inputs.setVgap(5);
        buttons.setHgap(5);
        buttons.setVgap(5);
        
        Scene scene = new Scene(VPane, 475, 270);
        primaryStage.setTitle("Tic-Tak-Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    //Following class based on code by StackOverflow user JAtkin 
    class EditableButton extends Button 
    {
        public EditableButton(String text) 
        {
            setText(text);
            setOnMouseClicked(e -> {
                tf.setText("Make Move");
                setText("");
                setGraphic(tf);
            });
        }
    }
    
    public void processButtonPress(ActionEvent event) 
    {
        try
        {
            if(board.getGameState() == GameState.PLAYING)
            {
                title.setText(board.validMovePrint());
                int x = Integer.parseInt(inputX.getText());
                int y = Integer.parseInt(inputY.getText());
                boolean xCheck = false;
                boolean yCheck = false;
                board.setCell(x, y, "X");
                player.setBoard(board);
                rules.setBoard(board);
                while(xCheck == false)
                {
                    if(x == 0 && y == 0)
                    {
                        cell1.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                    else if(x == 1 && y == 0)
                    {
                        cell2.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                    else if(x == 2 && y == 0)
                    {
                        cell3.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                    else if(x == 0 && y == 1)
                    {
                        cell4.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                    else if(x == 1 && y == 1)
                    {
                        cell5.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                    else if(x == 2 && y == 1)
                    {
                        cell6.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                    else if(x == 0 && y == 2)
                    {
                        cell7.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                    else if(x == 1 && y == 2)
                    {
                        cell8.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                    else 
                    {
                        cell9.setText("X");
                        player.setBoard(board);
                        xCheck = true;
                    }
                }
                System.out.println(board);
                player.setBoard(board);
                int[] computerMove = player.generateMove();
                board.setCell(computerMove[0], computerMove[1], "O");
                rules.setBoard(board);
                while(yCheck == false)
                {
                    if(computerMove[0] == 0 && computerMove[0] == 0)
                    {
                        cell1.setText("0");
                        yCheck = true;
                    }
                    else if(computerMove[0] == 1 && computerMove[0] == 0)
                    {
                        cell2.setText("0");
                        yCheck = true;
                    }
                    else if(computerMove[0] == 2 && computerMove[0] == 0)
                    {
                        cell3.setText("0");
                        yCheck = true;
                    }
                    else if(computerMove[0] == 0 && computerMove[1] == 1)
                    {
                        cell4.setText("0");
                        yCheck = true;
                    }
                    else if(computerMove[0] == 1 && computerMove[1] == 1)
                    {
                        cell5.setText("0");
                        yCheck = true;
                    }
                    else if(computerMove[0] == 2 && computerMove[1] == 1)
                    {
                        cell6.setText("0");
                        yCheck = true;
                    }
                    else if(computerMove[0] == 0 && computerMove[2] == 2)
                    {
                        cell7.setText("0");
                        yCheck = true;
                    }
                    else if(computerMove[0] == 1 && computerMove[2] == 2)
                    {
                        cell8.setText("0");
                        yCheck = true;
                    }
                    else
                    {
                        cell9.setText("0");
                        yCheck = true;
                    }
                }
                rules.setBoard(board);
                System.out.println(board);
                if(rules.didSomeoneWin() == GameState.X_WON)
                {
                    title.setText("Congrats " + name + ", you won!");
                    message.setText("Press \"Play Again\" to start a new game.");
                    board.setGameState(GameState.X_WON);
                }
                if(rules.didSomeoneWin() == GameState.O_WON)
                {   
                    title.setText(player.getPhrase());
                    message.setText("Press \"Play Again\" to start a new game.");
                    board.setGameState(GameState.O_WON);
                }
                if(rules.isDraw() == GameState.DRAW)
                {
                    title.setText("There seems to be a draw.");
                    message.setText("Press \"Play Again\" to start a new game.");
                    board.setGameState(GameState.DRAW);
                }
            }
            if(tf.getText().equals("Start"))
            {
                name = message.getText();
                title.setText(board.validMovePrint());
                message.setText(name +", Enter your move below");
                board.setGameState(GameState.PLAYING);
            }
        }
        catch(IllegalMoveException e)
        {
            message.setText("Please Enter a Valid Move");
        }
        catch(ArrayIndexOutOfBoundsException exception)
        {
            message.setText("Please only enter the numbers 0, 1, and 2");
        }
        catch(java.util.InputMismatchException exception)
        {
            message.setText("Please only enter the numbers 0, 1, and 2");
        }
        catch(NumberFormatException exception)
        {
            message.setText("Please only enter the numbers 0, 1, and 2");
        }
        catch(NullPointerException exception)
        {
            message.setText("There seems to be a draw.");
            board.setGameState(GameState.DRAW);
        }
    }
    
    public void processNewGameButtonPress(ActionEvent event)
    {
        board = new Board();
        player = new ComputerPlayer(board);
        rules = new RulesEngine(board);
        cell1.setText("");
        cell2.setText("");
        cell3.setText("");
        cell4.setText("");
        cell5.setText("");
        cell6.setText("");
        cell7.setText("");
        cell8.setText("");
        cell9.setText("");
        title.setText("Welcome to Tic-Tak-Toe! Enter your name below and press \"Start\"");
        message.setText("");
        inputX.setText("");
        inputY.setText("");
        tf.setText("Start");
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
}
