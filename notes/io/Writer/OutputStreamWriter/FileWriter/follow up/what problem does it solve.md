In simple terms, **`FileWriter` solves the problem of writing text to a file**.

Before `FileWriter`, if you wanted to save something like `"Hello, world!"` to a file in Java, you had to deal with lower-level tools that only handled **bytes**, not characters or strings. This meant you had to do extra work to convert your readable text into a format the computer could write — and that was error-prone and confusing, especially for beginners.

So `FileWriter` was created to:
- Let developers write **plain text** (like strings and characters) directly to a file.
- Hide the complexity of converting characters into bytes.
- Make file writing **easier, quicker, and more readable**.

### Example:
Instead of doing this:
```java
OutputStream out = new FileOutputStream("data.txt");
out.write("Hello".getBytes());
```

You could now do:
```java
FileWriter fw = new FileWriter("data.txt");
fw.write("Hello");
fw.close();
```

It made saving text as simple as printing it — and that was a big step for Java at the time.

