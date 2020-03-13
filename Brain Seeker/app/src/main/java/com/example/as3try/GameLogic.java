package com.example.as3try;

import java.util.Random;

public class GameLogic {
    private int brain_map[][];
    private int number_map[][];
    private int NUM_ROWS;
    private int NUM_COLS;
    private int NUM_BRAIN;


    public void setBrainMap(int row, int col, int brain){
        NUM_ROWS = row;
        NUM_COLS = col;
        NUM_BRAIN = brain;
        brain_map = new int[row][col];
        number_map = new int[row][col];

        int brain_count = 0;
        int button_count = 0;

        for (int i = 0; i < NUM_ROWS; i++){
            for (int j = 0; j < NUM_COLS; j++){
                float p = (float)(NUM_BRAIN-brain_count)/(float) (NUM_COLS*NUM_ROWS-button_count);
                Random r = new Random();
                float random = r.nextFloat()*(1);
                if (random < p){
                    brain_map[i][j] = 1;
                    brain_count++;
                }
                else{
                    brain_map[i][j] = 0;
                }
                button_count++;
            }
        }

        for (int i = 0; i < NUM_ROWS; i++){
            for (int j = 0; j < NUM_COLS; j++){
                int tmp_number = 0;
                for (int n = 0; n < NUM_ROWS; n++){
                    tmp_number = tmp_number + brain_map[n][j];
                }
                for (int m = 0; m < NUM_COLS; m++){
                    tmp_number = tmp_number + brain_map[i][m];
                }
                number_map[i][j] = tmp_number;
            }
        }
    }

    public boolean checkBrain(int row, int col){
        if(brain_map[row][col]==1){
            return true;
        }
        else{
            return false;
        }
    }

    public int checkNumber(int row, int col){
//        int tmp_number = 0;
//        for (int i = 0; i < NUM_COLS; i++){
//            tmp_number = tmp_number + brain_map[row][i];
//        }
//        for (int j = 0; j < NUM_ROWS; j++){
//            tmp_number = tmp_number + brain_map[j][col];
//        }
//        return tmp_number;
        return number_map[row][col];
    }

    public void update(int row, int col){
        for(int i = 0; i < NUM_ROWS; i++){
            if (number_map[i][col] > 0){
                number_map[i][col]--;
            }
        }
        for (int j = 0; j < NUM_COLS; j++){
            if (number_map[row][j] > 0){
                number_map[row][j]--;
            }
        }
    }
}
