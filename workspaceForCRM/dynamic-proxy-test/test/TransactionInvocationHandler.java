import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author radio
 * @create 2021-02-27 3:43 PM
 */
public class TransactionInvocationHandler implements InvocationHandler {
        //首先来一个目标对象
    private  Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    public  Object getProxy(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        return   method.invoke(target, args);
    }
}


