# 🎓 Student Details Management System

This is a **completely console-based Java project** that demonstrates clear logical implementation using **Object-Oriented Programming (OOP)** concepts and **CRUD operations**.

---

## 🧩 Step 1: Create a Class

### **Class Name:** `StudentDetails`

#### **Behaviours**
```java
private String RegNo[] = new String[1000];
private String Name[] = new String[1000];
private String ParentName[] = new String[1000];
private String ParentNumber[] = new String[1000];
private String Address[] = new String[1000];
private String Staying[] = new String[1000];
```

#### **Methods**
| Method | Description |
|--------|--------------|
| `EnterDetails()` | ➕ Create new student details |
| `ShowDetails()` | 📖 Display all student records |
| `ModifyPartData()` | ✏️ Update existing student data |
| `DeleteData()` | ❌ Delete a student record |

---

## ⚙️ Step 2: Main Method

In the `main()` method, create an object of the `StudentDetails` class to perform CRUD operations.

### Example:
```java
public class Main {
    public static void main(String[] args) {
        StudentDetails obj = new StudentDetails();
        // obj.EnterDetails();
        // obj.ShowDetails();
        // obj.ModifyPartData();
        // obj.DeleteData();
    }
}
```

---

## 💡 Summary

This project clearly demonstrates:

- ✅ **Encapsulation** and **Abstraction**
- ✅ **CRUD** operations (Create, Read, Update, Delete)
- ✅ Logical, structured use of **OOP principles**
- ✅ Fully **console-based** interaction

---

📘 *Developed for learning and demonstrating Java OOP and CRUD concepts.*
