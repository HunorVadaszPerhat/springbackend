Here is a **comprehensive, categorized breakdown of the `java.io.PushbackReader`** class from Java SE 21, structured to reflect its **real-world enterprise relevance**. The method tags — **Essential**, **Advanced**, **Legacy**, and **Rarely Used** — reflect practical usage frequency and criticality in modern enterprise applications.

---

## 🧩 **Categorized Methods of `PushbackReader`**

---

### 🔹 1. **Construction & Initialization**
> How to create an instance with appropriate buffer control.

| Method Signature | Tag | Description |
|------------------|-----|-------------|
| `PushbackReader(Reader in)` | **Essential** | Creates a PushbackReader with a **default 1-character pushback buffer**. Sufficient for simple parsing or token checks. |
| `PushbackReader(Reader in, int size)` | **Essential** | Allows setting a **custom buffer size**, crucial for any non-trivial parsing logic. Commonly used in enterprise XML, CSV, or DSL parsing. |

✅ **Enterprise Tip**: Always specify buffer size explicitly in enterprise applications to avoid `IOException` from buffer overflows during `unread()` calls.

---

### 🔹 2. **Core Reading Operations**
> Methods to read character(s) from the stream, considering unread data.

| Method Signature | Tag | Description |
|------------------|-----|-------------|
| `int read()` | **Essential** | Reads a **single character**. Checks the pushback buffer first, then the underlying reader. |
| `int read(char[] cbuf, int off, int len)` | **Advanced** | Reads multiple characters into a buffer, blending pushback contents with underlying stream reads. Slightly more complex but critical for **performance-optimized** parsing. |

✅ **Best Practice**: Use buffered reads for performance; especially helpful when dealing with network streams or file-based protocols.

---

### 🔹 3. **Pushback Operations (Unread)**
> Revert characters back into the stream.

| Method Signature | Tag | Description |
|------------------|-----|-------------|
| `void unread(int c)` | **Essential** | Pushes back a **single character**. Most used for **lookahead** in tokenization. Throws `IOException` if buffer is full. |
| `void unread(char[] cbuf, int off, int len)` | **Advanced** | Pushes back a sequence of characters. Useful for complex parsers needing to undo multiple reads. |

✅ **Warning**: Always ensure your unread size does not exceed the buffer, or wrap in a try-catch to handle errors gracefully.

---

### 🔹 4. **Stream Status and Control**
> Understand and manage the underlying stream.

| Method Signature | Tag | Description |
|------------------|-----|-------------|
| `boolean ready()` | **Rarely Used** | Checks if the stream is ready to be read without blocking. Useful in I/O-bound apps, but less relevant in business logic. |
| `void close()` | **Essential** | Closes the stream. Required for proper resource management and to prevent file descriptor leaks. |

✅ **Enterprise Practice**: Use try-with-resources to automatically call `close()` and avoid resource leakage.

---

### 🔹 5. **Unsupported/Legacy from Reader (Inherited)**
> Included from superclass `Reader` but not directly relevant or sometimes misleading.

| Method Signature | Tag | Description |
|------------------|-----|-------------|
| `void mark(int readAheadLimit)` | **Legacy** | **Not supported**. Always throws `IOException`. Exists due to inheritance from `Reader`. |
| `void reset()` | **Legacy** | **Not supported**. Same as above. |
| `boolean markSupported()` | **Legacy** | Returns false. Clarifies that marking is not available. |

⚠️ **Avoid** these methods entirely. They may confuse developers expecting mark/reset behavior like in `BufferedReader`.

---

## 📌 **Real-World Usage Summary**

In enterprise Java systems — think **configuration file parsers**, **custom DSL interpreters**, or **protocol readers** — `PushbackReader` shines when:

- You need **character-level parsing**.
- You require **lookahead capabilities** (e.g., parsing a token and reverting if it doesn't match).
- You want to combine it with a `BufferedReader` for performance and memory efficiency.

📘 **Typical usage pattern**:

```java
try (PushbackReader reader = new PushbackReader(new BufferedReader(new FileReader("config.txt")), 8)) {
    int c = reader.read();
    if (c == '#') {
        // Handle comment line
    } else {
        reader.unread(c); // Revert character
        // Process differently
    }
}
```

---

## ✅ Final Advice for Enterprise Developers

- **Use `unread()` with caution**: Always know your buffer size and how much data you’re pushing back.
- **Pair with `BufferedReader`**: For real-world performance, wrap PushbackReader around a buffered stream.
- **Don’t rely on mark/reset**: PushbackReader does not support them — instead, design your logic to explicitly manage unread states.
- **Testing matters**: Pushback logic can cause subtle bugs. Unit test your parsing logic rigorously, especially around boundary and edge conditions.
- **Use alternatives when appropriate**: If your parsing is token-based and doesn’t require low-level control, higher-level APIs like `Scanner`, or parser generators like ANTLR may be more appropriate.

---

