# ZipCode Formatter

* Save the project to local computer.
* Import the project as maven existing project to eclipse or spring tool suite. 
* Right click on project and maven clean, maven install.
* Right click on project Run As -> Run Configurations -> Add this in Arugments tab - parameterized arguments. 
** spring-boot.run.jvmArguments
* Apply and run.
* Hit the following end point in brower to see the output.
* http://localhost:8080/zipcodes/
* Change the input data in getZipCodeRangesData method to run with different inputs. 
* Or Access the http://localhost:8080/zipcodes1/ from postman tool and provide the input in below format.
* { "zipCodes":" [94133,94133] [94200,94299] [94226,94399] " }
    "zipCodes":" [94133,94133] [94200,94299] [94226,94399] [66210,66213] [66214,66215] "
* Open ZipCodeSFormatterServiceImplTest and right click and run as junit.

Note: Make sure there is space in begining and end with in quotes.
