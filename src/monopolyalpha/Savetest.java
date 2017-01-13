/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Harsh
 */

public class Savetest {
    public static void Save(String filename){
        Save_Data save = new Save_Data();
        XStream xstream = new XStream(new DomDriver());
        String xml = xstream.toXML(save);
//        System.out.println(xml);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Saves".concat(filename.concat(".xml")));
            fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8")); //write XML header, as XStream doesn't do that for us
            byte[] bytes = xml.getBytes("UTF-8");
            fos.write(bytes);

        } catch (Exception e) {
            e.printStackTrace(); // this obviously needs to be refined.
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace(); // this obviously needs to be refined.
                }
            }
        }
    }    
    public static void Load(String filename){
        XStream xstream = new XStream(new DomDriver());
        Save_Data save = (Save_Data)xstream.fromXML(new File(filename));
        Board board;
        Board.theme = save.theme;
        Board.players = save.players;
        Board.dice = save.dice;
        Board.chance = save.chance;
        Board.roll = save.roll;
        Board.turn = save.turn;
        Board.count = save.count;
        Board.EGS = save.EGS;
        Board.counter = save.counter;
        Board.numprop = save.numprop;
        Board.cpos = save.cpos;
        Board.bonus = save.bonus;
        Board.jailfee = save.jailfee;
        Board.propOwner = save.propOwner;
        Board.plChances = save.plChances;
        Board.plChancesLeft = save.plChancesLeft;
        Board.propMoney = save.propMoney;
        Board.totMoney = save.totMoney;
        Board.propHouse = save.propHouse;
        Board.money = save.money;
        Board.name = save.name;
        for (int i = 0; i < save.iconpaths.length; i++) {
            if (save.iconpaths[i] != null) {
                Board.icon[i] = new ImageIcon(save.iconpaths[i]);
            }
        }
        Board.colorPalette = save.colorPalette;
        Board.snake = save.snake;
        Board.bail = save.bail;
        Board.propOwned = save.propOwned;
        Board.propBuyable = save.propBuyable;
        Board.Game = save.Game;
        Board.housable = save.housable;
        Board.propH = save.propH;
        board = new Board(save.players, true);
        board.setVisible(true);
    }
    public static void main(String[] args) {
//        Save_Data sg = new Save_Data();
//        for (int i = 0; i < sg.names.length; i++) {
//            sg.names[i] = "Hello";
//        }
//        for (int i = 0; i < sg.props.length; i++) {
//            sg.props[i] = i + 1;
//        }       
        Board board = InitTest.board;
        XStream xstream = new XStream(new DomDriver());
        String xml = xstream.toXML(board);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SaveTry2.sav");
            fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8")); //write XML header, as XStream doesn't do that for us
            byte[] bytes = xml.getBytes("UTF-8");
            fos.write(bytes);

        } catch (Exception e) {
            e.printStackTrace(); // this obviously needs to be refined.
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace(); // this obviously needs to be refined.
                }
            }
        }
//        try {
//
//            File file = new File("src/save.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Board.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            // output pretty printed
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(board, file);
//            jaxbMarshaller.marshal(board, System.out);

//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
    }
}
