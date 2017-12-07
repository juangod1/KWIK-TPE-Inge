package Controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class InputController {
    public InputController(){

    }
    public boolean checkAll(InputStruct inputStruct){
        ArrayList<FormEntry> formEntries=inputStruct.getFormEntries();
        for(FormEntry fe: formEntries){
            int code = fe.getCode();
            switch (code){
                case 1:
                    if(!checkUserDocument(fe.getString())) return false;
                    break;
                case 2:
                    if(!checkUserEmail(fe.getString())) return false;
                    break;
                case 3:
                    if(!checkUserPassword(fe.getString())) return false;
                    break;
                case 4:
                    if(!checkUserAddress(fe.getString())) return false;
                    break;
                case 5:
                    if(!checkUserBirthDate(fe.getString())) return false;
                    break;
                case 6:
                    if(!checkUserDocumentType(fe.getString())) return false;
                    break;
                case 7:
                    if(!checkUserNeighbourhood(fe.getString())) return false;
                    break;
                case 8:
                    if(!checkUserPhoneNumber(fe.getString())) return false;
                    break;
                case 9:
                    if(!checkUserPostalCode(fe.getString())) return false;
                    break;
                case 10:
                    if(!checkUserState(fe.getString())) return false;
                    break;
                case 11:
                    if(!checkProductAmount(fe.getString())) return false;
                    break;
                case 12:
                    if(!checkProductDescription(fe.getString())) return false;
                    break;
                case 13:
                    if(!checkProductPrice(fe.getString())) return false;
                    break;
                case 14:
                    if(!checkProductTitle(fe.getString())) return false;
                    break;
                default:
                    throw new NotImplementedException();
            }
        }
        return true;
    }
    private boolean isPositiveInteger(String str){
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    public boolean checkUserDocument(String dni){
        if(dni.length()!=8) return false;
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
            if(s.isEmpty()) return false;
        }
        return strs.length>1;

    }
    public boolean checkUserPhoneNumber(String phoneNumber){
        if(phoneNumber.length()!=8) return false;
        for (char c : phoneNumber.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
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
            return false;
        }
        return a>=0;
    }
    public boolean checkProductAmount(String amount){
        if(isPositiveInteger(amount)) return false;
        int i = Integer.parseInt(amount);
        return i>0;
    }
    public boolean checkProductDescription(String email){
        return true;
    }
}

