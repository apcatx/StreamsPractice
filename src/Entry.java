
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entry {
  private Day day;
  private String note;

  public Entry(Day day, String note) {
    this.day = day;
    this.note = note;
  }

  public Day getDay() {
    return day;
  }

  public String getNote() {
    return note;
  }

  @Override
  public String toString() {
    return "Entry{" +
            "day=" + day +
            ", note='" + note + '\'' +
            '}';
  }

  public static List<Entry> populate(){
    List<Entry> entries = new ArrayList<>();
    Random random = new Random();

    Entry entry = new Entry(Day.MONDAY,"We were still recovering from Irma");
    entries.add(entry);

    entry = new Entry(Day.TUESDAY,"Still no class");
    entries.add(entry);

    entry = new Entry(Day.WEDNESDAY,"Irma Shmirma... lets get back to class");
    entries.add(entry);

    entry = new Entry(Day.THURSDAY,"We start again");
    entries.add(entry);

    entry = new Entry(Day.FRIDAY,"Final Friday of Iron Yard!");
    entries.add(entry);

    entry = new Entry(Day.SATURDAY,"Saturblaze");
    entries.add(entry);

    entry = new Entry(Day.SUNDAY,"Sunday Night Football");
    entries.add(entry);

    entry = new Entry(Day.MONDAY,"Final Monday of Iron Yard");
    entries.add(entry);

    entry = new Entry(Day.WEDNESDAY,"Whiskey Wednesday");
    entries.add(entry);

    entry = new Entry(Day.SATURDAY,"I plan on getting laid");
    entries.add(entry);


    return entries;

  }
}
