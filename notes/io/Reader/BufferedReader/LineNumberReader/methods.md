Here’s a **comprehensive categorization of the `java.io.LineNumberReader` class methods in Java SE 21**, structured for **enterprise-level clarity and practical use**. We group the methods by functionality and tag them based on how often they matter in real-world use: **Essential**, **Advanced**, **Legacy**, or **Rarely Used**.

---

## 🔧 **1. Line Number Tracking (Core Purpose)**

These methods define what makes `LineNumberReader` special — tracking and controlling the current line number during reading.

| Method | Description | Tag |
|--------|-------------|-----|
| `int getLineNumber()` | Returns the current line number, starting from 0 by default. | **Essential** |
| `void setLineNumber(int lineNumber)` | Sets the current line number to a specified value (does *not* reposition the stream). Useful when continuing reading from an offset. | **Advanced** |

> 🧠 **Note**: Line numbers are updated only through reading operations, *not* by setting this value manually. Use with care when handling nested input sources or partial documents.

---

## 📖 **2. Reading Methods (Inherited + Overridden)**

Reading is the bread and butter of any `Reader` class. These methods control how text is consumed from the input stream.

| Method | Description | Tag |
|--------|-------------|-----|
| `String readLine()` | Reads a line of text and advances the line number counter. Skips line terminators. | **Essential** |
| `int read()` | Reads a single character, updating the line number if a line break is encountered. | **Advanced** |
| `int read(char[] cbuf, int off, int len)` | Reads characters into a buffer. Properly updates line number if newlines occur in the chunk. | **Advanced** |
| `long skip(long n)` | Skips characters but may not reliably track line numbers — **line count may break** if skipping over line breaks. | **Rarely Used** |

> ⚠️ **Caution**: `skip()` can bypass newline detection logic. Not suitable if line number accuracy is required.

---

## 🧭 **3. Marking & Resetting State**

These methods allow the reader to mark a point and return to it later. Line number state is preserved, making this feature useful for conditional backtracking.

| Method | Description | Tag |
|--------|-------------|-----|
| `void mark(int readAheadLimit)` | Marks the current position and saves the current line number for potential reset. | **Advanced** |
| `void reset()` | Resets the stream to the last mark, including restoring the saved line number. | **Advanced** |
| `boolean markSupported()` | Returns true — indicating that mark/reset are supported. | **Rarely Used** |

> 💡 **Tip**: Very useful when parsing with lookahead — e.g., conditional parsing of blocks in config or source files.

---

## 🧹 **4. Stream Control & Resource Management**

These are inherited standard methods from `Reader`, important in any I/O class but not specific to `LineNumberReader`.

| Method | Description | Tag |
|--------|-------------|-----|
| `void close()` | Closes the underlying stream. Required in all I/O handling. | **Essential** |
| `boolean ready()` | Checks if the stream is ready for reading (non-blocking check). | **Rarely Used** |

---

## 🏛️ **5. Constructors**

While not methods, the constructors define how the class is initialized and are crucial in practical usage.

| Constructor | Description | Tag |
|-------------|-------------|-----|
| `LineNumberReader(Reader in)` | Wraps a `Reader` with default buffer size. | **Essential** |
| `LineNumberReader(Reader in, int sz)` | Wraps a `Reader` with a custom buffer size. Use when optimizing for large files or specific memory constraints. | **Advanced** |

---

## ✅ **Summary: Real-World Usage Scenarios**

### 🔹 Common Enterprise Use Cases:
- **Parsing configuration files** and reporting errors with line numbers.
- **Compiling or interpreting DSLs or templates**, where accurate position tracking is essential.
- **Log file analysis**, highlighting issues line-by-line.
- **ETL processes**, where source row numbers must be preserved or reported on failure.

### 🔹 Frequently Used in:
- Batch processing systems
- Custom format readers (CSV, INI, XML-like structures)
- Debug tooling and linters

---

## 💼 Final Advice & Tips for Enterprise Java Developers

1. **Use `readLine()` for most business logic** — it’s the cleanest and safest way to increment line numbers.
2. **Avoid `skip()` unless you’re not depending on line count accuracy.**
3. **Combine with `try-with-resources`** to ensure proper resource management:
   ```java
   try (LineNumberReader reader = new LineNumberReader(new FileReader("data.txt"))) {
       String line;
       while ((line = reader.readLine()) != null) {
           System.out.printf("Line %d: %s%n", reader.getLineNumber(), line);
       }
   }
   ```
4. **Use `setLineNumber()` when combining multiple sources**, such as reading fragments or handling includes.
5. **Prefer `Files.lines(Path)` with manual counting** if you need streams and don’t require backtracking.

---

