package atguigu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author SHJ
 * @create 2023-01-10 8:55
 */

interface Human {
    String getBelief();
    void eat(String food);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil {
    public void method1() {
        System.out.println("***********通用方法一*************");
    }

    public void method2() {
        System.out.println("***********通用方法二*************");
    }
}

class ProxyFactory {
    // 通过此方法，返回一个代理类对象
    public static Object getProxyInstance(Object obj) { // obj:被代理类对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj; // 用被代理类对象进行实例化

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 当我们通过代理类对象调用方法a时，就会自动的调用如下方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util = new HumanUtil();
        util.method1();

        // 此方法即被代理类对象要调用的方法
        Object returnValue = method.invoke(obj, args);

        util.method2();
        return returnValue;
    }
}

public class  DynamicProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // proxyInstance 代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("***************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }

}
