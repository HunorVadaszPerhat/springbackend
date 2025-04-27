---

### 💡 What Problem Does `PipedInputStream` Solve?

`PipedInputStream` solves the problem of **letting two different threads in the same program pass data to each other safely and easily** — **without using complicated shared memory** or manual locking.

**Imagine it like this**:
- One thread wants to **produce** data (like writing messages).
- Another thread wants to **consume** that data (like reading those messages).
- Instead of fighting over a shared list or buffer, they just use a "pipe" — one end writes, the other end reads — just like passing water through a hose.

✅ **It makes communication between threads simple and organized**.  
✅ **It automatically waits** if there’s nothing to read or no space to write, so the threads stay in sync naturally.  
✅ **It hides all the messy "thread safety" problems** behind an easy-to-use InputStream/OutputStream interface.

---

**One-sentence summary**:
> `PipedInputStream` makes it easy for two threads to hand off data to each other safely, like pouring water from one bucket into another through a pipe — without leaks or spills.

---