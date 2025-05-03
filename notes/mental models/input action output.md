### **1. INPUT: What goes in?**

Ask:

* **What type of data** does it accept? (primitive, object, stream, file, etc.)
* **Where does the data come from?** (user, file system, network, memory)
* Is it:

    * **Binary or text?**
    * **Structured (JSON, XML) or raw?**
    * **Mutable or immutable?**
* **Who provides the input?** (Caller, OS, user)
* Does it accept input via:

    * **Constructor?**
    * **Method parameters?**
    * **Stream or callback?**

---

### **2. ACTION (What it does):**

Ask:

* What is the **core responsibility**?

    * Read, write, transform, encode, calculate, route, etc.
* Is it a **wrapper**, **adapter**, **abstract class**, or **concrete class**?

    * Does it delegate work to another class?
* Is the logic:

    * **Synchronous or asynchronous?**
    * **Stateless or stateful?**
* Does it handle:

    * **Error checking?**
    * **Conversion?**
    * **Buffering or caching?**

---

### **3. OUTPUT: What comes out?**

Ask:

* What **type** is returned? (primitive, object, stream, side effect)
* Is the output:

    * A **return value**?
    * A **state change**?
    * A **file written**?
    * A **message sent**?
* Is there a **side effect**?

    * Writes to console, file, network, DB
    * Throws exception, logs, mutates state
* Is the output used **immediately**, or stored for later?

---

