Ah, let me tell you the tale of **`java.io.LineNumberInputStream`**, a curious and once-useful class that arrived with noble intentions — but like many things in software, eventually became a relic, gently nudged into the shadows by better designs and a changing world.

---

## 🧭 1. The Problem It Was Meant to Solve — *The Gap in the Stream*

In the early days of Java, when the platform was still finding its footing in the 1990s, I/O was both a necessity and a complexity. Developers needed to read from files, network sockets, and streams of data — and quite often, especially when dealing with source code, logs, or configuration files, they needed **line numbers**.

Why? Because line numbers gave **context**. Imagine writing a compiler, an interpreter, or even just a configuration parser — being able to say “Error at line 42” was golden. Yet, `InputStream`, the base class for byte-based reading, was blind to line numbers. It read bytes — faceless, positionless — without any built-in mechanism to know where one line ended and another began.

Thus was born **`LineNumberInputStream`** — a class that didn’t just read bytes, but **counted lines** as it went.

---

## 💡 2. The Idea — *Making Streams Smarter*

The architects of Java had a vision: to build **stream decorators**. A system where streams could be stacked, wrapped, and enhanced like layers of an onion — or better yet, like Lego bricks. You might take a raw `FileInputStream`, wrap it in a `BufferedInputStream` for performance, and then toss on a `LineNumberInputStream` to track lines. This was the philosophy behind the **Decorator Pattern** that pervaded `java.io`.

`LineNumberInputStream` was a **simple enhancement**: it wrapped any existing `InputStream`, and added the ability to **track line numbers** as you read.

Its purpose was clear:
- Enhance a stream to be **line-aware**
- Allow developers to query the **current line number**
- Provide minimal overhead

No grand ambitions. Just a focused tool for a focused job. It didn’t aim to parse or tokenize — just count lines, byte by byte.

But as with any design, simplicity would prove to be both a virtue and a flaw.

---

## 🏗️ 3. The Shape and Structure — *Anatomy of a Line Counter*

Let’s look at what made this class tick.

```java
@Deprecated(since="1.1")
public class LineNumberInputStream extends FilterInputStream
```

Right from the class declaration, you notice something jarring: it's marked **`@Deprecated` since Java 1.1**. We’ll come back to that.

As a subclass of `FilterInputStream`, it’s part of the decoration chain — a wrapper. It overrides methods from `InputStream`, particularly those that **read bytes** — because that’s where line endings show up.

### 🔧 Constructors

```java
public LineNumberInputStream(InputStream in)
```

Simple and clear: wrap another input stream. This is your decorator entry point.

### 📦 Key Methods

- **`public int getLineNumber()`**

  Returns the current line number. Starts from **0**, and increments when line endings are encountered.

- **`public void setLineNumber(int lineNumber)`**

  Let’s you *manually* set the line number. Useful if you resume parsing mid-stream or want to align with some external context.

- **`public int read()`**

  Reads a single byte. If it encounters a line terminator (`\n` or `\r`, or `\r\n`), it increments the line number.

- **`public int read(byte[] b, int off, int len)`**

  Reads multiple bytes, but carefully analyzes them to detect line endings.

- **`public long skip(long n)`**

  Skips bytes and updates line numbers accordingly.

- **`public void mark(int readlimit)`** and **`reset()`**

  These are supported, but with caveats — line number state must also be saved and restored.

### 🧠 Internal Logic

The class must track line endings, but not all systems use the same ones. Unix uses `\n`, Windows uses `\r\n`, and older Macs used `\r`. So, it has to be clever: it watches for `\r`, peeks at the next byte to see if it’s followed by `\n`, and ensures it doesn’t **double count**.

This made it slightly complex internally — handling edge cases, buffering partial line endings, and updating a simple integer counter at just the right moments.

---

## 🧱 4. The Limitations and Evolution — *Where Time Caught Up*

Here’s where the story takes a twist.

Despite being a neat idea, `LineNumberInputStream` had a **fatal flaw**: it operated on **bytes**, not characters.

That means it couldn't properly handle:
- Multibyte encodings like UTF-8 or UTF-16
- Character sets beyond ASCII

In a world rapidly shifting toward internationalization, this was unacceptable.

So in Java 1.1, just a short while after its introduction, it was **deprecated** — and replaced by its spiritual successor:

> **`LineNumberReader`**

This new class operated on **characters**, not bytes. It extended `BufferedReader`, supported proper encodings, and was far more aligned with how modern developers thought about text.

While `LineNumberInputStream` could still be used, the warning was clear: "There’s a better way."

And so it faded, used only in legacy systems or as an educational curiosity.

---

## 🌱 5. The Legacy — *What It Left Behind*

Despite its deprecation, `LineNumberInputStream` made a mark. It:
- Popularized the concept of **line-aware streams**
- Demonstrated the **power and limitations** of the decorator pattern
- Illustrated how even simple enhancements could hit complex problems in a global world

It’s often cited in textbooks and tutorials when teaching Java’s I/O system. It reminds developers of a time when Java was still grappling with how best to handle **text**, **encodings**, and **platform differences**.

And its downfall was instructive: by tying itself to byte-based reading, it limited its future.

---

## 📜 In Closing: The Quiet Retirement of a Once-Honored Class

So there it sits — `java.io.LineNumberInputStream` — quietly deprecated in Java 21, as it was in 1.1. Not removed, not forgotten. Just...retired.

It had a job to do, and it did it well for its time. But like many tools from early Java, it was outpaced by a changing world: Unicode, globalization, and better abstractions left it behind.

Still, there's something noble about it — a tiny guardian of line numbers, faithfully counting, byte by byte, as the input stream flows.

And maybe, just maybe, in some dusty corner of a legacy enterprise app, it’s still counting.