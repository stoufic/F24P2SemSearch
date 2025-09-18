# SemSearch (School Project)

This is a Java program developed for a **school project** that manages and searches seminar records using multiple data structures.  

## Features
- Stores seminars in **Binary Search Trees (BSTs)** (by ID, date, cost, keyword).  
- Maintains a spatial **BinTree** for location-based queries.  
- Supports operations like:
  - `insert <id>` (with title, date, cost, location, keywords, description)  
  - `delete <id>`  
  - `print ID|date|cost|keyword|location`  
  - `search ID <id>`  
  - `search keyword <term>`  
  - `search cost <low> <high>`  
  - `search date <start> <end>`  
  - `search location <x> <y> <radius>`  

Sample input and output files are included for reference.

## How to Run
```bash
# From the project root
javac -cp src -d out src/*.java
java -cp out SemSearch P2_sampleInput.txt
