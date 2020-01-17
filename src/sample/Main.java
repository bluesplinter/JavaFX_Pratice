package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;


import java.util.Scanner;


public class Main extends Application {
    Stage window;
    String pass = "name";

    ComboBox<String> dogs;
    ListView<String> bikes;
    TreeView<String> pokemon_tree;
    TableView<Memes> meme_table;

    TextField dog_User;
    TextField meme_name_input, meme_age_input, meme_rating_input, meme_about_input;
    Parent root;
    Scene loglog_scene, dogAdoption_scene, rateBrand_scene, MainMenu_scene, select_bike_scene, pokedex_scene, meme_tale_scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;


        //=========================Main Menu=================================================
        //Dog Adoption
        Label mm_dog = new Label("Adopts Dogs");
        GridPane.setConstraints(mm_dog, 0, 0);

        Button mm_butt_adopt = new Button("Adopt!");
        mm_butt_adopt.setOnAction(e -> window.setScene(dogAdoption_scene));
        GridPane.setConstraints(mm_butt_adopt, 1, 0);

        //Rate Brands
        Label mm_rateBrands_label = new Label("Rate Brands");
        GridPane.setConstraints(mm_rateBrands_label, 0, 1);

        Button mm_butt_rate = new Button("Rate!");
        mm_butt_rate.setOnAction(e -> window.setScene(rateBrand_scene));
        GridPane.setConstraints(mm_butt_rate, 1, 1);

        //Buy Bikes
        Label mm_bikes_label = new Label("Buy Bikes");
        GridPane.setConstraints(mm_bikes_label, 0, 2);

        Button mm_bikes_butt = new Button("Buy!");
        mm_bikes_butt.setOnAction(e -> window.setScene(select_bike_scene));
        GridPane.setConstraints(mm_bikes_butt, 1, 2);

        //Pokedex
        Label mm_pokedex_label = new Label("Pokedex");
        GridPane.setConstraints(mm_pokedex_label, 0, 3);

        Button mm_pokedex_butt = new Button("View Pokedex!");
        mm_pokedex_butt.setOnAction(e -> window.setScene(pokedex_scene));
        GridPane.setConstraints(mm_pokedex_butt, 1, 3);

        Label mm_meme_label = new Label("Memes");
        GridPane.setConstraints(mm_meme_label, 0, 4);

        Button mm_meme_butt = new Button("View Memes!");
        mm_meme_butt.setOnAction(e -> window.setScene(meme_tale_scene));
        GridPane.setConstraints(mm_meme_butt, 1, 4);


        //=========================TextField=================================================
        //Username Label
        Label username_label = new Label("Username: ");
        GridPane.setConstraints(username_label, 0, 0);

        // Username input
        TextField username_tf = new TextField();
        username_tf.setPromptText("Type username");
        GridPane.setConstraints(username_tf, 1, 0);


        //Password Label
        Label password_label = new Label("Password: ");
        GridPane.setConstraints(password_label, 0, 1);


        //Text field Password
        TextField password_tf = new TextField();
        GridPane.setConstraints(password_tf, 1, 1);

        //Log in Button
        Button log_in = new Button("Log in");
        GridPane.setConstraints(log_in, 0, 2);
        log_in.setOnAction(e -> window.setScene(MainMenu_scene));


        //========================CheckBox Rating==================================================
        //Checkbox
        CheckBox email = new CheckBox("Email");
        CheckBox paypal = new CheckBox("PayPal");
        CheckBox github = new CheckBox("GitHub");

        Button check = new Button("Check");
        check.setOnAction(e -> checking(email, paypal, github));
        GridPane.setConstraints(check, 50, 0);

        //VBox for Checkbox
        VBox checkbox_choise = new VBox();
        checkbox_choise.getChildren().addAll(email, paypal, github);
        checkbox_choise.setAlignment(Pos.TOP_LEFT);
        GridPane.setConstraints(checkbox_choise, 50, 1);


        //========================Drop-Down Menu Rating ==================================================
        //Drop-down menu
        ChoiceBox<String> subject = new ChoiceBox<>();
        subject.getItems().addAll("PayPal", "Email", "Form", "Illegal", "Legal", "Noice");
        GridPane.setConstraints(subject, 0, 0);
        subject.setValue("PayPal");


        //Rating dropdown
        ChoiceBox<String> rating = new ChoiceBox<>();
        rating.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        GridPane.setConstraints(rating, 5, 0);


        //Drop-down select without Button
        ChoiceBox<String> rating_upgrade = new ChoiceBox<>();

        rating_upgrade.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        GridPane.setConstraints(rating_upgrade, 1, 0);


        //Drop-down menu button
        Button subject_dropdown = new Button("Rate!");
        subject_dropdown.setOnAction(e -> getChoise(subject, rating_upgrade));
        GridPane.setConstraints(subject_dropdown, 1, 1);


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


        //========================ListView Buy Bikes ==================================================
        bikes = new ListView<>();
        bikes.getItems().addAll("Mountain Bike", "Hybrid Comfort", "Electric Bike", "Road Bike", "Triathlon/Time Trial Bike",
                "BMX Bike", "Cyclocross Bike", "Track Bike/Fixed Gear", "Tandem", "Adult Trike", "Folding Bike", "Kids Bike",
                "Beach Cruiser", "Recumbent", "Normal", "Any", "The one", "The one you ride on", "Horse", "Goat");
        bikes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        GridPane.setConstraints(bikes, 0, 5);

        Button buy_bikes = new Button("Buy");
        buy_bikes.setOnAction(e -> bikes_bought());
        GridPane.setConstraints(buy_bikes, 5, 30);


        //===============================Pokemon===========================================
        TreeItem<String> pokemon, fire, grass, water;

        //Pokemon Root
        pokemon = new TreeItem<>("Pokemon");
        pokemon.setExpanded(false);

        //Fire Branch
        fire = makeBranch("Fire Types", pokemon);
        makeBranch("Charmender", fire);
        makeBranch("Ninetales", fire);
        makeBranch("Growlithe", fire);
        makeBranch("Ponyta", fire);
        makeBranch("Magnar", fire);
        makeBranch("Cyndaquil", fire);
        makeBranch("Slugma", fire);
        makeBranch("Torchic", fire);
        makeBranch("Torkoal", fire);
        makeBranch("Fennekin", fire);
        makeBranch("Scorbunny", fire);
        makeBranch("Litten", fire);
        makeBranch("Darumaka", fire);
        makeBranch("Tepig", fire);
        makeBranch("Magmortar", fire);
        makeBranch("Chimchar", fire);
        fire.setExpanded(false);

        //Water Branch
        water = makeBranch("Grass Type", pokemon);
        makeBranch("Golduck", water);
        makeBranch("Poliwag", water);
        makeBranch("Magicarp", water);
        makeBranch("Azumarill", water);
        makeBranch("Kabuto", water);
        makeBranch("Lapras", water);
        makeBranch("Lotad", water);
        makeBranch("Mantine", water);
        makeBranch("Slowpoke", water);
        makeBranch("Slowking", water);
        makeBranch("Staryu", water);
        makeBranch("Piplup", water);
        water.setExpanded(false);

        //grass Branch
        grass = makeBranch("Water Type", pokemon);
        makeBranch("Budew", grass);
        makeBranch("Treeko", grass);
        makeBranch("Pansage", grass);
        makeBranch("Snivy", grass);
        makeBranch("Lombre", grass);
        makeBranch("Sunflora", grass);
        makeBranch("Lotad", grass);
        makeBranch("Grotel", grass);
        makeBranch("Shymin", grass);
        makeBranch("Petilil", grass);
        makeBranch("Rowlet", grass);
        makeBranch("Formantis", grass);
        grass.setExpanded(false);

        pokemon_tree = new TreeView<>(pokemon);
        pokemon_tree.setShowRoot(true);
        pokemon_tree.getSelectionModel().selectedItemProperty().
                addListener((v, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println("This is a Pokemon!!!!");
                });


        //===============================       Memes     ===========================================

        //Meme Name Column
        TableColumn<Memes, String> meme_name = new TableColumn<>("Meme");
        meme_name.setMinWidth(300);
        meme_name.setCellValueFactory(new PropertyValueFactory<>("meme"));

        //Meme Date Column
        TableColumn<Memes, Integer> meme_time = new TableColumn<>("Date");
        meme_time.setMinWidth(75);
        meme_time.setCellValueFactory(new PropertyValueFactory<>("date"));

        //Meme Rating Column
        TableColumn<Memes, Double> meme_rating = new TableColumn<>("Rating");
        meme_rating.setMinWidth(75);
        meme_rating.setCellValueFactory(new PropertyValueFactory<>("rating"));

        TableColumn<Memes, Double> meme_about = new TableColumn<>("About");
        meme_about.setMinWidth(600);
        meme_about.setCellValueFactory(new PropertyValueFactory<>("about"));


        //Meme's Text Field
        meme_name_input = new TextField();
        meme_name_input.setPromptText("Name of Meme");
        meme_name_input.setMinWidth(300);

        meme_age_input = new TextField();
        meme_age_input.setPromptText("Meme's Birth");
        meme_age_input.setMinWidth(75);

        meme_rating_input = new TextField();
        meme_rating_input.setPromptText("Rating");
        meme_rating_input.setMinWidth(75);

        meme_about_input = new TextField();
        meme_about_input.setPromptText("Write about this me here...");
        meme_about_input.setMinWidth(910);
        meme_about_input.setMinHeight(100);
        meme_about_input.setAlignment(Pos.TOP_LEFT);

        meme_table = new TableView<>();
        meme_table.setItems(meme_generater());
        meme_table.getColumns().addAll(meme_name, meme_time, meme_rating, meme_about);


        //Meme's Button
        Button add_meme = new Button("Add Meme!!");
        add_meme.setOnAction(e -> add_meme_butt_clicked());

        Button delete_meme = new Button("Delete...");
        delete_meme.setOnAction(e -> delete_meme_butt_clicked());

        Button back_meme = new Button("<< Back");
        back_meme.setOnAction(e -> window.setScene(MainMenu_scene));

        HBox meme_lay2 = new HBox();
        meme_lay2.setPadding(new Insets(10, 10, 10, 10));
        meme_lay2.setSpacing(10);
        meme_lay2.getChildren().addAll(meme_name_input, meme_age_input, meme_rating_input, add_meme, delete_meme, back_meme);

        HBox meme_about_lay = new HBox();
        meme_about_lay.setPadding(new Insets(10, 10, 10, 10));
        meme_about_lay.setAlignment(Pos.BOTTOM_CENTER);
        meme_about_lay.setSpacing(10);
        meme_about_lay.getChildren().addAll(meme_about_input);


        //===============================For All===========================================
        Button Log_out = new Button("<< Log Out");
        Log_out.setOnAction(e -> window.setScene(loglog_scene));
        GridPane.setConstraints(Log_out, 0, 30);

        Button back_brand = new Button("<< Back");
        back_brand.setOnAction(e -> window.setScene(MainMenu_scene));
        GridPane.setConstraints(back_brand, 0, 30);

        Button back_adoption = new Button("<< Back");
        back_adoption.setOnAction(e -> window.setScene(MainMenu_scene));
        GridPane.setConstraints(back_adoption, 0, 30);

        Button back_bikes = new Button("<< Back");
        back_bikes.setOnAction(e -> window.setScene(MainMenu_scene));
        GridPane.setConstraints(back_bikes, 0, 30);

        Button back_pokemon = new Button("<< Back");
        back_pokemon.setOnAction(e -> window.setScene(MainMenu_scene));
        GridPane.setConstraints(back_pokemon, 0, 15);




        //Layouts and Grid

        GridPane LogIn_lay = new GridPane();
        LogIn_lay.setPadding(new Insets(10, 10, 10, 10));
        LogIn_lay.setVgap(10);
        LogIn_lay.setHgap(10);

        GridPane dog_adoption_lay = new GridPane();
        dog_adoption_lay.setPadding(new Insets(10, 10, 10, 10));
        dog_adoption_lay.setHgap(10);
        dog_adoption_lay.setVgap(10);

        GridPane rate_brand_lay = new GridPane();
        rate_brand_lay.setPadding(new Insets(10, 10, 10, 10));
        rate_brand_lay.setHgap(10);
        rate_brand_lay.setVgap(10);

        GridPane main_menu_lay = new GridPane();
        main_menu_lay.setPadding(new Insets(10, 10, 10, 10));
        main_menu_lay.setHgap(10);
        main_menu_lay.setVgap(10);

        GridPane selection_bikes_lay = new GridPane();
        selection_bikes_lay.setPadding(new Insets(10, 10, 10, 10));
        selection_bikes_lay.setHgap(10);
        selection_bikes_lay.setVgap(10);

        GridPane poke_tree_lay = new GridPane();
        poke_tree_lay.setPadding(new Insets(10, 10, 10, 10));
        poke_tree_lay.setHgap(10);
        poke_tree_lay.setVgap(10);

        VBox meme_grid_lay = new VBox();


        LogIn_lay.getChildren().addAll(username_label, username_tf, password_label, password_tf, log_in);

        dog_adoption_lay.getChildren().addAll(dog_user_label, dogs, submit_dogs, dog_User, back_adoption, dog_breed_label);

        rate_brand_lay.getChildren().addAll(subject, rating_upgrade, subject_dropdown, back_brand);

        main_menu_lay.getChildren().addAll(mm_butt_adopt, mm_butt_rate, mm_dog, mm_rateBrands_label, Log_out, mm_bikes_butt,
                mm_pokedex_butt, mm_pokedex_label, mm_bikes_label, mm_meme_label, mm_meme_butt);

        selection_bikes_lay.getChildren().addAll(buy_bikes, bikes, back_bikes);

        poke_tree_lay.getChildren().addAll(pokemon_tree, back_pokemon);

        meme_grid_lay.getChildren().addAll(meme_table, meme_lay2, meme_about_lay);


        loglog_scene = new Scene(LogIn_lay, 500, 500);
        dogAdoption_scene = new Scene(dog_adoption_lay, 500, 500);
        rateBrand_scene = new Scene(rate_brand_lay, 500, 500);
        MainMenu_scene = new Scene(main_menu_lay, 500, 500);
        select_bike_scene = new Scene(selection_bikes_lay, 500, 500);
        pokedex_scene = new Scene(poke_tree_lay, 500, 500);
        meme_tale_scene = new Scene(meme_grid_lay, 1010, 500);


        window.setScene(loglog_scene);
        window.setTitle("Password Com");
        window.show();

    }
    //=========================================================================================================================================
    //=========================================================================================================================================
    //=========================================================================================================================================
    //===============================================       METHODS        =====================================================================
    //=========================================================================================================================================
    //=========================================================================================================================================
    //=========================================================================================================================================


    //Branchs Method for Pokemon
    public TreeItem<String> makeBranch(String type, TreeItem<String> parent) {

        TreeItem<String> poke_type = new TreeItem<>(type);
        poke_type.setExpanded(true);
        parent.getChildren().add(poke_type);
        return poke_type;


    }

    //============================Bikes Method==============================================
    private void bikes_bought() {
        String message = "";
        ObservableList<String> bike;
        bike = this.bikes.getSelectionModel().getSelectedItems();

        for (String b : bike) {
            message += b + "\n";
        }
        System.out.println("Bikes Bought : \n" + message);
    }

    //=============================App Rating=============================================
    //Drop-down
    private void getChoise(ChoiceBox<String> username_drop, ChoiceBox<String> my_rating) {
        String dropbox = username_drop.getValue();
        String rate = my_rating.getValue();
        System.out.println("You rated " + "'" + dropbox + "' " + rate + " stars");
    }

    //==========================================================================
    //Checkbox
    private void checking(CheckBox email, CheckBox PayPal, CheckBox github) {
        String message = "";
        if (email.isSelected())
            message += "Email password is :\nDittofe218\n";

        if (PayPal.isSelected())
            message += "PayPal password is :\nGoi2@#rf\n";

        if (github.isSelected())
            message += "GitHub password is :\n1ne0nLIUB081\n";

        System.out.println(message);

    }

    //==========================================================================
    // Normal
    private void corrects_pw(TextField input) {
        Scanner passcode = new Scanner(System.in);

        int x = 1;
        do {
            try {
                pass = input.getText();
                x++;
                System.out.println("Yes");
            } catch (Exception e) {
                System.out.println("Oppsie, try again");
            }
        } while (x == 1);
    }


    //============================= Memes Method =============================================
    public ObservableList<Memes> meme_generater() {

        ObservableList<Memes> meme_table = FXCollections.observableArrayList();
        meme_table.add(new Memes("Baby Yoda", 2019, 6.0, "This meme surged 2019 on the launch of star wars and contains baby Yoda being cute."));
        meme_table.add(new Memes("Damn Daniel", 2014, 9.0, "This meme surged in 2014 and includes a friend saying to his other friend 'DAMN DANIEL'"));
        meme_table.add(new Memes("Joker Meme", 2019, 7.0, "This meme surged after the Joker movie in 2019 and contains Joker dancing"));
        meme_table.add(new Memes("Michael Jackson Eating popcorn", 2016, 3.0, "This meme surged in 2016 and shows Michael Jackson eating popcorn"));
        meme_table.add(new Memes("Ice Bucket Challenge", 2015, 8.0, "The ice bucket meme surged in 2015. You woulf through water on yourself and challenge friends"));
        meme_table.add(new Memes("Nick Young", 2013, 8.0, "This meme surged in 2013 and is a picture of Nick Young being confused"));
        meme_table.add(new Memes("Keanu Reeves", 2017, 10.0, "This meme surged in 2017 and shows Keanu Reeves saying 'YOU ARE BREATHTAKING' to someone"));
        return meme_table;
    }

    //Add meme Method
    public void add_meme_butt_clicked() {
        Memes create_meme = new Memes();

        create_meme.setMeme(meme_name_input.getText());
        create_meme.setAbout(meme_about_input.getText());

        try {
            create_meme.setDate(Integer.parseInt(meme_age_input.getText()));
        } catch (Exception e) {
            System.out.println("That's not a year\n");
        }

        try {
            create_meme.setRating(Double.parseDouble(meme_rating_input.getText()));
        } catch (Exception e) {
            System.out.println("Please put in a rating with a decimal\n");
        }

        meme_table.getItems().add(create_meme);
        meme_about_input.clear();
        meme_age_input.clear();
        meme_name_input.clear();
        meme_rating_input.clear();
    }

    public void delete_meme_butt_clicked() {
        ObservableList<Memes> meme_selected, all_memes;
        all_memes = meme_table.getItems();
        meme_selected = meme_table.getSelectionModel().getSelectedItems();

        meme_selected.forEach(all_memes::remove);
    }


    public static void main(String[] args) {
        launch(args);
    }
}


