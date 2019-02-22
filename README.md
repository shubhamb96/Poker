# Poker

The program is currently terminal only, with a cross platform implementation planned for future

To RUN from terminal:-

javac ./src/*.java -d ./bin/

java ./bin/Poker <Cards numbering in multiple of 5>

Example java ./bin/Poker 2A 3A 4A 5A 6A

The Poker program takes cards as command line arguments, in multiple of 5

A card is input as string of 2 characters with the first character representing rank and the second suit of card.

Each set of 5 card represents a player hand. If number of arguments is 5, the program prints the classification description of the hand. 

There are nine classifications of hand in Poker: Straight flush, Four of a kind, Full house, Flush, Straight, Three of a kind, Two pair, One pair, High card (in decreasing order of precedence)
