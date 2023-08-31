# Java OOP mini project

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Rock, Paper, Scissors in Java

## Overview

It's time to put your Java knowledge to use. Create a basic version of rock–paper–scissors that allows users to play against the computer in the console. The game consists of a few main features:

- Play rock–paper–scissors against a computer player.
- Play rock–paper–scissors against a human player.

> **Hint**: Use a [random number generator](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html) to make the computer's choice.

---

## Feature Requirements

Your game must:

- Have a main menu with options to enter `2 players` or `vs. computer`.
- If the user enters `2 players`, they should be able to play rock–paper–scissors against a human competitor.
- If the user enters `vs. computer`, they should be able to play against the computer.
- When the game is over, the winner should be declared.

## Technical Requirements (HARD)

Use classes to remove repetitive parts of code

- Create an abstract `Player` class to manage the player's state (if they won or lost, how many points they have, what
  move they made).
- In addition, interfaces should be used in places where they are necessary.

Handle invalid user input

- Validate user input to ensure that it is valid.
- If the user input is invalid, provide an error message and ask the user to enter a valid input.
- Handle incorrect capitalization of otherwise valid user input.
- Convert all user input to lowercase before validating it.

Each class (including a `Player` class) should have methods associated with it and be instantiated as an object (as
opposed to a singleton or an interface).

- This will make the code more modular and easier to maintain.
- It will also make it easier to test the code.

Use `public`, `private`, and `static` variables, methods, and members within each class appropriately.

- `public` variables and methods are accessible from anywhere in the code.
- `private` variables and methods are only accessible from within the class they are defined in.
- `static` variables and methods are shared by all instances of the class.

Incorporate exception handling to make sure your game crashes gracefully if it receives bad input.

- Use try-catch blocks to handle exceptions.
- This will prevent the game from crashing if it receives bad input.

Get standard input with Java using a `Scanner`.

- A `Scanner` object can be used to read input from the standard input stream.
- This can be used to get user input from the keyboard.

Use arrays or array lists to store game history (if applicable).

- Arrays and array lists can be used to store a sequence of values.
- This can be used to store the history of the game, such as the moves that have been made by each player.

Add Java Doc string and proper comments.

- Add JavaDoc strings to each class, method, and variable to document their purpose and usage.
- Add comments to the code to explain what the code does and why it is doing it.

Use Java Optionals and Lambdas.

- Optionals can be used to represent the absence of a value.
- Lambdas can be used to write concise and expressive code.

Here are some examples of how Java Optionals and Lambdas can be used in the requirements:

- The `Player` class can have an `Optional<String>` field to represent the player's name.
- The `validateUserInput()` method can return an `Optional<String>` to represent the validated user input.
- The `getMove()` method can take a `String` parameter and return a `Player` object, or an `Optional<Player>` if the
  player name is not found.
- The `printGameHistory()` method can take an array of `String` objects and print them to the console.

Must have at least **50 commits** with proper git commit messages dating back to the beginning of the project.

This means that the project must have been started at least 50 commits ago, and each of those commits must have a proper
git commit message. A proper git commit message is one that is clear, concise, and follows the conventions that are used
by the team or project.

Here is an example of a proper git commit message:

```
Fix bug where the game would crash if the user entered an invalid move.
```

This commit message is clear, concise, and follows the conventions that are commonly used. It is also a good example of
a commit message that would be helpful for future developers who are trying to understand the code.


## Bonus Ideas

- Write automated JUnit tests for your application.
- Use an Agile project management framework for your game.
- If the user enters `history`, the program should display previous game history (winner's name, game date, and more).
- Use Java packages to modularize code. Place any helper tools in these packages — they could be related input, networking, or graphics.
- Use Maven to install external dependencies your game might require.
- Use [generics](https://docs.oracle.com/javase/tutorial/extra/generics/index.html) on collections such as arrays and array lists to store different data composed of different types.
- Use multithreading to handle concurrent requests (like in multiplayer games).

### Necessary Deliverables

Submit a pull request with a Java program that meets the above requirements.

Below, you can see sample output:

```
Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

play


Type 'rock', 'paper', or 'scissors' to play.
Type 'quit' to go back to the main menu.

rock
Computer picks: scissors
User picks: rock
You win!

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

play


Type 'rock', 'paper', or 'scissors' to play.
Type 'quit' to go back to the main menu.

paper
Computer picks: scissors
User picks: paper
You lose!

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

history
=== GAME HISTORY ===
WIN: Player picked rock, computer picked scissors
LOSS: Player picked paper, computer picked scissors

Welcome to Rock, Paper, Scissors!

MAIN MENU
=====
1. Type 'play' to play.
2. Type 'history' to view your game history.
3. Type 'quit' to stop playing.

quit
```

---

#### Suggested Ways to Get Started

- Don't hesitate to write throwaway code to solve short-term problems.
- Read the docs for whatever technologies you use. **Most of the time, you can follow a tutorial. However, learning to read documentation is crucial to your success as a developer.**
- Write pseudocode before you write actual code.

---

### Useful Resources

- [Random Number Generator](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
- [Rules and History of Rock–Paper–Scissors](https://en.wikipedia.org/wiki/Rock-paper-scissors)

---
