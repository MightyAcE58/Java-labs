package JavaPractice;
import java.io.*;
import java.util.zip.*;

public class zipMaker {

    public static void main(String[] args) {

        String rootPath = "/Users/vinay/Downloads/skills3";

        File rootFolder = new File(rootPath);

        if (!rootFolder.exists() || !rootFolder.isDirectory()) {
            System.out.println("Invalid root folder path!");
            return;
        }

        File[] folders = rootFolder.listFiles(File::isDirectory);

        if (folders == null || folders.length == 0) {
            System.out.println("No folders found!");
            return;
        }

        for (File folder : folders) {

            String zipName = folder.getName() + ".zip";

            File zipFile = new File(rootFolder, zipName);

            try (
                    FileOutputStream fos = new FileOutputStream(zipFile);
                    ZipOutputStream zos = new ZipOutputStream(fos)
            ) {

                zipFolder(folder, folder.getName(), zos);

                System.out.println("Created: " + zipName);

            } catch (IOException e) {
                System.out.println("Error zipping " + folder.getName());
                e.printStackTrace();
            }
        }

        System.out.println("All folders processed!");
    }

    private static void zipFolder(
            File folder,
            String parentPath,
            ZipOutputStream zos
    ) throws IOException {

        File[] files = folder.listFiles();

        if (files == null) return;

        for (File file : files) {

            String entryName = parentPath + "/" + file.getName();

            if (file.isDirectory()) {

                zipFolder(file, entryName, zos);

            } else {

                try (FileInputStream fis = new FileInputStream(file)) {

                    ZipEntry entry = new ZipEntry(entryName);
                    zos.putNextEntry(entry);

                    byte[] buffer = new byte[4096];
                    int length;

                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                    }

                    zos.closeEntry();
                }
            }
        }
    }
}
