interface calc{
    int  calculate(int num1, int num2);
}
interface TaskHandler {
    public Message getMessage(int a,int b);
}
class test{
    public int add(int num1, int num2){
        return (num1+num2);
    }
}
class Message {
    int a;
    int b;
    public Message(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class advques1 {
    public static void main(String[] args){
        // using lambda
        calc c = (n1, n2) -> n1 + n2;
        System.out.println(c.calculate(20,30));
        // using static method
        calc c1 = Integer::sum;
        System.out.println(c1.calculate(20,30));
        // using instance method
        calc c2 = new test()::add;
        System.out.println(c2.calculate(20,30));
        // using constructor
        TaskHandler c3 = Message::new;


    }
}
