import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;



public class Weather {
    public static void main(String[] args) {
        ;

        HttpClient client = HttpClient.newHttpClient(); 

        Flux.interval(Duration.ofSeconds(1))
        // create an infinte stream 
        .flatmap(tick -> Flux.fromCallable(() -> {
            // this part will run once every tick 
            // so here we do the http request 
            String url = "http://api.weatherapi.com/v1"; 
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build(); 

            HttpResponse<String> response = client.send(request, HttpRequest.BodyHandler.ofString()); 
    // We ret the response body, and that becomes the next item in the stream.
        return response.body();    
        
    })
    // tell the reactor: run this on a thread so we don't block the main reactive thread

    .subscribeOn(Schedulers.boundedElastic())
        )
    .subscribe(
        body -> {
            System.out.println("weather update:"); 
            System.out.println(body); 
        } 
    );
    
    Thread.sleep(60_000);
    }

}
