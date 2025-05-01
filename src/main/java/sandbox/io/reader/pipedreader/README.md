
---

## ✅ **Explanation of Each Method Used**

| Method | Purpose |
|--------|---------|
| `connect(PipedWriter)` | Connects the `PipedReader` to a `PipedWriter`. Required before reading. |
| `read(char[] cbuf, int off, int len)` | Reads characters in chunks into a buffer — most efficient and common. |
| `ready()` | Returns `true` if the stream is ready to be read (non-blocking). Used cautiously. |
| `skip(long n)` | Skips a number of characters — rarely needed but available. |
| `read(CharBuffer target)` | Reads into a `CharBuffer`. Useful in NIO-compatible situations (rare). |
| `markSupported()` | Returns `false` — indicates `mark()` and `reset()` are not supported. |
| `mark(int)` and `reset()` | Not supported — trying to use them throws `IOException`. |
| `close()` | Closes the stream, freeing resources. Essential in all usage. |

---

## 🧠 **Final Notes for Enterprise Use**

- **Keep it simple**: Use `read(char[], int, int)` for chunked reading in real-world use.
- **Handle thread lifecycle**: Always ensure threads are started and joined correctly.
- **Always close streams**: Prevent resource leaks by closing `PipedReader` and `PipedWriter`.
- **Avoid `mark()` and `reset()`**: Not supported, even though they exist from the `Reader` interface.

---
