---

## 📘 Short Explanations by Method

| Feature | Explanation |
|--------|-------------|
| `write(int b)` | Writes a single byte — rarely used due to performance. |
| `write(byte[] b)` | Writes entire byte array — typical for most data. |
| `write(byte[] b, int off, int len)` | Writes a portion of a byte array — great for stream-based or partial processing. |
| `flush()` | Pushes data from buffer to system (used with wrappers like `BufferedOutputStream`). |
| `close()` | Closes the stream — done automatically via try-with-resources. |
| `getFD()` | Accesses low-level OS file handle — enables sync or interop. |
| `FileOutputStream(File/FileDescriptor/String)` | Constructors — let you control how and where to write. |
| `FileOutputStream(File, boolean append)` | Lets you append data instead of overwriting. |
| `FileDescriptor.sync()` | Ensures data is committed to physical storage (advanced durability use case). |

---

## 💼 Enterprise Dev Tips

- **Always use try-with-resources** to prevent resource leaks.
- **Use append mode** for logs, audit trails, and incremental writes.
- **Wrap with BufferedOutputStream** when writing large data chunks.
- **Don’t use for text output directly** — wrap with `OutputStreamWriter` if you need encoding control.
- **Validate paths and catch IOExceptions gracefully** — files can disappear or permissions can change in enterprise environments.

---

