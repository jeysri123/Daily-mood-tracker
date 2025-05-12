import java.time.LocalDate;

public class MoodEntry {
    private LocalDate date;
    private String mood;

    public MoodEntry(LocalDate date, String mood) {
        this.date = date;
        this.mood = mood;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }

    @Override
    public String toString() {
        return date + ": " + mood;
    }
} 