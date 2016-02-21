package client.main;

public class Runner {
    
    private static Thread thread = null;
    private static boolean pause = false;
    private static boolean stop = false;
    private static boolean started = false;
    public static long now = System.currentTimeMillis();
    private static int fps = 60;
    private static int pauseSleepTime = 500;
    
    public static void start(){
        stop = false;
        pause = false;
        if (thread == null){
            getThread().start();
        } else {
            if (!getThread().isAlive()){
                getThread().start();
            }
        }
        started = true;
    }
    
    public static void stop(){
        stop = true;
    }
    
    public static void pause(){
        pause = true;
    }
    
    public static void continueAfterPause(){
        pause = false;
    }
    
    private static Thread getThread(){
        if (thread == null){
            Worker worker = new Worker();
            thread = new Thread(worker);
        }
        return thread;
    }
    
    public static boolean isStarted(){
        return started;
    }
    
    public static boolean isRunning(){
        return started && !pause;
    }
    
    private static class Worker implements Runnable{
        private long lastFrame = 0L;
        private int sleepTime = 0;
        
        public Worker(){
            sleepTime = (int) (1000.0f / fps);
        }

        private void sleep(){
            now = System.currentTimeMillis();
            if ((pause ? pauseSleepTime : sleepTime) > now - lastFrame){
                try {
                    Thread.sleep(sleepTime - (now - lastFrame));
                } catch (InterruptedException e){
                    // TODO show Error if Thread.sleep could not be performed
                }
            }
        }
        
        @Override
        public void run() {
            // work forever
            while (true){
                if (stop){
                    return;
                }
                sleep();
                if (!pause){
                    // do work
                }
            }
        }
    }
    
    private static void test(){
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Runner.start();
                    Thread.sleep(1000);
                    Runner.pause();
                    Thread.sleep(1000);
                    Runner.continueAfterPause();
                    Thread.sleep(1000);
                    Runner.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    public static void main(String[] args){
        Runner.test();
    }
}
