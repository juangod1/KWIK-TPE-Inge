package Controller;

import Model.Picture;

public class ProductStruct extends InputStruct {
    private Picture picture;
    public ProductStruct(String productName, Picture pic,  String productPrice, String productAmount, String description){
        super();
        picture=pic;
        this.formEntries.put(21,new FormEntry(productName, 21));
        this.formEntries.put(22,new FormEntry(productAmount, 22));
        this.formEntries.put(23,new FormEntry(productPrice, 23));
        this.formEntries.put(23,new FormEntry(description, 24));
    }
}
