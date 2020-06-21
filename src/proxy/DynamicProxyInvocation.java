package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DynamicProxyInvocation implements InvocationHandler {

    public Object target;

    private final Map<String, Method> methods = new HashMap<>();

    DynamicProxyInvocation(Object target){
        this.target = target;

        for(Method method: target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        long start = System.nanoTime();
        System.out.println("Invoked method: {}"+ method.getName() +","+ proxy.getClass().getMethods());
        for(Method m: proxy.getClass().getMethods()){
            System.out.println("Method name :"+ m.getName());
        }
        String result = (String)(methods.get(method.getName()).invoke(target,args));
        long end = System.nanoTime();

        System.out.println("Elapsed time is "+ (end-start));

        return result;


    }
}
