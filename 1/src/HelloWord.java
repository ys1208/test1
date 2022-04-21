import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloWord {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\2.txt");
            byte[] bytes = new  byte[4];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1){
                System.out.println(new String(bytes, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
