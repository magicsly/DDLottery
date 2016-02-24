package com.ddlottery.tools;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sun.jimi.core.raster.JimiRasterImage;
import com.sun.jimi.core.Jimi;
/**
 * Created by ElNino on 16/1/28.
 */
public class uploadFiles {

    public Map upload(MultipartFile file, HttpServletRequest request) {
        String fname = file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("image");
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String fileName = sdf.format(date);
        File targetFile = new File(path, fileName+".jpg");

        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            byte[] byteFile = this.getBytes(path+"/"+fileName+".jpg");
            byte[] normalFile = this.resizeImage(byteFile,3000);
            byte[] smallFile = this.resizeImage(byteFile,500);
            this.getFile(normalFile,path+"/",fileName+"_normal.jpg");
            this.getFile(smallFile,path+"/",fileName+"_small.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("filename","/image/"+fileName+".jpg");
        map.put("normalfile","/image/"+fileName+"_normal.jpg");
        map.put("smallfile","/image/"+fileName+"_small.jpg");
        map.put("fname",fname);
        return map;
    }

    public static byte[] getBytes(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    //根据byte数组，生成文件
    public static void getFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static byte[] resizeImage(byte[] in,int maxDim)
    {
        try
        {
            Image inImage=Toolkit.getDefaultToolkit().createImage(in);
            ImageIcon inImageIcon = new ImageIcon(in);

            int imh = inImageIcon.getIconHeight();
            int imw = inImageIcon.getIconWidth();
            double scale;
            if( imh <= maxDim && imw <= maxDim )
                scale = 1;
            else if( imh > imw )
                scale = (double) maxDim / (double) imh;
            else
                scale = (double) maxDim / (double) imw;

            int scaledW = (int) (scale * imw);
            int scaledH = (int) (scale * imh);

            Image img = inImage.getScaledInstance(scaledW, scaledH, Image.SCALE_FAST);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            JimiRasterImage raster = Jimi.createRasterImage(img.getSource());
            // --java.io.ByteArrayOutputStream
            Jimi.putImage("image/jpeg", raster, outStream);
            outStream.flush();
            outStream.close();
            return outStream.toByteArray();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
