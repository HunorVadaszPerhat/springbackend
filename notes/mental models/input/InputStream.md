
---

### **Class: `java.io.InputStream`**

(An abstract class for reading raw byte input.)

---

## **1. INPUT: What does it take in?**

* **Data type:** Raw **byte data**

* **Source:**

    * Files (via `FileInputStream`)
    * Memory (`ByteArrayInputStream`)
    * Network (`Socket.getInputStream()`)
    * Any custom stream subclass

* **Who provides input?**
  The underlying data source (file, buffer, socket, etc.)

* **Accepts input through:**

    * **Method calls:** like `read()` — you initiate the request to read from it
    * **Constructors of subclasses**, which take input sources (e.g., a `File` or `byte[]`)

---

## **2. ACTION: What does it do?**

* **Responsibility:**
  To **read raw byte data**, one byte or an array of bytes at a time
* **Type:**

    * **Abstract class** (must be subclassed to use directly)
    * Can act as a **base**, **wrapper**, or **decorator**
* **Core behavior:**

    * Reads one or more bytes
    * May **buffer**, **skip**, or **check availability**
* **Delegates to subclasses** like:

    * `FileInputStream`, `BufferedInputStream`, `ByteArrayInputStream`
* **Other behavior:**

    * Manages stream lifecycle (open/close)
    * May block if input isn’t available (e.g., reading from a network socket)

---

## **3. OUTPUT: What does it produce?**

* **Return values:**

    * `int` (for a single byte or number of bytes read)
    * `-1` indicates **end of stream**
* **Side effects:**

    * Pulls in data from external sources (files, sockets)
    * May **throw IOException**
* **No formatted output** (like strings or objects)—just raw **byte arrays**

---

## **Summary of InputStream under your model:**

| Phase      | Detail                                                                        |
| ---------- | ----------------------------------------------------------------------------- |
| **Input**  | Byte data source (file, socket, buffer)                                       |
| **Action** | Abstract reading of raw bytes; subclasses implement actual source handling    |
| **Output** | Bytes read into `int`/`byte[]`; side effects include IO, blocking, exceptions |

---

