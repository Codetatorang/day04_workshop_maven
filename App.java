package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String dirPath = "C:\\Users\\vince\\Root\\day04_workshop\\CookieFolder";
        File newDirectory = new File(dirPath);
        // if directory exist, print directory exists.
        // else create the directory
        if (newDirectory.exists()) {
            System.out.println("directory already exists.");
        } else {
            newDirectory.mkdir();
        }

        Cookie cookie = new Cookie();
        cookie.readCookieFile();
        cookie.showCookies();

        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();

        try(InputStream is = s.getInputStream()){
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            String messageReceived = "";

            while(!messageReceived.equals("close")){
                messageReceived = dis.readUTF();

                if(messageReceived.equalsIgnoreCase("get-cookie")){
                    String cookieValue = cookie.returnCookie();
                    System.out.println(cookieValue);
                }
            }
        }catch(EOFException EX){
            s.close();
            ss.close();
        }
    }
}
