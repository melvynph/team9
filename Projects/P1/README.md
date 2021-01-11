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

## Functions
This section contains all of the functions our team wrote and implemented.

### PacMan Class
The PacMan Class implements the functionality of the PacMan component in the game.

#### move()

- **Type**: `() -> Bool`
- **Description**: Moves the Pacman component by calling the myMap object's move() method.
- **Test**: Tested pacman not being able to move in an enclosed space, then being able to
move in a corridor.


### Ghost Class

The Ghost Class implements the functionality of the Ghost component in the game.

#### move()

- **Type**: `() -> Bool`
- **Description**: Moves the Ghost component by calling the myMap object's move() method.
- **Test**: Tested a red ghost not being able to move in an enclosed space, then being able to
move in a corridor.

### Map Class

The Map Class uses Java GUI to create the visual represenation of our game.
#### move(String name, Location loc, Type type)

- **Type**: `(String name, Location loc, Type type) -> Bool`
- **Description**: Takes the name, location, and type of a component and moves it to the specified location.
- **Test**: Tested if a pacman and ghost can move, but cookies should not move.

---
Sources: CMSC388T - University of Maryland, College Park
