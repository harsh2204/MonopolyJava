/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolyalpha;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

/**
 *
 * @author Harsh
 */
public class MusicPlayer {

    static Player player;
    static String filename = "Sounds/songlul.mp3";
    static AdvancedPlayer ply;

    public static void play() {

        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
//            player = new Player(bis);
            ply = new AdvancedPlayer(bis);
            ply.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackFinished(PlaybackEvent event){
                    try{
                    ply.play();                        
                    }catch(JavaLayerException e){
                        System.out.println("Error replaying file: "+ e);
                    }
                }
});
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }
        new Thread() {
            public void run() {
                try {
//                    player.play();
                    ply.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }
}
