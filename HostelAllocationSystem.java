import java.util.*;

/**
 * DSA Java Project: Hostel Room Allocation System
 * 
 * Data Structures Used:
 * 1. HashMap<Integer, Room> -> For O(1) lookup of rooms by ID.
 * 2. ArrayList<String> -> For dynamic storage of room occupants.
 * 3. Scanner -> For console input.
 */

public class HostelAllocationSystem {

    // DSA: HashMap to store rooms. Key = Room ID, Value = Room Object
    // This allows us to find a room instantly without looping through a list.
    private static HashMap<Integer, Room> roomDatabase = new HashMap<>();
    
    // Current logged-in user
    private static String currentUser = null;
    
    // Scanner for user input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Initialize the Database with Sample Data
        initializeDatabase();

        boolean isRunning = true;
        System.out.println("========================================");
        System.out.println("   HOSTEL ROOM ALLOCATION (DSA Java)   ");
        System.out.println("========================================");
        System.out.println("Welcome! Please Login to proceed.\n");

        // 2. Login Loop
        while (currentUser == null) {
            System.out.print("Enter your Name: ");
            String name = scanner.nextLine().trim();
            
            if (name.isEmpty()) {
                System.out.println("❌ Name cannot be empty. Try again.\n");
            } else {
                currentUser = name;
                System.out.println("✅ Login Successful! Welcome, " + currentUser + "\n");
            }
        }

        // 3. Main Menu Loop
        while (isRunning) {
            displayMenu();
            System.out.print("Enter your choice (1-5): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        viewAllRooms();
                        break;
                    case 2:
                        bookRoom();
                        break;
                    case 3:
                        viewMyRoom();
                        break;
                    case 4:
                        logout();
                        isRunning = false;
                        break;
                    case 5:
                        System.out.println("Exiting System...");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("❌ Invalid choice. Please try again.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.\n");
            }
        }
        
        scanner.close();
    }

    // --- DSA: Initialize Data (Seed Data) ---
    private static void initializeDatabase() {
        // Creating Room Objects
        Room r101 = new Room(101);
        Room r102 = new Room(102);
        r102.addOccupant("Alice Smith"); // Pre-filled occupant
        
        Room r103 = new Room(103);
        r103.addOccupant("Bob Jones");
        r103.addOccupant("Charlie Day");
        
        Room r104 = new Room(104);
        Room r105 = new Room(105);
        r105.addOccupant("David Wilson");
        
        Room r106 = new Room(106);

        // Adding to HashMap (O(1) Insertion)
        roomDatabase.put(101, r101);
        roomDatabase.put(102, r102);
        roomDatabase.put(103, r103);
        roomDatabase.put(104, r104);
        roomDatabase.put(105, r105);
        roomDatabase.put(106, r106);
    }

    // --- DSA: Display Rooms (Iterate over HashMap Values) ---
    private static void viewAllRooms() {
        System.out.println("\n--- Available Rooms ---");
        System.out.printf("%-10s %-15s %-20s%n", "Room ID", "Status", "Occupants");
        System.out.println("--------------------------------------------------");

        // Using values() to get all Room objects
        for (Room room : roomDatabase.values()) {
            String status = room.isAvailable() ? "Available" : "Occupied";
            String occupants = room.getOccupants().isEmpty() ? "None" : String.join(", ", room.getOccupants());
            
            System.out.printf("%-10d %-15s %-20s%n", room.getId(), status, occupants);
        }
        System.out.println();
    }

    // --- DSA: Book Room (Search & Update) ---
    private static void bookRoom() {
        System.out.print("\nEnter Room ID to book: ");
        try {
            int roomId = Integer.parseInt(scanner.nextLine());
            
            // DSA: HashMap get() is O(1)
            Room room = roomDatabase.get(roomId);

            if (room == null) {
                System.out.println("❌ Room ID not found.");
            } else if (!room.isAvailable()) {
                System.out.println("❌ Room is already occupied.");
            } else {
                // Update Data
                room.addOccupant(currentUser);
                room.setStatus("Occupied");
                System.out.println("✅ Success! " + currentUser + " booked Room " + roomId);
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid Room ID.");
        }
    }

    // --- DSA: View My Room ---
    private static void viewMyRoom() {
        System.out.println("\n--- My Room Details ---");
        boolean found = false;
        
        // Iterate to find the room where currentUser is present
        for (Room room : roomDatabase.values()) {
            if (room.getOccupants().contains(currentUser)) {
                System.out.println("Room ID: " + room.getId());
                System.out.println("Status: " + room.getStatus());
                System.out.println("Roommates: " + String.join(", ", room.getOccupants()));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("You are not currently allocated to any room.");
        }
    }

    // --- DSA: Logout ---
    private static void logout() {
        currentUser = null;
        System.out.println("✅ Logged out successfully.");
    }

    // --- Helper: Display Menu ---
    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. View All Rooms");
        System.out.println("2. Book a Room");
        System.out.println("3. View My Room");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
    }
}

// --- DSA: Room Class (Model) ---
class Room {
    private int id;
    private String status;
    private ArrayList<String> occupants; // DSA: Dynamic Array

    public Room(int id) {
        this.id = id;
        this.status = "Available";
        this.occupants = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getStatus() { return status; }
    public ArrayList<String> getOccupants() { return occupants; }

    public void setStatus(String status) { this.status = status; }
    
    public boolean isAvailable() {
        return "Available".equals(status);
    }

    public void addOccupant(String name) {
        occupants.add(name);
    }
}