package atguigu1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 注解的使用
 *
 * @author SHJ
 * @create 2022-12-28 14:01
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

//        Date date = new Date(2020, 10, 11);
//        System.out.println(date);

        @SuppressWarnings("unused")
        int num = 10;
    }

    @Test
    public void testGetAnnotation() {
        Class<Student> clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++){
            System.out.println(annotations[i]);
        }
    }

}

// JDK 8 之前
//@MyAnnotations({@MyAnnotation(value = "hi"), @MyAnnotation(value = "abc")})

@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
class Person {
    private String name;
    private int age;

    public Person() {
    }

    @MyAnnotation()
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T> {
    public void show() throws @MyAnnotation RuntimeException {
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }
}
