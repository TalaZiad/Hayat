import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class Patient{
    public static void main(String[] args){

        Scanner kbd = new Scanner(System.in);
        boolean flag = true;

        ArrayList<Process> list = new ArrayList<Process>();
        PlzWork s = new PlzWork();
        int atime , pri , burst ;
        String pid;
      /*  System.out.println("All zeros to exit: ");
        System.out.println("Enter process: ");
        pid= kbd.next();
        System.out.println("Enter Arrival time: ");
        atime = kbd.nextInt();
        System.out.println("Enter Priority: ");
        pri = kbd.nextInt();
        System.out.println("Enter Burst time: ");
        burst = kbd.nextInt();

        while(pid != "0" && atime != 0 && pri != 0 && burst != 0)
        {

            list.add( new Process(pid, atime, pri, burst));
        System.out.println("All zeros to exit: ");
        System.out.println("Enter process: ");
        pid= kbd.next();
        System.out.println("Enter Arrival time: ");
        atime = kbd.nextInt();
        System.out.println("Enter Priority: ");
        pri = kbd.nextInt();
        System.out.println("Enter Burst time: ");
        burst = kbd.nextInt();



        } */
        ArrayList<Process> list1 = new ArrayList<Process>();
        list1.add(new Process("p1", 0, 2, 11));
        list1.add(new Process("p2", 5, 0, 28));
        list1.add(new Process("p3", 12, 3, 2));
        list1.add(new Process("p4", 2, 1, 10));
        list1.add(new Process("p5", 9, 4, 16));




        ArrayList<Process> test = new ArrayList<Process>();
        Collections.sort(list1);
        test = s.Gantt(list1);

        for(int i = 0 ; i< test.size() ; i++) {

            System.out.println(i + "-" + test.get(i).print());
            System.out.println();
        }















    }
}
