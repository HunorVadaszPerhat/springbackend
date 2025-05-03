
---

### ✅ `java.io.InputStream` – abstract base class for reading bytes

* **`ByteArrayInputStream`** – reads bytes from a `byte[]` (internal buffer in memory; not resizable)
* **`FileInputStream`** – reads bytes from a file on the file system
* **`FilterInputStream`** – abstract wrapper class for filtering `InputStream`s

    * **`BufferedInputStream`** – adds internal buffering for efficient byte reading
    * **`DataInputStream`** – reads Java primitive data types (e.g. `int`, `double`) from an underlying stream
    * **`LineNumberInputStream`** – ❌ **Deprecated** – used to track line numbers while reading
    * **`PushbackInputStream`** – allows bytes to be "unread" (pushed back) into the stream
* **`ObjectInputStream`** – deserializes Java objects from a stream
* **`PipedInputStream`** – reads bytes from a connected `PipedOutputStream`, typically written to by another thread
* **`SequenceInputStream`** – reads from multiple `InputStream`s sequentially, as if they were one
* **`StringBufferInputStream`** – ❌ **Deprecated** – reads bytes from a `String`

---

### ✅ `java.io.OutputStream` – abstract base class for writing bytes

* **`ByteArrayOutputStream`** – writes bytes into a `byte[]` (internal resizable buffer in memory)
* **`FileOutputStream`** – writes bytes to a file on the file system
* **`FilterOutputStream`** – abstract wrapper class for filtering `OutputStream`s

    * **`BufferedOutputStream`** – adds internal buffering for efficient byte writing
    * **`DataOutputStream`** – writes Java primitive data types to an underlying stream
    * **`PrintStream`** – writes formatted or raw text as bytes (e.g. `System.out`)
* **`ObjectOutputStream`** – serializes Java objects to a stream
* **`PipedOutputStream`** – writes bytes to a connected `PipedInputStream`, typically read by another thread

---

### ✅ `java.io.Reader` – abstract base class for reading characters

* **`BufferedReader`** – adds buffering for efficient character reading

    * **`LineNumberReader`** – extends `BufferedReader`; tracks line numbers while reading
* **`CharArrayReader`** – reads characters from a `char[]` (internal buffer in memory; not resizable)
* **`FilterReader`** – abstract wrapper class for filtering `Reader`s

    * **`PushbackReader`** – allows characters to be "unread" (pushed back) into the stream
* **`InputStreamReader`** – converts a byte `InputStream` into a character stream using a character encoding

    * **`FileReader`** – reads characters from a file using the platform's default encoding
* **`PipedReader`** – reads characters from a connected `PipedWriter`, typically written to by another thread
* **`StringReader`** – reads characters from a `String` (backed by an internal buffer)

---

### ✅ `java.io.Writer` – abstract base class for writing characters

* **`BufferedWriter`** – adds buffering for efficient character writing
* **`CharArrayWriter`** – writes characters to an internal resizable `char[]` buffer in memory
* **`FilterWriter`** – abstract wrapper class for filtering `Writer`s
* **`OutputStreamWriter`** – converts characters into bytes and writes them to an `OutputStream` using a character encoding

    * **`FileWriter`** – writes characters to a file using the platform’s default encoding
* **`PrintWriter`** – writes formatted or raw text data to a `Writer` or `OutputStream` (with optional auto-flush)
* **`PipedWriter`** – writes characters to a connected `PipedReader`, typically read by another thread

---

