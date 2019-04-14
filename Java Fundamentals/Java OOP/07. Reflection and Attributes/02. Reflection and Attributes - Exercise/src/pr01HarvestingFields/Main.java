package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Field[] fields = RichSoilLand.class.getDeclaredFields();

		while (true){
			String line = reader.readLine();
			if (line.equals("HARVEST")){
				break;
			}

			Field[] fields1 = Arrays.stream(fields).filter(x -> Modifier.toString(x.getModifiers()).equals(line))
					.toArray(Field[]::new);

			Arrays.stream(fields1).forEach(f -> System.out.println(String.format("%s %s %s",
					Modifier.toString(f.getModifiers()),
					f.getType().getSimpleName(),
					f.getName())));

			if (line.equals("all")){
				Arrays.stream(fields).forEach(f -> System.out.println(String.format("%s %s %s",
						Modifier.toString(f.getModifiers()),
						f.getType().getSimpleName(),
						f.getName())));
			}

		}
	}
}
