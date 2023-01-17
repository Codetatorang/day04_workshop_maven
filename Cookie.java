package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {
    String dirPath = "C:\\Users\\vince\\Root\\day04_workshop\\CookieFolder";
    String fileName = "Cookie.txt";

    List<String> cookieItems = null;

    public void readCookieFile() throws FileNotFoundException {
        cookieItems = new ArrayList<String>();
        File file = new File(dirPath + File.separator + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String readString;
        try {
            while ((readString = br.readLine()) != null) {
                cookieItems.add(readString);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String returnCookie(){
        Random rand = new Random();

        if(cookieItems!=null){
            return cookieItems.get(rand.nextInt(cookieItems.size()));
        }else{
            return "There is no cookies found";
        }
    }

    public void showCookies(){
        if(cookieItems != null){
            cookieItems.forEach((ci)->System.out.println(ci));
        }else{
        }
    }
}
