package org.cordova.quasar.corona.app;

public enum UrlsEnum {

    SECRETARIA_SITE("https://www.se.df.gov.br"),
    ESCOLA_EM_CASA("https://escolaemcasa.se.df.gov.br/"),
    WIKIPEDIA_PT("https://pt.wikipedia.org/"),
    WIKIPEDIA_EN("en.wikipedia.org"),
    WIKIPEDIA("wikipedia.org"),
    CLASS_ROOM("classroom.google.com"),
    GOOGLE_ACCOUNT("accounts.google.com"),
    GOOGLE_DRIVA("googledrive.com"),
    DRIVE_GOOGLE("drive.google.com"),
    DOCS_GOOGLE("docs.google.com"),
    C_DOCS_GOOGLE("c.docs.google.com"),
    SHEETS_GOOGLE("sheets.google.com"),
    SLIDES_GOOGLE("slides.google.com"),
    TAKEOUT_GOOGLE("takeout.google.com"),
    GG_GOOGLE("gg.google.com"),
    SCRIPT_GOOGLE("script.google.com"),
    GOOGLE_ANALYTICS("ssl.google-analytics.com"),
    VIDEO_GOOGLE("video.google.com"),
    YTIMG("s.ytimg.com"),
    APIS_GOOGLE("apis.google.com"),
    GOOGLE_APIS("googleapis.com"),
    GOOGLE_USER_CONTENT("googleusercontent.com"),
    G_STATIC("gstatic.com"),
    GVT1("gvt1.com"),
    EDU_GOOGLE("edu.google.com"),
    ACCOUNTS_YOUTUBE("accounts.youtube.com"),
    MY_ACCOUNT_GOOGLE("myaccount.google.com"),
    FORMS_GLE("forms.gle"),
    GOOGLE("google.com");

    private final String url;
    UrlsEnum(String url) {
        this.url = url;
    }
    public String getUrl() {
        return this.url;
    }

    public static boolean allowed(String input) {
        for (UrlsEnum url : UrlsEnum.values()) {
            if(input.contains(url.getUrl())) {
                return true;
            }
        }
        return false;
    }


}
