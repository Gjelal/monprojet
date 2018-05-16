import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class CentLivres {

  public static void main (String[] args) throws IOException{
    CentLivresDao.chargerLivres();
    Frame frm = FrameLivre.getFrame();
    frm.setVisible(true);
    } // main

} // CentLivres
