✅ **What's happening:**
- Creates a `Person`.
- Saves it to `person.ser`.
- Loads it back.
- Shows the deserialized object.

---

# 📚 Recap: Updated Classes

| Class | Purpose |
|:---|:---|
| `Person` | The simple serializable object. |
| `Serializer` | Saves objects (serialization). |
| `CustomObjectInputStream` | Extends `ObjectInputStream`, overrides `resolveClass()`. |
| `Deserializer` | Loads objects (deserialization). |
| `Main` | Ties everything together to demo save/load flow. |

---

# ✍️ **Important Notes for You**

- The `saveObject()` is necessary and kept clean ✅
- `resolveClass()` now works **correctly** inside a custom subclass ✅
- Using `available()` just to demo — it's **not 100% reliable** for knowing the full size of an object!
- Streams are **auto-closed** with try-with-resources (modern, safe coding) ✅
- `transient` field (`password`) is **not saved** (you'll see it `null` after deserialization).

---

# 🚀 Would you like a version that also adds:
- **ObjectInputFilter** (enterprise security best practice)?
- A second object (`Address`) to demonstrate **object graphs** (nested serialization)?
