package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import org.w3c.dom.Text;


import java.util.Scanner;


public class Main extends Application {
    Stage window;
    String pass = "name";
    ComboBox<String> dogs;
    TextField dog_User;
    Parent root;
    Scene loglog_scene, dogAdoption_scene, rateBrand_scene,MainMenu ;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;



        GridPane LogIn = new GridPane();
        LogIn.setPadding(new Insets (10,10,10,10));
        LogIn.setVgap(10);
        LogIn.setHgap(10);

        GridPane dog_adoption = new GridPane();
        dog_adoption.setPadding(new Insets (10,10,10,10));
        dog_adoption.setHgap(10);
        dog_adoption.setVgap(10);

        GridPane rate_brand = new GridPane();
        rate_brand.setPadding(new Insets (10,10,10,10));
        rate_brand.setHgap(10);
        rate_brand.setVgap(10);

        GridPane main_menu = new GridPane();
        rate_brand.setPadding(new Insets (10,10,10,10));
        main_menu.setHgap(10);
        main_menu.setVgap(10);


        //=========================Main Menu=================================================
        //Main menu window
        Label mm_dog = new Label("Adopts Dogs");
        GridPane.setConstraints(mm_dog,0,0);

        Label mm_rateBrands = new Label("Rate Brands");
        GridPane.setConstraints(mm_rateBrands,16,17);

        //Buttons
        Button mm_butt_adopt = new Button("Adopt!");
        mm_butt_adopt.setOnAction( e -> window.setScene(dogAdoption_scene));
        GridPane.setConstraints(mm_butt_adopt,17,16);


        Button mm_butt_rate = new Button("Rate!");
        mm_butt_rate.setOnAction( e -> window.setScene(rateBrand_scene));
        GridPane.setConstraints(mm_butt_rate,17,17);




        //=========================TextField=================================================
        //Username Label
        Label username_label = new Label("Username: ");
        GridPane.setConstraints(username_label, 0,0);

        // Username input
        TextField username_tf = new TextField();
        username_tf.setPromptText("Type username");
        GridPane.setConstraints(username_tf,1,0);


        //Password Label
        Label password_label = new Label("Password: ");
        GridPane.setConstraints(password_label,0,1);


        //Text field Password
        TextField password_tf = new TextField();
        GridPane.setConstraints(password_tf,1,1);

        //Log in Button
        Button log_in = new Button("Log in");
        GridPane.setConstraints(log_in,0,2);
        log_in.setOnAction( e -> window.setScene(MainMenu));

        //Back button




        //========================CheckBox Rating==================================================
        //Checkbox
        CheckBox email = new CheckBox("Email");
        CheckBox paypal = new CheckBox("PayPal");
        CheckBox github = new CheckBox("GitHub");

        Button check = new Button("Check");
        check.setOnAction( e -> checking(email, paypal, github));
        GridPane.setConstraints(check,50,0);

        //VBox for Checkbox
        VBox checkbox_choise = new VBox();
        checkbox_choise.getChildren().addAll(email, paypal, github);
        checkbox_choise.setAlignment(Pos.TOP_LEFT);
        GridPane.setConstraints(checkbox_choise,50,1);

        //========================Drop-Down Menu Rating ==================================================
        //Drop-down menu
        ChoiceBox<String> subject = new ChoiceBox<>();
        subject.getItems().addAll("PayPal", "Email", "Form", "Illegal", "Legal", "Noice");
        GridPane.setConstraints(subject, 0, 0);
        subject.setValue("PayPal");


        //Rating dropdown
        ChoiceBox<String> rating =  new ChoiceBox<>();
        rating.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        GridPane.setConstraints(rating,5,0);


        //Drop-down select without Button
        ChoiceBox<String> rating_upgrade =  new ChoiceBox<>();
        rating_upgrade.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        rating_upgrade.getSelectionModel().selectedItemProperty().addListener
                ( (v, b, a) -> System.out.println("You rated " + subject.getValue() + " " + a + " stars."));
        GridPane.setConstraints(rating_upgrade,1,0);


        //Drop-down menu button
        Button subject_dropdown = new Button("Rate!");
        subject_dropdown.setOnAction( e -> getChoise(subject,rating_upgrade));
        GridPane.setConstraints(subject_dropdown,1,1);


        //========================Drop-Down Adopt Dog==================================================

        Label dog_user_label = new Label("Adopter Name:");
        GridPane.setConstraints(dog_user_label, 0, 0);


        dog_User = new TextField();
        dog_User.setEditable(true);
        GridPane.setConstraints(dog_User, 1, 0);

        Label dog_breed_label = new Label("Breed:");
        GridPane.setConstraints(dog_breed_label, 0, 1);

        //ComboBox dogs
        dogs = new ComboBox<>();
        dogs.getItems().addAll("Yorkie", "Pitbull", "Alaskan", "Golden Retriever,", "Chiwawaw (never)");
        dogs.setPromptText("Yorkie");
        dogs.setEditable(true);
        dogs.setOnAction(e -> System.out.println(dog_User.getText() + " chose " + dogs.getValue()));
        GridPane.setConstraints(dogs, 1, 1);

        //Button for dogs
        Button submit_dogs = new Button("Search");
        submit_dogs.setOnAction(e -> System.out.println("Great choice! We will inform you as soon as " +
                "there is a " + dogs.getValue() + " is available for adoption"));
        GridPane.setConstraints(submit_dogs, 0, 2);



        //===============================For All===========================================
        Button Log_out = new Button("<< Log Out");
        Log_out.setOnAction( e -> window.setScene(loglog_scene));
        GridPane.setConstraints(Log_out,0,30);

        Button back_brand = new Button("<< Back");
        back_brand.setOnAction( e -> window.setScene(MainMenu));
        GridPane.setConstraints(back_brand,0,30);

        Button back_adoption = new Button("<< Back");
        back_adoption.setOnAction( e -> window.setScene(MainMenu));
        GridPane.setConstraints(back_adoption,0,30);





        //Scenes
        LogIn.getChildren().addAll(username_label,username_tf,password_label,password_tf, log_in);

        dog_adoption.getChildren().addAll(dog_user_label,dogs,submit_dogs,dog_User, back_adoption, dog_breed_label);

        rate_brand.getChildren().addAll(subject, rating_upgrade, subject_dropdown, back_brand);

        main_menu.getChildren().addAll(mm_butt_adopt,mm_butt_rate,mm_dog,mm_rateBrands, Log_out);

        loglog_scene = new Scene(LogIn,500,500);
        dogAdoption_scene = new Scene(dog_adoption,500, 500);
        rateBrand_scene = new Scene(rate_brand,500,500);
        MainMenu = new Scene(main_menu, 500,500);


        window.setScene(loglog_scene);
        window.setTitle("Password Com");
        window.show();

    }

    //==========================================================================
    //Drop-down
    private void getChoise(ChoiceBox <String> username_drop, ChoiceBox <String> my_rating){
        String dropbox = username_drop.getValue();
        String rate = my_rating.getValue();
        System.out.println("You rated " + "'" +dropbox+ "' " + rate + " stars");
    }









    //==========================================================================
    //Checkbox
    private void checking(CheckBox email, CheckBox PayPal, CheckBox github) {
        String message = "";
        if(email.isSelected())
            message += "Email password is :\nDittofe218\n";

        if(PayPal.isSelected())
            message += "PayPal password is :\nGoi2@#rf\n";

        if(github.isSelected())
            message += "GitHub password is :\n1ne0nLIUB081\n";

        System.out.println(message);

    }

    //==========================================================================
    // Normal
    private void corrects_pw(TextField input){
         Scanner passcode = new Scanner(System.in);

         int x=1;
         do{
         try{
             pass = input.getText();
             x++;
             System.out.println("Yes");
         } catch(Exception e) {
            System.out.println("Oppsie, try again");
    }} while(x == 1);}




    public static void main(String[] args) {
        launch(args);
    }
}

