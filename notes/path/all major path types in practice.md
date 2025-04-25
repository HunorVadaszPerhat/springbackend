Great choice! Let’s create a **simple, plain Java project** that demonstrates **all major path types** in practice — including:

- Absolute path
- Relative path
- Canonical path
- Symbolic link (if present)
- Classpath-relative resource path
- URI-based path

---

## ✅ Project Structure (Simple & Clear)

```
PathDemoProject/
├── resources/
│   └── io/
│       └── input.txt
├── src/
│   └── PathDemo.java
```

---

## 📄 `resources/io/input.txt`

Content:
```txt
Hello from input.txt
```

---

## 📄 `PathDemo.java`

```java
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;

public class PathDemo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("=== Java Path Demo ===\n");

        // 1. Absolute Path
        File absoluteFile = new File("resources/io/input.txt").getAbsoluteFile();
        System.out.println("1. Absolute Path: " + absoluteFile.getPath());

        // 2. Relative Path (from working dir)
        File relativeFile = new File("resources/io/input.txt");
        System.out.println("2. Relative Path: " + relativeFile.getPath());

        // 3. Canonical Path (resolves symlinks, dots)
        File canonicalFile = relativeFile.getCanonicalFile();
        System.out.println("3. Canonical Path: " + canonicalFile.getPath());

        // 4. Symbolic Link (only works if symlink is created manually)
        Path realPath = Paths.get("resources/io/input.txt").toRealPath(); // resolves symlink if any
        System.out.println("4. Resolved Real Path (handles symbolic links): " + realPath);

        // 5. Classpath Resource Path (loaded via ClassLoader)
        InputStream classpathStream = PathDemo.class
                .getClassLoader()
                .getResourceAsStream("io/input.txt");

        if (classpathStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(classpathStream));
            String line = reader.readLine();
            System.out.println("5. Classpath Resource Loaded: " + line);
        } else {
            System.out.println("5. Classpath Resource NOT FOUND. Check resource folder setup.");
        }

        // 6. URI-Based Path (works only if resource is not inside a JAR)
        URL resourceUrl = PathDemo.class.getClassLoader().getResource("io/input.txt");
        if (resourceUrl != null) {
            URI uri = resourceUrl.toURI();
            Path pathFromUri = Paths.get(uri);
            System.out.println("6. URI Path to resource: " + pathFromUri);
        } else {
            System.out.println("6. URI Path not available. Resource missing?");
        }
    }
}
```

---

## ▶️ How to Run It

### 1. Compile

```bash
javac -d out src/PathDemo.java
```

### 2. Copy resources

```bash
cp -r resources/* out/
```

### 3. Run

```bash
java -cp out PathDemo
```

---

## 🔎 Output Example

```
=== Java Path Demo ===

1. Absolute Path: /Users/you/PathDemoProject/resources/io/input.txt
2. Relative Path: resources/io/input.txt
3. Canonical Path: /Users/you/PathDemoProject/resources/io/input.txt
4. Resolved Real Path (handles symbolic links): /Users/you/PathDemoProject/resources/io/input.txt
5. Classpath Resource Loaded: Hello from input.txt
6. URI Path to resource: /Users/you/PathDemoProject/out/io/input.txt
```

---

## 🧠 Pro Tip: Creating a Symlink for Demo (Optional)

If you want to test symbolic path resolution:

```bash
ln -s resources/io/input.txt resources/symlink.txt
```

Then change:
```java
Path realPath = Paths.get("resources/symlink.txt").toRealPath();
System.out.println("Resolved from symlink: " + realPath);
```

---

## ✅ Summary of Concepts Demonstrated

| Path Type       | Key API Used                     | Notes |
|-----------------|----------------------------------|-------|
| Absolute Path   | `new File(...).getAbsoluteFile()`| From root of filesystem |
| Relative Path   | `new File(...)`                  | From current working directory |
| Canonical Path  | `file.getCanonicalFile()`        | Resolves `.` `..`, and symlinks |
| Symbolic Path   | `Paths.get(...).toRealPath()`    | Resolves the final file |
| Classpath Path  | `getClassLoader().getResourceAsStream()` | Loads from inside classpath |
| URI Path        | `getClassLoader().getResource().toURI()` | Converts resource to a URI |

---

