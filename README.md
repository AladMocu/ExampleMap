# Welcome to ExampleMap!
This is a simple example repo about the use of JxMaps

 - [The explaining video](https://youtu.be/-ofmjUWQEAI)
   
  - [Library Buy Page]( https://www.teamdev.com/jxmaps)
   
   - [JxMaps API](https://www.teamdev.com/downloads/jxmaps/docs/index.html)

**Info message**
-On the video there is a missed library that is now in the repo its called		`jxmaps-win-1.3.1`  its necesary for the first time you use this library


-If you are getting a null pointer exception after trying to create a marker or something over a preloaded map you should add this after the map constructor:



```java
System.out.print("Wait until map is generated ");
	try {
		for(int i=0;i<10;i++)
		{
			TimeUnit.SECONDS.sleep(1);
			System.out.print(".");
		}
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
	
```


It will give the map 10 seconds to load until receive any request
