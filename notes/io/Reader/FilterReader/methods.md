Here's a **comprehensive and practical categorization of the `java.io.FilterReader` class methods (Java SE 21)**, organized into logical groups. This is tailored for **enterprise-level Java development**, highlighting **real-world relevance**, tagged accordingly, and concluding with **usage summaries and strategic advice**.

---

# 📚 **Java SE 21 — `FilterReader` Method Categorization Guide**

### 🚩 **Legend:**
- **Essential** – Frequently used in most real-world applications.
- **Advanced** – Useful in specific, more complex scenarios (e.g., performance tuning, advanced stream handling).
- **Legacy** – Part of older patterns; modern APIs may offer alternatives.
- **Rarely Used** – Niche or rarely needed in standard enterprise use.

---

## 🧭 1. **Construction and Core Delegation**

| Method | Tag | Description |
|--------|-----|-------------|
| `protected FilterReader(Reader in)` | **Essential** | Protected constructor that requires a wrapped `Reader`. Used by subclasses to implement filtering behavior. |
| `int read()` | **Essential** | Reads a single character. Most often overridden to implement filtering logic. |
| `int read(char[] cbuf, int off, int len)` | **Essential** | Reads multiple characters into a buffer. Default implementation delegates; override for efficient filtering. |

### 🔧 Practical Insight:
- Overriding `read()` alone often **isn't enough** in enterprise-scale apps—consider both `read()` and `read(char[], int, int)` for performance.

---

## 🔄 2. **Stream Management & Control**

| Method | Tag | Description |
|--------|-----|-------------|
| `void close()` | **Essential** | Closes the stream. Always call this or use try-with-resources in production code. |
| `boolean ready()` | **Advanced** | Checks if input is ready without blocking. Useful in interactive or buffered stream chains. |
| `long skip(long n)` | **Advanced** | Skips characters in the stream. Helpful when filtering out known headers or metadata. |

### 🔧 Practical Insight:
- In **large file parsing** or **ETL pipelines**, `skip()` can be paired with custom filters to ignore headers.
- `ready()` can optimize responsiveness in **I/O-bound enterprise services** (e.g., reading from sockets or web APIs).

---

## 📍 3. **Marking & Resetting (Stream Positioning)**

| Method | Tag | Description |
|--------|-----|-------------|
| `boolean markSupported()` | **Legacy** | Returns whether the wrapped stream supports marking. Delegated. |
| `void mark(int readAheadLimit)` | **Rarely Used** | Marks the current stream position. Use with caution unless you know the delegate supports it. |
| `void reset()` | **Rarely Used** | Resets to the last marked position. Risky unless carefully handled. |

### ⚠️ Caveats:
- Often **misunderstood or misused**.
- Most enterprise-grade filters **don’t rely on marking**, especially with large, unbuffered streams.
- Prefer **buffering and checkpointing at higher layers** (e.g., `BufferedReader`, or business logic level).

---

## 🧾 4. **Protected Accessors (for Subclasses)**

| Field | Tag | Description |
|-------|-----|-------------|
| `protected Reader in` | **Essential** | The underlying reader. Subclasses use this to delegate or override methods selectively. |

### 🔧 Practical Insight:
- This protected field is the **key entry point** for custom logic.
- Always ensure null checks or validation before deep delegation.

---

# 📌 **Real-World Usage Summary**

### ✅ **Most Useful Methods in Practice**
- `read()`, `read(char[], int, int)` — for building custom character-based filters (e.g., sanitizers, converters, formatters).
- `close()` — critical for resource management, especially in high-concurrency enterprise environments.
- `ready()` — beneficial in **non-blocking** or **interactive input** systems (e.g., CLI tools, socket readers).

### ❌ **Commonly Overused or Misused**
- `mark()`, `reset()` — typically misunderstood; best avoided unless the full reader chain supports them reliably.
- `skip()` — sometimes used incorrectly to “consume” data without verifying character encoding or buffer state.

---

# 🧠 **Advice & Best Practices for Enterprise Developers**

### ✅ **Do**
- Extend `FilterReader` when you need **lightweight, reusable, and composable character stream transformations**.
- Always implement both `read()` methods if your logic modifies character sequences (e.g., HTML stripping, case conversion).
- Wrap your `FilterReader` in a `BufferedReader` when handling large or line-based input.

### ❌ **Don’t**
- Rely on `mark/reset` unless you're absolutely sure the source reader and your logic support it.
- Use `FilterReader` for byte-level filtering — use `FilterInputStream` or `Reader`/`InputStreamReader` conversions instead.

### 📦 **Better Alternatives for Modern Use Cases**
| Need | Preferred Tool |
|------|----------------|
| Structured data parsing (XML, JSON) | Jackson, JAXB, Gson |
| File I/O with modern APIs | `java.nio.file.Files` with `BufferedReader` |
| Stream transformation pipelines | Java Streams + functional transformations |
| Reactive or async I/O | Project Reactor, Akka Streams, or `java.util.concurrent.Flow` (Java 9+) |

---

# 🏁 **Final Thoughts**

`FilterReader` is not flashy — but it’s **foundational**. In the toolkit of the enterprise Java developer, it’s the **custom scalpel** for precise character-stream manipulation. When used thoughtfully, it enables clean, testable, modular stream processing without reinventing the wheel.

Its greatest strength lies in what it **doesn’t do**: it doesn’t impose buffering, doesn’t dictate format, and doesn’t try to be too smart. Instead, it invites you to shape the stream — **your way**.
