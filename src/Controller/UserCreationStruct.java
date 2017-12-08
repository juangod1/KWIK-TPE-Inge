package Controller;

public class UserCreationStruct extends InputStruct {
    public UserCreationStruct(String name, String userName, String password, String country, String neighbourhood,
    String address, String phoneNumber, String surname, String email, String confirmPassword, String state,
                              String postalCode, String documentType, String document, String telephone2){
        super();
        this.formEntries.put(1,new FormEntry(name, 1));
        this.formEntries.put(2,new FormEntry(userName, 2));
        this.formEntries.put(3,new FormEntry(password, 3));
        this.formEntries.put(3,new FormEntry(country, 4));
        this.formEntries.put(4,new FormEntry(neighbourhood, 5));
        this.formEntries.put(6,new FormEntry(address, 6));
        this.formEntries.put(7,new FormEntry(phoneNumber, 7));
        this.formEntries.put(8,new FormEntry(surname, 8));
        this.formEntries.put(9,new FormEntry(email, 9));
        this.formEntries.put(10,new FormEntry(state, 10));
        this.formEntries.put(11,new FormEntry(documentType, 11));
        this.formEntries.put(12,new FormEntry(document, 12));
        this.formEntries.put(14,new FormEntry(postalCode, 14));
        this.formEntries.put(15,new FormEntry(confirmPassword, 15));
        this.formEntries.put(16,new FormEntry(telephone2, 7));
    }
}
