package main.java.app.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HttpRequestImpl implements HttpRequest {

    private String method;
    private String requestUrl;
    private HashMap<String, String> headers;
    private HashMap<String, String> bodyParameters;
    private List<HttpCookie> cookies;

    public HttpRequestImpl(String request) {
        this.headers = new HashMap<>();
        this.bodyParameters = new HashMap<>();
        this.cookies = new ArrayList<>();
        this.init(request);
    }

    private void init(String request) {
        this.setMethod(request.split("\\s+")[0]);
        this.setRequestUrl(request.split("\\s+")[1]);

        String[] requestParams = request.split(System.lineSeparator());
        this.insertHeaders(requestParams);
        this.insertBodyParams(requestParams);


    }

    private void insertBodyParams(String[] request) {
        if (!request[request.length - 1].isEmpty()){
            Arrays.stream(request[request.length - 1].split("&"))
                    .map(bp -> bp.split("="))
                    .forEach(bpKvp -> this.addBodyParameter(bpKvp[0], bpKvp[1]));
        }
    }

    private void insertHeaders(String[] request) {
        Arrays.stream(request)
                .filter(h -> h.contains(": "))
                .map(h -> h.split(": "))
                .forEach(headerKvp -> {
                            String key = headerKvp[0];
                            String value = headerKvp[1];

                            if (key.equals("Cookie")){
                              Arrays.stream(value.split("; "))
                                      .map(v -> v.split("="))
                                      .forEach(x -> {
                                          HttpCookie cookie = new HttpCookieImpl(x[0], x[1]);
                                          this.addCookie(cookie);
                                      });
                            }else {
                                this.addHeader(headerKvp[0], headerKvp[1]);
                            }
                });
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return this.bodyParameters;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getRequestUrl() {
        return this.requestUrl;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParameters.put(parameter, value);
    }

    @Override
    public void addCookie(HttpCookie cookie) {
        this.cookies.add(cookie);
    }

    @Override
    public boolean isResource() {
        return this.requestUrl.contains(".");
    }

    @Override
    public List<HttpCookie> getCookies() {
        return cookies;
    }
}
