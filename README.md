# Advent of Code 2025

This year I will be trying my hand at *[Advent Of Code](https://adventofcode.com/)!*

I will be attempting this in *Kotlin* in order to familiarize myself with the language.
I will also be writing about my process here. This year, there are *12 days* of puzzles.
My goal is to solve as many of them as possible, but not necessarily on the day they come out.
As I write, it is already December 2nd.

Conveniently, this year IntelliJ is [livestreaming](https://youtube.com/playlist?list=PLlFc5cFwUnmx9-VIcfxqhjHrwD3Lab4o4&si=v9J7AW-4XdhY-tEQ) their puzzle solving in Kotlin on their YouTube channel.
My goal for this year is learning rather than compete, so I will be checking these out where I get completely stuck.
I will write in my log when I do so, and note what I learn from it.
Even if I solve it completely by myself, I may still go back and watch the steams to see what a best practice approach might have been, if I have the time.

I also want to practice *Test Driven Development*.
Even though this is not a practical requirement of the task, I will write unit tests for my puzzle solutions.

## Day 1: *[Secret Entrance](https://adventofcode.com/2025/day/1)* Solved!

**Puzzle Outline**
- Goal: Find the password (to the North Pole).
- Goal: Solve the combination lock (containing the password).
- The dial has numbers 0-99 in order, and an arrow that spins.
- The dial is a circle, rotating past the minimum leads to the maximum and vice versa.
- Provided is a sequence of rotations.
  - "L" indicates turn left, towards lower numbers.
  - "R" indicates turn right, towards higher numbers.
  - A number indicates how many numbers the dial should be turned.
  - A new line indicates the end of that rotation.
- THE DIAL STARTS POINTED AT 50!
- Examples:
  - if the dial is at 11, and gets rotation R8,  it would then point to 19.
  - if the dial is at 19, and gets rotation L19, it would then point to 0.
  - if the dial is at 00, and gets rotation L1,  it would then point to 99.
  - if the dial is at 99, and gets rotation R1,  it would then point to 0.
  - 5 -> L10 -> 95
  - 95 -> R5 -> 0
- The solution is *not* the ending number.
- Instead, it is the number of times the dial is left pointing at 0.

**What I Need**
A method to gather the rotation sequence
- a "rotation" class containing a left/right boolean, and a distance.
- an array of these classes
- a method to search through a string of sequences
 - take the first character. Set direction based on R/L.
  - if I use a char byte for this, I can just steal the character itself
 - take the next character, hold onto it.
 - take the next character.
  - if it is a newline: get the integer of the held character and put it into the class. continue loop
  - if it is not: add the character to the string, get that number, skip over the predicted newline & continue the loop

A "combination lock" class
- Holds an integer state
- a method for rotating it left / right by an amount, careful to cross over minimum and maximum.

A rotator method
- feed array of rotations through safe
- gather return state of safe. if 0, increase a count.
- return the 0 count, and the ending state just for fun (and testing).

**Potential Problem**
What if the puzzle input has rotations with larger digit numbers like L08429380?
- I will need to change my string reading algorithm to only stop at a newline, instead of at two digits.
- This might be cleaner anyway, I think I will just implement it like this from the start.
- I am going to try to write this solution *before* looking at the puzzle input. I may do this differently for later puzzles.

**12/2/24 Log**
I've just implemented the rotation sequence separator as designed above, but now I am realizing something.
There is no reason to store rotations as a distance *and* direction.
Each rotation can be a single Integer, and the direction can exist as a positive or negative state. Left is negative, Right is positive.
Do I continue and juggle the consequences of my design?
Or do I refactor, even though it already works?

I decided to refactor, and it made my implementation of CombinationLock cleaner than I was imagining.
I could just apply the integer directly to the pointingAt value, instead of discerning between left and right turns.
I still am figuring out the syntax of Kotlin. I like being neat and concise, but am sure that will come with familiarity.

I implemented the solver, and I got... 1043. And it's correct!


**Part Two**
- using the same rotations, don't *just* count whenever it ends at 0.
- also count each time it crosses over zero

I already have a correction implemented for when the dial goes around zero.
Maybe this will be as simple as incrementing my count each time those activate.
I will introduce a new value for it though, so that I retain the ability to solve Part 1.

Some time later: It is not so easy. My test cases pass, but my solution is incorrect.
I suspect I am not handling an edge case where the dial starts or ends on a 0, and loops around across a zero or back onto it.
Tomorrow, I think I will change my CombinationLock implementation to be more literal, and do away with applying the rotation and correcting the number down after the fact.
I think that part of my implementation is the problem. It sounds crude, but incrementing the dial by one for each rotation may fix this.

12/3/25
I solved it! Changing the implementation gave me 5963 and worked. I really enjoy unit testing, changing the implementation while keeping each feature saves so much time.
There must have been an edge case with my previous implementation.
It was more optimized and I could have fixed it, but considering optimization at the expense of the actual goal seems silly.
Sleeping also did me good. I currently am home sick with Covid, so I wonder if that was affecting my problem-solving abilities.

So far, my biggest displeasure with Kotlin is the weird for loop syntax.
I'm very used to C styled for loops, but that's a superficial complaint and easy to get past.

12/13/25
Work and life has been busy, and I missed the intended completion window!
I still intend to complete this challenge by December 24th.
I work as a bank teller, and on slower days I have been using play.kotlinlang.org to write pseudocode and unit tests for days 2-5.
This has been fantastic for getting practice in, as I cannot install any software on the bank's computers, but can use some websites.
Note that, while I write this on the 13th, some of what I will be committing is being taken from text files I have emailed to myself from work over the past week.

## Day 2: *[Gift Shop](https://adventofcode.com/2025/day/2)* Solved!

**Puzzle Outline**
- receive an input of ranges
- format: `#####-#####,###-###,#####-#####`
- gather each range's min and max
- gather all ids in each range
- count each id that has a sequence of repeating numbers
- ie `55`, `6464`, `123123`
- id's do not lead with zeros (so `101` is not secretly `0101`)
- Goal: add all "invalid" ids together.

**Examples**
- `11-22` has two invalid id's: `11` and `22`
- `95-115` has one invalid id: `99`
- `998-1012` has one invalid id: `1010`
- `1188511880-1188511890` has one invalid id: `1188511885`
- `222220-222224` has one invalid id: `222222`
- `1698522-1698528` contains no invalid ids
- `446443-446449` has one invalid ID: `446446`
- `38593856-38593862` has one invalid ID, `38593859`
- Adding up all the invalid IDs in this example produces `1227775554`

**Initial Notes - What I Need**
- separate each range, and then separate each max and min
- collect each id in a range
```
for i = min, i <= max, i++
add i to array
```
- for each id, split into halves
- compare each half
- if the halves equal, add to a running count.

I passed all tests and input the puzzle data and... got an error!
It was fine until reading id 9184965756, which I realized is outside of the Integer limit.
Refactoring the code to use Longs got me the solution 9184965756.. and it's right!

**Part Two**
- ids aren't *just* invalid when they are composed of two repeating numbers.
- they are invalid when they are composed of ANY repeating sequence.
- ie 999, 123123123, 565656

Observations:
- Previously we would split the digits in half and compare each half.
- Now, we must split the digits into each possible division, and compare the sections of each division.
- a 10 character string is divisible into 1, 2, 5, and 10 character segments.
- previously we would divide it into 5 character segments, which is half the string.
- we don't have to break it into a 10 character segment, because you can't compare a single string against anything.
- so, we must segment it into each possible length, and compare segments of the same length.
- if any segment group is all identical, the id is invalid.

**What I need**
- alter tests & functions to take a "part" input.
- include tests for new rules.
- get all numbers an id is divisible by, excluding itself.
- for each divisible number, split the id into segments of that number.
- compare elements in each segment group.
- if any segment group is a full match, the id is invalid.

12/14/25
I implemented the above steps and passed all tests.
I got solution 43872163557 and... it's correct!
I am surprised that my idIsInvalid() refactoring worked on the first attempt.
It is extremely verbose with the added Part Two requirements and should probably be broken down into separate functions that can be tested in isolation.
I also could find a way to use my new implementation to solve Part One instead of having a separator within the function that includes the original solution.
I might look at other people's solutions to see where I can improve, but for now I will move on to the next puzzle.

## Day 3: *[Lobby](https://adventofcode.com/2025/day/3)* Solved!

**Puzzle Outline**
- a "battery" is an integer between 1 and 9
- a "bank" is a line of batteries
- for each bank, you must concatenate two batteries together
- the first character must come first in the bank
- you must create the largest possible number
- Goal: Sum the largest possible number from each bank.

**Initial Notes - What I Need**
- parseBanks separates each line into an Int array of "banks" // redundant, can be done with one line in solver
- getJoltage(String) finds the largest joltage
- search characters (except last), note the largest. Stop if 9 is found.
- search again (after largest), note the largest
- getJoltages(Array<Int>) gets the joltage of each bank
- solvePartOne gets the joltages and adds them all up

12/14/25
This one was fast to implement! I got 16993 and... it's correct!
It's nice to have an easy one! I still feel like my solution can be more concise, and am interested in seeing how others have implemented this with better practices.

**Part Two**
- Now, the joltage must be 12 digits instead of 2.
- It seems to still be the case that it is most important for the leftmost digits to be largest, no matter what
- However now, instead of saving just one extra digit at the end, we must save enough for the remaining digits
- so on the first iteration, we must save 11 digits just in case. On the second, 10 digits. etc.

**What I Need**
- tests for getJoltage2, getJoltages2, and solvePartTwo
- getJoltage2 finds all 12 digits, each iteration leaving room for the remaining digits, 
- getJoltages2 uses getJoltage2
- solvePartTwo

12/14/25 I got 168617068915447 and... it's correct!
This one was easier than I anticipated upon first reading part 2, but I need to rethink how I want to organize my class to include functionality for both parts.
This is a fun exercise, because I have to design a class around functionality that will change in a way I cannot predict.
In this puzzle, I opted for a "getJoltage" and "getJoltage2" approach, which I didn't like. It isn't how I will write code for a real project, and passes on the opportunity to solve real refactoring conundrums.
I also think I am more verbose than I need to be. I will definitely be returning to compare my solutions against more experienced programmers, but for now I will continue blind.
Comparing and taking notes will be a good exercise to do when I am working at the bank on a slow day. For now, with access to my full IDE, I will continue with the puzzles.

## Day 4: *[Printing Department](https://adventofcode.com/2025/day/4)*

**Puzzle Outline**
- there is a string representing a grid.
- `.` represents empty space.
- `@` represents rolls of paper.
- `\n` represents the end of a row
- adjacent tiles are the 8 tiles surrounding a tile.
- @'s are "movable" if less than 4 of their adjacent tiles are obstructed
- off-grid tiles don't count as obstructions
- Goal: Count the "movable" tiles in the grid.

**Initial Notes - What I Need**
- find width & height of grid. (Count characters before newline, and count every newline)
- getTile(x,y): extracts character via coordinate. if off-grid, return '.' or special character.
- getAdjacentTiles(x,y): return 8 length string of characters
- isTileMoveable(x,y): check, return true/false
- countMoveableTiles(width, height), search through grid. When an @ is found, increment if moveable.
- solvePartOne: find dimensions of grid, and count moveable tiles.

12/15/25
This didn't give me too much trouble and was a fun puzzle! I enjoy working with a grid, it feels tangible in a way more abstract data structures don't.
I got 1527 and... it's right!

**Part Two**
- remove all moveable rolls from the grid
- count how many newly moveable rolls there are
- repeat until there are no moveable rolls
- count how many rolls you've removed.

**Brainstorming**
I need to be able to edit the grid, but if I do this during my counting, it will influence the result.
I could separate the counting and removal process by keeping track of where each moveable roll is and removing them between each count.
OR I could create a buffer grid, which starts as a duplicate of the original grid, but I modify it as I count, before changing the original grid to match it.
Method 1 saves some memory, Method 2 is faster. Neither really matters, so what is a cleaner solution?
My intuition is that keeping track of indexes is slightly tidier than creating a buffer system, so I'll try that.

**What I Need**
- data class coordinate(x, y)
- setTile
- getMoveableCoordinates, returns an array of coordinates
- moveTiles(moveableCoordinates) sets all tiles to `.`
- solvePartTwo - gets moveable coordinates, moves them, adds moveableCoordinates length to a rolling sum.