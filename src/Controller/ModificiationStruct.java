package Controller;

public class ModificiationStruct extends InputStruct {
    public ModificiationStruct(String name, String surname, String birthDate, String email, String document,
                               String documentType, String address, String neighbourhood, String country,
                               String phoneNumber,String postalCode, String telephone2){
        super();
        this.formEntries.add(new FormEntry(name, 1));
        this.formEntries.add(new FormEntry(country, 4));
        this.formEntries.add(new FormEntry(neighbourhood, 5));
        this.formEntries.add(new FormEntry(address, 6));
        this.formEntries.add(new FormEntry(phoneNumber, 7));
        this.formEntries.add(new FormEntry(telephone2, 7));
        this.formEntries.add(new FormEntry(surname, 8));
        this.formEntries.add(new FormEntry(email, 9));
        this.formEntries.add(new FormEntry(documentType, 11));
        this.formEntries.add(new FormEntry(document, 12));
        this.formEntries.add(new FormEntry(birthDate, 13));
        this.formEntries.add(new FormEntry(postalCode, 14));
    }
}
