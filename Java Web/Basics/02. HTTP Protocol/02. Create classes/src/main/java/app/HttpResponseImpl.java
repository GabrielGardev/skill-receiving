package main.java.app;

import java.util.*;

public class HttpResponseImpl implements HttpResponse {

    private HashMap<String, String> headers;
    private int statusCode;
    private byte[] content;

    public HttpResponseImpl(HttpRequest request, List<String> validUrls) {
        this.headers = new HashMap<>();
        this.init(request, validUrls);
    }

    private void init(HttpRequest request, List<String> validUrls) {
        request.getHeaders().forEach(this::addHeader);

        if (!isUrlValid(validUrls, request)){
            this.setStatusCode(404);
            this.setContent("The requested functionality was not found.".getBytes());
        }else if (!request.getHeaders().containsKey("Authorization")){
            this.setStatusCode(401);
            this.setContent("You are not authorized to access the requested functionality.".getBytes());
        }else if (request.getMethod().equals("POST") && request.getBodyParameters().size() == 0){
            this.setStatusCode(400);
            this.setContent("There was an error with the requested functionality due to malformed request."
                    .getBytes());
        }else {
            this.setStatusCode(200);

            String first = "";
            String second = "";
            String third = "";
            int count = 0;
            for (Map.Entry<String, String> kvp : request.getBodyParameters().entrySet()) {
                switch (count){
                    case 0:
                        first = kvp.getValue();
                        break;
                    case 1:
                        second = kvp.getKey() + " - " + kvp.getValue();
                        break;
                    case 2:
                        third = kvp.getKey() + " - " + kvp.getValue();
                        break;
                }
                count++;
            }

            String responseBody = String.format(
                    "Greetings %s! You have successfully created %s with %s, %s.",
                    new String(Base64.getDecoder().decode(headers.get("Authorization").split("\\s+")[1])),
                    first, second, third
            );
            this.setContent(responseBody.getBytes());
        }
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public byte[] getContent() {
        return this.content;
    }

    @Override
    public byte[] getBytes() {
        String sp = System.lineSeparator();
        return ("HTTP/1.1 "
                + statusCode
                + " "
                + this.getResponse(statusCode)
                + sp
                + this.beautyHeaders(headers)
                + sp
                + new String(content))
                .getBytes();
    }

    private String beautyHeaders(HashMap<String, String> headers) {
        StringBuilder sb = new StringBuilder();

        headers.entrySet()
                .stream()
                .filter(h -> h.getKey().equals("Date")
                        || h.getKey().equals("Host")
                        || h.getKey().equals("Content-Type"))
                .forEach(h
                -> sb.append(h.getKey())
                .append(": ")
                .append(h.getValue())
                .append(System.lineSeparator()));
        return sb.toString();
    }

    private String getResponse(int statusCode) {
        String response = "";
        switch (statusCode){
            case 200:
                response = "OK";
                break;
            case 404:
                response = "Not found";
                break;
            case 400:
                response = "Bad Request";
                break;
            case 401:
                response = "Unauthorized";
                break;
        }
        return response;
    }

    @Override
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    private boolean isUrlValid(List<String> validUrls, HttpRequest req){
        return validUrls.contains(req.getRequestUrl());
    }

    @Override
    public String toString() {
        return new String(this.getBytes());
    }
}
