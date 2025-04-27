package sandbox.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // Prepare some file and directory objects
        File file = new File("demo.txt");
        File dir = new File("demoDir");
        File nestedDirs = new File("demoDir/nested/inner");

        // --- 📄 File and Directory Creation ---
        file.createNewFile();
        dir.mkdir();
        nestedDirs.mkdirs();
        File temp1 = File.createTempFile("temp", ".txt");
        File temp2 = File.createTempFile("temp", ".log", dir);

        // --- 📂 File Path and Name Handling ---
        System.out.println("getName: " + file.getName());
        System.out.println("getPath: " + file.getPath());
        System.out.println("getAbsolutePath: " + file.getAbsolutePath());
        System.out.println("getAbsoluteFile: " + file.getAbsoluteFile());
        System.out.println("getCanonicalPath: " + file.getCanonicalPath());
        System.out.println("getCanonicalFile: " + file.getCanonicalFile());
        System.out.println("getParent: " + file.getParent());
        System.out.println("getParentFile: " + file.getParentFile());

        // --- 🔍 File Information and Attributes ---
        System.out.println("exists: " + file.exists());
        System.out.println("isDirectory: " + dir.isDirectory());
        System.out.println("isFile: " + file.isFile());
        System.out.println("isHidden: " + file.isHidden());
        System.out.println("length: " + file.length());
        System.out.println("lastModified: " + file.lastModified());
        System.out.println("canRead: " + file.canRead());
        System.out.println("canWrite: " + file.canWrite());
        System.out.println("canExecute: " + file.canExecute());

        file.setReadable(false, false);
        file.setWritable(true);
        file.setExecutable(true, true);
        file.setLastModified(System.currentTimeMillis());
        file.setReadOnly();

        System.out.println("getTotalSpace: " + file.getTotalSpace());
        System.out.println("getFreeSpace: " + file.getFreeSpace());
        System.out.println("getUsableSpace: " + file.getUsableSpace());

        // --- 📋 Directory Listing ---
        System.out.println("list: " + Arrays.toString(dir.list()));
        System.out.println("listFiles: " + Arrays.toString(dir.listFiles()));
        System.out.println("list(FilenameFilter): " + Arrays.toString(
                dir.list((d, name) -> name.endsWith(".log"))
        ));
        System.out.println("listFiles(FileFilter): " + Arrays.toString(
                dir.listFiles(File::isFile)
        ));

        // --- 🔄 File Manipulation ---
        File renamedFile = new File("renamed_demo.txt");
        file.renameTo(renamedFile);

        // --- 🗑️ File and Directory Deletion ---
        temp1.delete();
        temp2.deleteOnExit();  // Will be deleted on JVM exit
        renamedFile.delete();
        nestedDirs.delete();
        dir.delete();

        // --- 🔗 Conversion and Interoperability ---
        System.out.println("toURI: " + renamedFile.toURI());
        // System.out.println("toURL (Deprecated): " + renamedFile.toURL());
        System.out.println("toPath: " + renamedFile.toPath());

        // --- ⚖️ Comparison and Hashing ---
        File anotherFile = new File("renamed_demo.txt");
        System.out.println("compareTo: " + renamedFile.compareTo(anotherFile));
        System.out.println("equals: " + renamedFile.equals(anotherFile));
        System.out.println("hashCode: " + renamedFile.hashCode());

        // --- 🧪 Testing and Validation ---
        System.out.println("isAbsolute: " + file.isAbsolute());
    }
}
