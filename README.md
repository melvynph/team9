# Project 1: PacMan
**Team 9**: Sarah Bang, Anjali Sharma, Rongjing Li, Zeeshan Shaikh

## Description
[short description of the project]

## Playing Pacman
[image here]

## Command line Instructions

To run the code, please input these directions onto the command line:
```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```
Make sure you are on the project root folder/directory when running the commands.
Running these commands should open the JFrame and allow you to play Automonous PacMan.

### Submitting

Once you complete each feature, you will submit a pull request from your feature to the main branch. Assign your project manager as a reviewer to this pull request and they will grade your work. Make sure to assign any pull requests from feature items to feature branches to your assigned cards. We will use this to grade your individual contributions.

## Functions
This section contains all of the functions our team wrote and implemented.

### PacMan Class
The PacMan Class implements the functionality of the PacMan component in the game.

#### get_valid_moves()

- **Type**: `() -> ArrayList`
- **Description**: This method returns all the valid moves that PacMan can make given his current position.
- **Examples**:
  ```java
  //pacman at location (9,11)
  pacman.get_valid_moves() -> {(9,12), (10,11), (10,12)}
  ```

#### move()

- **Type**: `() -> Bool`
- **Description**: This method uses the get_valid_moves method to find the possible locations that PacMan can move, given his current location. The method then  chooses to move in one of those directions. You are free to apply an algorithm here if you would like, but the only requirement is that you move in a valid direction. If PacMan is able to move, this function returns true otherwise it returns false.
- **Examples**:
  ```java
  //pacman at location (9,11)
  pacman.move() -> true
  pacman.myLoc ∈ {(9,12), (10,11), (10,12)}
  ```

#### is_ghost_in_range()

- **Type**: `() -> Bool`
- **Description**: This method checks its surroundings to see if any Ghosts are in attack range. The attack radius of a ghost is 1 which means that a ghost at location <img src="https://render.githubusercontent.com/render/math?math=(x, y)">  can attack PacMan as long as PacMan is located at <img src="https://render.githubusercontent.com/render/math?math=(x \pm 1, y \pm 1)">. If any Ghosts are in the attack range, this method returns true otherwise it returns false.

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  pacman.is_ghost_in_range() -> true
  ```

#### consume()

- **Type**: `() -> JComponent`
- **Description**: This method checks to see if there is a 'power-cookie' located in Pacman's current <img src="https://render.githubusercontent.com/render/math?math=(x, y)">  coordinate. If there is, this method calls the _______ method from the Map Class, and returns a boolean if the cookie a consumed.
- **Examples**:
```java
//pacman at location (9,12)
//cookie NOT at location (9,12)
pacman.consume() -> null
```


### Ghost Class

The Ghost Class implements the functionality of the Ghost component in the game.

#### get_valid_moves()

- **Type**: `() -> ArrayList<Location>`
- **Description**: This function returns an arraylist of possible locations that a ghost can move to from its current location. Ghosts cannot move through walls, but they can move through other ghosts or PacMan.
- **Examples**:
  ```java
  //ghost at location (9,11)
  ghost.get_valid_moves() -> {(9,12), (10,11), (10,12)}
  ```

#### move()

- **Type**: `() -> Bool`
- **Description**: This function uses the get_valid_moves function to find the possible locations that a ghost can move to from its current location and chooses to move in one of those directions. You are free to apply an algorithm here if you would like, but the only requirement is that you move in a valid direction. If the ghost is able to move, this function returns true otherwise it returns false.

- **Examples**:
  ```java
  //ghost at location (9,11)
  ghost.move() -> true
  ghost.myLoc ∈ {(9,12), (10,11), (10,12)}
  ```

#### is_pacman_in_range()

- **Type**: `() -> Bool`
- **Description**: This function checks its surroundings to see if PacMan is in attack range. The attack radius of a ghost is 1 which means that a ghost at location <img src="https://render.githubusercontent.com/render/math?math=(x, y)">  can attack PacMan as long as PacMan is located at <img src="https://render.githubusercontent.com/render/math?math=(x \pm 1, y \pm 1)">. If PacMan is in the attack range, this function returns true otherwise it returns false.

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  ghost.is_pacman_in_range() -> true
  ```

#### attack()

- **Type**: `() -> Bool`
- **Description**: This function checks to see if PacMan is in the attack range by using the is_pacman_in_range method and attacks PacMan if it is in range. This function returns true if the attack was successful and false otherwise.

- **Examples**:
  ```java
  //ghost at location (9,11)
  //pacman at location (9,12)
  ghost.attack() -> true
  ```

### Map Class

The Map Class uses Java GUI to create the visual represenation of our game.
#### move(String name, Location loc, Type type)

- **Type**: `(String name, Location loc, Type type) -> Bool`
- **Description**: The method takes a name, location, and type and put the object specified by the name at the location. If the function is able to successfull move the object it returns true, otherwise it returns false.
- **Examples**:
  ```java
  //pacman at location (2,4)
  map.move("pacman", new Location (2,4), Map.Type.PACMAN) -> true
  ```
#### getLoc(Location loc)

- **Type**: `(Location loc) -> HashSet<Type>`
- **Description**: For the given location argument, returns what is currently at the location (Empty, Pacman, Cookie, Ghost, Wall).

 ```java
  //pacman at location (2,4)
  map.getLoc(new Location (2,4) -> Map.Type.PACMAN
  ```

#### attack(String name)
- **Type**: `(String name) -> Bool`
- **Description**: The method controls ghosts attacking pacman. If the ghost was able to successfully attack pacman and update the display to do so return true, otherwise return false.

 ```java
  //ghost named clyde at location (9,11)
  //pacman at location (9,12)
  Map.attack("clyde") -> true
  ```


#### eatCookie(String Name)
- **Type**: `() -> Bool`
- **Description**: The method controls Pacman eating a cookie. If it was able to successfully eat the cookie and update the display to do so return true, otherwise return false.

 ```java
  //cookie at location (4,6)
  //pacman at location (4,6)
  Map.eatCookie("pacman") -> true
  ```

---
Sources: CMSC388T - University of Maryland, College Park