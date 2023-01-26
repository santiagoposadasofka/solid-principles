package org.example.singleResponsibility;

public class PasswordHasher {
    public String hashAndSavePassword(String password) {
        hashPassword();
        savePassword();
        return "Password hashed and saved";
    }

    public void hashPassword() {
        //hashing implementation
    }

    public void savePassword() {
        //save to the db
    }
}
