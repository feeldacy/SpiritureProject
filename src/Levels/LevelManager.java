package Levels;

import Main.Game;
import Utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {

    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;
    public LevelManager(Game game){
        this.game = game;
        importOutsideSprite();
        levelOne = new Level(LoadSave.GetLevelData());
    }

    private void importOutsideSprite() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);

        levelSprite = new BufferedImage[48];
        for (int j = 0; j < 4; j++){
            for (int i = 0; i < 12; i++){
                int index = j * 12 + i;
                levelSprite[index] = img.getSubimage(i * 32, j * 32, 32, 32);
            }
        }
    }

    public void draw(Graphics g){
        for (int j = 0; j<Game.TILE_INHEIGHT; j++){
            for (int i = 0; i<Game.TILE_INWIDTH; i++){
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite[index], Game.TILE_SIZE*i, Game.TILE_SIZE*j, Game.TILE_SIZE, Game.TILE_SIZE, null);
            }
        }
    }

    public void update(){

    }

    public Level getCurrentLevel(){
        return levelOne;
    }
}
