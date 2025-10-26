Simply a repo for learning reactive java 

Fundamentally it's about being lazy, instead of always fetching data, even if we don't have any new updates we simply fetch it as an updates comes. Let's think about stock price. If we always fetch, even if there are no updates, we'll just make more trafic and consume more resources than needed. The solution to this is programming in a reactive way. 

- Data Stream: 
We establish a *reactive* stream that emites stockh price updates from the API. Now to be clear, a reactive stream works as a "subscription" basically, we continuosly get info from the stream. So the difference from a traditional way, where we have a fucntion that look for one answer then we run the function over and over again we have a funciton that cont. run and we get values as a subscription. 

- Subscription
Now we subscribe to the dta stream in our application. This means that the code will be notified when a new stock price update is emitted. There are different types: 
    - Hot Observables:
        they emit data regardless of there are subscribers or not. Once subscribed you'll get all the emitted data.

    - Cold Observables: 
        they emit only when subscribed. 

- Processing: 
Update happen, process it and update the UI to display the latest price 
 