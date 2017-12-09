package Controller;

import Model.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.Normalizer;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class InputController {
    public InputController(){

    }
    public int checkAll(InputStruct inputStruct){
        Set<Map.Entry<Integer, FormEntry>> formEntries=inputStruct.getFormEntries().entrySet();
        String password=null;
        for(Map.Entry<Integer,FormEntry> fe: formEntries){
            int code = fe.getValue().getCode();
            switch (code){
                case 1:
                    if(!checkUserName(fe.getValue().getString())) return 1;
                    break;
                case 2:
                    if(!checkUserUserName(fe.getValue().getString())) return 2;
                    break;
                case 3:
                    if(!checkUserPassword(fe.getValue().getString())) return 3;
                    if(password==null) {
                        password = fe.getValue().getString();
                    }else{
                        if(!password.equals(fe.getValue().getString())) return 3;
                    }
                    break;
                case 4:
                    if(!checkUserCountry(fe.getValue().getString())) return 4;
                    break;
                case 5:
                    if(!checkUserNeighbourhood(fe.getValue().getString())) return 5;
                    break;
                case 6:
                    if(!checkUserAddress(fe.getValue().getString())) return 6;
                    break;
                case 7:
                    if(!checkUserPhoneNumber(fe.getValue().getString())) return 7;
                    break;
                case 8:
                    if(!checkUserSurname(fe.getValue().getString())) return 8;
                    break;
                case 9:
                    if(!checkUserEmail(fe.getValue().getString())) return 9;
                    break;
                case 10:
                    if(!checkUserState(fe.getValue().getString())) return 10;
                    break;
                case 11:
                    if(!checkUserDocumentType(fe.getValue().getString())) return 11;
                    break;
                case 12:
                    if(!checkUserDocument(fe.getValue().getString())) return 12;
                    break;
                case 13:
                    if(!checkUserBirthDate(fe.getValue().getString())) return 13;
                    break;
                case 14:
                    if(!checkUserPostalCode(fe.getValue().getString())) return 14;
                    break;
                case 15:
                    if(!checkUserPassword(fe.getValue().getString())) return 15;
                    if(password==null) {
                        password = fe.getValue().getString();
                    }else{
                        if(!password.equals(fe.getValue().getString())) return 15;
                    }
                case 21:
                    if(!checkProductTitle(fe.getValue().getString())) return 21;
                    break;
                case 22:
                    if(!checkProductAmount(fe.getValue().getString())) return 22;
                    break;
                case 23:
                    if(!checkProductPrice(fe.getValue().getString())) return 23;
                    break;
                case 31:
                    if(!checkCardName(fe.getValue().getString())) return 31;
                    break;
                case 32:
                    if(!checkCardSurname(fe.getValue().getString())) return 32;
                    break;
                case 33:
                    if(!checkCardExpMonth(fe.getValue().getString())) return 33;
                    break;
                case 34:
                    if(!checkCardExpYear(fe.getValue().getString())) return 34;
                    break;
                case 35:
                    if(!checkCardSecurityNumber(fe.getValue().getString())) return 35;
                    break;
                case 36:
                    if(!checkCardNumber(fe.getValue().getString())) return 36;
                    break;
                default:
                    throw new NotImplementedException();
            }
        }
        return 0;
    }

    private boolean checkCardNumber(String string) {
        if(string.length()!=16){
            return false;
        }
        for(Character c : string.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private boolean checkCardExpYear(String string) {
        if(string.length()!=4){
            return false;
        }
        for(Character c : string.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        int year = Integer.parseInt(string);
        return year<2050 && year>2017;

    }

    private boolean checkCardExpMonth(String string) {
        if(string.length()!=2){
            return false;
        }
        for(Character c : string.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        int month = Integer.parseInt(string);
        return month<13 && month>0;
    }

    private boolean checkCardSurname(String string) {
        return !string.isEmpty();
    }
    private boolean checkCardName(String string) {
        return !string.isEmpty();
    }

    private boolean checkCardSecurityNumber(String string) {
        if(string.length()!=3){
            return false;
        }
        for (char c : string.toCharArray())
        {
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    public User addUser(UserCreationStruct userCreationStruct){
        String name= userCreationStruct.getFormEntries().get(1).getString();
        String userName= userCreationStruct.getFormEntries().get(2).getString();
        String password = userCreationStruct.getFormEntries().get(3).getString();
        Country country = null;// Country country = new Country(userCreationStruct.getFormEntries().get(4);
        City city = null;// City city = userCreationStruct.getFormEntries().get(5);
        String address = userCreationStruct.getFormEntries().get(6).getString();
        String phoneNumber = userCreationStruct.getFormEntries().get(7).getString();
        String surname = userCreationStruct.getFormEntries().get(8).getString();
        String email = userCreationStruct.getFormEntries().get(9).getString();
        Province province = null;// Province province= userCreationStruct.getFormEntries().get(10);
        DocType doctype = null;// DocType doctype = userCreationStruct.getFormEntries().get(11);
        String docNumber = userCreationStruct.getFormEntries().get(12).getString();
        String postalcode = userCreationStruct.getFormEntries().get(14).getString();
        String telephone2 = userCreationStruct.getFormEntries().get(16).getString();
        boolean enabled = true;
        boolean confirmado = true;
        boolean admin = false;
        Cart cart = null;
        return User.create(docNumber,userName,password,name,surname,email,enabled,confirmado,admin,doctype,cart,country,
                city,province,address,postalcode,phoneNumber,telephone2);

    }

    private boolean checkUserSurname(String surname) {
        return !surname.isEmpty();
    }

    private boolean checkUserCountry(String country) {
        return !country.isEmpty();
    }

    private boolean isPositiveInteger(String str){
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    public boolean checkUserName(String name){
        return !name.isEmpty();
    }
    public boolean checkUserUserName(String username){
        return !username.isEmpty();
    }
    public boolean checkUserDocument(String dni){
        if(dni.length()!=8){
            return false;
        }
        System.out.println(true);
        return isPositiveInteger(dni);
    }
    public boolean checkUserEmail(String email){
        String[] strs= email.split("@");
        return (strs.length==2 && !strs[0].isEmpty() && !strs[1].isEmpty());
    }
    public boolean checkUserPassword(String password){
        return !password.isEmpty();

    }
    public boolean checkUserNeighbourhood(String neighbourhood){
        return !neighbourhood.isEmpty();
    }
    public boolean checkUserAddress(String address){

        String[] strs= address.split(" ");
        for (String s: strs){
            if(s.isEmpty()){
                return false;
            }
        }
        return strs.length>1;

    }
    public boolean checkUserPhoneNumber(String phoneNumber){
        if(phoneNumber.length()!=8){
            return false;
        }
        for (char c : phoneNumber.toCharArray())
        {
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;

    }
    public boolean checkUserState(String state){
        return !state.isEmpty();
    }
    public boolean checkUserPostalCode(String postalCode){
        return !postalCode.isEmpty();

    }
    public boolean checkUserDocumentType(String documentType){
        return documentType.equals("DNI");
    }
    public boolean checkUserBirthDate(String birthDate){
        String[] strs = birthDate.split("/");
        if(strs.length!=3 || isPositiveInteger(strs[0]) || isPositiveInteger(strs[1]) || isPositiveInteger(strs[2])) return false;
        int int1=Integer.parseInt(strs[0]);
        int int2=Integer.parseInt(strs[1]);
        int int3=Integer.parseInt(strs[2]);
        return (int1<32 && int1>0 && int2<13 && int2>0 && int3>1900 && int3<2018);
    }
    public boolean checkProductTitle(String title){
        return !title.isEmpty();
    }
    public boolean checkProductPrice(String price){
        double a;
        try
        {
            a=Double.parseDouble(price);
        }
        catch(NumberFormatException e)
        {
            System.out.println(false);
            return false;
        }
        System.out.println(a>=0);
        return a>=0;
    }
    public boolean checkProductAmount(String amount){
        if(isPositiveInteger(amount)){
            System.out.println(false);
            return false;
        }
        int i = Integer.parseInt(amount);
        System.out.println(i>0);
        return i>0;
    }
    public boolean checkProductDescription(String email){
        return true;
    }

    public void addCard(CardStruct cardStruct) {
        User user = null;
        String name = cardStruct.getFormEntries().get(31).getString();
        String surname = cardStruct.getFormEntries().get(32).getString();
        String number = cardStruct.getFormEntries().get(36).getString();
        int month = Integer.parseInt(cardStruct.getFormEntries().get(33).getString());
        int year = Integer.parseInt(cardStruct.getFormEntries().get(34).getString());
        int code = Integer.parseInt(cardStruct.getFormEntries().get(35).getString());

        Card.create(user, name, surname, number, month, year, code);
    }
}

