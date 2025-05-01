Here's a **practical, high-yield list** of commonly used data types in Java enterprise apps, categorized by whether you should use **byte-based** (`InputStream`/`OutputStream`) or **character-based** (`Reader`/`Writer`) I/O classes.

---

## ✅ Java I/O Class Selection Cheat Sheet

| **Data Type** | **Description / Use Case** | **Use This** | **Why** |
|---------------|----------------------------|--------------|---------|
| **Text Files (.txt, .csv)** | Logs, config, flat files | `Reader` / `Writer` | These are plain Unicode character data |
| **JSON / XML / YAML** | APIs, configs, data exchange | `Reader` / `Writer` | Structured text; needs encoding/decoding |
| **Properties Files** | App configuration | `Reader` / `Writer` (via `Properties.load()`) | Key-value format; character-based |
| **PDF (.pdf)** | Documents, reports | `InputStream` / `OutputStream` | Binary format; not directly readable as text |
| **Images (.jpg, .png, .gif)** | Media, profile pictures | `InputStream` / `OutputStream` | Pure binary; must not be decoded |
| **Excel (.xls, .xlsx)** | Structured data | `InputStream` / `OutputStream` | Binary (or zipped XML); use Apache POI |
| **ZIP / GZIP / TAR** | Archives, compression | `InputStream` / `OutputStream` (with GZIP wrappers) | Compressed binary data |
| **Serialized Java Objects (.ser)** | Object persistence | `ObjectInputStream` / `ObjectOutputStream` | Binary stream of Java objects |
| **Audio / Video** | Multimedia | `InputStream` / `OutputStream` | Binary; processed by libraries |
| **HTML / Markdown** | Web templating | `Reader` / `Writer` | These are text files |
| **Database Text Export (e.g., SQL dump)** | Data backup/export | `Reader` / `Writer` | Plain text content |
| **Socket Communication** | WebSockets, HTTP, chat | Start with `InputStream` / `OutputStream`, use `Reader`/`Writer` if it's text | Depends on protocol (text or binary) |
| **Memory Buffers** | Caching or intermediate streams | `ByteArrayInputStream` / `CharArrayReader` | Depends on byte or character type |

---

## 🧭 Key Takeaways

- 🟢 Use `Reader`/`Writer` when the **content is meant to be read or written as human-readable text**
- 🔵 Use `InputStream`/`OutputStream` when you're dealing with **raw binary data**
- ⚙️ Use **wrappers** (`InputStreamReader`, `BufferedReader`, etc.) to compose behavior

---
