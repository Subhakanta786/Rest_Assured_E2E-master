package serializationDeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//inform that we are doing Serialization on object of Test class
class Test implements Serializable {

	int i = 10, j = 20;
}

public class SerializationAndDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Before Serialization
		long starttimebeforeserialization=System.currentTimeMillis();
		System.out.println("Before Serialization");
		Test t1 = new Test();
		System.out.println(t1.i + " " + t1.j);
		long endtimebeforeserialization=System.currentTimeMillis();
		System.out.println(endtimebeforeserialization-starttimebeforeserialization+"ms");

		// Serialization
		FileOutputStream fos = new FileOutputStream("test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(t1);

		// De-Serialization
		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// After Serialization
		long starttimeafterserialization=System.currentTimeMillis();
		System.out.println("After Serialization");
		Test t2 = (Test) ois.readObject();
		System.out.println(t2.i + " " + t2.j);
		long endtimeafterserialization=System.currentTimeMillis();
		System.out.println(endtimeafterserialization-starttimeafterserialization+"ms");
	}

}
