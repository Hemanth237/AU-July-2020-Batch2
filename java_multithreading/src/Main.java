import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        thread t = new thread();
        Scanner sc = new Scanner(System.in);
        List<Thread> run_p = new ArrayList<>();
        List<Thread> run_q = new ArrayList<>();
        System.out.println("Enter the number of producers");
        int np = sc.nextInt();
        System.out.println("Enter the number of consumers");
        int pp = sc.nextInt();
        for(int i=0;i<np;i++){
            run_p.add(new Thread(t::produce));
        }
        for(int i=0;i<pp;i++){
            run_q.add(new Thread(t::consume));
        }
        for (int i = 0; i < np; i++) {
            run_p.get(i).start();
        }
        for (int i = 0; i < pp; i++) {
            run_q.get(i).start();
        }

    }
}

class thread{
    int max = 10;
    int min = 0;
    List<Integer> lis = new ArrayList<>();
    final Object lock = new Object();
    int num = 0;
    public void produce(){
        synchronized (lock){
            while (true){
                if(lis.size()==max){
                    System.out.println("Queue is full. No task is already taken by any of the consumer.");
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    System.out.println(num +" added to the Queue.");
                    lis.add(num);
                    num++;
                    lock.notify();
                }
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public void consume(){
        synchronized (lock){
            while(true){
                if(lis.size() == min){
                    System.out.println("Queue is empty. There is no task present in the Queue.");
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    System.out.println("Removing message "+lis.remove(--num));
                    lock.notify();
                }
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}