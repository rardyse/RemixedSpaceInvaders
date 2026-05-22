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

### Week 7: to come ....


## ★ Notes
- All files are organized according to the assignment and assistant instructions.  
- External libraries were properly added and required resource folders were configured.
