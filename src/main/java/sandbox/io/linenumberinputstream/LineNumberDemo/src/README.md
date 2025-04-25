## 🗒️ Method Explanations (Recap)

| Method | Purpose |
|--------|---------|
| `read()` | Reads one byte, updates line number on newline. |
| `read(byte[], int, int)` | Reads into byte array segment, updates line numbers. |
| `read(byte[])` | Reads into full byte array — simpler form of above. |
| `getLineNumber()` | Returns current line number. |
| `setLineNumber(int)` | Manually sets the line number. |
| `mark(int)` | Marks the current stream + line number. |
| `reset()` | Resets to previously marked position. |
| `skip(long)` | Skips forward and counts line endings in skipped data. |
| `available()` | Rough estimate of how many bytes are ready to be read. |

---

## ✅ How to Run

Compile and run:

```bash
javac src/LineNumberInputStreamDemo.java
java -cp src LineNumberInputStreamDemo
```

Ensure `input.txt` is in the root directory.

---

## 📌 Final Tip for Enterprise Use

- **Only use this for legacy maintenance.**
- Always validate behavior around `\r\n` vs `\n` endings.
- For new code, switch to `LineNumberReader`, which supports multibyte encodings and works on `Reader` rather than `InputStream`.

