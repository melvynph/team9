# Project 1: PacMan #
## **Team 9**

## 1. Group Members
Sarah Bang, Anjali Sharma, Rongjing Li, Zeeshan Shaikh


## 2. Image of Our Code Playing PacMan
<img src="pacman.png" width="200" title="PacMan Game">


## 3. The Code from the Command Line (How to Run)
To run the code, please input these directions onto the command line:
```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```
Make sure you are on the project root folder/directory when running the commands.
Running these commands should open the JFrame and allow you to play Automonous PacMan.

b) Test the code by running JUnit
```bash
javac -cp "tests/junit-4.10.jar:src/:tests/" src/*.java tests/*.java
java -cp "tests/junit-4.10.jar:src/:tests/" org.junit.runner.JUnitCore your_test_here
ex: java -cp "tests/junit-4.10.jar:src/:tests/" org.junit.runner.JUnitCore TestGhostMove
```

## 4. List of the Functions We Wrote
This section contains all of the functions our team wrote and implemented.

### PacMan Class
The PacMan Class implements the functionality of the PacMan component in the game.

#### move()
- **Type:** `() -> Bool`
- **Description:** Moves the Pacman component by calling the myMap object's move() method.
- **Test:** Tested pacman not being able to move in an enclosed space, then being able to
move in a corridor.

#### consume()
- **Type:** `() -> JComponent`
- **Method Description:** This method checks to see if there is a 'power-cookie' located in Pacman's current coordinate. If there is, this method calls the eatCookie method from the Map Class, and returns the cookie component if the cookie a consumed, and null otherwise.
- **Test Description:** This test uses JUnit Assert API to test if the consume method in PacMan class is functional. It created a new frame and pacman object, setted the inital position to (0, 0). According to Map.txt, there is a wall, so the pacman can't do anything with cookies anyway, and the method should return null if the method works.

#### get_valid_moves()
- **Type:** `() -> ArrayList`
- **Method Description:** This method returns all the valid moves that PacMan can make given his current position. Invalid moves include walls and out of bounds.
- **Test Description:** Tested with JUnit Assert API to check if the result contains the correct valid moves in multiple locations.

#### is_ghost_in_range()
- **Type**: `() -> Bool`
- **Method Description:**: This method checks its surroundings to see if any Ghosts are in attack range. The attack radius of a ghost is 1 in respect to their x and y coordinates. If any Ghosts are in the attack range, this method returns true otherwise it returns false.
- **Test Description:**: Tested a ghost at (1,2) and pacman at (1,1), therefore it is true that there is a ghost in range since they are 1 apart.


### Ghost Class
The Ghost Class implements the functionality of the Ghost component in the game.

#### move()
- **Type:** `() -> Bool`
- **Description:** Moves the Ghost component by calling the myMap object's move() method.
- **Test:** Tested a red ghost not being able to move in an enclosed space, then being able to
move in a corridor.

#### get_valid_moves()
- **Type:** `() -> ArrayList`
- **Method Description:** This method returns all the valid moves that a Ghost can make given its current position. Invalid moves include walls and out of bounds.
- **Test Description:** Tested with JUnit Assert API to check if the result contains the correct valid moves in multiple locations.

#### is_pacman_in_range()

- **Type**: `() -> Bool`
- **Method Description**: This method checks its surroundings to see if any Pacmans are in attack range. The attack radius of a pacman is 1 in respect to their x and y coordinates . If any Pacman are in the attack range, this method returns true otherwise it returns false.
- **Test Description**: Tested a ghost at (1,2) and pacman at (1,1), therefore it is true that there is a pacman in range since they are 1 apart.

#### attack()

- **Type**: `() -> Bool`
- **Method Description**: This method returns true if the the is_pacman_in_range() function returns true. this means that the ghost can attack, and was successful. 
- **Test Description**: Tested a ghost at (1,2) and pacman at (1,1), therefore it is true that there is a ghost in range since they are 1 apart. This means that is_pacman_in_range() returns true, and attack() will return true as well. 


### Map Class
The Map Class uses Java GUI to create the visual represenation of our game.

#### move(String name, Location loc, Type type)
- **Type:** `(String name, Location loc, Type type) -> Bool`
- **Description:** Takes the name, location, and type of a component and moves it to the specified location.
- **Test:** Tested if a pacman and ghost can move, but cookies should not move.

#### attack(String name)
- **Type:** `(String name) -> Bool`
- **Method Description:** The method controls ghosts attacking pacman. If the ghost was able to successfully attack pacman and update the display to do so return true, otherwise return false.
- **Test Description:** This test uses JUnit Assert API to test if the attack method in Map class is functional. It created a new frame, pacman, and ghost object, setted the inital position to (0, 0). According to Map.txt, there is a wall, so there won't be any attack happens, and the method should return null if the method works. And then the pacman shifts to (1, 1), at this point, the method should not return null.

#### eatCookie(String Name)
- **Type:** `() -> JComponent`
- **Method Description:** The method controls Pacman eating a cookie. When the function is able to successfully update display to eat a cookie it returns the Cookie component that has been eaten, otherwise it returns null.
- **Test Description:** This test uses JUnit Assert API to test if the eatCookie method in Map class is functional. It created a new frame and pacman object, setted the inital position to (0, 0). According to Map.txt, there is a wall, so the pacman can't eat cookie, and the method should return null if the method works. And then the pacman shifts to (1, 1), at this point, the method should not return null.

#### getLoc(Location loc)
- **Type:** `(Location loc) -> HashSet<Type>`
- **Method Description:** For the given location argument, this method returns what is currently at the location (Empty, Pacman, Cookie, Ghost, Wall).
- **Test Description:** Tested with JUnit Assert API to check if the result contains the correct Types.



-----
Sources: CMSC388T - University of Maryland, College Park
-----
