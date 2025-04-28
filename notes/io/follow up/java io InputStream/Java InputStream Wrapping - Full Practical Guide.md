# 📚 Java InputStream Wrapping - Full Practical Guide

---

## 1. Fundamental Principle

> **You combine InputStreams based on the problem you want to solve.**  
> Wrapping adds **layers of new functionality** on top of the base reading mechanism.

Think of it like:
```plaintext
[Source] → [Buffering for speed] → [Pushback for control] → [Data/Object for meaning]
```

---

## 2. Basic Types of Streams

| Type                    | Class                        | What It Provides                     |
|--------------------------|-------------------------------|--------------------------------------|
| **Source Stream**        | `FileInputStream`, `ByteArrayInputStream`, `PipedInputStream`, etc. | Raw bytes from somewhere. |
| **Speed Layer**          | `BufferedInputStream`         | Speeds up reading by using memory buffer. |
| **Control Layer**        | `PushbackInputStream`         | Allows pushing bytes back manually. |
| **Interpretation Layer** | `DataInputStream`, `ObjectInputStream` | Interprets raw bytes as Java types or objects. |

---

## 3. Common Combinations and What They Solve

### 🧩 A. Fast File Reading (binary data)

```java
InputStream input = new BufferedInputStream(new FileInputStream("file.bin"));
```
- **Problem solved:**  
  ➔ Reading files faster (fewer disk accesses).
- **When to use:**  
  ➔ Reading big binary files, images, etc.

---

### 🧩 B. Pushback Parsing (need to look ahead)

```java
InputStream input = new PushbackInputStream(new BufferedInputStream(new FileInputStream("file.txt")));
```
- **Problem solved:**  
  ➔ Peek at upcoming bytes, and push back if necessary (e.g., parsing tokens, formats).
- **When to use:**  
  ➔ Writing parsers, file format interpreters.

---

### 🧩 C. Reading Structured Data (int, double, etc.)

```java
DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));
```
- **Problem solved:**  
  ➔ Reading **primitives** (`int`, `double`, etc.) from a binary file easily.
- **When to use:**  
  ➔ When files save "raw" data types, not text.

---

### 🧩 D. Reading Objects (Deserialization)

```java
ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("object.ser")));
```
- **Problem solved:**  
  ➔ Reconstructing Java objects (`Person`, `Order`, etc.) from a file or network.
- **When to use:**  
  ➔ Java object serialization (e.g., saving game state, configurations).

---

### 🧩 E. Complex Parser (Fast + Lookahead + Type Safety)

```java
DataInputStream input = new DataInputStream(new PushbackInputStream(new BufferedInputStream(new FileInputStream("complex.dat"))));
```
- **Problem solved:**  
  ➔ Fast reading, with pushback support, and typed primitive reading.
- **When to use:**  
  ➔ Building complex binary parsers (file formats, protocol parsers).

---

## 4. Best Practices for Wrapping Order

✅ **General Recommended Wrapping Order**:

```plaintext
Source Stream
    ↓
BufferedInputStream (Optional, but almost always useful)
    ↓
PushbackInputStream (If parsing and backtracking are needed)
    ↓
DataInputStream or ObjectInputStream (If interpreting bytes as types or objects)
```

✅ **Notes:**
- `BufferedInputStream` **should be close to the source** to avoid slow reads.
- `PushbackInputStream` **should be inside** the buffering layer (pushing back to a buffered stream is safer).
- `DataInputStream` or `ObjectInputStream` **should be the outermost** layer (because they "assume" normal byte availability).

---

# 🎯 Visual Stacking Model

```plaintext
DataInputStream / ObjectInputStream
      ↑
PushbackInputStream (if needed)
      ↑
BufferedInputStream (for speed)
      ↑
Source InputStream (FileInputStream, ByteArrayInputStream, etc.)
```

---

# 5. Problems Solved by Each Layer

| Layer                       | Problem Solved                         |
|------------------------------|----------------------------------------|
| Source Stream                | Raw byte access to file, network, or memory. |
| BufferedInputStream          | Faster access by reducing I/O calls.  |
| PushbackInputStream          | Ability to rollback / look ahead during parsing. |
| DataInputStream              | Easy reading of Java primitive types. |
| ObjectInputStream            | Full Java object reconstruction (serialization). |

---

# 📋 Final Summary: How to Choose

| If you need...              | Then use...                                          |
|------------------------------|-----------------------------------------------------|
| Just basic file reading      | `FileInputStream` (optionally buffered).             |
| Faster reading               | `BufferedInputStream` wrapping your source.         |
| Parsing/Lookahead capability | `PushbackInputStream` wrapping a buffer.             |
| Reading ints, doubles, etc.  | `DataInputStream` wrapping a buffered stream.        |
| Reading saved Java objects   | `ObjectInputStream` wrapping a buffered stream.      |

---

✅ Now, **you fully know**:
- **How streams combine**
- **Why they combine that way**
- **Which problems they solve**
- **How to design professional, layered IO code**

---

# 🧠 One Final Tip:
> **Think of InputStream wrapping as *building up capabilities* layer by layer — not rigid inheritance.**

---
