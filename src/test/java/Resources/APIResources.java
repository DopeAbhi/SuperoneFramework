package Resources;

public enum APIResources {

    user_status_check("/writer/v3/user/checkAccountStatus"),
    initiate_login("/writer/v3/user/checkAccountStatus"),
    login("/writer/user/email/login"),
    get_verification_url("/reader/getVerificationHistory"),

    verify_url("/writer/v3/user/verifyUserToken"),
    verification_check("/reader/user/checkVerificationStatus"),
    set_password("/writer/v3/user/password/set"),
    verify_referral("/writer/v3/user/verifyReferral"),
    set_username("/writer/v3/user/updateUserName"),
    set_firstname_lastname("/writer/v3/user/100706/updateUserInfo"),
    set_avatar("/writer/user/update-avatar"),
    get_walletdata("/reader/members/get/walletdata"),
    checking_settings("/reader/user/104947/setting"),
    member_search("/reader/member/searchmemberbyreferralcode"),
    transfer("/writer/v3/user/100623/transfer");

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
