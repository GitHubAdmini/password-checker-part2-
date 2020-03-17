import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Pattern;


public class PasswordChecker {
    public static int count = 0;
    public static void main(String[] args) throws Exception {
        PasswordChecker PChecker = new PasswordChecker();
        Scanner Sinput = new Scanner(System.in);
        System.out.println("Enter Password");
        String s = Sinput.next();
        try{
                if(PChecker.passwordIsOk(s)){
                    logger.debug("User password is ok!");
                }else{
                    logger.debug("User password is not ok!");
                }
                PChecker.Is_Valid_password(s);
        }catch (Exception e){

               logger.error(e.getLocalizedMessage());
        }

    }
    static final Logger logger = LogManager.getLogger(PasswordChecker.class.getName());

    public void Is_Valid_password(String password) throws  Exception {
        boolean uppercase = false;
        boolean lowercase = false;
        boolean isdigit = false;
        boolean isSpecialChar = false;
        String SpecialChars = "{<>,.!@#$%^&*()_+| \\/~`}";
        char[] convertSpecialChars = SpecialChars.toCharArray();
        if (password.length() < 8) {
            throw new Exception("Password should be longer than than 8 characters");
        } else if (password.isEmpty()) {
            throw new Exception("Password should exists!");
        } else {
            char[] characters = password.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                if (Character.isUpperCase(characters[i])) {
                    uppercase = true;
                }
                if (Character.isDigit(characters[i])) {
                    isdigit = true;
                }
                if (Character.isLowerCase(characters[i])) {
                    lowercase = true;
                }
                for (int j = 0; j < convertSpecialChars.length; j++) {
                    if (characters[i] == convertSpecialChars[j]) {
                        isSpecialChar = true;
                    }
                }
            }
            if (!uppercase) {
                throw new Exception("password should have at least one uppercase letter");
            }
            if (!lowercase) {
                throw new Exception("password should have at least one lowercase letter");
            }
            if (!isdigit) {
                throw new Exception("password should have at least one digit");
            }
            if (!isSpecialChar) {
                throw new Exception("password should have at least one special character");
            }
        }
    }

    public boolean passwordIsOk(String password){

        int sum = 0;
        int isUpper=0, IsLower=0, isChar=0, isDigit=0;



        String SpecialChars = "{<>,.!@#$%^&*()_+| \\/~`}";
        char[] convertSpecialChars = SpecialChars.toCharArray();



            char[] characters = password.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                if (Character.isUpperCase(characters[i])) {
                  isUpper =1;
                }
                if (Character.isDigit(characters[i])) {
                    isDigit =1;
                }
                if (Character.isLowerCase(characters[i])) {
                    IsLower = 1;
                }
                for (int j = 0; j < convertSpecialChars.length; j++) {
                    if (characters[i] == convertSpecialChars[j]) {
                        isChar = 1;

                    }
                }


                sum = (isChar + isDigit + isUpper + IsLower);

            }

  return sum >  2;



}}



