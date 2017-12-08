package Controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

public class InputController {
    public InputController(){

    }
    public int checkAll(InputStruct inputStruct){
        ArrayList<FormEntry> formEntries=inputStruct.getFormEntries();
        String password=null;
        for(FormEntry fe: formEntries){
            int code = fe.getCode();
            switch (code){
                case 1:
                    if(!checkUserName(fe.getString())) return 1;
                    break;
                case 2:
                    if(!checkUserUserName(fe.getString())) return 2;
                    break;
                case 3:
                    if(!checkUserPassword(fe.getString())) return 3;
                    if(password==null) {
                        password = fe.getString();
                    }else{
                        if(!password.equals(fe.getString())) return 3;
                    }
                    break;
                case 4:
                    if(!checkUserCountry(fe.getString())) return 4;
                    break;
                case 5:
                    if(!checkUserNeighbourhood(fe.getString())) return 5;
                    break;
                case 6:
                    if(!checkUserAddress(fe.getString())) return 6;
                    break;
                case 7:
                    if(!checkUserPhoneNumber(fe.getString())) return 7;
                    break;
                case 8:
                    if(!checkUserSurname(fe.getString())) return 8;
                    break;
                case 9:
                    if(!checkUserEmail(fe.getString())) return 9;
                    break;
                case 10:
                    if(!checkUserState(fe.getString())) return 10;
                    break;
                case 11:
                    if(!checkUserDocumentType(fe.getString())) return 11;
                    break;
                case 12:
                    if(!checkUserDocument(fe.getString())) return 12;
                    break;
                case 13:
                    if(!checkUserBirthDate(fe.getString())) return 13;
                    break;
                case 14:
                    if(!checkUserPostalCode(fe.getString())) return 14;
                    break;
                case 15:
                    if(!checkUserPassword(fe.getString())) return 15;
                    if(password==null) {
                        password = fe.getString();
                    }else{
                        if(!password.equals(fe.getString())) return 15;
                    }
                case 21:
                    if(!checkProductTitle(fe.getString())) return 21;
                    break;
                case 22:
                    if(!checkProductAmount(fe.getString())) return 22;
                    break;
                case 23:
                    if(!checkProductPrice(fe.getString())) return 23;
                    break;
                case 24:
                    if(!checkProductDescription(fe.getString())) return 24;
                    break;
                default:
                    throw new NotImplementedException();
            }
        }
        return 0;
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
}

