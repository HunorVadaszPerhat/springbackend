# 📚 **PushbackInputStream Methods: Enterprise Categorization**

---

## **1. Core Read and Unread Operations**
*(These are the heart of PushbackInputStream — the methods you will actually use in production.)*

| Method | Tag | Explanation |
|:---|:---|:---|
| `int read()` | **Essential** | Reads one byte: first from the pushback buffer if available, otherwise from the underlying stream. |
| `int read(byte[] b, int off, int len)` | **Essential** | Bulk read method: reads multiple bytes, considering unread data first. Essential for efficient parsing. |
| `void unread(int b)` | **Essential** | Pushes back a single byte. Crucial for implementing "peek and push back" logic in parsers. |
| `void unread(byte[] b, int off, int len)` | **Advanced** | Pushes back multiple bytes at once. Useful when undoing a batch read operation. |

---

## **2. Stream Control and Metadata**
*(These help manage stream state and interactions but are secondary to read/unread operations.)*

| Method | Tag | Explanation |
|:---|:---|:---|
| `int available()` | **Advanced** | Returns the number of bytes available to read without blocking, including bytes in the pushback buffer. Useful for optimizing non-blocking reads. |
| `void close()` | **Essential** | Closes the stream and the underlying InputStream. Always necessary for proper resource management in enterprise applications. |

---

## **3. Constructors**
*(Control the initial setup of the PushbackInputStream.)*

| Constructor | Tag | Explanation |
|:---|:---|:---|
| `PushbackInputStream(InputStream in)` | **Essential** | Creates a PushbackInputStream with a **default 1-byte pushback buffer** — suitable for simple lookahead. |
| `PushbackInputStream(InputStream in, int size)` | **Advanced** | Creates a PushbackInputStream with a **custom buffer size**. Important for more complex parsing needs (multi-byte pushback). |

---

## **4. Inherited Legacy Methods**
*(Inherited from `InputStream`, available but less relevant for pushback-specific functionality.)*

| Method | Tag | Explanation |
|:---|:---|:---|
| `long skip(long n)` | **Legacy** | Skips over and discards `n` bytes. Risky with pushback context because it doesn't manage unread bytes intuitively. Rarely used with PushbackInputStream. |
| `boolean markSupported()` | **Legacy** | Always returns `false`. PushbackInputStream does **not** support `mark/reset`. This reminds you to rely on `unread()` instead. |

---

# 📖 **Summary: Real-World Usage in Enterprise Applications**

✅ **Primary Use Cases**:
- **Protocol parsing**: Reading a few bytes to determine message types (e.g., HTTP, FTP, custom protocols).
- **File format sniffing**: Reading headers or magic numbers, then "unreading" if wrong type detected.
- **Lightweight lookahead parsers**: Handling token-based input without needing massive buffering frameworks.

✅ **Typically Used Methods**:
- `read()`
- `read(byte[], int, int)`
- `unread(int)`
- `close()`

✅ **Less Common but Sometimes Useful**:
- `unread(byte[], int, int)` (multi-byte rollback)
- `available()` (when designing non-blocking parsers)

✅ **Methods Rarely Used**:
- `skip(long)` and `markSupported()`

---

# 🎯 **Final Advice and Tips for Enterprise Java Developers**

- **🔵 Size Your Buffer Wisely**:  
  If you expect multiple bytes might need to be unread (e.g., multi-byte magic numbers or structured tokens), use the constructor that allows setting a **larger buffer**.

- **🔵 Always Close Streams**:  
  Treat `PushbackInputStream` like any other resource — close it in a `finally` block or use a try-with-resources statement (`try (PushbackInputStream pbis = ...) {}`).

- **🔵 Don't Misuse for General Buffering**:  
  If you need **large read buffers** for performance, prefer `BufferedInputStream`. PushbackInputStream is for **selective, small reversals**, not full buffering.

- **🔵 Handle IOException on Unread**:  
  Always be aware that `unread()` can throw if the pushback buffer overflows. Catch and handle `IOException` sensibly.

- **🔵 No Mark/Reset Expectation**:  
  Unlike `BufferedInputStream`, this class **does not support mark/reset**. Design your code to **pushback manually** instead.

- **🔵 Thread Safety**:  
  Remember that like most `java.io` classes, `PushbackInputStream` is **not thread-safe**. Use external synchronization if accessed by multiple threads.

---

> **In short**: In an enterprise system, use **PushbackInputStream** for lightweight, deterministic parsing tasks where you might need to peek ahead. Use it **deliberately**, not casually — and combine it with strong resource management and error handling practices.

---