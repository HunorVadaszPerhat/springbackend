
---

### ✅ **What This Project Demonstrates**

| Method | Purpose |
|--------|---------|
| `write(int c)` | Low-level write of a single character. |
| `write(char[] cbuf)` | Write a full character array. |
| `write(char[] cbuf, int off, int len)` | Write part of a character array. |
| `write(String str)` | Write an entire string — most common usage. |
| `write(String str, int off, int len)` | Write part of a string — useful in templating or string slicing. |
| `append(char c)` | Append a character — fluent style. |
| `append(CharSequence csq)` | Append entire text — StringBuilder-friendly. |
| `append(CharSequence csq, int start, int end)` | Append a substring of a CharSequence. |
| `flush()` | Force any buffered output to be written — useful in real-time logs or socket streaming. |
| `close()` | Finalize and release resources — always required. |
| `getEncoding()` | Show what charset is being used (e.g., UTF-8). Helpful for debugging. |


---

### 💡 Final Tips (for Enterprise Use)
- Always **use a specific Charset** like `StandardCharsets.UTF_8`, never the platform default.
- **Wrap with `BufferedWriter`** if performance matters (e.g., in batch processing).
- Always use **try-with-resources** to ensure `close()` is called.
- Avoid `write(int c)` unless you're working with very low-level character generation.
- Use `flush()` manually **only when needed** — e.g., mid-stream for logs or partial sends.

