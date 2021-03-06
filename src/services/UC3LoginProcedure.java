package services;


import dataBase.IDbHandler;

public class UC3LoginProcedure {

    private IDbHandler userDb;

    public UC3LoginProcedure(IDbHandler userdb) {
        this.userDb = userdb;
    }



    public Boolean connect(String userName, String password){
        if (checkUserNameExist(userName)){
            String hashedPassword = makeHash(password);
            if (isCorrect(userName,hashedPassword)){
                return true;
            }
            else{
                return false;
            }

        }
        else
        {
            return false;
        }

    }

    private boolean isCorrect(String userName, String hashedPassword) {
        return userDb.authenticate(userName,hashedPassword);
    }

    private boolean checkUserNameExist(String userName) {
        return userDb.isUserExists(userName);
    }

    //need to add hash function
    private String makeHash(String password){

        return password;
    }


}
