
---

## 📝 Summary of Method Use

| Method                            | Purpose                                      | Line in Code                         |
|----------------------------------|----------------------------------------------|--------------------------------------|
| `write(String s)`                | Write an entire string to the buffer         | `writer.write("Hello, Java 21!")`    |
| `newLine()`                      | Adds system-specific line separator          | `writer.newLine()`                   |
| `write(char[] cbuf, int, int)`   | Write part of a character array              | `writer.write(nameChars, 0, 9)`      |
| `write(String s, int, int)`      | Write part of a string                       | `writer.write(longText, 0, 10)`      |
| `write(int c)`                   | Write a single character (ASCII value)       | `writer.write(65)`                   |
| `flush()`                        | Immediately write buffered data to output    | `writer.flush()`                     |
| `close()`                        | Flush and close the writer                   | Handled by `try-with-resources`      |


---

## 📌 Tips for Enterprise Developers

- Use **try-with-resources** to avoid forgetting `close()`.
- Call `flush()` manually only if partial content must be visible *before* the writer is closed (e.g., during network streaming).
- For writing structured data (logs, reports), combine `write()` and `newLine()` for line-based formats.
- Consider custom buffer sizes for large file generation — test and tune for your workloads.

---

