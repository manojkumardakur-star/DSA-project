🏨 Hostel Room Allocation System

A console-based Java application that simulates a hostel room allocation process.
This project demonstrates how Data Structures in Java can be used to manage and organize room data efficiently.

Users can log in, view available rooms, book a room, and check their allocated room.
📌 Project Overview

Managing hostel rooms manually can become messy when many students are involved.
This system provides a simple digital solution where room data is stored and accessed efficiently using Data Structures.

The project focuses on applying:

HashMap for fast room lookup

ArrayList for dynamic storage of occupants

Object-Oriented Programming for structured design

✨ Features
🔑 User Login

Users enter their name to access the system.

Prevents empty input.

🏢 View All Rooms

Displays a list of all rooms including:

Room ID

Availability status

Current occupants

🛏️ Book a Room

Users can enter a room ID to book a room.

The system checks if the room exists and is available.

👤 View My Room

Shows:

Room ID

Room status

Roommates

🚪 Logout / Exit

Users can logout or terminate the program.

🧠 Data Structures Used
1. HashMap

Used to store and manage rooms.

HashMap<Integer, Room> roomDatabase = new HashMap<>();

Key: Room ID

Value: Room object

Advantages:

Fast lookup

O(1) access time

Example:

Room room = roomDatabase.get(roomId);

2. ArrayList

Used to store occupants in each room.

ArrayList<String> occupants = new ArrayList<>();

Advantages:

Dynamic resizing

Easy insertion and iteration

Example:

occupants.add(name);

🏗️ Project Structure
HostelAllocationSystem
│
├── HostelAllocationSystem.java   (Main program)
│
└── Room Class
     ├── Room ID
     ├── Status
     └── Occupants List

     ▶️ How to Run the Project
1️⃣ Clone the repository
git clone https://github.com/your-username/hostel-room-allocation-system.git
2️⃣ Compile the program
javac HostelAllocationSystem.java
3️⃣ Run the program
java HostelAllocationSystem

💻 Example Output
========================================
   HOSTEL ROOM ALLOCATION (DSA Java)
========================================
Welcome! Please Login to proceed.

Enter your Name: Rahul
Login Successful! Welcome, Rahul

--- Main Menu ---
1. View All Rooms
2. Book a Room
3. View My Room
4. Logout
5. Exit

 ⏱️ Time Complexity
Operation	Data Structure	Complexity
Find Room	HashMap	O(1)
Add Occupant	ArrayList	O(1)
View Rooms	Iteration	O(n)
Find User Room	Iteration	O(n)

⚠️ Limitations

Data is stored only in memory.

No database integration.

No authentication system.

Room capacity is not limited.

Data resets when the program stops.

🚀 Future Improvements

Possible enhancements:

Database integration (MySQL / MongoDB)

GUI interface using JavaFX or Swing

Room capacity management

Admin dashboard

File-based data persistence

Booking cancellation feature

🛠️ Technologies Used

Java

Object-Oriented Programming

HashMap

ArrayList

Console-based Interface

👨‍💻 Author

DSA Mini Project – Hostel Room Allocation System

