---

## **The Decorator Pattern – Core Idea**

The **Decorator Pattern** is a structural design pattern that allows you to add new behavior to objects **dynamically**, without changing their structure or using inheritance.

### **Basic Principles:**
- You start with a **core object** that performs the essential operation.
- You wrap it in **decorators**, which implement the same interface but **add new functionality** before or after delegating to the original object.
- This allows for flexible stacking of behaviors.

### **Why use it?**
- Follows the **Open/Closed Principle**: classes are open for extension, but closed for modification.
- Supports **composition over inheritance**.
- Enables **modular behavior** through layers.

---

## **The I/O System in Java: A Decorator Masterpiece**

### 1. **Base Abstraction: InputStream**
At the heart of Java's I/O is the abstract class:

```java
public abstract class InputStream {
    public abstract int read() throws IOException;
    // ...
}
```

This defines the **common interface** for all byte input streams.

### 2. **Concrete Component: FileInputStream**
This is your **core object** — a simple class that reads raw bytes from a file:

```java
InputStream fis = new FileInputStream("data.bin");
```

It implements `read()` and provides the raw access to the file’s bytes.

### 3. **Decorator Classes**
Now, here’s where the magic happens. Java includes multiple `InputStream` subclasses that **wrap another InputStream** to add functionality.

#### Examples:

- **BufferedInputStream**: Adds buffering to reduce disk access and improve performance.

  ```java
  InputStream in = new BufferedInputStream(new FileInputStream("data.bin"));
  ```

- **DataInputStream**: Lets you read Java primitives like `int`, `long`, and `double`.

  ```java
  DataInputStream dataIn = new DataInputStream(in);
  ```

- **CheckedInputStream** (from `java.util.zip`): Adds checksum computation as you read bytes.

Each of these **decorators** adds functionality but still behaves like an `InputStream`. You can keep stacking decorators to build complex behaviors.

### 4. **The Reader/Writer Parallel**
The same idea is used in character streams:
- `Reader` is the base.
- `InputStreamReader` adapts a byte stream to characters.
- `BufferedReader` adds buffering and line-reading (`readLine()`).

---

## **Why Not Use Inheritance?**

If Java had tried to make `BufferedInputStream` a subclass of `FileInputStream`, it would’ve been **too rigid**:
- What if you want to buffer a `ByteArrayInputStream` instead?
- What if you want to checksum a socket stream?

By using the decorator pattern, you can do this:

```java
InputStream in = new CheckedInputStream(
                     new BufferedInputStream(
                         new FileInputStream("data.bin")),
                     new CRC32());
```

No inheritance needed. No class explosion. **Just composition.**

---

## **Decorator Pattern Benefits in `java.io`**

| Feature | Benefit |
|--------|--------|
| Flexible layering | Combine functionality (e.g., buffer + checksum + primitive read) |
| Consistent interface | Everything is still an `InputStream` |
| Easy testing and replacement | Swap out one stream for another without changing the rest |
| Open to extension | Developers can write their own decorators |

---

## **TL;DR**

The `java.io` package **embodies the Decorator Pattern**:
- `FileInputStream` is a core component.
- Wrappers like `BufferedInputStream` and `DataInputStream` are decorators.
- They all share a common interface (`InputStream`) and can be composed freely.

Java’s I/O streams are one of the **clearest and most elegant real-world uses** of the decorator pattern — a masterclass in modular and extensible design.

