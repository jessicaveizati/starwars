package backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpClient {
    private OkHttpClient client;
    private String baseURI;


    public HttpClient(String baseURL) {
        this.client = new OkHttpClient();
        this.baseURI = Helpers.normalizeBaseURL(baseURL);
    }

    public <T> T getOne(String url, Class<T> tClass) throws IOException {
        Request request = new Request.Builder()
                .url(this.baseURI + url)
                .get()
                .build();

        Response response = this.client.newCall(request).execute();
        if (response.isSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body().string(), tClass);
        } else throw new RuntimeException("Unexpected code " + response);
    }
}
