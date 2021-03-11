package HW;

public class TestedMethods {

    @BeforeSuite
    public static void BeforeMethod(){
        System.out.println("С аннотацией @BeforeSuite");
    }

    @AfterSuite
    public static void AfterMethod(){
        System.out.println("С аннотацией @AfterSuite");
    }

    @Test(priority = 3)
    public static void Method_1(){
        System.out.println("Приоритет 3");
    }

    @Test(priority = 8)
    public static void Method_2(){
        System.out.println("Приоритет 8");
    }

    @Test(priority = 1)
    public static void Method_3(){
        System.out.println("Приоритет 1");
    }
    @Test
    public static void Method_4(){
        System.out.println("Приоритет 5");
    }

}
