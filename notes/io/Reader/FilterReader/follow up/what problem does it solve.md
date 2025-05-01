In simple terms, **`FilterReader` solves the problem of customizing how text is read from a source** — like a file or a network connection — **without rewriting everything from scratch**.

### 🧩 The Problem Before `FilterReader`:
Imagine you're reading a big document and want to:
- Remove certain words (like profanity),
- Convert all text to uppercase,
- Count the number of lines,
- Or strip out HTML tags...

You could read the file manually, character by character, and add all your filtering logic right there. But that quickly becomes messy and repetitive — especially if you're working with multiple types of input (files, sockets, strings).

### ✅ What `FilterReader` Solves:
`FilterReader` lets you **wrap an existing reader** (like `FileReader`, `StringReader`, etc.) and **add your own custom behavior** on top — like cleaning, transforming, or tracking the text as it's being read.

It's like putting a smart "filter" or lens over your book: you still read the same book, but through your lens, certain words disappear, change color, or get counted.

So in short:

> **FilterReader solves the problem of customizing text input in a clean, reusable way, without needing to rebuild or duplicate reader logic.**