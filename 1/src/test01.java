import java.io.*;

public class test01 {
    public static void main(String[] args) {
        File srcFile = new File("E:\\java learn\\test");
        File destFile = new File("C:\\");
        copyDir(srcFile,destFile);
    }

    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()){
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                in = new FileInputStream(srcFile);
                //System.out.println(destFile.getAbsolutePath());
                String path  =destFile.getAbsolutePath() + srcFile.getAbsolutePath().substring(3);
              /*  String path = destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\"
                        + srcFile.getAbsolutePath().substring(3);*/
                out = new FileOutputStream(path);
                byte[] bytes  = new  byte[1024*1024];
                int readCount =0;
                while ((readCount = in.read(bytes) )!= -1){
                    out.write(bytes,0,readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(out != null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            return;

        }
        File[] files =  srcFile.listFiles();
        for(File file : files){
            //System.out.println(file.getAbsolutePath());
            if(file.isDirectory()){
                String srcDir  = file.getAbsolutePath();
                String destDir = destFile.getAbsolutePath() + srcDir.substring(3);
                /*String destDir = destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\"
                        + srcDir.substring(3);*/
                System.out.println(destDir);
                File newFile = new File(destDir);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }
            }
            copyDir(file,destFile);
        }
    }
}
