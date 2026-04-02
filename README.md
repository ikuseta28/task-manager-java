# Task Manager Java

A simple console-based task manager application written in **Java 25** with **PostgreSQL** support.

---

## Features
- Add new tasks
- View all tasks
- Mark tasks as completed
- Delete tasks

---

## Technologies
- **Java 25**
- **PostgreSQL** database connection via JDBC
- Git & GitHub for version control

---

## Project Structure
src/

└── com/ivan/taskmanager/

├── Main.java

├── model/Task.java

├── repository/TaskRepository.java

├── service/TaskService.java

└── database/DatabaseConnection.java



---

## How to Run

1. Clone the repository:

``bash  
git clone https://github.com/ikuseta28/task-manager-java.git``
2. Open the project in your IDE (IntelliJ IDEA or Eclipse).
3. Configure PostgreSQL connection in DatabaseConnection.java.
4. Run Main.java and follow the console instructions.

## Example Console Output
===== TASK MANAGER =====
1. Add task
2. View tasks
3. Mark task as done
4. Delete task
5. Exit
Choose: 1
Enter task title: Buy groceries
Task added!

===== TASK MANAGER =====
1. Add task
2. View tasks
3. Mark task as done
4. Delete task
5. Exit
Choose: 2
1. Buy groceries [UNDONE]

## Dependencies

Before running the project, make sure you have the following installed:

- **Java**: JDK 25.0.1
- **PostgreSQL**: Ensure you have a running PostgreSQL instance
- **IDE**: IntelliJ IDEA or Eclipse (for easy project management)
- **Git**: For cloning the repository and version control

Make sure your PostgreSQL database is configured in `DatabaseConnection.java` before running the project.

## License

This project is licensed under the **MIT License**.

```
MIT License

Copyright (c) 2026 [Your Name]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```