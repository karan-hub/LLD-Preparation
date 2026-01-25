interface Logger {
    public void log(String msg);
}

class FileLogger implements Logger {

    @Override
    public void log(String msg) {
         System.out.println(msg+ "file logging");
    }
    
}

class DataBaseLogger implements Logger {

    @Override
    public void log(String msg) {
         System.out.println( msg +"DataBase logging");
    }
    
}

public class Solution {
    
}
