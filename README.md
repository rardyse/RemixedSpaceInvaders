# Remixed Space Invaders

## ★ Authors
- Luna Darwich
- Mirnela Vejzovic  


## ★ Course Information
Object-Oriented Programming  
Spring Semester 2026  
University of Fribourg  

GROUP 11


## ★ Description
This repository contains the work completed throughout the semester for the Object-Oriented Programming course.  
It includes all exercises, project implementations, and tester classes developed step by step.


## ★ Contents

### Week 1: Sprite Implementation
- Implemented `Sprite.java` class with x/y coordinates.  
- Added getters, setters, and `paint()` method.  
- Tested sprite drawing using `Tester.java`.  

### Week 2: Factory Methods & SpriteList
- Created factory methods for `Sprite` to instantiate with different images.  
- Implemented `SpriteList` for storing multiple sprites.  
- Added methods `add()`, `remove()`, `get()`, `getSize()`, `allocateSpace()`.  
- Tested adding multiple sprites and drawing them from the list.  

### Week 3: Game Object Hierarchy
- Designed hierarchy for `Enemy`, `Shot`, and `Player`.  
- Created classes with constructors and fields; methods left empty for later implementation.  
- Started planning inheritance and shared behaviors.  

### Week 4: Interfaces, Abstract Classes & Movement
- Improved hierarchy using abstract classes and interfaces.  
- Implemented `move(Direction direction)` method for each moveable object.  
- Added sprites for each game object and scaled images as necessary.  
- Tested movement of game objects with `Tester.java`.  

### Week 5: MVC Structure, Point & Vector
- Built project package structure following MVC (Model, View, Controller).  
- Replaced x/y fields with `Point` and `Vector` for object positioning.  
- Updated movement logic to use vectors and translation.  
- Verified correct behavior with a tester class.  

### Week 6: Enums & Generic LinkedList
- Created `Direction` enum for UP, DOWN, LEFT, RIGHT.  
- Updated `Moveable` interface and all movement calls to use enum instead of strings.  
- Implemented generic linked list classes `MyLinkedList`, `Node`, and `Iterator`.  
- Added methods `add()`, `remove()`, `get()`, `size()` and partially implemented `listIterator()`.  

### Week 7: Iterator & List Refactoring
- Fully implemented `Iterator` class with `hasNext()`, `next()`, `hasPrevious()`, `previous()`, `add()`, `remove()`, `set()`.  
- Replaced all custom lists (`EnemyList`, `ShotList`, `PlayerList`, `SpriteList`) with generic `MyLinkedList<T>`.  
- Updated `Attacker` interface and all attack methods to return `MyLinkedList<Shot>`.  
- Replaced for-loops with for-each loops where possible.
  
### Week 8: GUI, KeyListeners & Shooting
- Designed and planned the GUI for the Space Invaders game.  
- Implemented `Board.java` extending `Display` as the main game window.  
- Created `SpaceInvaders.java` as the main controller extending `Animation`.  
- Added `KeyAdapter` for player movement (LEFT, RIGHT) and shooting (SPACE).  
- Implemented shooting logic for player (500ms cooldown) and enemies (0.5% chance per frame).
  
### Week 9: Enemy Movement & Collision Detection
- Implemented `MyOrderedLinkedList` with `getMin()` and `getMax()` methods.  
- Added `moveEnemies()` with border detection — enemies reverse direction and descend.  
- Created `getBoundingBox()` in `Sprite` returning a `java.awt.Rectangle`.  
- Added `checkCollision()` in `Sprite` using `Rectangle.intersects()`.  
- Implemented `resolveShotsCollisions()` to handle bullet/enemy and bomb/player collisions.  
- Added exceptions in `MyLinkedList.remove()`, `Enemy.gotHit()` and `Player.gotHit()`.
  
### Week 10: Custom Animation & advanced GUI (personal choices & implementations)
- Replaced `oop.lib.Animation` with a custom `Animation.java` class implementing `Runnable` and `ActionListener`.  
- Added animated `StartScreen` with falling stars effect and glow title.  
- Implemented HUD (score, lives with icons, title) using `Graphics2D` overlay.  
- Added victory and game over images with centered display.  
- Integrated background music and sound effects for victory and game over.  
- Added replay functionality with R key and exit with E key.  
- Added visual border around the game area and formatted score display.

## ★ Notes
- All files are organized according to the assignment and assistant instructions.  
- External libraries were properly added and required resource folders were configured.
