package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import static Main.Game.GAME_HEIGHT;
import static Main.Game.GAME_WIDTH;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static Utilz.Constants.PlayerConstants.*;
import static Utilz.Constants.Directions.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private Game game;
//    private float xDelta = 100, yDelta = 100;

    public GamePanel(Game game){
        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


    public void updateGame(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); //calling super component

        game.render(g);
    }

    private void setPanelSize(){
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
    }

    public Game getGame(){
        return  game;
    }
}
