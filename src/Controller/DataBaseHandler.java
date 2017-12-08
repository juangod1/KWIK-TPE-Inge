package Controller;

import Model.Card;
import Model.Cart;
import Model.Product;
import Model.*;

import java.util.ArrayList;

public class DataBaseHandler {
    private String url;
    private User user;
    private Model model;

    public DataBaseHandler(Model model){
        this.model = model;
    }

    public void initialize(){
        //sacar to-do de la bd
    }

    public void updateProduct(){

    }

    public void updateUser(){

    }

    public void updateCart(){

    }

    public void updateCard(){

    }

    public boolean checkLogin(String username, String password){
        //pedir de la bd
        return true;
    }
}
