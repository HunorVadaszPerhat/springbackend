# 📋 What Each Part Demonstrates:

| Method                         | Shown in code | Explanation |
|---------------------------------|---------------|-------------|
| **`connect(PipedInputStream)`** | `outputStream.connect(inputStream)` | Connects `PipedOutputStream` to `PipedInputStream` so data written can be read. |
| **`write(int b)`**              | `outputStream.write(65)` | Writes one byte (`A`) into the stream. |
| **`write(byte[] b, int off, int len)`** | `outputStream.write(data, 0, data.length)` | Writes a chunk of bytes — typical real-world use. |
| **`flush()`**                   | `outputStream.flush()` | Flushing (though in `PipedOutputStream`, it doesn't change behavior). |
| **`close()`**                   | `outputStream.close()` | Closing tells the reader "no more data is coming" (otherwise it waits forever). |

---

# ✅ Expected Output:
```bash
Streams connected.
Wrote single byte: 65 (A)
Wrote byte array: Hello, World!
Flushed the output stream.
Output stream closed.
AHello, World!
Reader finished.
```

---

# ⚡ Quick Final Tips for Enterprise Java Devs:
- Always **connect first** before writing.
- Use **write(byte[], off, len)** for bulk efficiency.
- Always **close** after you're done writing to unblock readers.
- **Flush** if you think it might matter (but don't rely on it with `PipedOutputStream`).
- **Separate threads** are critical — never read and write on the same thread.

---



