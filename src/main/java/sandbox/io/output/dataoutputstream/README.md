✅ Here's what this **small Java 21 project** demonstrates:

- **Writes** all primitive types and basic String operations.
- **Explains** the purpose of each method with comments.
- **Uses** `try-with-resources` for safe closing.
- **Prints** the **total bytes written** using `size()`, although it’s typically used rarely in production.

# ✍️ Final Pro Tip for Enterprise Devs:
- If designing a real protocol, **document the order and type of writes clearly** (e.g., "4 bytes for ID, 2 bytes for short version, UTF string for name").
- **Wrap streams with buffering** (`BufferedOutputStream`) for efficiency.
- **Avoid `writeBytes` unless you're 100% sure** about encoding needs (e.g., ASCII-only data).
- Always **use `flush()`** especially before expecting clients to read the written data over a network.

---

