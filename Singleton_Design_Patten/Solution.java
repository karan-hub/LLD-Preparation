
class Configuration {
    public static volatile Configuration INSTANCE;
    private String config;

    private Configuration() {
    }

    public static Configuration getInstance() {
        if (INSTANCE == null) {
            synchronized (Configuration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Configuration();
                }
            }
        }
        return INSTANCE;
    }

    public String getConfiguration() {
        return config;
    }

    public void setConfiguration(String config) {
        this.config = config;
    }
}

public class Solution {
    public static void main(String[] args) {
        Runnable task = () -> {
            Configuration config = Configuration.getInstance();
            System.out.println(Thread.currentThread().getName()
                    + " -> " + config.hashCode());
        };
        Thread t1 = new Thread(task, "t1");
        t1.start();
        Thread t2 = new Thread(task, "t2");
        t2.start();

        Thread t8 = new Thread(task, "t8");
        t8.start();

        Thread t3 = new Thread(task, "t3");
        t3.start();

        Thread t4 = new Thread(task, "t4");
        t4.start();

        Thread t5 = new Thread(task, "t5");
        t5.start();

        Thread t6 = new Thread(task, "t6");
        t6.start();

        Thread t7 = new Thread(task, "t7");
        t7.start();

    }
}