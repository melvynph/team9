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

#### move()

- **Type**: `() -> Bool`
- **Description**: Moves the Pacman component by calling the myMap object's move() method.
- **Test**: Tested pacman not being able to move in an enclosed space, then being able to
move in a corridor.

#### is_ghost_in_range()

- **Type**: `() -> Bool`
- **Description**: This method checks its surroundings to see if any Ghosts are in attack range. The attack radius of a ghost is 1 in respect to their x and y coordinates. If any Ghosts are in the attack range, this method returns true otherwise it returns false.
- **Test**: Tested a ghost at (1,2) and pacman at (1,1), therefore it is true that there is a ghost in range since they are 1 apart.


### Ghost Class

The Ghost Class implements the functionality of the Ghost component in the game.

#### move()

- **Type**: `() -> Bool`
- **Description**: Moves the Ghost component by calling the myMap object's move() method.
- **Test**: Tested a red ghost not being able to move in an enclosed space, then being able to
move in a corridor.

#### is_pacman_in_range()

- **Type**: `() -> Bool`
- **Description**: This method checks its surroundings to see if any Pacmans are in attack range. The attack radius of a pacman is 1 in respect to their x and y coordinates . If any Pacman are in the attack range, this method returns true otherwise it returns false.
- **Test**: Tested a ghost at (1,2) and pacman at (1,1), therefore it is true that there is a pacman in range since they are 1 apart.

#### is_pacman_in_range()

- **Type**: `() -> Bool`
- **Description**: This method returns true if the the is_pacman_in_range() function returns true. this means that the ghost can attack, and was successful. 
- **Test**: Tested a ghost at (1,2) and pacman at (1,1), therefore it is true that there is a ghost in range since they are 1 apart. This means that is_pacman_in_range() returns true, and attack() will return true as well. 

### Map Class

The Map Class uses Java GUI to create the visual represenation of our game.
#### move(String name, Location loc, Type type)

- **Type**: `(String name, Location loc, Type type) -> Bool`
- **Description**: Takes the name, location, and type of a component and moves it to the specified location.
- **Test**: Tested if a pacman and ghost can move, but cookies should not move.

---
Sources: CMSC388T - University of Maryland, College Park
