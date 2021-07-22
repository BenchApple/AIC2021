// 
// Decompiled by Procyon v0.5.36
// 

package instrumenter;

import java.io.IOException;
import java.io.FileOutputStream;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import java.io.InputStream;
import org.objectweb.asm.ClassReader;
import java.io.FileInputStream;
import java.io.File;
import java.util.HashSet;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class Main
{
    static boolean DEBUG;
    static String packageName;
    static boolean playerCode;
    static Set<String> disallowedClasses;
    static Set<String> allowedClasses;
    static HashMap<String, Integer> methodBytecode;
    static final String dirPath;
    
    public static void readDisallowedClasses() throws Exception {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("resources/DisallowedClasses.txt")));
            Main.disallowedClasses = new HashSet<String>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Main.disallowedClasses.add(line);
            }
            bufferedReader.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void readAllowedClasses() throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("resources/AllowedClasses.txt")));
        Main.allowedClasses = new HashSet<String>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Main.allowedClasses.add(line);
        }
        bufferedReader.close();
    }
    
    public static void readBytecodeCost() throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("resources/BytecodeCost.txt")));
        Main.methodBytecode = new HashMap<String, Integer>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] split = line.split("\\s+");
            Main.methodBytecode.put(split[0], Integer.parseInt(split[1]));
        }
        bufferedReader.close();
    }
    
    public static void main(final String[] array) throws Exception {
        final File file = new File(array[0]);
        Main.packageName = array[1];
        Main.playerCode = array[2].equals("true");
        readDisallowedClasses();
        readAllowedClasses();
        readBytecodeCost();
        instrument(file);
    }
    
    public static void errorDetected(final String x) {
        System.err.println(x);
        //System.exit(1); // By removing this and adjusting the disallowed classes we can hopefully allow file IO
    }
    
    private static void instrument(final File file) throws IOException {
        if (Main.DEBUG && file.listFiles() == null) {
            System.err.println("Wrong address!!!!");
        }
        for (final File file2 : file.listFiles()) {
            if (Main.DEBUG && Main.playerCode) {
                System.err.println("Instrumenting file " + file2);
            }
            if (file2.isFile()) {
                final ClassReader classReader = new ClassReader((InputStream)new FileInputStream(file2));
                final ClassWriter classWriter = new ClassWriter(1);
                classReader.accept((ClassVisitor)new ClassAdapter((ClassVisitor)classWriter), 0);
                final byte[] byteArray = classWriter.toByteArray();
                final FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(byteArray);
                fileOutputStream.close();
            }
            else if (file2.isDirectory()) {
                instrument(file2);
            }
        }
    }
    
    static {
        Main.DEBUG = false;
        Main.packageName = "DEFAULT";
        Main.playerCode = true;
        dirPath = System.getProperty("user.dir") + File.separator + "instrumenter/resources" + File.separator;
    }
}
