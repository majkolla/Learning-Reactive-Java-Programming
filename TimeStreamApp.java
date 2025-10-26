import reactor.core.publisher.Flux; 
import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TimeStreamApp {
    public static void main(String[] args) {
        var scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {System.out.println("time is: " + LocalTime.now());
        },0,1, TimeUnit.SECONDS);
    }
}