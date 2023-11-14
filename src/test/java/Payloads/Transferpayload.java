package Payloads;

public class Transferpayload {


    public static String searchpayload(String searchuser)
    {
     return "{\n" +
             "\"limit\": 10,\n" +
             "\"pageNo\": 0,\n" +
             "\"referralCode\": \""+searchuser+"\"\n" +
             "}";
    }

    public static String Transfer(String memberid ,int amount)

    {
        return "{\n" +
                "    \"amount\": "+amount+",\n" +
                "    \"isReserve\": false,\n" +
                "    \"medium\": \"MOBILE\",\n" +
                "    \"receiverId\": "+memberid+",\n" +
                "    \"requestId\": \"\"\n" +
                "}";

    }
    public static String receiveduser(String receiveuser,String pass)
    {
        return "{\n" +
                "\"deviceToken\": \"\",\n" +
                "\"deviceType\":\"WEB\",\n" +
                "\"email\": \""+receiveuser+"\",\n" +
                "\"password\": \""+pass+"\"\n" +
                "\n" +
                "}";
    }
}
