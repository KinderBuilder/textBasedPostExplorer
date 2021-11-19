package com.postserver.Account;
import java.util.List;

import com.postserver.Exceptions.AccountExceptions;

import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/accounts")
//When someone enters this url, than run this code

public class AccountController {
    private final AccountService as;
    @Autowired
	public AccountController(AccountService accountService){this.as = accountService;}

    @GetMapping
    public List<Account> getAccount(){
        //Account requirments
        //String userName, String firstName, String lastName, String password, String bio, String eMail, String phoneNumber, int month, int day, int year
        return(this.as.getAcounts());
    }
    @PostMapping
	public ResponseEntity<String> createAccount(@RequestBody Account a){
    try{
        if(as.makeAccount(a)==true){
            return(new ResponseEntity<>("Congradulations! You successfully made an account",HttpStatus.OK));
        }else{return(new ResponseEntity<>("What have you done? Achievement: Broke the Code", HttpStatus.INTERNAL_SERVER_ERROR));}
    }catch(AccountExceptions ae){
        return(new ResponseEntity<>(ae.getMessage(),HttpStatus.BAD_REQUEST));
    }catch(Exception huh){  
        System.out.println(huh.getMessage());
        return(new ResponseEntity<>("My Bad... Something broke on our servers", HttpStatus.INTERNAL_SERVER_ERROR));
    }
	}
}