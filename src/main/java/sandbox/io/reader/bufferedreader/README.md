
---

## 📝 **README.md – Method Summary**

| Method                      | Tag           | Purpose / Typical Use                                                   |
|-----------------------------|---------------|--------------------------------------------------------------------------|
| `readLine()`                | Essential     | Reads one line at a time; returns `null` at end of file.                |
| `lines()`                   | Essential     | Returns a `Stream<String>` of lines for stream-based processing.        |
| `read(char[], int, int)`    | Advanced      | Reads multiple characters into buffer—faster for large files.           |
| `read()`                    | Advanced      | Reads a single character; used in low-level or custom parsers.          |
| `skip(long)`                | Rarely Used   | Skips a fixed number of characters—used for header skipping, etc.       |
| `ready()`                   | Rarely Used   | Checks if input is available without blocking.                          |
| `mark(int)` / `reset()`     | Advanced      | Used for lookahead or rewinding when parsing structured data.           |
| `markSupported()`           | Rarely Used   | Tells whether `mark()` and `reset()` are supported.                     |
| `close()`                   | Essential     | Closes the stream; auto-managed with try-with-resources.                |

---

## 💡 Final Advice for Enterprise Java Devs

- **Use `readLine()` or `lines()` in 95% of real-world cases.**
- Avoid manual `read()` unless you're doing **custom parsing or filtering**.
- Wrap streams in `try-with-resources` to prevent **resource leaks**.
- Use `mark()`/`reset()` **only** when you're writing a parser or need lookahead.
- Avoid premature optimization: use `lines()` for clean code unless profiling demands otherwise.

