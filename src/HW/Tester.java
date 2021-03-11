package HW;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {
    public static void start (Class testClass) throws InvocationTargetException, IllegalAccessException {
        Method[] afterBefore = cheсkAfterBefore(TestedMethods.class);
        afterBefore[0].invoke(null);
        Method[] methods = testClass.getDeclaredMethods();
        for (int i = 1; i <= 10; i++) {
            for (Method method: methods) {
                if (method.isAnnotationPresent(Test.class)){
                    if (method.getAnnotation(Test.class).priority() == i) {
                        method.invoke(null);
                    }
                }
            }
        }
        afterBefore[1].invoke(null);
    }

    public static Method[] cheсkAfterBefore(Class checkedClass){
        int countBefore = 0;
        int countAfter = 0;
        Method[] afterBefore = new Method[2];
        Method[] methods = checkedClass.getDeclaredMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)){
                countBefore++;
                afterBefore[0] = method;
            }
            if (method.isAnnotationPresent(AfterSuite.class)){
                countAfter++;
                afterBefore[1] = method;
            }
        }
        if (countAfter != 1 || countBefore != 1){
            throw new RuntimeException("Более одного метода с аннотациями @BeforeSuite и @AfterSuite");
        }
        return afterBefore;
    }
}
