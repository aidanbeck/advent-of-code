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

## Day 1: *[Secret Entrance](https://adventofcode.com/2025/day/1)*

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
  - if the dial is at 11, and gets rotation R0,  it would then point to 19.
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