import java.util.Arrays;

public class Convert {
/*
    So why did I structure my LEDs this way??
    The simple answer is that when I started making the Scoreboard, I didn't want to spend
    time learning how to solder, so instead opted to make the programming portion of it
    more difficult for myself. Which is fine with me, since my goal is to become a
    software developer. I rather challenge myself on that front, then learning how to solder
    and other electrical engineering ideas.
 */


    public static void main(String[] args){
        //How to use.
        //1. Insert the grid dimensions.
         int COL = 5;
         int ROW = 7;

        //2. Create an array containing 0 for off, and 1 for on.
         String zero = "01110" +
                      "10001" +
                      "10011" +
                      "10101" +
                      "11001" +
                      "10001" +
                      "01110";

        //3. Name your variable, and adjust the stringToConvert reference to the digital character you want converted.
        String nameOfVariable = "zero";
        String stringToConvert = zero;

        //4. Read console.


        String one = "00010001100101000010000100001000010";
        String two = "01110100010000100010001000100011111";
        String three = "01110100010000100110000011000101110";
        String four = "00011001010100110001111110000100001";
        String five = "11111100001000011110000010000111110";
        String six = "01110100011000011110100011000101110";
        String seven = "11111000010000100010001000010000100";
        String eight = "01110100011000101110100011000101110";
        String nine = "01110100011000101111000011000101110";

        String g = "00000011101001010010011100001011100";
        String a = "00000000000110000010011101001001110";
        String m = "00000000001111010101101011010110101";
        String e1 = "00000000000110010010111101000001110";

        String p = "00000111001001010010111001000010000";
        String o = "00000000000110010010100101001001100";
        String k = "00000100001001010010111001001010010";
        String y = "00000000001001010010011100001011100";

        String o_with_i = "00001000000110110011100111001101111";
        String n = "00000000001110010010100101001010010";
        String t = "00000010001111001000010000100000110";

        String s ="00000000000111010000011000001011100";
        String iletter ="00100000000010000100001000010000100";
        String nletter = "00000000001110010010100101001010010";
        String i_with_n = "10000000001111011001110011100111001";
        String W = "10001100011000110001101011101110001";


        String S = "01110100011000001110000011000101110";
        String P = "11110100011000110001111101000010000";
        String I = "11111001000010000100001000010011111";
        String N = "10001100011100110101100111000110001";



        char[] arr = stringToConvert.toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(i % 5 == 0){
                System.out.println();
            }

            if(arr[i] == '1'){
                System.out.print((char) 0x25A0 );
            }else {
                System.out.print(arr[i]);
            }
        }

        System.out.println();
        /* This will swap every 2nd row of LEDS, this has to be done because
        of the way the LEDS are structured. See below.

        01234
        98765

        So this method saves me time from having to reverse every second
        row of pixels for every digital letter I want to use with my scoreboard.
         */
        for(int i = 1; i < ROW; i+= 2){
            int b = 0;
            int e = COL - 1;
            while(b < e){

                char tmp = arr[(COL * i ) + b];
                arr[(COL * i) + b] = arr[(COL * i) + e];
                arr[(COL * i) + e] = tmp;

                b++;
                e--;
            }
        }
        System.out.println();

        /*
            Now the issue becomes depending on if the letter is drawn on the left
            or side side of one half of the scoreboard the drawing differs.
            The following two methods corrects that for me.
            IE.

            01
            23 98
            45 67

            As you can see, the way the LEDs are structured are not the same :(
         */


        System.out.print("const char " + nameOfVariable + "_left[] = \"");
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                System.out.print(arr[(i*COL) + j]);
            }
        }
        System.out.println("\";");

        System.out.print("const char " + nameOfVariable + "_right[] = \"");
        for(int i = ROW - 1; i >= 0; i--){
            for(int j = 0; j < COL; j++){
                System.out.print(arr[(i*COL) + j]);
            }
        }
        System.out.println("\";");
    }
}
