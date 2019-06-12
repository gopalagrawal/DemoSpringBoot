<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
  ${welcomemsg} ${alien}
  
  <form action="addAlien" method=get>
  
  	ID:   <input type=text name="aid">	<br>
   	NAME: <input type=text name="aname"><br> 	
   	TECH: <input type=text name="tech">	<br>
   	
   	<input type=submit> 
  </form>
  
  <hr>
  
    <form action="getAlien" method=get>
  	ID:   <input type=text name="aid">	<br>
   	<input type=submit> 
  </form>
  
  
</body>

</html>