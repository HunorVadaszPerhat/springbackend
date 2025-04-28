# 📚 How to Wrap IO Classes in InputStream (Rules and Best Practices)

✅ **Rule 1: You can stack (wrap) InputStream classes freely — based on your needs, not the tree hierarchy.**

- **You don’t have to follow the inheritance tree** (`BufferedInputStream` and `PushbackInputStream` both extend `FilterInputStream`, but they can be wrapped in any order logically).
- **You follow the functionality you need**, not "who extends who".

---

✅ **Rule 2: You should wrap streams logically based on purpose:**

| Purpose                         | Best Practice                                           | Example Wrapping                                |
|----------------------------------|---------------------------------------------------------|-------------------------------------------------|
| **Speed** (buffering)            | Add a `BufferedInputStream` as close to the source as possible. | `BufferedInputStream(new FileInputStream(...))` |
| **Parsing control** (pushback)   | Add `PushbackInputStream` after buffering (if needed).  | `PushbackInputStream(new BufferedInputStream(...))` |
| **Structured data (primitives)** | Add `DataInputStream` as the final wrapper (outermost). | `DataInputStream(new BufferedInputStream(new FileInputStream(...)))` |
| **Object reading** (Java objects) | Use `ObjectInputStream` directly over a buffered stream. | `ObjectInputStream(new BufferedInputStream(new FileInputStream(...)))` |

---

✅ **Rule 3: General wrapping order suggestion (inside → out):**

```plaintext
Source InputStream (FileInputStream, ByteArrayInputStream, etc.)
    ↓
Optional: BufferedInputStream (if reading large amounts)
    ↓
Optional: PushbackInputStream (if parsing needs rollback)
    ↓
Optional: DataInputStream or ObjectInputStream (to interpret bytes as data or objects)
```

---

# 🎯 Short Practical Guide

| If you want...                          | Then...                                           |
|------------------------------------------|---------------------------------------------------|
| Fast reading only                        | Use `BufferedInputStream`.                       |
| Ability to push back bytes               | Use `PushbackInputStream`.                        |
| Reading primitive types (int, double)    | Use `DataInputStream` on top.                     |
| Reading serialized Java objects          | Use `ObjectInputStream` on top.                   |
| Complex parsing (fast + pushback + type)  | Stack: `DataInputStream(PushbackInputStream(BufferedInputStream(...)))` |

---

✅ **Summary:**
> **Wrap based on functionality you need, not based on class inheritance tree.**

✅ **BufferedInputStream is almost always useful** for performance.

✅ **PushbackInputStream is useful for tricky parsing**, but don't use it unless needed.

✅ **DataInputStream / ObjectInputStream** should always be the **last outer layer**, because they **expect a clean stream underneath**.

---

# 🧠 Final Mental Model:
> **Wrapping InputStreams is like building layers of features: source → speed → control → meaning.**

---
