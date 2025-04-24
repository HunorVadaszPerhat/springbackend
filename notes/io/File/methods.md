## 📂 File Path and Name Handling

These methods deal with the file's path and name:

- `getName()`:Returns the name of the file or directory
- `getPath()`:Returns the pathname string
- `getAbsolutePath()`:Returns the absolute pathname string
- `getAbsoluteFile()`:Returns the absolute form as a `File` object
- `getCanonicalPath()`:Returns the canonical pathname string, resolving any relative paths and symbolic links
- `getCanonicalFile()`:Returns the canonical form as a `File` object
- `getParent()`:Returns the pathname string of the parent directory
- `getParentFile()`:Returns the parent directory as a `File` object

---

## 📄 File and Directory Creation

Methods for creating files and directories:

- `createNewFile()` Creates a new, empty file if it does not exis.
- `mkdir()` Creates a single director.
- `mkdirs()` Creates the directory, including any necessary but nonexistent parent directorie.
- `createTempFile(String prefix, String suffix)` Creates a temporary file in the default temporary-file director.
- `createTempFile(String prefix, String suffix, File directory)` Creates a temporary file in the specified director.

---

## 🗑️ File and Directory Deletion

Methods for deleting files and directories:

- `delete()`*: Deletes the file or directoy.
- `deleteOnExit()`*: Requests that the file or directory be deleted when the JVM terminats.

---

## 🔍 File Information and Attributes

Methods to retrieve information about the file or directory:

- `exists()`*: Tests whether the file or directory exits.
- `isDirectory()`*: Tests whether the file is a directry.
- `isFile()`*: Tests whether the file is a normal fle.
- `isHidden()`*: Tests whether the file is hiden.
- `length()`*: Returns the length of the file in byes.
- `lastModified()`*: Returns the time the file was last modifed.
- `canRead()`*: Tests whether the application can read the fle.
- `canWrite()`*: Tests whether the application can modify the fle.
- `canExecute()`*: Tests whether the application can execute the fle.
- `setReadable(boolean readable)`*: Sets the owner's read permisson.
- `setReadable(boolean readable, boolean ownerOnly)`*: Sets the read permission for the owner or everyne.
- `setWritable(boolean writable)`*: Sets the owner's write permisson.
- `setWritable(boolean writable, boolean ownerOnly)`*: Sets the write permission for the owner or everyne.
- `setExecutable(boolean executable)`*: Sets the owner's execute permisson.
- `setExecutable(boolean executable, boolean ownerOnly)`*: Sets the execute permission for the owner or everyne.
- `setLastModified(long time)`*: Sets the last-modified time of the fle.
- `setReadOnly()`*: Marks the file or directory as read-oly.
- `getTotalSpace()`*: Returns the size of the partition named by this abstract pathnme.
- `getFreeSpace()`*: Returns the number of unallocated bytes in the partiton.
- `getUsableSpace()`*: Returns the number of bytes available to this virtual machine on the partiton.

---

## 📋 Directory Listing

Methods for listing the contents of directories:

- `list(): Returns an array of strings naming the files and directories in the direcory.
- `list(FilenameFilter filter): Returns an array of strings naming the files and directories that satisfy the specified fiter.
- `listFiles(): Returns an array of abstract pathnames denoting the files in the direcory.
- `listFiles(FileFilter filter): Returns an array of abstract pathnames denoting the files and directories that satisfy the specified fiter.
- `listFiles(FilenameFilter filter): Returns an array of abstract pathnames denoting the files and directories that satisfy the specified fiter.

---

## 🔄 File Manipulation

Methods for manipulating files:

- `renameTo(File dest`: Renames the file or diretory.

---

## 🔗 Conversion and Interoperability

Methods for converting to other types:

- `toURI)`: Constructs a file: URI that represents this abstract pahname.
- `toURL)`: Deprecated. Constructs a file: URL that represents this abstract pahname.
- `toPath)`: Returns a `Path` object constructed from this abstrac path.

---

## ⚖️ Comparison and Hashing

Methods for comparing and hashing:

- `compareTo(File pathnam)`: Compares two abstract pathnames lexicographcally.
- `equals(Object ob)`: Tests this abstract pathname for equality with the given bject.
- `hashCode)`: Computes a hash code for this abstract pahname.

---

## 🧪 Testing and Validation

Methods for testing and validation:

- `isAbsolut()`: Tests whether this abstract pathname is asolute.

---
