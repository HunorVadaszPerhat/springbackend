
---

## 🧠 Method-by-Method Summary (All Covered)

| Method | Used? | Explanation |
|--------|-------|-------------|
| `read()` | ✅ Essential | Reads a single character. Used to process input one char at a time and detect patterns (like comments). |
| `read(char[] cbuf, int off, int len)` | ✅ Advanced | Reads a set of characters into a buffer — used here to fetch a number token. |
| `unread(int c)` | ✅ Essential | Pushes back a single character that we peeked at — helpful in lookahead parsing. |
| `unread(char[] cbuf, int off, int len)` | ✅ Advanced | Pushes back multiple characters (e.g., digits). Demonstrates partial rollback of read operations. |
| `ready()` | ✅ Rarely Used | Checks if the stream is ready for reading — used here for completeness, rarely critical. |
| `close()` | ✅ Essential (via try-with-resources) | Automatically closes the stream and releases resources. Important in enterprise settings. |
---

## 💡 Enterprise Tip

In real-world Java apps, this pattern helps with:

- **Custom file parsers** (e.g., `.conf`, `.ini`, domain-specific formats)
- **Preprocessing streams** (e.g., skip comments or detect syntax)
- **Error-tolerant input** where backtracking is safer than failing

