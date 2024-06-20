#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static ${package}.PrintString.printTime;

public class Main {
    public static void main(String[] args) {
       printTime(Time.time.toString());
    }
}