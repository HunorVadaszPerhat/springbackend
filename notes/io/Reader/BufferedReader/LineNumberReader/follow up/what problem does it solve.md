In **simple terms**, `LineNumberReader` solves this problem:

> **“I’m reading a text file and I need to know which line I’m on.”**

### Why this matters:
- If you’re reading a **log file**, you might want to print:  
  *“Error found on line 42.”*
- If you’re parsing **code or a config file**, you need to say:  
  *“Syntax error at line 17.”*
- If you’re importing a file into a database and hit bad data, you want to report:  
  *“Invalid format on line 5.”*

### Without `LineNumberReader`:
You’d have to manually count each line as you read it — adding your own logic to track line breaks (`\n`, `\r\n`, etc.).

### With `LineNumberReader`:
Java does the counting for you automatically as you read.  
You just call `getLineNumber()` anytime, and it tells you your current line number.

👉 It **saves time**, **reduces bugs**, and makes **error reporting much easier**.

