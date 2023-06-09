﻿# Hyperlocal_Assignment

# SHIELD Dashboard

The SHIELD Dashboard is a Java program that uses OOPS (Object-Oriented Programming) concepts to simulate the tracking and management of the missions assigned to Avengers.

## Classes

The program consists of five classes:

1. Avenger
   This class represents an Avenger with attributes such as name, ability, number of missions assigned and completed, and status. It also has a HashSet of missions to which the Avenger is assigned. The class has methods to assign a mission, complete an assigned mission, and assign a completed mission.

2. Dashboard
   This class represents the dashboard used to manage the Avengers and their missions. It has a Database object to store all the Avenger and Mission objects. The class has methods to check the status of missions, check the availability of Avengers, add a new mission, print mission and Avenger details, and update the mission status.

3. Database
   This class represents the database used by the Dashboard to store all the Avenger and Mission objects. It has methods to get, add, and update the Avenger and Mission objects.

4. Mission
   This class represents a mission assigned to one or more Avengers. It has attributes such as name, details, status, and a list of Avengers assigned to it.

5. Service
   This is the entry point of the program. It creates an instance of the Dashboard class and allows the user to interact with the program.

## OOPS Concepts Used

The SHIELD Dashboard program uses several OOPS concepts, including:

1. Encapsulation
   Encapsulation is used to encapsulate the data of the Avenger, Dashboard, and Mission classes. The data can only be accessed through methods provided by the classes, which helps maintain the integrity of the data.

2. Inheritance
   Inheritance is not used in this program.

3. Polymorphism
   Polymorphism is not used in this program.

4. Abstraction
   Abstraction is used to hide the implementation details of the Avenger, Dashboard, and Mission classes. Users only need to know how to use the methods provided by these classes, and not how they are implemented.

## How to Use

To use the SHIELD Dashboard program, follow these steps:

1. Clone or download the project from the Github repository.
2. Open the project in an IDE such as Eclipse or IntelliJ IDEA.
3. Run the Service.java file to start the program.
4. Follow the prompts to interact with the program.

## Conclusion

The SHIELD Dashboard program is a useful tool for tracking and managing the missions assigned to Avengers. It uses OOPS concepts to maintain the integrity of the data and provides an easy-to-use interface for users.

![image](https://github.com/AniS135/Hyperlocal_Assignment/assets/85433315/47702e22-c723-4912-89f2-ee1c069b0c40)

# Cricket Scoreboard

This program is designed to provide users with a simple Cricket scoreboard for a match between two teams. This program will enable the user to set the number of players per team and the number of overs for the match. The program will also ask for the batting order of each player for both teams, and then proceed to play the match and display the score and the result of the match.

## Object Oriented Programming (OOP) Concepts

This program implements the following OOP concepts:

### Classes
The program uses four classes: `Match`, `Player`, `Scoreboard_Manager`, and `Team`.

### Objects
The program creates instances of the `Match`, `Player`, and `Team` classes.

### Encapsulation
The program uses encapsulation to hide the implementation details of the `Player` and `Team` classes from other classes.

### Inheritance
The program does not implement inheritance.

### Polymorphism
The program does not implement polymorphism.

## Classes

### Match
This class is responsible for the main functionality of the program. It initializes the `Team` objects and calls the `inning` method for each team. It also displays the result of the match.

### Player
This class represents a player of the cricket team. It has attributes like `name`, `score`, `countOfFours`, `countOfSixes`, and `balls`, and methods like `nextBall` to update the players score and ball count.

### Scoreboard_Manager
This class is responsible for managing the overall program flow. It takes input from the user and initializes the `Match` object.

### Team
This class represents a cricket team. It has attributes like `numOfPlayers`, `playerOrder[]`, `nextGonnaBePlayer`, `score`, and `out`, and methods like `inputBattingOrder`, `nextPlayer`, and `nextBall` to manage the teams players and score.

## Usage

To use the program, you can run the `Scoreboard_Manager` class. The program will prompt the user to enter the number of players per team and the number of overs. The program will then ask for the batting order of each player for both teams. After that, the program will play the match and display the score and the result of the match.

![image](https://github.com/AniS135/Hyperlocal_Assignment/assets/85433315/68992a75-598f-41f7-a665-de2d537fdb9e)
