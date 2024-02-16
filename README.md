# Backend-Intern-Technical-Assessment

Tools/Software(required) 
JDK 17
SpringBoot 3.1.8
Build Tool Maven
Postman

Quickstart :
1.Clone the repository
2.Open the project in your IDE: IntelliJ IDEA (recommended) or Eclipse

If you are using IntelliJ IDEA, make sure the IDE opens project as Maven and recognizes the project as a Spring Boot project. 
1.Configure the database connection in application.properties file, I have created database name `zindus` .
2.Run the project (by running the main method in DemoApplication.java)

Endpoints
1. Add  a  User  to  database
http://localhost:8080/user/signup
![image](https://github.com/Anshul-eng/Backend-Intern-Technical-Assessment/assets/105932043/6802794a-61ef-4a16-ad3b-42e4625ea467)

2.Login 
http://localhost:8080/login
![image](https://github.com/Anshul-eng/Backend-Intern-Technical-Assessment/assets/105932043/eeeb7204-16d0-4456-be43-c0ed01127db8)

3.create wishlist (POST Request):
 http://localhost:8080/api/wishlists
 ![image](https://github.com/Anshul-eng/Backend-Intern-Technical-Assessment/assets/105932043/71b1faf5-72e1-4636-a7c0-073395a16900)

 4.get wishlist(GET ):
http://localhost:8080/api/wishlists
![image](https://github.com/Anshul-eng/Backend-Intern-Technical-Assessment/assets/105932043/af033758-0655-4046-b749-eebd5793c937)

5.remove item from wishlist (delete):
http://localhost:8080/api/wishlists/1
![image](https://github.com/Anshul-eng/Backend-Intern-Technical-Assessment/assets/105932043/d30ab6eb-6478-44fb-b345-c44b700fc123)




