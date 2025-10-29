import java.time.LocalTime;
import java.time.Duration;
import reactor.core.publisher.Flux;  


public class TimeStream {
    public static void main(String[] args) throws InterruptedException {
        // stream that emits one number every second
        Flux.interval(Duration.ofSeconds(5))
           .map(tick -> LocalTime.now())
           .subscribe(time -> System.out.println(time));
        Thread.sleep(60_000);
    }    
}
