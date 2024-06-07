package gameState;

import Entities.Player;
import Levels.LevelManager;
import Main.Game;
import UI.PausedOverlay;
import Utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import static Utilz.Constants.Environment.*;
import java.util.Random;

public class Playing extends State implements StateMethods{

    private Player player;
    private LevelManager levelManager;
    private PausedOverlay pausedOverlay;
    private boolean paused = false;

    private int xLvlOffset;
    private int leftBorder = (int) (0.2 * Game.GAME_WIDTH);
    private int rightBorder = (int) (0.8 * Game.GAME_WIDTH);
    private int lvlTilesWide = LoadSave.GetLevelData()[0].length;
    private int maxTilesOffset = lvlTilesWide - Game.TILE_INWIDTH;
    private int maxLevelOffsetX = maxTilesOffset * Game.TILE_SIZE;

    private BufferedImage backgroundImg, movingTree, movingSmallTree;

    public Playing(Game game) {
        super(game);
        initClasses();
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND_MAIN);
        movingTree = LoadSave.GetSpriteAtlas(LoadSave.MOVING_BACKGROUND);
        movingSmallTree = LoadSave.GetSpriteAtlas(LoadSave.MOVING_BACKGROUND_2);
    }

    private void initClasses() {
        levelManager = new LevelManager(game);
        player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
        player.loadLvlData(levelManager.getCurrentLevel().getLvlData());
        pausedOverlay = new PausedOverlay(this);
    }

    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost(){
        player.resetDirBooleans();
    }

    public void unpauseGame(){
        paused = false;
    }
    @Override
    public void update() {
        if (!paused){
            levelManager.update();
            player.update();
            checkCloseToBorder();
        } else {
            pausedOverlay.update();
        }
    }

    private void checkCloseToBorder() {
        int playerX = (int) player.getHitBox().x;
        int diff = playerX - xLvlOffset;

        if (diff > rightBorder)
            xLvlOffset += diff - rightBorder;
        else if (diff < leftBorder)
            xLvlOffset += diff - leftBorder;

        if (xLvlOffset > maxLevelOffsetX)
            xLvlOffset = maxLevelOffsetX;
        else if (xLvlOffset < 0)
            xLvlOffset = 0;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        drawTree(g);
        levelManager.draw(g, xLvlOffset);
        player.render(g, xLvlOffset);
        if (paused) {
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
            pausedOverlay.draw(g);
        }
    }
    private void drawTree(Graphics g){
        for (int i = 0; i < 3; i++)
            g.drawImage(movingSmallTree, (5 + i * MOVING_SMALL_TREE_WIDTH) - (int) (xLvlOffset * 0.3), 110, MOVING_SMALL_TREE_WIDTH, MOVING_SMALL_TREE_HEIGHT, null);

        for (int i = 0; i < 3; i++)
            g.drawImage(movingTree, (0 + i * MOVING_TREE_WIDTH) - (int) (xLvlOffset * 0.7), 110, MOVING_TREE_WIDTH, MOVING_TREE_HEIGHT, null);

    }

    public void mouseDragged(MouseEvent e){
        if (paused)
            pausedOverlay.mouseDragged(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            player.setAttacking(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (paused)
            pausedOverlay.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (paused)
            pausedOverlay.mouseReleased(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (paused)
            pausedOverlay.mouseMoved(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                player.setLeft(true);
                break;
            case KeyEvent.VK_D:
                player.setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(true);
                break;
            case KeyEvent.VK_ESCAPE:
                paused = !paused;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                player.setLeft(false);
                break;
            case KeyEvent.VK_D:
                player.setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(false);
                break;
        }
    }
}
