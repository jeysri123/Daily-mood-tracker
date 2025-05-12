import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MoodTracker tracker = new MoodTracker();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nDaily Mood Tracker");
            System.out.println("1. Add today's mood");
            System.out.println("2. View all entries");
            System.out.println("3. Show mood summary");
            System.out.println("4. Save entries to file");
            System.out.println("5. Load entries from file");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter today's mood: ");
                    String mood = scanner.nextLine();
                    tracker.addEntry(LocalDate.now(), mood);
                    break;
                case 2:
                    tracker.viewEntries();
                    break;
                case 3:
                    tracker.showSummary();
                    break;
                case 4:
                    System.out.print("Enter filename to save: ");
                    String saveFile = scanner.nextLine();
                    tracker.saveToFile(saveFile);
                    break;
                case 5:
                    System.out.print("Enter filename to load: ");
                    String loadFile = scanner.nextLine();
                    tracker.loadFromFile(loadFile);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
} 