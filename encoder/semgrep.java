import java.io.*;

public class InsecureDeserialization {
    public static void main(String[] args) {
        try {
            // Serialize an object
            String filename = "testfile.ser";
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(new TestClass("test"));
            out.close();
            file.close();

            // Deserialize the object (insecure deserialization)
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            TestClass obj = (TestClass) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Deserialized object: " + obj.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class TestClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public TestClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}