## 🔍 Explanation by Method

| Method | What It Does | Example Use |
|--------|---------------|--------------|
| `read()` | Reads one character | Loop over input one char at a time |
| `read(char[] buffer)` | Reads multiple characters into an array | Efficient batch reads |
| `read(char[] buf, int off, int len)` | Reads into a portion of a char array | Fine-grained control |
| `read(CharBuffer)` | Reads into a `CharBuffer` (NIO) | Useful for NIO-based processing |
| `getEncoding()` | Returns charset used | Debug/logging |
| `ready()` | Checks if reading won’t block | UI or network stream optimization |
| `skip(long n)` | Skips `n` characters | Useful to ignore headers/prefixes |
| `markSupported()` | Always returns false | Confirms no mark/reset support |
| `close()` | Closes stream | Auto-handled via try-with-resources |

---

## 🏁 Final Notes

- This example shows **every meaningful method** in `InputStreamReader` that you'd use in a **real-world Java 21 project**.
- All file reading is done safely with **try-with-resources**.
- Encoding is **explicitly set** to avoid system default pitfalls.
- The file used should be UTF-8 encoded to match behavior.

---

