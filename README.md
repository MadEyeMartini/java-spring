# java-spring

Unfortunately I have ran out of time (I have a birthday party to run to!) and was not able to refactor the code however there is a working solution but not all edge cases may be covered.

I am sorry for the quality of code, I focused more on "brute-forcing" a solution and planned to refactor late but I have had another technical challenge to do alongside this.

To build is very simple! First off, sign up to Mongo Atlas (It's free!) (Or any platform hosting MongoDB) and create a database with any name, the collection should be provider offers. Once done just go ahead and put the connection string in the application.properties

Example:

spring.data.mongodb.uri=
spring.data.mongodb.database=

Keep CSVs in resources folder!

That is it! 

**Notes**

1. Repeating above a little but refactoring was a little problem due to time constraint.
2. Comments are left throughout although a lot may be self explanatory.
3. I attempted to "simulate" some aspects, for example I could have use annotation binding to automatically bind columns to variables but this would need to be hardcoded for each provider. Instead I used a switch case that I think can represent more of a database, but optimally I would store provider chosen headers in a database.
4. CSVInput needs heavily refactoring as it performs some MongoDB operations after reading but I ran out of time, data formatting (Removing £) should also be done in a cleaner fasion.
5. The /Get is not optimal, it will always query the database, if given more time an object cache could have been implemented.
6. CSV paths are hardcoded in to read, another solution would just be to load all CSV within a folder but alas time is not in my favour.
7. The GenericProviderImp was going to be a generic class that used synonyms to detect and automatically load CSVs, for example NAME, BRAND, MANUFACTURER would all link to MAKE. I had ran out of time for this too! :(
8. I have not used Java since 2019 but Spring Boot is very cool, this was my first time using it!
