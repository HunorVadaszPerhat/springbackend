In **simple terms**, `FileReader` solves this problem:

> 🧩 **"How do I read text — not raw bytes — from a file in Java, easily and quickly?"**

Before `FileReader`, Java had `InputStream`s, which read **bytes**, not characters. That was fine for binary data (like images or serialized objects), but not good for **human-readable text** like:

- `.txt` files
- configuration files
- logs
- reports

`FileReader` made it easy to:

- **Open a text file**
- **Read it character by character**
- **Without needing to worry about converting bytes to characters manually**

It's like saying:  
**"Just give me the text inside this file."**

It was designed for **simplicity** — perfect for small scripts, tools, or when you’re just starting with file input.

