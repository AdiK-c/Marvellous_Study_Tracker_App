# Marvellous_Study_Tracker_App

## 🚀 Project Overview

The **Marvellous Study Tracker App** is a console-based Java application designed to help students **log, track, summarize, and export** their daily study activities.

This project demonstrates practical usage of **Core Java**, including **OOP concepts, Collections, and File Handling**, in a real-world scenario.

---

## 🛠️ Technologies Used

* **Language:** Java
* **Concepts:**

  * Object-Oriented Programming (OOP)
  * Collections (`ArrayList`, `TreeMap`)
  * File Handling (CSV Export)
  * Date API (`LocalDate`)

---

## ✨ Features

* ➕ Insert Study Log

  * Add subject, duration, and description
  * Date is automatically captured

* 📄 Display Logs

  * View all stored study records

* 📊 Summary by Date

  * Total study hours per day

* 📚 Summary by Subject

  * Total study hours per subject

* 📁 Export to CSV

  * Save all logs into a `.csv` file

* 🧭 Menu-Driven Interface

  * Easy navigation using switch-case

---

## 🧩 Project Structure

```
MarvellousStudyTracker.java
│
├── StudyLog         → Represents a single study record
├── StudyTracker     → Handles all operations (Insert, Display, Summary, Export)
└── Main Class       → Menu-driven execution
```

---

## ▶️ How to Run

### Step 1: Compile

```bash
javac MarvellousStudyTracker.java
```

### Step 2: Run

```bash
java MarvellousStudyTracker
```

---

## 💻 Sample Usage

```
====== Marvellous Study Tracker ======
1. Insert Study Log
2. Display All Logs
3. Export to CSV
4. Summary By Date
5. Summary By Subject
6. Exit

Enter choice: 1
Enter Subject: Java
Enter Duration: 2
Enter Description: Practiced OOP concepts

Study Logs Gets Stored Successfully
```

---

## 📁 Sample CSV Output

```
Date,Subject,Duration,Description
2025-09-13,Java,2.0,Practiced OOP concepts
2025-09-13,DBMS,1.5,Revised SQL joins
```

---

## 🎯 Key Learnings

* Implementation of real-world problem using Java
* Working with Collections (`ArrayList`, `TreeMap`)
* File handling using `FileWriter`
* Designing menu-driven applications

---

## 📌 Future Improvements

* Add GUI using Java Swing
* Store data in database (MySQL)
* Add login system
* Add edit/delete logs feature

---

## 👨‍💻 Author

**Aditya Kotewar**

---

## ⭐ Conclusion

This project is a simple yet powerful tool to track study productivity and demonstrates strong fundamentals of Java programming, making it ideal for **academic submission and placement preparation**.

---
