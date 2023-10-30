package Payloads;

import Pojo.Login;

public class userpayload {

    public static String userstatuspayload(String email)

    {
        return"{\n" +
                "    \"countryCode\": \"+91\",\n" +
                "    \"countryName\": \"India\",\n" +
                "    \"deviceToken\": \"\",\n" +
                "    \"deviceType\": \"WEB\",\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"lang\": \"en\",\n" +
                "    \"referenceId\": \"\",\n" +
                "    \"subscribeMarketing\": true\n" +
                "}" ;
    }
    public static String intiateloginpayload(String email,String password)
    {
        return "{\n" +
                "    \"deviceToken\": \"\",\n" +
                "    \"deviceType\": \"WEB\",\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}";
    }

    public static Login loginpayload(String email, String password)
    {
        Login login =new Login();
        login.setDeviceToken("");
        login.setDeviceType("WEB");
        login.setEmail(email);
        login.setPassword(password);
        login.setRecaptchaToken("");

        return login;
    }

public static String verifyuserpayload(String vertoken)
{
    return "{\n" +
            "    \"deviceType\": \"WEB\",\n" +
            "    \"verification_token\": \"" + vertoken + "\"\n" +
            "}";
}

public static String passwordpayload(String password)
{
    return "{\n" +
            "    \"password\": \""+password+"\"\n" +
            "}";
}
public static String referralpayload(String email, String referral){
    return "{\n" +
            "    \"email\": \""+email+"\",\n" +
            "    \"referralCode\": \""+referral+"\"\n" +
            "}";
}

public static String usernamepayload(String username)
{
    return "{\n" +
            "    \"languageCode\": \"en\",\n" +
            "    \"userName\": \"" + username + "\"\n" +
            "}";
}
public static String namepayload (String firstname)
{
    return "{\n" +
            "    \"firstName\": \"" + firstname + "\",\n" +
            "    \"lastName\": \"test\"\n" +
            "}";
}
public static String avatarpayload(String imageurl,int userid)
{
    return "{\n" +
            "    \"avatarUrl\": \"" + imageurl + "\",\n" +
            "    \"mode\": \"AVATAR\",\n" +
            "    \"userId\": " + userid + "\n" +
            "}";
}


}


