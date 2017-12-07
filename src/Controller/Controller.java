package Controller;

import Model.Model;

public class Controller {
    private DataBaseHandler dBH;
    private Model model;

    public static void main(String[] args){
        Controller controller = new Controller();
    }

    public Controller(){
        dBH = new DataBaseHandler(model);
        dBH.initialize();
    }
}
