package com.madesh.CDMA_Official.Utility;


public class Users {

    String Name, Email, Password;
    String Phone;

    public Users() {

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Users(String fullName, String mEmail, String mPassword, String mPhone) {

        Name = fullName;
        Email = mEmail;
        Password = mPassword;
        Phone = mPhone;

    }


}
