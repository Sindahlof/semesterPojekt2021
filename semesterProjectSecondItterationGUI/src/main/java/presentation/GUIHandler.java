package presentation;

import domain.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import org.controlsfx.control.spreadsheet.Grid;
import textUI.Play;
import textUI.PrintGrid;

import java.util.HashMap;

public class GUIHandler {
    @FXML
    private GridPane secretaryOffice;

    @FXML
    private GridPane mayorOffice;

    @FXML
    private AnchorPane titleScreen;

    @FXML
    private ImageView article1;

    @FXML
    private HBox Quiz1;

    @FXML
    private GridPane assemblyRoom;

    @FXML
    private GridPane harbor1;

    @FXML
    private GridPane restroom;

    @FXML
    private GridPane volkswagenMechanic;

    @FXML
    private GridPane playground;

    @FXML
    private GridPane university;

    @FXML
    private GridPane townSquare_;

    @FXML
    private GridPane park_;

    @FXML
    private GridPane cloverSt_;

    @FXML
    private GridPane harbor2;

    @FXML
    private GridPane queensST;

    private Game game;
    private GridPane currentRoom;
    private PrintGrid grid;
    private ImageView player;
    private HashMap<String, GridPane> rooms;
    private HashMap<String, ImageView> items;
    private Play play;
    private String answer;
    private HashMap<String,HBox> quizs;
    private String quiz;


    private void startGame() {
        this.game = new Game();
        this.grid = new PrintGrid();
        this.player = new ImageView(game.getPlayer1().getImage());
        this.player.setFitHeight(30);
        this.player.setFitWidth(30);
        this.rooms = new HashMap<>();
        this.items = new HashMap<>();
        this.quizs = new HashMap<>();
        this.play = new Play();
        addAllRooms();
        addAllItems();
        addAllQuizs();
        this.titleScreen.setDisable(false);
        this.titleScreen.setVisible(true);
    }

    private void changeRoom(GridPane pane) {
        this.currentRoom = pane;
        this.currentRoom.setVisible(true);
        this.currentRoom.setDisable(false);
        int x = game.getPlayer1().getPosistion().getX();
        int y = game.getPlayer1().getPosistion().getY();
        this.currentRoom.add(this.player, x, y);
        System.out.println(this.grid.printGrid(game));
    }

    private void addAllRooms() {
        this.rooms.put("secretary Office", this.secretaryOffice);
        this.rooms.put("Mayor Office", this.mayorOffice);
        this.rooms.put("green fields",this.assemblyRoom);
        this.rooms.put("Harbor", this.harbor1);
        this.rooms.put("public restroom",this.restroom);
        this.rooms.put("volkswagen mechanic",this.volkswagenMechanic);
        this.rooms.put("playground",this.playground);
        this.rooms.put("university of Engineering and Science",this.university);
        this.rooms.put("town square",this.townSquare_);
        this.rooms.put("park",this.park_);
        this.rooms.put("clover St",this.cloverSt_);
        this.rooms.put("harbor",this.harbor2);
        this.rooms.put("queens St",this.queensST);
    }

    private  void addAllQuizs(){
        this.quizs.put("1",this.Quiz1);
    }

    private void addAllItems() {
        this.items.put("Article-1", this.article1);
        /*this.items.put("Article-2",);
        this.items.put("Article-3",);
        this.items.put("Article-4",);
        this.items.put("Article-5",);
        this.items.put("Article-6",);*/
    }

    private void disableCurrentRoom() {
        this.currentRoom.setVisible(false);
        this.currentRoom.setDisable(true);
    }

    private void enableCurrentRoom(){
        this.currentRoom.setVisible(true);
        this.currentRoom.setDisable(false);
    }

    private void disableTitleScreen() {
        this.titleScreen.setDisable(true);
        this.titleScreen.setVisible(false);
    }

    public void easy() {
        startGame();
        disableTitleScreen();
        this.game.getPlayer1().setHealth(10);
        changeRoom(this.mayorOffice);
    }

    public void medium() {
        startGame();
        disableTitleScreen();
        this.game.getPlayer1().setHealth(5);
        changeRoom(this.mayorOffice);
    }

    public void hard() {
        startGame();
        disableTitleScreen();
        this.game.getPlayer1().setHealth(2);
        changeRoom(this.mayorOffice);
    }

    public void a() {
        this.answer = "A";
        this.play.quizHandler(this.game.getCurrentRoom().getQuizInRoom(), this.game, this.answer);
        if (this.game.getCurrentRoom().getQuizInRoom().isCompletion()){
            this.quizs.get(quiz).setDisable(true);
            this.quizs.get(quiz).setVisible(false);
            enableCurrentRoom();
        }
    }

    public void b() {
        this.answer = "B";
        this.play.quizHandler(this.game.getCurrentRoom().getQuizInRoom(), this.game, this.answer);
        if (this.game.getCurrentRoom().getQuizInRoom().isCompletion()){
            this.quizs.get(quiz).setDisable(true);
            this.quizs.get(quiz).setVisible(false);
            enableCurrentRoom();
        }
    }

    public void c() {
        this.answer = "C";
        this.play.quizHandler(this.game.getCurrentRoom().getQuizInRoom(), this.game, this.answer);
        if (this.game.getCurrentRoom().getQuizInRoom().isCompletion()){
            this.quizs.get(quiz).setDisable(true);
            this.quizs.get(quiz).setVisible(false);
            enableCurrentRoom();
        }
    }

    @FXML
    public void keyHandler(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.S) {
            Command command = new Command(CommandWord.MOVE, "down");
            game.processCommand(command);
            this.currentRoom.setRowIndex(this.player, game.getPlayer1().getPosistion().getY());
            System.out.println("fejl 2");
        }

        if (keyEvent.getCode() == KeyCode.W) {
            Command command = new Command(CommandWord.MOVE, "up");
            game.processCommand(command);
            this.currentRoom.setRowIndex(this.player, game.getPlayer1().getPosistion().getY());
            System.out.println("fejl 3");
        }

        if (keyEvent.getCode() == KeyCode.A) {
            Command command = new Command(CommandWord.MOVE, "left");
            game.processCommand(command);
            this.currentRoom.setColumnIndex(this.player, game.getPlayer1().getPosistion().getX());
            System.out.println("fejl 4");
        }
        if (keyEvent.getCode() == KeyCode.D) {
            Command command = new Command(CommandWord.MOVE, "right");
            game.processCommand(command);
            this.currentRoom.setColumnIndex(player, game.getPlayer1().getPosistion().getX());
            System.out.println("fejl 5");
        }

        if (keyEvent.getCode() == KeyCode.E) {
            String s = game.exitRoom();
            if (s.equals("3")) {
                disableCurrentRoom();
                changeRoom(this.rooms.get(game.getCurrentRoom().getShortDescription()));
                System.out.println(game.getCurrentRoom().getShortDescription());
            }
            String a = game.getCurrentRoom().collectObject(game.getPlayerInventory(), game.getPlayer1());
            if (!(a == "df")) {
                this.items.get(a).setDisable(false);
                this.items.get(a).setVisible(true);
            } else {
            }
        }

        if (keyEvent.getCode() == KeyCode.SPACE) {
            this.quiz = game.getCurrentRoom().getQuizInRoom().getDescription();

            if (!(this.game.getCurrentRoom().getQuizInRoom().isCompletion())){
                disableCurrentRoom();
                this.quizs.get(this.quiz).setDisable(false);
                this.quizs.get(this.quiz).setVisible(true);
            }
        }

        if (keyEvent.getCode() == KeyCode.ESCAPE){
            this.quizs.get(this.quiz).setVisible(false);
            this.quizs.get(this.quiz).setDisable(true);
            enableCurrentRoom();
        }


        game.getCurrentRoom().constructGrid(game.getPlayer1());
        System.out.println(this.grid.printGrid(game));
    }


}