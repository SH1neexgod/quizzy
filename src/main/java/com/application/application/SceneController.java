package com.application.application;

import java.io.IOException;
import java.io.PushbackInputStream;
import java.sql.ResultSet;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class SceneController {

    @FXML
    public Label questionLabel;

    @FXML
    public Label pointLabel;

    @FXML
    public Button startButton;
    @FXML
    public Button ansA;
    @FXML
    public Button ansB;
    @FXML
    public Button ansC;
    @FXML
    public Button ansD;

    @FXML
    public TextField enterName;

    @FXML
    public  Label enterNameText;

    @FXML
    public  Label currentNameText;
    @FXML
    public  Label questionNumText;

    @FXML
    public  Label topOne;
    @FXML
    public  Label topTwo;
    @FXML
    public  Label topThree;

    @FXML
    public  Label endGame, endSavedInfo;

    public String ans;
    public  int point = 0;
    public  int num = 0;
    public  int numQuestion = 0;

    public String currentName = null;

    @FXML
    public void SetQuestion(ActionEvent event) throws IOException
    {
        if(!enterName.getText().isEmpty())
        {
            num = NumOfStart();
            numQuestion = 1;
            currentName = enterName.getText();
            currentNameText.setText("Player Name: " + enterName.getText());
            questionNumText.setText("Question " + numQuestion);
            ansA.setVisible(true);
            ansB.setVisible(true);
            ansC.setVisible(true);
            ansD.setVisible(true);
            enterName.setVisible(false);
            enterNameText.setVisible(false);
            selectedTopicLabel.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);

            DatabaseHandler dbHandler = new DatabaseHandler();
            questionLabel.setText(dbHandler.GetQuestionFromDB(num, 0));
            ansA.setText(dbHandler.GetQuestionFromDB(num, 1));
            ansB.setText(dbHandler.GetQuestionFromDB(num, 2));
            ansC.setText(dbHandler.GetQuestionFromDB(num, 3));
            ansD.setText(dbHandler.GetQuestionFromDB(num, 4));
            ans = dbHandler.GetQuestionFromDB(num, 5);
            System.out.println(ans);
            startButton.setVisible(false);
        }
        else if(enterName.getText().isEmpty()){
            startButton.setText("Enter name, and press me");

        }
    }

    public  int NumOfStart()
    {
        int returnBack = 1;
        if(selectedButton == 1)
        {
            returnBack = 1;
        }
        else if(selectedButton == 2)
        {
            returnBack = 11;
        }
        else if(selectedButton == 3)
        {
            returnBack = 21;

        }
        else if(selectedButton == 4)
        {

        }
        return returnBack;
    }

    @FXML
    public  void AnswerA(ActionEvent event)
    {
        if(ans.equals("1"))
        {
            point += 20;
            pointLabel.setText("Point: " + point);
            System.out.println("Дұрыс жауап");
            AnswerIs(true);
        }
        else
        {
            System.out.println("Өтрк жауап");
            AnswerIs(false);
        }
        num += 1;
        numQuestion += 1;
        if(SaveData())
        {
            questionNumText.setText("Question " + numQuestion);
            DatabaseHandler dbHandler = new DatabaseHandler();
            questionLabel.setText(dbHandler.GetQuestionFromDB(num, 0));
            ansA.setText(dbHandler.GetQuestionFromDB(num, 1));
            ansB.setText(dbHandler.GetQuestionFromDB(num, 2));
            ansC.setText(dbHandler.GetQuestionFromDB(num, 3));
            ansD.setText(dbHandler.GetQuestionFromDB(num, 4));
            ans = dbHandler.GetQuestionFromDB(num, 5);
            System.out.println(ans);
        }
        else
        {
            ansA.setVisible(false);
            ansB.setVisible(false);
            ansC.setVisible(false);
            ansD.setVisible(false);
            questionLabel.setVisible(false);
            endGame.setVisible(true);
            endSavedInfo.setVisible(true);
            questionNumText.setVisible(false);
            answerCur.setVisible(false);
            EndLabelAnimation();
        }
    }
    @FXML
    public  void AnswerB(ActionEvent event)
    {
        if(ans.equals("2"))
        {
            point += 20;
            pointLabel.setText("Point: " + point);
            System.out.println("Дұрыс жауап");
            AnswerIs(true);
        }
        else
        {
            System.out.println("Өтрк жауап");
            AnswerIs(false);
        }
        num += 1;
        numQuestion += 1;
        if(SaveData())
        {
            questionNumText.setText("Question " + numQuestion);
            DatabaseHandler dbHandler = new DatabaseHandler();
            questionLabel.setText(dbHandler.GetQuestionFromDB(num, 0));
            ansA.setText(dbHandler.GetQuestionFromDB(num, 1));
            ansB.setText(dbHandler.GetQuestionFromDB(num, 2));
            ansC.setText(dbHandler.GetQuestionFromDB(num, 3));
            ansD.setText(dbHandler.GetQuestionFromDB(num, 4));
            ans = dbHandler.GetQuestionFromDB(num, 5);
            System.out.println(ans);
        }
        else
        {
            ansA.setVisible(false);
            ansB.setVisible(false);
            ansC.setVisible(false);
            ansD.setVisible(false);
            questionLabel.setVisible(false);
            endGame.setVisible(true);
            endSavedInfo.setVisible(true);
            questionNumText.setVisible(false);
            answerCur.setVisible(false);
            EndLabelAnimation();
        }
    }
    @FXML
    public  void AnswerC(ActionEvent event)
    {
        if(ans.equals("3"))
        {
            point += 20;
            pointLabel.setText("Point: " + point);
            System.out.println("Дұрыс жауап");
            AnswerIs(true);
        }
        else
        {
            System.out.println("Өтрк жауап");
            AnswerIs(false);
        }
        num += 1;
        numQuestion += 1;
        if(SaveData())
        {
            questionNumText.setText("Question " + numQuestion);
            DatabaseHandler dbHandler = new DatabaseHandler();
            questionLabel.setText(dbHandler.GetQuestionFromDB(num, 0));
            ansA.setText(dbHandler.GetQuestionFromDB(num, 1));
            ansB.setText(dbHandler.GetQuestionFromDB(num, 2));
            ansC.setText(dbHandler.GetQuestionFromDB(num, 3));
            ansD.setText(dbHandler.GetQuestionFromDB(num, 4));
            ans = dbHandler.GetQuestionFromDB(num, 5);
            System.out.println(ans);
        }
        else
        {
            ansA.setVisible(false);
            ansB.setVisible(false);
            ansC.setVisible(false);
            ansD.setVisible(false);
            questionLabel.setVisible(false);
            endGame.setVisible(true);
            endSavedInfo.setVisible(true);
            questionNumText.setVisible(false);
            answerCur.setVisible(false);
            EndLabelAnimation();
        }
    }
    @FXML
    public  void AnswerD(ActionEvent event)
    {
        if(ans.equals("4"))
        {
            point += 20;
            pointLabel.setText("Point: " + point);
            System.out.println("Дұрыс жауап");
            AnswerIs(true);
        }
        else
        {
            System.out.println("Өтрк жауап");
            AnswerIs(false);
        }
        /*
        Random rand = new Random();
        int randomNum = rand.nextInt(max) + min;*/

        num  += 1;
        numQuestion += 1;

        if(SaveData())
        {
            questionNumText.setText("Question " + numQuestion);
            DatabaseHandler dbHandler = new DatabaseHandler();
            questionLabel.setText(dbHandler.GetQuestionFromDB(num, 0));
            ansA.setText(dbHandler.GetQuestionFromDB(num, 1));
            ansB.setText(dbHandler.GetQuestionFromDB(num, 2));
            ansC.setText(dbHandler.GetQuestionFromDB(num, 3));
            ansD.setText(dbHandler.GetQuestionFromDB(num, 4));
            ans = dbHandler.GetQuestionFromDB(num, 5);
            System.out.println(ans);
        }
        else
        {
            ansA.setVisible(false);
            ansB.setVisible(false);
            ansC.setVisible(false);
            ansD.setVisible(false);
            questionLabel.setVisible(false);
            endGame.setVisible(true);
            endSavedInfo.setVisible(true);
            questionNumText.setVisible(false);
            answerCur.setVisible(false);
            EndLabelAnimation();
        }
    }

    public boolean SaveData()
    {
        DatabaseHandler dbHandler = new DatabaseHandler();
        if(numQuestion > 10)
        {
            dbHandler.SavePlayerData(currentName, point);
            return false;
        }
        else
        {
            return true;
        }
    }

    public void EndLabelAnimation()
    {
        FadeTransition endTexts = new FadeTransition(Duration.seconds(0.8), endGame);
        FadeTransition endTextSaved = new FadeTransition(Duration.seconds(0.8), endSavedInfo);
        endTexts.setFromValue(0.1);
        endTexts.setToValue(1.0);
        endTextSaved.setFromValue(0.1);
        endTextSaved.setToValue(1.0);
        endTexts.play();
        endTextSaved.play();
    }


    public void GetTops() throws Exception {

        System.out.println("Was get tops");

        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet rs = dbHandler.getTopPlayers();

        if(rs.next()) {
            topOne.setText(rs.getString(Const.NAME_USER) + " - " + rs.getInt(Const.SCORE));
        }
        if(rs.next()) {
            topTwo.setText(rs.getString(Const.NAME_USER) + " - " + rs.getInt(Const.SCORE));
        }
        if(rs.next()) {
            topThree.setText(rs.getString(Const.NAME_USER) + " - " + rs.getInt(Const.SCORE));
        }
    }

    public String topA, topB, topC;

    @FXML
    public void TopThreeShow()
    {
        topOne.setText(topA);
        topTwo.setText(topB);
        topThree.setText(topC);


        System.out.println(topA + " "+  topB  + " "+  topC);
    }
    @FXML
    public  void GetTopsByBtn() throws Exception{

        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet rs = dbHandler.getTopPlayers();
        System.out.println(rs);
        if(rs.next()) {
            topOne.setText("1. " +  rs.getString(Const.NAME_USER) + " - " + rs.getInt(Const.SCORE) + "p");
        }
        if(rs.next()) {
            topTwo.setText("2. " +  rs.getString(Const.NAME_USER) + " - " + rs.getInt(Const.SCORE) + "p");
        }
        if(rs.next()) {
            topThree.setText("3. " +  rs.getString(Const.NAME_USER) + " - " + rs.getInt(Const.SCORE) + "p");
        }
    }

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Label selectedTopicLabel;

    private final String starterStyle = "-fx-background-color:" +
            "        #3c7fb1," +
            "        linear-gradient(#fafdfe, #e8f5fc)," +
            "        linear-gradient(#eaf6fd 0%, #fcf6d9 49%, #f7fcbd 50%, #faf7a2 100%);" +
            "    -fx-background-insets: 0,1,2;" +
            "    -fx-background-radius: 3,2,1;" +
            "    -fx-padding: 15 90 15 90;" +
            "    -fx-text-fill: black;" +
            "    -fx-font-size: 13px;" +
            "    -fx-max-width: 300px;" +
            "    -fx-text-alignment: center;";

    public int selectedButton = 1;

    @FXML
    protected void handleButton1Action(ActionEvent event) {
        resetButtonStyles();
        button1.setStyle("-fx-background-color: yellow;");
        selectedButton = 1;
        System.out.println( "Selected: "+ selectedButton);
    }

    @FXML
    protected void handleButton2Action(ActionEvent event) {
        resetButtonStyles();
        button2.setStyle("-fx-background-color: yellow;");
        selectedButton = 2;
        System.out.println( "Selected: "+ selectedButton);
    }

    @FXML
    protected void handleButton3Action(ActionEvent event) {
        resetButtonStyles();
        button3.setStyle("-fx-background-color: yellow;");
        selectedButton = 3;
        System.out.println( "Selected: "+ selectedButton);
    }

    @FXML
    protected void handleButton4Action(ActionEvent event) {
        resetButtonStyles();
        button4.setStyle("-fx-background-color: red;");
        selectedButton = 4;
        System.out.println( "Selected: "+ selectedButton);
    }

    private void resetButtonStyles() {
        button1.setStyle(starterStyle);
        button2.setStyle(starterStyle);
        button3.setStyle(starterStyle);

    }

    @FXML
    public Label answerCur;

    @FXML Label mainMenuLabel;
    @FXML Button startMain;
    @FXML Button exitGameMain;
    @FXML Button exitGame;
    @FXML Button getTopsMain;
    public void AnswerIs(boolean right)
    {
        answerCur.setVisible(true);
        if(right)
        {
            answerCur.setText("Correct answer!");
            answerCur.setStyle("-fx-text-fill: #0ead05;");
        }
        else
        {
            answerCur.setText("Incorrect answer!");
            answerCur.setStyle("-fx-text-fill: #ff001e;");
        }
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), answerCur);


        fadeTransition.setFromValue(0.1);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();

        fadeTransition.setOnFinished(event -> {
            FadeTransition fadeB = new FadeTransition(Duration.seconds(1.0), answerCur);
            fadeB.setFromValue(1.0);
            fadeB.setToValue(0.9);
            fadeB.play();

            fadeB.setOnFinished(a -> {
                FadeTransition fadeEnd = new FadeTransition(Duration.seconds(0.5), answerCur);
                fadeEnd.setFromValue(1.0);
                fadeEnd.setToValue(0.0);
                fadeEnd.play();


                fadeEnd.setOnFinished(c -> {
                    answerCur.setVisible(false);
                });
            });
        });


    }

    public int getSelectedButton() {
        return selectedButton;
    }








    private Stage stage;
    private Scene scene;
    private Parent root;



    public void LoadMainMenu() throws IOException, Exception {
        FadeTransition MainText = new FadeTransition(Duration.seconds(2), mainMenuLabel);
        MainText.setFromValue(0.1);
        MainText.setToValue(1.0);
        MainText.play();
    }

    @FXML
    public void switchToScene1(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("/logo.png")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        FadeTransition MainText = new FadeTransition(Duration.seconds(0.6), mainMenuLabel);
        MainText.setFromValue(1.0);
        MainText.setToValue(0.0);
        FadeTransition exitBtn = new FadeTransition(Duration.seconds(0.5), exitGameMain);
        exitBtn.setFromValue(1.0);
        exitBtn.setToValue(0.0);
        FadeTransition getTops = new FadeTransition(Duration.seconds(0.5), getTopsMain);
        getTops.setFromValue(1.0);
        getTops.setToValue(0.0);
        FadeTransition startBtn = new FadeTransition(Duration.seconds(0.5), startMain);
        startBtn.setFromValue(1.0);
        startBtn.setToValue(0.0);

        MainText.play();
        exitBtn.play();
        getTops.play();
        startBtn.play();

        startBtn.setOnFinished(s -> {
            try {
                root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("/logo.png")));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

/*
            TranslateTransition exitBtnInGame = new TranslateTransition(Duration.seconds(0.5), exitGame);
            exitBtnInGame.setToX(-200.0);
            exitBtnInGame.play();*/
        });

    }

    @FXML
    public  void ExitGame(ActionEvent a) throws Exception{
        System.exit(0);
    }

}