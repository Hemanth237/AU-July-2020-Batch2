import java.util.*;
public class advques4 {
    public static void main(String[] args) {
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(1);
        lis.add(2);
        lis.add(3);

        lis.stream().forEach(x -> {
            if (x==1) return;
            System.out.println(x);
        });
    }
}
