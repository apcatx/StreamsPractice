import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        printEntries( entries );
        printTuesdays( entries );
        countTueWedThur( entries );
        weekendList( entries );
        weekdaySet( entries );
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println( "For Loop:" );
        for (Entry entry : entries) {
            System.out.println( entry + ", " );
        }
        System.out.println( "\nStream, forEach:" );
        entries.stream()
                .forEach( entry -> System.out.println( entry + ", " ) );
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {
        System.out.println( "For Loop:" );
        for (Entry entry : entries) {
            if (entry.getDay() == Day.TUESDAY) {
                System.out.println( entry + "," );
            }
        }
        System.out.println( "\nStream, filter, forEach:" );
        entries.stream()
                .filter( entry -> entry.getDay() == Day.TUESDAY )
                .forEach( entry -> System.out.println( entry + "," ) );
        System.out.println();
    }

    public static void countTueWedThur(List<Entry> entries) {
        System.out.println( "For Loop:" );
        int count = 0;
        for (Entry entry : entries) {
            if (entry.getDay() == Day.TUESDAY || entry.getDay() == Day.WEDNESDAY || entry.getDay() == Day.THURSDAY) {
                count++;
            }
        }
        System.out.println( "Number of entries on Tuesday, Wednesday or Thursday: " + count );
        System.out.println( "\nStream, filter, count: " );
        long count1;
        count1 = entries.stream()
                .filter( entry -> entry.getDay() == Day.TUESDAY || entry.getDay() == Day.WEDNESDAY || entry.getDay() == Day.THURSDAY )
                .count();
        System.out.println( "Number of entries on Tuesday, Wednesday or Thursday: " + count1 );
        System.out.println();
    }

    public static void weekendList(List<Entry> entries) {
        entries.add( new Entry( Day.SATURDAY, "this is a saturday note" ) );
        entries.add( new Entry( Day.SUNDAY, "this is a sunday note" ) );
        System.out.println( "For Loop:" );
        Set<String> weekends = new HashSet<>();
        for (Entry entry : entries) {
            if (entry.getDay() == Day.SATURDAY || entry.getDay() == Day.SUNDAY) {
                weekends.add( entry.getNote());
            }
        }
        System.out.println( weekends + "\n" );
    }

    public static void weekdaySet(List<Entry> entries) {
        entries.add( new Entry( Day.MONDAY, "this is a monday note" ) );
        entries.add( new Entry( Day.TUESDAY, "this is a tuesday note" ) );
        entries.add( new Entry( Day.WEDNESDAY, "this is wednesday note" ) );
        entries.add( new Entry( Day.THURSDAY, "this is a thursday note" ) );
        entries.add( new Entry( Day.FRIDAY, "this is a friday note" ) );
        System.out.println( "For Loop:" );
        Set<String> weekdays = new HashSet<>();
        for (Entry entry : entries) {
            if (entry.getDay() != Day.SATURDAY && entry.getDay() != Day.SUNDAY) {
                weekdays.add( entry.getNote() );
            }
        }
        System.out.println( weekdays );
        System.out.println( "\nStream, filter, map, collect:" );
        weekdays = entries.stream().filter( entry -> entry.getDay() != Day.SATURDAY && entry.getDay() != Day.SUNDAY ).map( entry -> entry.getNote() ).collect( Collectors.toSet() );
        System.out.println( weekdays );
        System.out.println();
    }

}