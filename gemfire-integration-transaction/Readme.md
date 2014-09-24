#Spring Integration with transactions example

This application listens to a region
**Customer** and copies the data to two other regions, **CustomerCopy1** and **CustomerCopy2**.

The example uses a local GemFire instance,  however the instance could be swapped out for a remote durable queue query or a a remote continuous query.

The writes to **CustomerCopy1** and CustomerCopy2 should both be successful otherwise the transaction
will be rolled back and the message will be written to the Error region.

In order to simulate a failure their is a CacheWriter assigned to CustomerCopy 1 that will throw an error if the last name of the Customer is Smith.

Run the main class in **Application.class** you should see output inidicating that only two of the Customers added to the Customers region were copied the copy regions and John Smith is in the Errors Region.

> 
> customer list is [Smith, Revere, Doe]
> 
> order list is [Revere, Doe]
> 
> product list is [Revere, Doe]
> 
> error list is [Smith]


You can also view the CacheWriter/CacheListener activity to see what data was written to which region.
