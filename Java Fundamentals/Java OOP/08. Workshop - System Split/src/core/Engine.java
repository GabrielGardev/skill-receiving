package core;

import hardwareComponents.HeavyHardware;
import hardwareComponents.PowerHardware;
import softwareComponents.ExpressSoftware;
import softwareComponents.LightSoftware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private System system;
    private BufferedReader reader;

    public Engine(System system){
        this.system = system;
        this.reader = new BufferedReader(new InputStreamReader(java.lang.System.in));
    }

    public void run() throws IOException {
        while (true){
            String input = this.reader.readLine();
            if ("System Split".equals(input)) {
                break;
            }

            String cmd = input.substring(0, input.indexOf("("));
            String[] args = input.substring(input.indexOf("(") + 1, input.length() - 1).split(", ");

            switch (cmd){
                case "RegisterPowerHardware":
                    this.system.addHardware(new PowerHardware(
                            args[0],
                            Integer.parseInt(args[1]),
                            Integer.parseInt(args[2])
                    ));
                    break;
                case "RegisterHeavyHardware":
                    this.system.addHardware(new HeavyHardware(
                            args[0],
                            Integer.parseInt(args[1]),
                            Integer.parseInt(args[2])
                    ));
                    break;
                case "RegisterExpressSoftware":
                    this.system.addSoftware(
                            args[0],
                            new ExpressSoftware(
                                    args[1],
                                    Integer.parseInt(args[2]),
                                    Integer.parseInt(args[3])
                            )
                    );
                    break;
                case "RegisterLightSoftware":
                    this.system.addSoftware(
                            args[0],
                            new LightSoftware(
                                    args[1],
                                    Integer.parseInt(args[2]),
                                    Integer.parseInt(args[3])
                            )
                    );
                    break;
                case "ReleaseSoftwareComponent":
                    this.system.releaseSoftwareComponent(args[0], args[1]);
                    break;
                case "Analyze":
                    java.lang.System.out.println(this.system.analyze());
                    break;
            }
        }

    }
}
