Based on Tutorial from Telusko: 
https://www.youtube.com/watch?v=35EQXmHKZYs

-----
pom.xml ... 1st line was showing error due to eclipse bug. 
Had to downgrade maven-jar-plugin as follows: 

	<properties>
		<java.version>1.8</java.version>
		<maven-jar-plugin.version>3.1.1</maven-jar-plugin.version>
	</properties>
	
-------


