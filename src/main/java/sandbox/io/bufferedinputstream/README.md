## 🧪 Output Example (Varies by File Content)

```
Available bytes before reading: 98
First byte read (as char): H
Marked stream at current position.
Next 10 bytes read: ello, Buff
Skipped 5 bytes.
Read into buffer2[5..15]: redIn
Reset to marked position.
Read again after reset: ello, Buff
```

---

## 🧠 What This Project Covers (Method Map)

| Method | Use in Project | Description |
|--------|----------------|-------------|
| `read()` | `int firstByte = bis.read();` | Reads a single byte |
| `read(byte[])` | `bis.read(buffer)` | Reads into a byte array |
| `read(byte[], int, int)` | `bis.read(buffer2, 5, 10)` | Reads into portion of array |
| `mark(int)` | `bis.mark(32)` | Marks a position in stream |
| `reset()` | `bis.reset()` | Resets to marked position |
| `skip(long)` | `bis.skip(5)` | Skips bytes |
| `available()` | `bis.available()` | Returns estimate of bytes available |
| `close()` | Auto-handled by try-with-resources | Proper stream closure |

---

## 🧰 Java Version

Ensure you are using **Java 21**, and compile using:

```bash
javac Main.java
java Main
```

---

## 📦 Final Notes

- This project is **self-contained**, plain Java, no frameworks.
- You can swap `FileInputStream` with `ByteArrayInputStream` for testing without files.
- For enterprise apps, wrap `BufferedInputStream` in a service class and inject it as a dependency to enable testing and mocking.
