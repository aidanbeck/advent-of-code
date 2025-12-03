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