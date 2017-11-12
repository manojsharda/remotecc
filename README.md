# Remote Controlled Cars

### Description
The purpose of this exercise is to demonstrate TDD and come up with a solution to the problem given below. Working unit tests will be sufficient as a solution, but you may provide a simple user interface to demonstrate your codes capability if you desire.
Cars are placed on a 15 by 15 grid at particular co-ordinates heading north, and the simple commands Left, right and forward are transmitted to them. The commands must be executed and the final position calculated.
The following examples should be used to demonstrate your code:

For the input "5,5:RFLFRFLF"
We should get the position "7,7"

For the input "6,6:FFLFFLFFLFF"
We should get the position "6,6"

For the input "5,5:FLFLFFRFFF"
We should get the position "4,1"


### How to Build and Run the Project
This project uses the [Maven](http://maven.apache.org/) build system, you can build the project locally just by typing the following in the console:
```
./mvn install
```
The output of the Maven build is located in the  `target/` directory.

Note that this goal runs all JUnit tests included in the solution.

When using Eclipse, I recommend simply importing the project via the
File->Import->Existing Maven Project. Select the directory
corresponding to this solution.

To run the project, you can execute the generated jar by typing the following:
```
./java -jar RemoteCCars.jar
```
You will be asked to enter the Car initial position and the commands to be executed in the following format `X,Y:Commands`

### Assumptions
- Input data will be entered through System.in
- Grid size can be defined only during creation
- Multiple cars are allowed in the grid
- Minimum position is (1,1)
- When a car reaches the grid limit and a forward command is sent, it's position will remain unchanged