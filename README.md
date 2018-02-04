# DigitalCharToScoreBoardOrientation
Converts a grid representing a digital character to an orientation that works on my scoreboard project.

<hr>

The purpose of this program was to reduce to workload of manually typing in 1's and 0's to represent
digital characters for my scoreboard project. This was needed because of the way I structured my addressable LEDs.
 ``` 
  //The pattern is starting from the top is as follows: left to right, right to left, etc.
    00 01  10 11
    03 02  09 08
    04 05  06 07
    grid_0 grid_1
    
 ```
 
 That way I didn't have to cut and solder every row, and at the start of a new grid. Ofcourse, if you are
 comfortable with soldering, you can bypass all this work by doing that.
 
<hr>

How to use

        1. Insert the grid dimensions.
        int COL = 5;
        int ROW = 7;

        2. Create an array containing 0 for off, and 1 for on.
        String zero = "01110" +
                      "10001" +
                      "10011" +
                      "10101" +
                      "11001" +
                      "10001" +
                      "01110";
        
        3. Name your variable, and adjust the stringToConvert reference to the digital character you want converted.
        String nameOfVariable = "zero";
        String stringToConvert = zero;
        
        4. Read console.
        //An image to ensure that I correctly entered in the digital character.
        0■■■0
        ■000■
        ■00■■
        ■0■0■
        ■■00■
        ■000■
        0■■■0
        
        //Note this is c syntax for use in Arduino IDE.
        const char zero_left[] = "01110100011001110101110011000101110";
        const char zero_right[] = "01110100011100110101100111000101110";
