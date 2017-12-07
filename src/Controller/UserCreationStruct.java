package Controller;

public class UserCreationStruct extends InputStruct {
    public UserCreationStruct(String name, String userName, String password, String country, String neighbourhood,
    String address, String phoneNumber, String surname, String email, String confirmPassword, String state,
                              String postalCode, String documentType, String document, String telephone2){
        super();
        this.formEntries.add(new FormEntry(name, 1));
        this.formEntries.add(new FormEntry(userName, 2));
        this.formEntries.add(new FormEntry(password, 3));
        this.formEntries.add(new FormEntry(country, 4));
        this.formEntries.add(new FormEntry(neighbourhood, 5));
        this.formEntries.add(new FormEntry(address, 6));
        this.formEntries.add(new FormEntry(phoneNumber, 7));
        this.formEntries.add(new FormEntry(telephone2, 7));
        this.formEntries.add(new FormEntry(surname, 8));
        this.formEntries.add(new FormEntry(email, 9));
        this.formEntries.add(new FormEntry(state, 10));
        this.formEntries.add(new FormEntry(documentType, 11));
        this.formEntries.add(new FormEntry(document, 12));
        this.formEntries.add(new FormEntry(postalCode, 14));
        this.formEntries.add(new FormEntry(confirmPassword, 15));
    }
}
