
---

## ✅ **Method Usage Summary**

| Method | Example Purpose |
|--------|-----------------|
| `readLine()` | Reading line-by-line for parsing or logging |
| `getLineNumber()` | Reporting current position (e.g. error reporting) |
| `setLineNumber()` | Manually adjusting counter for offset starts or includes |
| `mark(int)` | Bookmarking a point in the file for backtracking |
| `reset()` | Returning to a marked position (with line number restored) |
| `read()` | Low-level single-char read (not often used directly) |
| `read(char[], int, int)` | Reading into a char buffer — useful for custom parsing |
| `skip(long)` | Skipping data — risky if line numbers matter |
| `markSupported()` | Always returns `true` (required if you plan to mark/reset) |
| `close()` | Used to release file handles (handled automatically here) |

---

## 💡 Tips for Enterprise Developers

- Use `LineNumberReader` with `try-with-resources` to avoid leaks.
- Stick to `readLine()` and `getLineNumber()` for clarity and reliability.
- Be cautious with `skip()` if line tracking is essential.
- Use `mark()` and `reset()` when parsing formats that need lookahead or rollback (e.g. custom file formats).

---

