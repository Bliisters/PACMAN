package view;

//On importe tout ce qui va être utile pour la classe.
import  java.io.*;
import javax.sound.sampled.*;
 

//////////////////////////////////////////////////////////////////////
//																	//
//							AUDIO									//
//																	//
//////////////////////////////////////////////////////////////////////



public class Theme extends Thread{
     
	
    AudioInputStream audioInputStream = null;
    SourceDataLine line;
    
    
    public void run(){
        File fichier = new File("music/themeGAME.wav");
        /*try {
        AudioFileFormat format = AudioSystem.getAudioFileFormat(fichier);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/
         
        try {
            audioInputStream = AudioSystem.getAudioInputStream(fichier);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
         AudioFormat audioFormat = audioInputStream.getFormat();
         DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);
          
         try {
             line = (SourceDataLine) AudioSystem.getLine(info);
                        
             } catch (LineUnavailableException e) {
               e.printStackTrace();
               return;
             }
          
        try {
                line.open(audioFormat);
        } catch (LineUnavailableException e) {
                    e.printStackTrace();
                    return;
        }
        line.start();
        
        try {
            byte bytes[] = new byte[1024];
            int bytesRead=0;
            while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) {
                 line.write(bytes, 0, bytesRead);
                }
        } catch (IOException io) {
            io.printStackTrace();
            return;
        }
    }
}