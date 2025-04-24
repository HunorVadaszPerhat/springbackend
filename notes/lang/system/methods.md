## 🔧 1. **Standard Input/Output/Error Streams**
Used for console-based I/O, debugging, or redirection.

| Method | Description |
|--------|-------------|
| `System.in` | Standard input stream (typically keyboard input). |
| `System.out` | Standard output stream (typically the console). |
| `System.err` | Standard error stream (for error messages). |
| `setIn(InputStream in)` | Redirects standard input stream. |
| `setOut(PrintStream out)` | Redirects standard output stream. |
| `setErr(PrintStream err)` | Redirects standard error stream. |

---

## 🕰️ 2. **Time and Performance**
Used to measure time for performance monitoring and logging.

| Method | Description |
|--------|-------------|
| `currentTimeMillis()` | Returns the current time in milliseconds since epoch. |
| `nanoTime()` | High-resolution time for measuring elapsed time (not wall-clock). |

---

## 🧪 3. **System Properties**
Used for configuration and environment-dependent behavior.

| Method | Description |
|--------|-------------|
| `getProperty(String key)` | Retrieves a system property by key. |
| `getProperty(String key, String defaultValue)` | Gets property or default if not found. |
| `setProperty(String key, String value)` | Sets a system property. |
| `clearProperty(String key)` | Removes a property from the system properties. |
| `getProperties()` | Returns all system properties as a `Properties` object. |

---

## 🌍 4. **Environment Variables**
For accessing OS-level configuration (note: read-only in Java).

| Method | Description |
|--------|-------------|
| `getenv(String name)` | Retrieves the value of the specified environment variable. |
| `getenv()` | Returns a map of all environment variables. |

---

## 🚪 5. **System Exit & Termination**
For shutting down the JVM, useful in scripts or CLI tools.

| Method | Description |
|--------|-------------|
| `exit(int status)` | Terminates the JVM with a given status code. |
| `halt(int status)` | Forces the JVM to stop immediately, bypassing shutdown hooks. |

---

## 🧹 6. **Memory and Garbage Collection**
Not generally needed in enterprise apps, but useful for tuning/testing.

| Method | Description |
|--------|-------------|
| `gc()` | Suggests that the JVM performs garbage collection. |
| `runFinalization()` | Runs finalizers on objects pending finalization. |

---

## 🧵 7. **Security & Access Control**
Used to interact with the security manager (mostly deprecated as of Java 17+).

| Method | Description |
|--------|-------------|
| `getSecurityManager()` | Returns the current security manager. *(Deprecated)* |
| `setSecurityManager(SecurityManager s)` | Sets the security manager. *(Deprecated)* |

---

## 🔌 8. **System Loaders and Native Interfaces**
Used for advanced native or modular development.

| Method | Description |
|--------|-------------|
| `load(String filename)` | Loads a native library by file name (absolute path). |
| `loadLibrary(String libname)` | Loads a native library by name from library path. |
| `mapLibraryName(String libname)` | Maps a library name to a platform-specific name. |
| `getLogger(String name)` | Returns a system logger for the given name. |

---

## 🧵 9. **Modules and Boot Layer (Java 9+)**
Introduced in Java 9 to support the module system.

| Method | Description |
|--------|-------------|
| `Logger getLogger(String name, ResourceBundle bundle)` | Returns a logger using a specific resource bundle. |
| `Logger getLogger(String name)` | Returns a system logger (since Java 9). |

---

## 🔄 10. **Internal and Advanced Use**
Use with caution; typically for advanced diagnostics or internal libraries.

| Method | Description |
|--------|-------------|
| `arraycopy(Object src, int srcPos, Object dest, int destPos, int length)` | Copies elements from one array to another. |
| `setSecurityManager(SecurityManager s)` | Controls permissions. *(Deprecated in modern Java)* |

---

### 🧠 Best Practices for Enterprise Use
- Use **system properties** for application configuration.
- Prefer **logging frameworks** over `System.out/err` in production.
- Only use `exit()` in CLI utilities, not in web or enterprise apps.
- Access **environment variables** for externalized configurations.
- Use `arraycopy()` for performance-optimized array handling.
- Avoid deprecated or security-sensitive methods in modern applications.

