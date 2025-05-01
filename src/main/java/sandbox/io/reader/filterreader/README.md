
---

## 📝 **Explanation of Each Method in Use**

| Method | Purpose |
|--------|---------|
| `read()` | Converts each character to uppercase (used internally by BufferedReader). |
| `read(char[], int, int)` | Filters sensitive words like "password". |
| `skip(long n)` | Demonstrates skipping a chunk of characters in the stream. |
| `ready()` | Shows if the stream is ready without blocking. |
| `mark(int limit)` | Marks the current position in the stream (used before reset). |
| `reset()` | Resets to the mark set earlier. |
| `markSupported()` | Checks if `mark()`/`reset()` are allowed (they are, because BufferedReader supports it). |
| `close()` | Closes the stream and shows a cleanup message. |

---

## 🧠 **Final Tips for Enterprise Devs**
- Always **wrap your `FilterReader` in a `BufferedReader`** if you need efficient reading, `mark()`/`reset()`, or line-wise processing.
- Customize `read(char[], int, int)` when doing **batch filtering** or **search/replace logic**.
- Use `read()` for **character-by-character transformations** like case conversion or encryption.
- Avoid relying too much on `mark()`/`reset()` unless absolutely required — it introduces state complexity.
- **Always close readers** using `try-with-resources` in production.

---

