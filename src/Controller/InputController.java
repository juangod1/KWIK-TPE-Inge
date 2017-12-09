package Controller;

import Model.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.Normalizer;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class InputController {
    private Controller controller;
    public InputController(Controller controller){
        this.controller=controller;
    }
    public Controller getController(){
        return controller;
    }
    public int checkAll(InputStruct inputStruct){
        Set<Map.Entry<Integer, MyEntry>> formEntries=inputStruct.getFormEntries().entrySet();
        String password=null;
        for(Map.Entry<Integer,MyEntry> fe: formEntries){
            int code = fe.getValue().getCode();
            switch (code){
                case 1:
                    if(!checkUserName((String)fe.getValue().getItem())) return 1;
                    break;
                case 2:
                    if(!checkUserUserName((String)fe.getValue().getItem())) return 2;
                    break;
                case 3:
                    if(!checkUserPassword((String)fe.getValue().getItem())) return 3;
                    if(password==null) {
                        password = (String)fe.getValue().getItem();
                    }else{
                        if(!password.equals((String)fe.getValue().getItem())) return 3;
                    }
                    break;
                case 4:
                    if(!checkUserCountry(((Country)fe.getValue().getItem()).getName())) return 4;
                    break;
                case 5:
                    if(!checkUserNeighbourhood(((City)(fe.getValue().getItem())).getName())) return 5;
                    break;
                case 6:
                    if(!checkUserAddress((String)fe.getValue().getItem())) return 6;
                    break;
                case 7:
                    if(!checkUserPhoneNumber((String)fe.getValue().getItem())) return 7;
                    break;
                case 8:
                    if(!checkUserSurname((String)fe.getValue().getItem())) return 8;
                    break;
                case 9:
                    if(!checkUserEmail((String)fe.getValue().getItem())) return 9;
                    break;
                case 10:
                    if(!checkUserState(((Province)(fe.getValue().getItem())).getName())) return 10;
                    break;
                case 11:
                    if(!checkUserDocumentType((String)fe.getValue().getItem())) return 11;
                    break;
                case 12:
                    if(!checkUserDocument((String)(fe.getValue().getItem()))) return 12;
                    break;
                case 13:
                    if(!checkUserBirthDate((String)fe.getValue().getItem())) return 13;
                    break;
                case 14:
                    if(!checkUserPostalCode((String)fe.getValue().getItem())) return 14;
                    break;
                case 15:
                    if(!checkUserPassword((String)fe.getValue().getItem())) return 15;
                    if(password==null) {
                        password = (String)fe.getValue().getItem();
                    }else{
                        if(!password.equals(fe.getValue().getItem())) return 15;
                    }
                case 21:
                    if(!checkProductTitle((String)fe.getValue().getItem())) return 21;
                    break;
                case 22:
                    if(!checkProductAmount((String)fe.getValue().getItem())) return 22;
                    break;
                case 23:
                    if(!checkProductPrice((String)fe.getValue().getItem())) return 23;
                    break;
                case 24:
                    if(!checkProductDescription((String)fe.getValue().getItem())) return 24;
                    break;
                case 31:
                    if(!checkCardName((String)fe.getValue().getItem())) return 31;
                    break;
                case 32:
                    if(!checkCardSurname((String)fe.getValue().getItem())) return 32;
                    break;
                case 33:
                    if(!checkCardExpMonth((String)fe.getValue().getItem())) return 33;
                    break;
                case 34:
                    if(!checkCardExpYear((String)fe.getValue().getItem())) return 34;
                    break;
                case 35:
                    if(!checkCardSecurityNumber((String)fe.getValue().getItem())) return 35;
                    break;
                case 36:
                    if(!checkCardNumber((String)fe.getValue().getItem())) return 36;
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
        String name= (String)userCreationStruct.getFormEntries().get(1).getItem();
        String userName= (String)userCreationStruct.getFormEntries().get(2).getItem();
        String password = (String)userCreationStruct.getFormEntries().get(3).getItem();
        Country country = (Country)userCreationStruct.getFormEntries().get(4).getItem();// Country country = new Country(userCreationStruct.getFormEntries().get(4);
        City city = (City)userCreationStruct.getFormEntries().get(5).getItem();
        String address = (String)userCreationStruct.getFormEntries().get(6).getItem();
        String phoneNumber = (String)userCreationStruct.getFormEntries().get(7).getItem();
        String surname = (String)userCreationStruct.getFormEntries().get(8).getItem();
        String email = (String)userCreationStruct.getFormEntries().get(9).getItem();
        Province province = (Province) userCreationStruct.getFormEntries().get(10).getItem();
        DocType doctype =  DocType.list().get(0);
        String docNumber = (String)userCreationStruct.getFormEntries().get(12).getItem();
        String postalcode = (String)userCreationStruct.getFormEntries().get(14).getItem();
        String telephone2 = (String)userCreationStruct.getFormEntries().get(16).getItem();
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
        catch(NumberFormatException e){
            return false;
        }
        return a>=0;
    }
    public boolean checkProductAmount(String amount){
        if(!isPositiveInteger(amount)){
            return false;
        }
        int i = Integer.parseInt(amount);
        return i>0;
    }
    public boolean checkProductDescription(String email){
        return true;
    }

    public void addCard(CardStruct cardStruct) {
        User user = null;
        String name = (String)cardStruct.getFormEntries().get(31).getItem();
        String surname = (String)cardStruct.getFormEntries().get(32).getItem();
        String number = (String)cardStruct.getFormEntries().get(36).getItem();
        int month = Integer.parseInt((String)cardStruct.getFormEntries().get(33).getItem());
        int year = Integer.parseInt((String)cardStruct.getFormEntries().get(34).getItem());
        int code = Integer.parseInt((String)cardStruct.getFormEntries().get(35).getItem());

        Card.create(user, name, surname, number, month, year, code);
    }

    public User modifyUser(UserCreationStruct userCreationStruct, User currentUser) {
        currentUser.delete();
        User u = addUser(userCreationStruct);
        getController().setUser(u);
        return u;
    }
}

