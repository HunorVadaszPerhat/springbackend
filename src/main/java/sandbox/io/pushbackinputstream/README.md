---

# 📜 **What Each Part Demonstrates**

| Java Method | Where it's Used | Short Explanation |
|:---|:---|:---|
| `read()` | Reading single bytes and after unread | Reads the next available byte (from buffer or file). |
| `unread(int b)` | After detecting a letter | Pushes back one byte for re-reading. |
| `read(byte[] b, int off, int len)` | Reading digits in batch | Reads multiple bytes into a byte array. |
| `unread(byte[] b, int off, int len)` | After batch reading digits | Pushes back multiple bytes for re-reading. |
| `available()` | After reading a letter | Shows how many bytes can be read immediately without blocking. |
| `close()` | Implicit by try-with-resources | Closes both the PushbackInputStream and underlying stream safely. |

---

# 🧠 **Real-World Style Use Case Simulated**

- Detect if incoming data is a **letter** or **digit**.
- For letters: **peek ahead** by pushing back and re-reading.
- For digits: **read a block** and **reconstruct** it for reprocessing.

---
# ⚡ **Notes**

- **Buffer size matters**: we created the `PushbackInputStream` with a buffer of `4` bytes to allow pushing back multiple bytes.
- **Error Handling**: All IOExceptions are caught simply here; in enterprise code, prefer proper logging or user-defined exceptions.
- **Stream Closure**: Always use **try-with-resources** to avoid memory leaks.
- **Simplicity**: We keep parsing logic clear and match the real parsing challenges in simple data formats (protocols, file signatures, etc.)

---

# 🛠 **Next Steps (Optional Extensions)**

- You could extend this project by parsing different file types like `.csv`, `.ini`, or custom binary headers.
- Add advanced buffer management (detecting overflows).
- Support multiple character sets (e.g., UTF-8) via `InputStreamReader + PushbackReader`.

---
