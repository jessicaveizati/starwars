package backend;

public class Helpers {

    public static String normalizeBaseURL(String url) {
        if (url.startsWith("/"))
            url = url.substring(1);
        if (!url.endsWith("/"))
            url = url + "/";
        return url;
    }
}
