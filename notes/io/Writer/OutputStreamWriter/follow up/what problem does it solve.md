In simple terms, **`OutputStreamWriter` solves the problem of writing text to places that only understand bytes** — like files, network connections, or sockets.

Most systems (like your file system or an HTTP connection) don’t deal with letters or words — they deal with **raw bytes**. But Java programs often work with **characters** (like `'A'`, `'你'`, or `'€'`). These characters need to be **converted into bytes using a specific encoding** (like UTF-8) so they can be stored or sent correctly.

Without `OutputStreamWriter`, you’d have to do this conversion yourself, which is tricky and error-prone.

So the problem it solves is:

> **How do you take characters in your Java code and safely write them as bytes to a stream, using the correct encoding?**

`OutputStreamWriter` is the **bridge** that automatically translates characters into the right bytes and sends them to the underlying byte stream.

