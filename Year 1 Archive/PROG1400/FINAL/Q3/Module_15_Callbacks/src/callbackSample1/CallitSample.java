package callbackSample1;

public class CallitSample {

    public static void main(String[] args) {
        CallerClass caller = new CallerClass();
        CallBack callBack = new IhaveaCallback();
        
        caller.register(callBack);  
        caller.start();
    }
} 

