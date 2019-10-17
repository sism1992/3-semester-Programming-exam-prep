package Threads.MCdonalds;

public class Consumer implements Runnable
{
    private Slider resource;
    public Consumer(Slider res)
    {
        resource=res;
    }
    @Override
    public void run()
    {
        int newLevel=0;
        while(true){
            newLevel = resource.takeOne();
            System.out.print(Thread.currentThread().getName() + " ");
            System.out.println("Consumer: "+newLevel);
            int pause = (int)(Math.random()*2000);
            try
            {
                Thread.sleep(pause);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }



}
