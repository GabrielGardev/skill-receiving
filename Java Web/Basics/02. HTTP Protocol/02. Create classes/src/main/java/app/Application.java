package main.java.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<String> validUrls = getValidUrls();
        String requests = getRequest();

        HttpRequest request = new HttpRequestImpl(requests);
        HttpResponse response = new HttpResponseImpl(request, validUrls);

        System.out.println(response.toString());

    }

    private static List<String> getValidUrls() throws IOException {
        return Arrays.asList(reader.readLine().split("\\s+"));
    }

    private static String getRequest() throws IOException {
        StringBuilder sb = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null && line.length() > 0){
            sb.append(line).append(System.lineSeparator());
        }

        sb.append(System.lineSeparator());
        if ((line = reader.readLine()) != null && line.length() > 0){
            sb.append(line);
        }
        return sb.toString().trim();
    }
}
