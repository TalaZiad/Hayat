class Process implements Comparable<Process>  {
    private String pid;
    private int atime;
    private   int priority;
    private int burst;

    public Process(String P, int A ,int Pr ,int B){
        this.pid = AP;
        this.atime = I;
        this.priority = Pr;
        this.burst = B
    }

    public int getAtime() {
        return atime;
    }


    public int getBurst() {
        return burst;
    }

    public int getPriority() {
        return priority;
    }

    public String getPid() {
        return pid;
    }

    public void setBurst(int burst) {
        this.burst = burst;
    }

    public String print(){

        return "Pid: " + getPid()    Arrival time:   "+ getAtime() + "   Priority: "+ getPriority() + "   Burst time: "+ getBurst();
    }


    @Override
    public int compareTo(Process pid) {
        int compareArrival = ((Process)pid).getAtime();
        return this.atime- compareArrival;
    }
}