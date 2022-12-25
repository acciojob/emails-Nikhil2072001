package com.driver;
import java.util.regex.*;
public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        Pattern passwordRegex = Pattern.compile("((?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[`~!@#$%^&*]).{8,20})");
        Matcher m = passwordRegex.matcher(newPassword);
        if(oldPassword.equals(this.password) && m.matches()){
            this.password = newPassword;
        }
//        int n = newPassword.length();
//        if(n<8)
//            return;
//        Pattern letter = Pattern.compile("[a-zA-z]");
//        Pattern digit = Pattern.compile("[0-9]");
//        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
//        //Pattern eight = Pattern.compile (".{8}");
//
//
//        Matcher hasLetter = letter.matcher(password);
//        Matcher hasDigit = digit.matcher(password);
//        Matcher hasSpecial = special.matcher(password);
//        if(oldPassword.equals(this.password) && hasLetter.find() && hasDigit.find() && hasSpecial.find()){
//
//            this.password = newPassword;
//          //  System.out.println("this is new password "+this.password);
//        }

        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }

}
