package com.meal360.web.storageService.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.time.format.SignStyle;
import java.util.Base64;
import java.util.stream.Stream;

@Service
public class StorageService {

/*
    void init();
    String store(MultipartFile file);
    Stream<Path> loadAll();
    Path load(String filename);
    Resource loadAsResource(String filename);
    void deleteAll();
*/
    private String rootDir = "E:\\root\\meal360\\";

    private String restaurantStoreDir  = "restaurant\\";

    private String cousineStoreDir = "cousine\\";

    private String safetyMeasureDir =  "safetyCOVID\\";

    private String riderDir = "rider\\";

    private String itemDir = "item\\";

    private String couponsDir = "coupons\\";

    private String promotionsDir = "promotions\\";

    public String getPromotionsDir() {
        return promotionsDir;
    }

    public void setPromotionsDir(String promotionsDir) {
        this.promotionsDir = promotionsDir;
    }

    public String getCouponsDir() {
        return couponsDir;
    }

    public void setCouponsDir(String couponsDir) {
        this.couponsDir = couponsDir;
    }

    public String getItemDir() {
        return itemDir;
    }

    public void setItemDir(String itemDir) {
        this.itemDir = itemDir;
    }

    public String getSafetyMeasureDir() {
        return safetyMeasureDir;
    }

    public void setSafetyMeasureDir(String safetyMeasureDir) {
        this.safetyMeasureDir = safetyMeasureDir;
    }

    public String getRiderDir() {
        return riderDir;
    }

    public void setRiderDir(String riderDir) {
        this.riderDir = riderDir;
    }

    public String getCousineStoreDir() {
        return cousineStoreDir;
    }

    public void setCousineStoreDir(String cousineStoreDir) {
        this.cousineStoreDir = cousineStoreDir;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getRestaurantStoreDir() {
        return restaurantStoreDir;
    }

    public void setRestaurantStoreDir(String restaurantStoreDir) {
        this.restaurantStoreDir = restaurantStoreDir;
    }

    public boolean store(MultipartFile storeFile, String storeLocation){

        String fileLocation = rootDir + restaurantStoreDir + "\\" + storeLocation;
        File file = new File(fileLocation);
        if(!file.exists()){
            file.getParentFile().mkdirs();
        }
        try {
            storeFile.transferTo(file);

        }catch (Exception e){
            return false;
        }

        return true;
    }
/*
    public boolean storeUrl(String url, String storeLocation) {

        String binaryVal = (inputURI.split(',')[0].indexOf("base64") >= 0)?atob(inputURI.split(',')[1]):null;

        var inputMIME = inputURI.split(',')[0].split(':')[1].split(';')[0];


        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
        ImageIO.write(bufferedImage, "png", new File("img.png"));

    }*/

    public boolean downloadFileFromUri(String uri, String downloadLocation){

        if(uri == null || downloadLocation == null || uri.isEmpty() || downloadLocation.isEmpty() ){
            return false;
        }

        try {
            String[] parts = uri.split(",");
            /*
            URI uriParsed = URI.create(uri);
            ReadableByteChannel rbc = null;

            URL url = uriParsed.toURL();
            rbc = Channels.newChannel(url.openStream());
            if (rbc == null){
                return false;
            }



*/
            int offset = parts[0].indexOf("/");
            int offset2 = parts[0].indexOf(";");
            String ext= parts[0].substring(offset +1,offset2);

            if(ext == "jpeg" || ext == "png" || ext == ""){

            }else {
                return false;
            }
            BufferedImage imag2 = decodeToImage(parts[1]);
            String fileLocation =  downloadLocation;

            File file = new File(fileLocation);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            ImageIO.write(imag2, ext, file);
/*            FileOutputStream fos = new FileOutputStream(fileLocation);

            fos.getChannel().transferFrom(rbc, 0 , Long.MAX_VALUE);
            fos.close();*/

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static BufferedImage decodeToImage(String imageString){

        BufferedImage image = null;
        byte[] imageByte;
        try {
            imageByte = Base64.getDecoder().decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return image;
    }


    public String downloadImageFromUri(String uri,String downloadLocation){

        if(uri == null || downloadLocation == null || uri.isEmpty() || downloadLocation.isEmpty() ){
            System.out.println(uri);
            System.out.println(downloadLocation);
            return "0";
        }
        String fileLocation = null;

        try {
            String[] parts = uri.split(",");
            int offset = parts[0].indexOf("/");
            int offset2 = parts[0].indexOf(";");
            String ext = parts[0].substring(offset + 1, offset2);

            if (ext.equals("jpeg")|| ext.equals("png") || ext.equals("jpg")) {

            } else {
                return "0";
            }
            BufferedImage imag2 = decodeToImage(parts[1]);
            String generatedString = getAlphaNumericString(20);
            fileLocation =  downloadLocation +"\\" + generatedString +"." + ext;

            File file = new File(fileLocation);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            ImageIO.write(imag2, ext, file);
        }catch (Exception e){

            e.printStackTrace();
            return "0";
        }


        return fileLocation;
    }


    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
