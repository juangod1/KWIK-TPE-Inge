package Controller;

public class ModificiationStruct extends InputStruct {
    public ModificiationStruct(String name, String surname, String birthDate, String email, String document,
                               String documentType, String address, String neighbourhood, String country,
                               String phoneNumber,String postalCode, String telephone2){
        super();
        this.formEntries.put(1,new FormEntry(name, 1));
        this.formEntries.put(3,new FormEntry(country, 4));
        this.formEntries.put(4,new FormEntry(neighbourhood, 5));
        this.formEntries.put(6,new FormEntry(address, 6));
        this.formEntries.put(7,new FormEntry(phoneNumber, 7));
        this.formEntries.put(16,new FormEntry(telephone2, 16));
        this.formEntries.put(8,new FormEntry(surname, 8));
        this.formEntries.put(9,new FormEntry(email, 9));
        this.formEntries.put(11,new FormEntry(documentType, 11));
        this.formEntries.put(12,new FormEntry(document, 12));
        this.formEntries.put(13,new FormEntry(birthDate, 13));
        this.formEntries.put(14,new FormEntry(postalCode, 14));
    }
}
