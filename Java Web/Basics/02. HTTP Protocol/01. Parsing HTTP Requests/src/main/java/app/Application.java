package main.java.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class Application {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        List<String> validUrls = getValidUrls();
        List<String> requests = getRequest();

        String method = getMethod(requests.get(0));
        String url = getUrl(requests.get(0));

        Map<String, String> headers = getHeaders(requests);
        Map<String, String> bodyParams = getBodyParams(requests);

        StringBuilder response = new StringBuilder();
        String separator = System.lineSeparator();
        if (!validUrls.contains(url)){
            response.append("HTTP/1.1 404 Not Found").append(separator);

            getResponseHeaders(headers, response);

            response.append(separator);
            response.append("The requested functionality was not found.");
        }else if (!headers.containsKey("Authorization")){
            response.append("HTTP/1.1 401 Unauthorized").append(separator);

            getResponseHeaders(headers, response);

            response.append(separator);
            response.append("You are not authorized to access the requested functionality.");
        }else if (method.equals("POST") && bodyParams.size() == 0){
            response.append("HTTP/1.1 400 Bad Request").append(separator);

            getResponseHeaders(headers, response);

            response.append(separator);
            response.append("There was an error with the requested functionality due to malformed request.");
        }else {
            response.append("HTTP/1.1 200 OK").append(separator);

            getResponseHeaders(headers, response);

            String first = "";
            String second = "";
            String third = "";
            int count = 0;
            for (Map.Entry<String, String> kvp : bodyParams.entrySet()) {
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
            
            response.append(separator);
            response.append(responseBody);
        }
        System.out.println(response.toString().trim());
    }

    private static void getResponseHeaders(Map<String, String> headers, StringBuilder response) {
        String separator = System.lineSeparator();

        for (Map.Entry<String, String> kvp : headers.entrySet()) {
            if (kvp.getKey().equals("Date") ||
            kvp.getKey().equals("Host") ||
            kvp.getKey().equals("Content-Type")){
                response.append(kvp.getKey()).append(": ").append(kvp.getValue()).append(separator);
            }
        }
    }

    private static Map<String, String> getBodyParams(List<String> requests) {
        Map<String, String> params = new LinkedHashMap<>();

        if (requests.get(requests.size() - 1).equals("\r\n")){
            return params;
        }

        Arrays.stream(requests.get(requests.size() - 1)
        .split("&"))
                .map(bp -> bp.split("="))
                .forEach(bpKvp -> params.put(bpKvp[0], bpKvp[1]));

        return params;
    }

    private static Map<String, String> getHeaders(List<String> requests) {
        Map<String, String> headers = new LinkedHashMap<>();

          requests.stream()
                .skip(1)
                .filter(h -> h.contains(": "))
                .map(h -> h.split(": "))
                .forEach(headerKvp -> headers.put(headerKvp[0], headerKvp[1]));

          return headers;
    }

    private static String getMethod(String line) {
        return line.split("\\s+")[0];
    }

    private static String getUrl(String line) {
        return line.split("\\s+")[1];
    }

    private static List<String> getValidUrls() throws IOException {
        return Arrays.asList(reader.readLine().split("\\s+"));
    }

    private static List<String> getRequest() throws IOException {
        List<String> request = new ArrayList<>();

        String line;

        while ((line = reader.readLine()) != null && line.length() > 0){
            request.add(line);
        }

        request.add(System.lineSeparator());
        if ((line = reader.readLine()) != null && line.length() > 0){
            request.add(line);
        }
        return request;
    }


}
