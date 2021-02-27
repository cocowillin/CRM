/**
 * @author radio
 * @create 2021-02-27 3:52 PM
 */
public class TransactionChangeTest {
    public static void main(String[] args) {
        SuperMan1 superMan1 = new SuperMan1();
        TransactionInvocationHandler handler = new TransactionInvocationHandler(superMan1);
        Human1 human1= (Human1) handler.getProxy();
        System.out.println(human1.getBelief());
        human1.eat("苹果和橘子");

    }
}


interface Human1 {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan1 implements Human1 {
    @Override
    public String getBelief() {
        return "我拥有自由和力量1！";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃的东西是1" + food);
    }
}