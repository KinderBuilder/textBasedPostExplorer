//Import the package first always
package com.postserver.Account;
import java.util.ArrayList;

import com.postserver.Exceptions.AccountExceptions;

import com.postserver.Database;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class AccountService {
    private ArrayList<Account> database;
    public AccountService(){
        //there may be other database, so this.data is this file's dataase
        this.database = new ArrayList<Account>();
        this.database.add(new Account("Temie", "Tobby", "Catis", "IHaveHats", "It is I...ME!", "mesa@totallyNotAFakeEmail.com", "555-909-9090", 3, 3, 3));
    }
    public ArrayList<Account> getAcounts(){
        return(this.database);
    }
    public boolean makeAccount(Account a)throws AccountExceptions{
        //defining username restrictions
        if(a.getUserName().length()<=4||a.getUserName().length()>=30){
            System.out.println("Username is too short or too long");
            throw new AccountExceptions("Username is too short or too long");
        }
        for(int x =0; x<a.getUserName().length();x++){
            if((a.getUserName().charAt(x)<65 || a.getUserName().charAt(x)>90)&&(a.getUserName().toLowerCase().charAt(x)< 97 || a.getUserName().toLowerCase().charAt(x)>122)){
                System.out.println("Username cannot be anything other than a number or a letter"); 
                throw new AccountExceptions("Username cannot be anything other than a number or a letter");
            }
        }
        //checks for empty first and last name
        if(a.getFirstName().length()==0){
            System.out.println("First Name is blank");
            throw new AccountExceptions("First Name is blank");
        }
        if(a.getLastName().length()==0){
            System.out.println("Last Name is blank");
            throw new AccountExceptions("Last Name is blank");
        }
        //password
        if(a.getPassword().length()<8||a.getPassword().length()>16){
             System.out.println("Password is either too long or too short");
             throw new AccountExceptions("Password is either too long or too short");
            }
        for(int x=0; x<a.getPassword().length(); x++){
            if(a.getPassword().charAt(x)>=65&&a.getPassword().charAt(x)<=90){break;}
            if(x==a.getPassword().length()){
                System.out.println("Password does not contain an uppercase letter");
                throw new AccountExceptions("Password does not contain an uppercase letter");
        }
        }
        for(int x=0; x<a.getPassword().length();x++){
            int counter = 0;
            if(a.getPassword().charAt(x)>=48&&a.getPassword().charAt(x)<=57){counter++;}
            if(counter<=2){break;}
            if(x==a.getPassword().length()){
                System.out.println("Passowrd does not contain a number");
                throw new AccountExceptions("Passowrd does not contain a number");
            }
        }
        //email check ending
        String[] check = {".com",".org",".edu",".co",".net", ".it",".blog",".io",".gov"};
         if(a.getEMail().contains("@")){
            for(int x = 0; x<check.length;x++){
                if((a.getEMail().contains(check[x]))){
                    break;
                }
                if(x==(check.length-1)){
                    System.out.println("Your email is invalid");
                    throw new AccountExceptions("Your email is invalid");
                }
            }
        }else{
            System.out.println("Your email is invalid");
            throw new AccountExceptions("Your email is invalid");
        }
        //phone number check
        if(a.getPhoneNumber().length()<10||a.getPhoneNumber().length()>18){
            System.out.println("This phonenumber is invalid");
            throw new AccountExceptions("This phonenumber is invalid");
        }
        if(a.getPhoneNumber().contains("-")){
            //123-456-7890
                if(!(a.getPhoneNumber().charAt(a.getPhoneNumber().length()-5)=='-')||!(a.getPhoneNumber().charAt(a.getPhoneNumber().length()-9) == '-')){
                    //Just in case people write it like (999)100-2890 or 999-100-2890
                    //                                  1234567890123
                    if(a.getPhoneNumber().length()==13){
                        if(!(a.getPhoneNumber().charAt(a.getPhoneNumber().length()-13)=='(')||!(a.getPhoneNumber().charAt(a.getPhoneNumber().length()-9)==')')){
                            System.out.println("The phone number is not formated correctly");
                            throw new AccountExceptions("The phone number is not formated correctly");
                        }
                    }else{
                        System.out.println("The phone number is not formated correctly");
                            throw new AccountExceptions("The phone number is not formated correctly");
                    }
                }

        }else{
            for(int x = 0; x < a.getPhoneNumber().length(); x++){
                char numberHolder[] = {'1','2','3','4','5','6','7','8','9','0'};
                for(int y = 0; y < numberHolder.length; y++){
                    if((a.getPhoneNumber().charAt(x) == numberHolder[y])){break;}
                    if(y==(numberHolder.length-1)){
                        System.out.println("The phone number is formated incorrectly");
                        throw new AccountExceptions("The phone number is formated incorrectly");
                }
                }
            }
        }
        //Chekcs If it is younger than 18, if it is over 110
        if(a.getbDay().getYear()>(LocalDate.now().getYear()-18)||(LocalDate.now().getYear()-a.getbDay().getYear())>110){
            System.out.println("The birthdate is too old or young");
            throw new AccountExceptions("The birthdate is too old or young");
        }
        //only if everything above is fine
        //Adds the account to database
        Database.addAccounts(a);
        return true;
    }
}