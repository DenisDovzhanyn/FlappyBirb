# Flappy Birb

Flappy Birb is a simple, fun, and engaging game inspired by the classic Flappy Bird. The player controls a fish that must navigate through a series of pipes while avoiding obstacles and scoring points. The game is built using the LibGDX framework, which allows for cross-platform game development.

## Overview

The game consists of several components, including:

- **Main Game Class (`FlappyBirb`)**: This class initializes the game and manages the screens.
- **Game Screen (`FlappyScreen`)**: The main gameplay screen where the player interacts with the game.
- **Main Menu (`MainMenu`)**: The screen displayed when the game starts or when the player loses.
- **Scores Management (`Scores`)**: Manages the high scores and file operations related to storing and retrieving high scores.

## Features

- **Simple Controls**: The player can make the fish jump by clicking the screen or pressing the spacebar.
- **Dynamic Gameplay**: The game generates pipes that the fish must navigate through
- **High Score Tracking**: The game keeps track of the highest score achieved and stores it in a text file.

## Game Logic

- The fish's movement is influenced by gravity and jump force, creating a smooth jumping motion.
- Pipes are spawned at regular intervals, and their positions are updated to create the illusion of movement.
- Collision detection is implemented to determine if the fish has hit a pipe or the floor, resulting in a game-over state..
