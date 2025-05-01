In simple terms, **`FilterWriter` solves the problem of customizing how text is written** — without having to build a writer from scratch.

### 🧠 The Problem:
Imagine you're writing data to a file, a web response, or a log. But before the text is written, you want to:

- **Censor** sensitive words (like masking passwords or names),
- **Convert** characters (like making everything uppercase),
- **Escape** special characters (like turning `<` into `&lt;` for HTML),
- **Track** what’s being written (like logging every line).

Java’s normal `Writer` classes like `FileWriter` just write text **as-is**, with no way to insert logic in the middle.

---

### ✅ The Solution:
`FilterWriter` lets you **wrap another writer and add your own logic** in between. It acts like a **middleman** or **custom gatekeeper** for the text.

You don't have to re-implement how to write to a file or a socket — just focus on **how the text should be transformed**.

---

### 🎯 In short:
> **`FilterWriter` gives you a simple way to change or monitor text as it's being written — without touching the actual destination.**

