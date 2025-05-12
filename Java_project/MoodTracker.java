import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class MoodTracker {
    private List<MoodEntry> entries;

    public MoodTracker() {
        entries = new ArrayList<>();
    }

    public void addEntry(LocalDate date, String mood) {
        entries.add(new MoodEntry(date, mood));
    }

    public void viewEntries() {
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
            return;
        }
        for (MoodEntry entry : entries) {
            System.out.println(entry);
        }
    }

    public void showSummary() {
        Map<String, Integer> summary = new HashMap<>();
        for (MoodEntry entry : entries) {
            summary.put(entry.getMood(), summary.getOrDefault(entry.getMood(), 0) + 1);
        }
        System.out.println("Mood Summary:");
        for (Map.Entry<String, Integer> e : summary.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (MoodEntry entry : entries) {
                writer.println(entry.getDate() + "," + entry.getMood());
            }
            System.out.println("Entries saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving entries: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        entries.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    LocalDate date = LocalDate.parse(parts[0]);
                    String mood = parts[1];
                    entries.add(new MoodEntry(date, mood));
                }
            }
            System.out.println("Entries loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading entries: " + e.getMessage());
        }
    }
} 