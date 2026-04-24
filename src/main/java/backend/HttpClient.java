package backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URI;

public class HttpClient {
    private OkHttpClient client;
    public String baseURI;


    public HttpClient(String baseURL) {
        this.client = new OkHttpClient();
        this.baseURI = Helpers.normalizeBaseURL(baseURL);
    }

    //Only if you have the end of the URL (/people, /planet, etc)
    public <T> T getOne(String url, Class<T> tClass) throws IOException {
        return getOne(URI.create(this.baseURI + url), tClass);
    }

    //Adding unique id's to the end of the URL (/people/1, /people/2, /planet/3, etc)
    public <T> T getOne(URI fullURL, Class<T> tClass) throws IOException {
        Request request = new Request.Builder()
                .url(fullURL.toURL())
                .get()
                .build();

        Response response = this.client.newCall(request).execute();
        if (response.isSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body().string(), tClass);
        } else throw new RuntimeException("Unexpected code " + response);
    }

}
