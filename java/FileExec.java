import java.io.File;

public class FileExec {
    private static final String BASE_URL = "C:\\Users\\Administrator\\Desktop\\regudata";
    private static final String META_INF_URL = BASE_URL + "\\META-INF";
    private static final String WEB_INF_URL = BASE_URL + "\\WEB-INF";
    private static final String CLASSES_URL = WEB_INF_URL + "\\classes";
    private static final String CONFIG_URL = CLASSES_URL + "\\config";
    public static void main(String[] args){
        File file = new File(BASE_URL);
        itFile(file);
    }

    private static void itFile(File file){
        if (!file.exists()){
            return;
        }
        File[] files = file.listFiles();
        if (files == null || files.length == 0){
            return;
        }
        for (File temp : files) {
            if (temp.isDirectory() && temp.listFiles().length > 0){
                itFile(temp);
            }
            //删除meta-inf文件夹下文件
            if (temp.getAbsolutePath().contains(META_INF_URL)){
                deleteFile(temp);
                System.out.println(4);
            }
            //删除web-inf文件夹下文件
            if (temp.getAbsolutePath().contains(WEB_INF_URL) && !temp.getAbsolutePath().contains(CLASSES_URL)){
                if (WEB_INF_URL.equals(temp.getAbsolutePath())){
                    continue;
                }
                deleteFile(temp);
            }
            //删除classes文件夹下文件
            if (CLASSES_URL.equals(temp.getParent()) && !temp.isDirectory()){
                deleteFile(temp);
            }
            //删除config文件夹下文件
            if (temp.getAbsolutePath().contains(CONFIG_URL)){
                deleteFile(temp);
            }
        }
    }
    private static void deleteFile (File file) {
        if (!file.exists()){
            System.out.println("文件或文件夹不存在 : " + file.getAbsolutePath());
            return;
        }
        if (file.isDirectory() && file.listFiles().length > 0){
            System.out.println("文件夹不为空 : " + file.getAbsolutePath());
            return;
        }
        StringBuilder massage = new StringBuilder();
        massage.append("删除");
        if (file.isDirectory()){
            massage.append("文件夹");
        } else{
            massage.append("文件");
        }
        boolean b = file.delete();
        if (!b){
            System.out.println(massage.append("失败：").toString() + file.getAbsolutePath());
        } else{
            System.out.println(massage.append("成功：").toString() + file.getAbsolutePath());
        }
    }
}
