import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Reflection> clazz = Reflection.class;
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());

        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection ref = clazz.getDeclaredConstructor().newInstance();
        System.out.println(ref);

        TreeSet<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] getMethods = clazz.getDeclaredMethods();

        for (Method currentMethod : getMethods) {
            if (currentMethod.getName().startsWith("get")){
                getters.add(currentMethod);
            }else if (currentMethod.getName().startsWith("set")){
                setters.add(currentMethod);
            }
        }
        getters.forEach(x -> System.out.println(String.format("%s will return %s",
                x.getName(),
                x.getReturnType())));

        setters.forEach(s -> System.out.println(String.format("%s and will set field of %s",
                s.getName(),
                s.getParameterTypes()[0])));

        Field[] declaredFields = clazz.getDeclaredFields();
        int fields = clazz.getModifiers();

        Arrays.stream(declaredFields)
                .filter(x -> !Modifier.isPrivate(x.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(x -> System.out.println(String.format("%s must be private!", x.getName())));

        getters.stream()
                .filter(x -> !Modifier.isPublic(x.getModifiers()))
                .forEach(x -> System.out.println(String.format("%s have to be public!", x.getName())));

        setters.stream()
                .filter(x -> !Modifier.isPrivate(x.getModifiers()))
                .forEach(x -> System.out.println(String.format("%s have to be private!", x.getName())));
    }
}
