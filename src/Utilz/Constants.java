package Utilz;

import Main.Game;

import javax.swing.plaf.PanelUI;

public class Constants {
    public static class Environment{
        public static final int MOVING_TREE_WIDTH_DEFAULT = 620;
        public static final int MOVING_TREE_HEIGHT_DEFAULT = 360;

        public static final int MOVING_TREE_WIDTH = (int) (MOVING_TREE_WIDTH_DEFAULT * Game.SCALE);
        public static final int MOVING_TREE_HEIGHT = (int) (MOVING_TREE_HEIGHT_DEFAULT * Game.SCALE);


        public static final int MOVING_SMALL_TREE_WIDTH_DEFAULT = 620;
        public static final int MOVING_SMALL_TREE_HEIGHT_DEFAULT = 360;

        public static final int MOVING_SMALL_TREE_WIDTH = (int) (MOVING_SMALL_TREE_WIDTH_DEFAULT * Game.SCALE);
        public static final int MOVING_SMALL_TREE_HEIGHT = (int) (MOVING_SMALL_TREE_HEIGHT_DEFAULT * Game.SCALE);
    }

    public static class UI{
        public static class Buttons{
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
        }

        public static class PauseButtons {
            public static final int SOUND_SIZE_DEFAULT = 42;
            public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
        }

        public static class UrmButtons{
            public static final int URM_DEFAULT_SIZE = 56;
            public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);
        }

        public static class VolumeButtons{
            public static final int VOLUME_DEFAULT_WIDTH = 28;
            public static final int VOLUME_DEFAULT_HEIGHT = 44;

            public static final int SLIDER_DEFAULT_WIDTH = 215;
            public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * Game.SCALE);
            public static final int VOLUME_HEIGHT= (int) (VOLUME_DEFAULT_HEIGHT * Game.SCALE);
            public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);

        }
    }

    public static class Directions{

        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants{
        public static final int IDLE = 0;
        public static final int WALK = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int HIT = 4;
        public static final int DEATH = 5;
        public static final int ATTACK = 6;


        public static int getSpriteAmount(int player_action){

            switch (player_action){
                case DEATH:
                    return 8;
                case WALK:
                case ATTACK:
                    return 6;
                case JUMP:
                    return 5;
                case IDLE:
                case HIT:
                    return 4;
                case FALLING:
                    return 3;
            }
            return player_action;
        }
    }
}
