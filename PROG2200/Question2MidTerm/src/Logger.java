import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {


    private PrintWriter writer;
    private static Logger logger = null;
    private static boolean performanceMode = false;
    private static String priority = "med"; // low, med, high  NOTE: High is for exception printing, the program will do this ON ITS OWN.

    private Logger() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy-HH.mm.ss");
            String time = formatter.format(new Date());
            System.out.println(time);
            String logFile = "log_" + time + ".log";
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException ignored) {}
    }

    public void logStuff(String name, int amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy-HH.mm.ss");
        String time = formatter.format(new Date());
        if(priority.equals("low")) {
            writer.println(name + "," + amount);
        }
        if(priority.equals("med")){
            writer.println(time + "," + name + "," + amount);
        }
    }

    public void logError(String error){
        writer.println(error);
    }
    public void logError(Exception error){
        error.printStackTrace(writer);
    }

    public static synchronized Logger getInstance(){
        if(logger == null)
            logger = new Logger();
        return logger;
    }


    public void setPerformanceMode(boolean performanceMode) {
        Logger.performanceMode = performanceMode;
    }

    public static boolean isPerformanceMode() {
        return performanceMode;
    }

    public static String getPriority() {
        return priority;
    }

    public static void setPriority(String priority) {
        Logger.priority = priority;
    }
}