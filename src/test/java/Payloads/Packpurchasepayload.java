package Payloads;

public class Packpurchasepayload {
    public  static String pack_purchase_payload(int packnumber)
    {

//    purchase p ayload=new purchase();
//    payload.setisStore(true);
//    payload.setisUpgrade(false);
//    payload.setpackagePaymentType("CASH");
//    payload.setpackageType("AFFILIATE");
//    payload.setpackageTypeId(packnumber);
//    payload.setpurchaseType("CASH");
//    payload.setquantity(1);
//    payload.setreserve(true);
//    return payload;
        return "{\n" +
                "    \"isStore\": true,\n" +
                "    \"isUpgrade\": false,\n" +
                "    \"packagePaymentType\": \"CASH\",\n" +
                "    \"packageType\": \"AFFILIATE\",\n" +
                "    \"packageTypeId\": "+packnumber+",\n" +
                "    \"purchaseType\": \"CASH\",\n" +
                "    \"quantity\": 1,\n" +
                "    \"reserve\": true\n" +
                "}";
    }
}
