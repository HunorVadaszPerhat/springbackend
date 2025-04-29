## 📦 Project: `BinaryProfileReader`
### 🎯 Goal:
Simulate reading structured binary data representing user profiles from a binary file using `DataInputStream`, exercising **all key methods**, organized clearly and meaningfully.

---

## 🧱 Project Structure
```
BinaryProfileReader/
├── data/
│   └── sample_profiles.dat
├── src/
│   ├── BinaryProfileWriter.java
│   └── BinaryProfileReader.java
```

---

## 🧪 What’s Covered

| Method | Usage |
|--------|-------|
| `readInt()` | Reads unique profile ID |
| `readUTF()` | Reads username (UTF-8 encoded) |
| `readBoolean()` | Active flag |
| `readByte()` | Age |
| `readShort()` | Short ID |
| `readChar()` | User initial |
| `readFloat()` | Weight |
| `readDouble()` | Height |
| `readLong()` | Timestamp |
| `readFully()` | Fixed-size byte block |
| `skipBytes()` | Demonstrated as no-op (can be used in field skipping) |
| `available()` | Show remaining bytes (roughly) |

---

## 💡 Final Tips for Enterprise Developers

- Always use **`BufferedInputStream`** for performance.
- **Use `readFully()`** when reading fixed-length blocks to avoid partial reads.
- Avoid `readUTF()` unless you're using `writeUTF()` symmetrically — use `InputStreamReader` otherwise.
- Use **`skipBytes()`** to skip deprecated fields in legacy formats.
- Use **`available()`** only for diagnostics — not reliable for stream boundaries.

---
