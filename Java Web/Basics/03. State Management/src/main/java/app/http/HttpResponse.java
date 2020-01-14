package main.java.app.http;

import java.util.HashMap;
import java.util.List;

public interface HttpResponse {
    HashMap<String,String> getHeaders();

    int getStatusCode();

    byte[] getContent();

    byte[] getBytes();

    void setStatusCode(int statusCode);

    void setContent(byte[] content);

    void addHeader(String header, String value);

    List<HttpCookie> getCookies();

    void setCookies(List<HttpCookie> cookies);

    void printCookies();
}
