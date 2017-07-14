package ph.sarai.pestlibrary;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

public class ImageStorage {

    public static String saveToSdCard(Bitmap bitmap, String filename) {

        String stored = null;

        String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String pathDir = baseDir + "/Android/data/ph.sarai.pestlibrary/images";
        File file = new File(pathDir,filename);
        if (file.exists())
            return stored;

        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            stored = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stored;
    }

    public static File getImage(String filename) {
        File mediaImage = null;
        try {
            String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
            String pathDir = baseDir + "/Android/data/ph.sarai.pestlibrary/images";
            mediaImage = new File(pathDir,filename);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mediaImage;
    }
    public static boolean checkifImageExists(String filename)
    {
        File file = ImageStorage.getImage(filename);
        if (file.exists()) {
            return true;
        }
        return false;
    }
}
