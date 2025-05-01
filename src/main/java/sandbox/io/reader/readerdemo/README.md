
---

### 📌 **Method Usage Summary**

| Method | What It Does | Where It’s Used |
|--------|---------------|------------------|
| `read()` | Reads one character at a time. | *Omitted due to inefficiency.* |
| `read(char[] cbuf)` | Reads data into full buffer. | `reader.read(buffer)` |
| `read(char[], off, len)` | Reads into part of a buffer. | `reader.read(partialBuffer, 2, 6)` |
| `read(CharBuffer)` | Fills a CharBuffer (NIO). | `reader.read(charBuffer)` |
| `skip(long n)` | Skips characters. | `reader.skip(10)` |
| `ready()` | Checks if stream is ready. | `bufferedReader.ready()` |
| `mark(int limit)` / `reset()` | Marks and returns to position. | `reader.mark(50); reader.reset()` |
| `markSupported()` | Checks if mark/reset is supported. | `reader.markSupported()` |
| `close()` | Closes the stream. | Used implicitly via try-with-resources |

---

### 🧠 **Tips for Enterprise Developers**

- **Use `BufferedReader`** to get `mark/reset` and `readLine()` functionality.
- **Always check `markSupported()`** before calling `mark()`/`reset()`.
- **Avoid `read()` in loops** — use buffered reads instead.
- **Leverage `CharBuffer`** if integrating with NIO APIs.
- **Always wrap readers in try-with-resources** to ensure proper cleanup.

---

