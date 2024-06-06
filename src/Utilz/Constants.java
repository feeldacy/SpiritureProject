package Utilz;

import Main.Game;

public class Constants {

    public static class UI{
        public static class Buttons{
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
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
