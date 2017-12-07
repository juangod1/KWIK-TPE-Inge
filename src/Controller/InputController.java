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
                    if(!checkUserDNI(fe.getString())) return false;
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
                    if(!checkUserDNIType(fe.getString())) return false;
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
    public boolean checkUserDNI(String dni){

    }
    public boolean checkUserEmail(String email){

    }
    public boolean checkUserPassword(String email){

    }
    public boolean checkUserNeighbourhood(String email){

    }
    public boolean checkUserAddress(String email){

    }
    public boolean checkUserPhoneNumber(String email){

    }
    public boolean checkUserState(String email){

    }
    public boolean checkUserPostalCode(String email){

    }
    public boolean checkUserDNIType(String email){

    }
    public boolean checkUserBirthDate(String email){

    }
    public boolean checkProductTitle(String email){

    }
    public boolean checkProductPrice(String email){

    }
    public boolean checkProductAmount(String email){

    }
    public boolean checkProductDescription(String email){

    }
}

