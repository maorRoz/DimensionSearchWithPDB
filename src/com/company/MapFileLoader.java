package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MapFileLoader {
    private static int getHeight(String heightLine){
        String heightNumberString = heightLine.substring(7);
        return Integer.parseInt(heightNumberString);
    }

    private static int getWidth(String widthLine){
        String widthNumberString = widthLine.substring(6);
        return Integer.parseInt(widthNumberString);
    }

    public static GameGrid2D loadMapFile(String path){
        GameGrid2D gameGrid2D = null;

        File file = new File(path);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            bufferedReader.readLine(); // remove type line
            String heightLine = bufferedReader.readLine();
            String widthLine = bufferedReader.readLine();
            bufferedReader.readLine(); // remove 'map' line

            if(heightLine == null || widthLine == null){
                throw new Error();
            }

            int height = getHeight(heightLine);
            int width = getWidth(widthLine);

            gameGrid2D = new GameGrid2D(width, height);

            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    char input = (char)bufferedReader.read();
                    boolean isOccupied = input == '@' || input =='T';
                    gameGrid2D.setTile(i,j,isOccupied ? Tile.TileState.OCCUPIED : Tile.TileState.EMPTY);
                }
                bufferedReader.read(); }
        } catch(Exception e){

        }

        return gameGrid2D;

    }
}
