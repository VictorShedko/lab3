package sample.create;
import sample.veiv.View;

public class CreateUi {

    public static void generateWindow(String[] args){

        View myView= new View();
        myView.launch(View.class, args);


    }

}