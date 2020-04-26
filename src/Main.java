//Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов
// с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
// передается или объект типа Class, или имя класса. Из «класса-теста» вначале должен быть запущен метод
// с аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test, а по завершению всех
// тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
// в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет
// значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе
// необходимо бросить RuntimeException при запуске «тестирования».

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat cat = new Cat("Мурзик", 3, "белый");
        Cat cat2 = new Cat("Василий", 2, "черный");
        start(cat);
        start(cat2);
    }

    public static void start(Cat cat) throws InvocationTargetException, IllegalAccessException {
        Class rt = Cat.class;
        Method[] methods = rt.getDeclaredMethods();
        for (Method o : methods){
            if(o.isAnnotationPresent(BeforeSuite.class)){
                o.invoke(cat);
            }
        }

        for (Method o : methods){
            if(o.isAnnotationPresent(Test2.class)){//как вывести возвращаемое по RETURN? ок типа так... вопрос отпал
                System.out.println(o.invoke(cat));
            }
            if(o.isAnnotationPresent(Test.class)){
                o.invoke(cat);
                //как передать вызываемому методу параметры? например высоту в метод jump?
            }
        }

        for (Method o : methods){
            if(o.isAnnotationPresent(AfterSuite.class)){
                o.invoke(cat);
            }
        }
    }

}

