# 📚 Difference between BufferedInputStream and PushbackInputStream

| Feature                   | BufferedInputStream                           | PushbackInputStream                          |
|----------------------------|-----------------------------------------------|----------------------------------------------|
| Purpose                    | **Speeds up reading** by preloading bytes into an internal buffer. | **Allows undoing** (pushing back) bytes you have already read. |
| Main Focus                 | **Performance**: fewer reads from slow sources like files, networks. | **Control/Parsing**: ability to **re-read** specific bytes manually. |
| Memory Use                 | **Big buffer** (e.g., 8 KB by default) holding upcoming bytes. | **Small pushback buffer** (usually a few bytes you push back). |
| Default Behavior           | Always fills its buffer **ahead of time** before you even ask for a byte. | Only holds **bytes you manually push back** — otherwise, acts like a normal stream. |
| How You Use It             | Transparent: you just read faster, no manual work needed. | You **explicitly call `unread(byte)`** to push bytes back into the stream. |
| Typical Use Case           | Reading files, network streams efficiently (performance). | Parsing structured formats where you might **peek ahead**, then **go back**. |
| Relationship               | Wraps an InputStream (e.g., `BufferedInputStream(new FileInputStream(...))`). | Wraps an InputStream (e.g., `PushbackInputStream(new FileInputStream(...))`). |

---

# 🎯 In Simple Words:

- **BufferedInputStream** = *"Let’s read ahead so everything feels fast."* 🚀
- **PushbackInputStream** = *"Oops, I need that byte again — let me push it back!"* 🔙

---

# 🧠 Final Mental Model:
> **BufferedInputStream = Speed optimization.**  
> **PushbackInputStream = Parsing control (mini memory for going back).**

---

✅ They **both wrap other InputStreams**, but they solve **very different problems**.

---
