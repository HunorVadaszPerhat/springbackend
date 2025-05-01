In **simple terms**, `BufferedWriter` solves this problem:

> **Writing to a file or output one character at a time is slow and inefficient.**

Every time you write something without buffering, Java might have to talk directly to the disk or network — which is *very slow* compared to writing to memory.

### 🔧 What `BufferedWriter` does:
It **collects your text in memory first**, in a temporary space called a *buffer*, and only sends it out **in bigger chunks**. This is much faster and more efficient.

### 🧠 Think of it like this:
Imagine mailing a letter for every single word you write. That’s slow and expensive.  
Instead, you write an entire page and then mail it — **BufferedWriter is like that page.**

### ✅ So in short:
- It **speeds up writing** by avoiding constant small writes.
- It **reduces resource usage** (like CPU and disk access).
- It **makes your programs more efficient and smoother**, especially when writing lots of data.

