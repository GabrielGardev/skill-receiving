package P04_Traffic_Lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        List<TrafficLight> lights = new ArrayList<>();

        for (String s : input) {
            TrafficLight light = new TrafficLight(States.valueOf(s));
            lights.add(light);
        }

        int n = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (TrafficLight light : lights) {
                light.changeState();
                sb.append(light.getState().toString()).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
