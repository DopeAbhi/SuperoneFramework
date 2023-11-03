package Resources;

public enum APIResources {

   initiate_login("/writer/v3/user/checkAccountStatus"),
    GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceAPI("/maps/api/place/delete/json");
    private String resources;

    APIResources(String resources)
    {
        this.resources=resources;

    }
    public String getResource()
    {
        return resources;
    }
}
