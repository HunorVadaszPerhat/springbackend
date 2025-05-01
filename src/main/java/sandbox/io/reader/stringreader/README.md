
---

### 🧠 **What This Project Shows**

| Method | What It Demonstrates |
|--------|----------------------|
| `read()` | Reading one character at a time |
| `read(char[], int, int)` | Partial buffer filling |
| `read(CharBuffer)` | Interfacing with `CharBuffer` (NIO integration) |
| `skip(long)` | Skipping characters without reading |
| `mark(int)` + `reset()` | Re-reading from a marked point |
| `markSupported()` | Always returns true for `StringReader` |
| `ready()` | Always true unless closed |
| `close()` | Disables further reading, simulates cleanup |

---

### 🧭 Final Tips for Enterprise Devs

- **Use `StringReader` to inject strings into text-based parsers** (e.g., XML, JSON, CSV).
- **Combine with `BufferedReader`** if you need `readLine()` functionality:
  ```java
  new BufferedReader(new StringReader("line1\nline2"));
  ```
- **Perfect for testing**, mocking file input without filesystem access.
- **Avoid overusing `mark()`/`reset()`** unless you're implementing a parser.

