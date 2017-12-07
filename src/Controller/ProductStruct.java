package Controller;

import Model.Picture;

public class ProductStruct extends InputStruct {
    private Picture picture;
    public ProductStruct(String productName, Picture pic,  String productPrice, String productAmount, String description){
        super();
        picture=pic;
        this.formEntries.add(new FormEntry(productName, 21));
        this.formEntries.add(new FormEntry(productAmount, 22));
        this.formEntries.add(new FormEntry(productPrice, 23));
        this.formEntries.add(new FormEntry(description, 24));
    }
}
