package gameState;

import Main.Game;
import UI.ButtonMenu;
import Utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menus extends State implements StateMethods {

    private ButtonMenu[] buttons = new ButtonMenu[3];
    private BufferedImage backgroundImg;
    private int menuX, menuY, menuWidth, menuHeight;


    public Menus(Game game) {
        super(game);
        loadButtons();
        loadBackground();
    }

    private void loadBackground() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
        menuWidth = (int) (backgroundImg.getWidth() * Game.SCALE);
        menuHeight = (int) (backgroundImg.getHeight() * Game.SCALE);
        menuX = Game.GAME_WIDTH / 2 - menuWidth / 2;
        menuY = (int) (45 * Game.SCALE);
    }

    private void loadButtons() {
        buttons[0] = new ButtonMenu(Game.GAME_WIDTH / 2, (int) (150*Game.SCALE), 0, GameState.PLAYING);
        buttons[1] = new ButtonMenu(Game.GAME_WIDTH / 2, (int) (220*Game.SCALE), 1, GameState.OPTIONS);
        buttons[2] = new ButtonMenu(Game.GAME_WIDTH / 2, (int) (290*Game.SCALE), 2, GameState.QUIT);
    }

    @Override
    public void update() {
        for (ButtonMenu mb : buttons)
            mb.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, menuX, menuY, menuWidth, menuHeight, null);
        for (ButtonMenu mb : buttons)
            mb.draw(g);
//        g.setColor(Color.BLACK);
//        g.drawString("MENU", Game.GAME_WIDTH/2, 200);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (ButtonMenu mb : buttons){
            if (isIn(e, mb)) {
                mb.setMousePressed(true);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (ButtonMenu mb : buttons) {
            if (isIn(e, mb)){
                if (mb.isMousePressed()){
                    mb.applyGameState();
                }
                break;
            }
        }
        resetButtons();
    }

    private void resetButtons() {
        for (ButtonMenu mb : buttons){
            mb.resetBools();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (ButtonMenu mb : buttons) {
            mb.setMouseOver(false);
        }
        for (ButtonMenu mb : buttons) {
            if (isIn(e, mb)){
                mb.setMouseOver(true);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            GameState.state = GameState.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
