package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException, NoSuchMethodException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
		constructor.setAccessible(true);

		BlackBoxInt blackBoxInt = constructor.newInstance();

		Method[] methods = blackBoxInt.getClass().getDeclaredMethods();

		Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
		innerValue.setAccessible(true);

		while (true){
			String line = reader.readLine();
			if ("END".equals(line)){
				break;
			}

			String[] tokens = line.split("_");
			String cmd = tokens[0];
			int num = Integer.parseInt(tokens[1]);

			for (Method method : methods) {
				method.setAccessible(true);
				if (method.getName().equals(cmd)){
					method.invoke(blackBoxInt, num);
					System.out.println(innerValue.get(blackBoxInt));
				}
			}
		}
	}
}
