package Tela;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class Utils {
    public static void setIcon(JFrame frame){
//        ImageIcon icon = new ImageIcon(Utils.class.getResource("/Tela/imagem/AlexandriaIcon.jpeg"));
//        frame.setIconImage(icon.getImage());
          URL iconURL = Utils.class.getResource("/Tela/imagem/aleIcon.jpeg");
          if(iconURL == null){
              System.err.println("icone n encontrado");
          }else{
              ImageIcon icon = new ImageIcon(iconURL);
              frame.setIconImage(icon.getImage());
          }
    }
}
