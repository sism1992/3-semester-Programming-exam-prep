package Threads.MCdonalds;

public class Run {

    public static void main(String[] args) {

        new Run();
    }

    public Run(){
        Slider resource = new Slider(2);
        Thread prodThread = new Thread(new Producer(resource));
        prodThread.start();
        Thread consThread = new Thread(new Consumer(resource));
        consThread.start();
    }
}
