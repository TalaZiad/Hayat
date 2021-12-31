import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PlzWork {


    public ArrayList<Process> Gantt(ArrayList<Process> list) {

        ArrayList<Process> p = new ArrayList<Process>();
        p = list;
        ArrayList<Process> Ready = new ArrayList<Process>();


        boolean flag = true;
        Process c;


        // Iterator<Process> Riter = Ready.iterator()  ;
        //Iterator<Process> piter = p.iterator()  ;
        //piter.next();
        int r, v = 0;

        int count = 1, Pcount = 0, highpri = 0;
        int lastArrival = p.get(p.size() - 1).getAtime(), second = 0;
        v = p.get(0).getBurst() - 1;
        p.set(0, c = new Process(p.get(0).getPid(), p.get(0).getAtime(), p.get(0).getPriority(), v));
        Ready.add(p.get(0));
        /* we can use for loop i< sum of all burst times
        can do this */
        int burstsum = 0;
        for (int k = 0; k < p.size(); k++)
            burstsum += p.get(k).getBurst();


        for (int i = 0; i < burstsum + 1; i++)
        {
            if (i < lastArrival)
            {

                if (Ready.get(Ready.size() - 1).getBurst() != 0)
                {
                    if (i < p.get(count).getAtime())
                    {
                        int w = p.get(Pcount).getBurst() - 1;
                        p.set(Pcount, c = new Process(p.get(Pcount).getPid(), p.get(Pcount).getAtime(), p.get(Pcount).getPriority(), w));
                        Ready.add(c = new Process(Ready.get(Ready.size() - 1).getPid(), Ready.get(Ready.size() - 1).getAtime(), Ready.get(Ready.size() - 1).getPriority(), w));
                    }
                    else if (i == p.get(count).getAtime()) {
                        if (Ready.get(Ready.size() - 1).getPriority() >= p.get(count).getPriority())
                        {
                            int q = p.get(count).getBurst() - 1;
                            p.set(count, c = new Process(p.get(count).getPid(), p.get(count).getAtime(), p.get(count).getPriority(), q));
                            Ready.add(p.get(count));

                        }
                        count++;
                        Pcount++;

                    }
                    else if (Ready.get(Ready.size() - 1).getBurst() == 0) {
                        int temp1 = 0;
                        for (int s = 0; s < p.size(); s++) {
                            if (Ready.get(Ready.size() - 1).getPriority() >= p.get(s).getPriority() && p.get(s).getAtime() < i && Ready.get(Ready.size() - 1).getPid() != p.get(s).getPid())
                                temp1 = s;
                        }
                        v = p.get(temp1).getBurst() - 1;
                        p.set(temp1, c = new Process(p.get(temp1).getPid(), p.get(temp1).getAtime(), p.get(temp1).getPriority(), v));
                        Ready.add(p.get(temp1));
                        count++;
                        Pcount++;
                    }

                }
            }
            else
            {
                if (Ready.get(Ready.size() - 1).getBurst() != 0) {
                    // System.out.println("hello");

                    String Pidselect = Ready.get(Ready.size() - 1).getPid();
                    int index = 0;
                    for (int y = 0; y < p.size(); y++) {
                        if (Pidselect == p.get(y).getPid())
                            index = y;
                    }
                    int a = Ready.get(Ready.size() - 1).getBurst() - 1;
                    p.set(index, c = new Process(p.get(index).getPid(), p.get(index).getAtime(), p.get(index).getPriority(), a));
                    Ready.add(c = new Process(Ready.get(Ready.size() - 1).getPid(), Ready.get(Ready.size() - 1).getAtime(), Ready.get(Ready.size() - 1).getPriority(), a));

                }
                else if (Ready.get(Ready.size() - 1).getBurst() == 0)
                {
                    // System.out.println("hi");
                    for (int z = 0; z < p.size(); z++)
                    {
                        for (int k = 0; k < p.size(); k++)
                        {

                            if ((p.get(z).getPriority() <= p.get(k).getPriority() )&& (p.get(z).getBurst() >= 0) && (p.get(k).getBurst() > 0) && !p.get(z).getPid().equalsIgnoreCase(Ready.get(Ready.size() - 1).getPid()))
                            {
                                highpri = z;
                            }
                        }
                    }


                    int g = p.get(highpri).getBurst() - 1;
                    p.set(highpri, c = new Process(p.get(highpri).getPid(), p.get(highpri).getAtime(), p.get(highpri).getPriority(), g));
                    Ready.add(p.get(highpri));
                }


            }


        }
        return Ready;


    }
}