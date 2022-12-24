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

    boolean upper = false;
    boolean lower=false;
    boolean digit=false;
    boolean special=false;
   // String s ="<([{\\^-=$!|]})?*+.>";
    public void changePassword(String oldPassword, String newPassword){
        int n = newPassword.length();
        if(n<8)
            return;
        for(int i=0;i<n;i++){
            char c = newPassword.charAt(i);
            if(c>='a' && c<='z')
                lower=true;
            if(c>='A' && c<='Z')
                upper=true;
            if(c>='0' && c<='9')
                digit=true;
            if(c=='@'||c=='<'||c=='('||c=='['||c=='{'||c=='\\'||c=='^'||c=='-'||c=='='||c=='$'||c=='!'||c=='|'||c==']'||c=='}'||c==')'||c=='?'||c=='*'||c=='+'||c=='.'||c=='>')
                special=true;
        }
     //   System.out.println(lower+" "+upper+" "+digit+" "+special);
if(oldPassword.equals(this.password) && n>=8 && upper==true && lower==true&&digit==true&&special==true){
    this.password = newPassword;
 //   System.out.println("this is new password "+this.password);
  //  System.out.println("this is new password "+newPassword);
}



//        Pattern passwordRegex = Pattern.compile("((?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[`~!@#$%^&*]).{8,20})");
//        Matcher m = passwordRegex.matcher(newPassword);
//        if(oldPassword.equals(this.password) && m.matches()){
//            this.password = newPassword;
//            System.out.println("this is new password "+this.password);
//        }

        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }

}
