1. Save the project to local computer.
2. Import the project as maven existing project to eclipse or spring tool suite. 
3. Right click on project and maven clean, maven install.
4. Right click on project Run As -> Run Configurations -> Add this in Arugments tab - parameterized arguments. 
5. spring-boot.run.jvmArguments
6. Apply and run.
7. Hit the following end point in brower to see the output.
8. http://localhost:8080/zipcodes/
9. Change the input data in getZipCodeRangesData method to run with different inputs. 
10. Or Access the http://localhost:8080/zipcodes1/ from postman tool and provide the input in below format.
11. { "zipCodes":" [94133,94133] [94200,94299] [94226,94399] " }
"zipCodes":" [94133,94133] [94200,94299] [94226,94399] [66210,66213] [66214,66215] "
12. Open ZipCodeSFormatterServiceImplTest and right click and run as junit.

Note: Make sure there is space in begining and end with in quotes.
