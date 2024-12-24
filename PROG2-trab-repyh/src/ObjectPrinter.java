import java.lang.reflect.Field;

public class ObjectPrinter {
    public static void printObject(Object obj) {
        if (obj == null) {
            System.out.println("null");
            return;
        }

        Class<?> objClass = obj.getClass();
        System.out.println("Class: " + objClass.getName());
        Field[] fields = objClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // Bypass private field restrictions
            try {
                System.out.println(field.getName() + " = " + field.get(obj));
            } catch (IllegalAccessException e) {
                System.out.println(field.getName() + " = [ACCESS DENIED]");
            }
        }
    }
}
