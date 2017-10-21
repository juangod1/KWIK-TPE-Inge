package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private HashMap<Product,Integer> products;
    private int ID;
    private User user;
    private boolean closed;
    private double subTotal;
    private Card card;
}
