package proxy;

import java.beans.EventHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class ProxyTest {

    public static void main(String[] args){

        Map proxyInstance = (Map) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[] { Map.class },
                new DynamicProxyInvocation(new HashMap<>()));


        //proxyInstance.put("hi","gullu");

        //Here we pass the TestPersonImpl the actual class to the InvocationHandler so it can invoke real methoid after doing proxy thing
        //If I use javassist I can do same thing differently: https://martinsdeveloperworld.wordpress.com/2014/01/19/implementing-dynamic-proxies-a-comparison/
        //In JDK proxy that I used below I need an interface whereas Javassist and CGLib can directly proxy a class. Hibernate uses Javassist for lazy loading of entities
        TestPerson person = (TestPerson) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{TestPerson.class}, new DynamicProxyInvocation(new TestPersonImpl()));
        System.out.println(person.getPersonName());


        //Note Even Handler implements InvocationHandler
        //In Event Handler we specify the class and method just needs to be invoked when we we invoke any method in Listener(here List is Listener but usually it is ActionListener)
        //Here getPersonBool() method is invoked in testPersonImpl when we invoke any method in List.
        List a = EventHandler.create(List.class, new TestPersonImpl(), "getPersonBool");

        System.out.println(a.add("bill"));

        for(Method m:a.getClass().getMethods())
            System.out.println(m.getName());

        //Here we are also saying to pass the actual argument of Listener("bill" to the target getPersonBool2)
        List b = EventHandler.create(List.class, new TestPersonImpl(), "getPersonBool2","");

        System.out.println("Second :"+ b.add("bill"));


    }
}
