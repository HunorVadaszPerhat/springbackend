
---

## 📚 **Method Cheat Sheet (with Practical Explanations)**

| Method                       | Description & Use Case                                                       | Importance        |
|-----------------------------|-------------------------------------------------------------------------------|-------------------|
| `CharArrayWriter()`         | Creates writer with 32-char default buffer; fine for small/typical cases.    | Essential         |
| `CharArrayWriter(int)`      | Allows setting buffer size for large/known workloads.                        | Advanced          |
| `write(int c)`              | Writes one character; useful in character-by-character parsing.              | Rarely Used       |
| `write(char[], off, len)`   | Efficient bulk write from char arrays; use in parsers or serializers.        | Essential         |
| `write(String, off, len)`   | Writes substring; great for templating and formatting.                       | Essential         |
| `toCharArray()`             | Returns a trimmed copy of the internal buffer; used for raw processing.      | Essential         |
| `toString()`                | Converts written characters to a `String`; most common final output.         | Essential         |
| `writeTo(Writer)`           | Transfers all written content to another writer; useful for pipelines.       | Essential         |
| `size()`                    | Returns number of written characters; good for checks or conditions.         | Advanced          |
| `reset()`                   | Clears the buffer without reallocating; ideal for reuse.                     | Advanced          |
| `flush()`                   | No-op; included for API compatibility.                                       | Rarely Used       |
| `close()`                   | No-op; no system resources to close.                                         | Rarely Used       |

---

## 💼 **Enterprise Developer Tips**

- Use `reset()` to **reuse** a writer instance and **avoid GC pressure** in loops.
- `writeTo(Writer)` is perfect for piping buffered content to an output stream or HTTP response.
- If you're working with templates or generating reports, `CharArrayWriter` gives you **flexibility and control**.
- Prefer `write(char[], off, len)` and `write(String, off, len)` for **performance-critical code**.
- Safe to use in unit tests to **capture and assert on written content**.

---

