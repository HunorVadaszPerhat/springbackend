---

### 🔍 Breakdown of Each Method Demonstrated

| Method / Constructor | Line | Purpose | Notes |
|----------------------|------|---------|-------|
| `BufferedOutputStream(OutputStream, int)` | line 15 | Custom buffer size | Useful when tuning I/O performance |
| `write(int b)`       | line 18 | Writes a single byte | Common in byte-by-byte streaming |
| `write(byte[], int, int)` | line 21 | Writes a portion of a byte array | Optimized and efficient |
| `write(byte[])` (inherited) | line 24 | Writes full byte array | Often used with full message chunks |
| `flush()`            | line 27 | Immediately writes buffer to output | Prevents data being stuck in buffer |
| `close()`            | line 30 | Flushes and releases resources | Automatically used with try-with-resources |

---

## ✅ Example Output File Contents

```
ABufferedOuBufferedOutputStream in Java 21
```

> ✔️ You see `'A'` (from `write(int)`), then "BufferedOu" (partial), then full message (full array).

---

## 💡 Tips for Enterprise Devs

- **Use flush() before switching output consumers** — e.g., before handing off control to another handler or thread.
- **Always prefer try-with-resources** to ensure `close()` is called even on failure.
- **Benchmark buffer size** in performance-sensitive systems — 8K is default, but 16K/32K may be better for large writes.
- **Don't use BufferedOutputStream in non-blocking or reactive contexts** — instead, look at `java.nio` or `java.util.concurrent.Flow`.

---

