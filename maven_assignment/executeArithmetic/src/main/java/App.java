public class App {
    public static void main(String[] args){
        arithmetic obj = new arithmeticImpl();
        int ans = obj.add(1,2);
        double ansmul = obj.div(2,3);
        System.out.println(ansmul);

    }
}
