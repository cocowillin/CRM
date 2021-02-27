import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author radio
 * @create 2021-02-27 9:28 AM
 */

    interface Human {
        String getBelief();

        void eat(String food);
    }

    //被代理类
    class SuperMan implements Human {
        @Override
        public String getBelief() {
            return "我拥有自由和力量！";
        }

        @Override
        public void eat(String food) {
            System.out.println("我喜欢吃的东西是" + food);
        }
    }

    //此时我们不想写一个代理类对象了 ，而是写一个类及其方法类获取被代理类的方法 及其代理类附加的功能；有了需求来源你代理类才有价值
    class ProxyFactory {

        //第一步先通过加载的代理类先获取代理类，也就需求有了 你代理类该干活了。
        public static Object getProxyInstance(Object obj) {/*obj为被代理类对象*/
            MyinvocationHandler handler = new MyinvocationHandler(obj);
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
            //传入的参数handler自动调用invoke方法；

        }

    }

    class MyinvocationHandler implements InvocationHandler {
        private  Object obj;

        public MyinvocationHandler(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { /* proxy是代理类对象，*/
                //method为代理类对象调用的方法;
                Object returnValue=method.invoke(obj,args);
                return returnValue;
        }
    }

    public class Dynamic_proxyTest{
        public static void main(String[] args) {
            SuperMan superMan=new SuperMan();
            Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
            proxyInstance.eat("番茄炒蛋");
            String belief = proxyInstance.getBelief();
            System.out.println(belief);

        }
}



