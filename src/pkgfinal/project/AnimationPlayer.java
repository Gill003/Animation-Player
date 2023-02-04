/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;

/**
 *
 * @author bhavj
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class AnimationPlayer {

    int frames;
    public static int speed;
    int numofe;
    public static List<String> circle = new ArrayList<>();
    public static List<String> rect = new ArrayList<>();
    public static List<String> line = new ArrayList<>();
    public static List<String> effects = new ArrayList<>();
    //circle data
    public static int x1 = 10, y1 = 10, r1 = 10;
    public static int red1 = 255, green1 = 0, blue1 = 0;
    public static int borderRed1 = 255, borderGreen1 = 0, borderBlue1 = 0;
    public static int borderThickness1 = 10;
    public static int x1n = 10, y1n = 10;
    //rectangle data
    public static int l1 = 10, w1 = 10;
    public static int red1r = 255, green1r = 1, blue1r = 1;
    public static int x1r = 10, y1r = 10;
    public static int borderThickness1r = 10;
    public static int borderRed1r = 255, borderGreen1r = 1, borderBlue1r = 1;
    //line data
    int StartX1 = 10, StartY1 = 10;
    int endX1 = 10, endY1 = 10;
    public static int borderThickness1l;
    public static int red1l, green1l, blue1l;

    public void LoadAnimationFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                if (line.contains("frames")) {
                    //reads frames
                    String[] toarray = line.split(": ");
                    String froma = toarray[1];
                    frames = Integer.parseInt(froma);
                    //reads speed
                    line = reader.readLine();
                    String[] speedarr = line.split(": ");
                    String speedst = speedarr[1];
                    String[] speedarr1 = speedst.split("f");
                    String speedst2 = speedarr1[0];
                    speed = Integer.parseInt(speedst2);
                    line = reader.readLine();
                    line = reader.readLine();
                    line = reader.readLine();
                }
                switch (line) {
                    case "Circle":
                        int c = 0;
                        int cy = 0;
                        while (line.length() != 0) {
                            if (line.contains("r:") || line.contains("x:") || line.contains("y:") || line.contains("border:")) {
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                switch (toarray[0]) {
                                    case "r":
                                        r1 = Integer.parseInt(froma);
                                        break;
                                    case "x":
                                        if (c < 1) {
                                            x1 = Integer.parseInt(froma);
                                            c++;
                                        }
                                        break;
                                    case "y":
                                        if (cy < 1) {
                                            y1 = Integer.parseInt(froma);
                                            cy++;
                                        }
                                        break;
                                    case "border":
                                        borderThickness1 = Integer.parseInt(froma);
                                        break;
                                }
                            }
                            if (line.contains("color:")) {
                                String[] speedarr = line.split(": ");
                                String secondp = speedarr[1];
                                String[] speedarr2 = secondp.split(", ", 3);
                                red1 = Integer.parseInt(speedarr2[0]);
                                green1 = Integer.parseInt(speedarr2[1]);
                                blue1 = Integer.parseInt(speedarr2[2]);
                            }
                            if (line.contains("borderColor")) {
                                String[] speedarr = line.split(": ");
                                String secondp = speedarr[1];
                                String[] speedarr2 = secondp.split(", ", 3);
                                borderRed1 = Integer.parseInt(speedarr2[0]);
                                borderGreen1 = Integer.parseInt(speedarr2[1]);
                                borderBlue1 = Integer.parseInt(speedarr2[2]);
                            }
                            if (line.contains("Hide") || line.contains("Show")) {

                                String effect = line;

                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                effects.add("Circle" + "," + effect + "," + Integer.parseInt(froma));
                            }
                            if (line.contains("Jump")) {
                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                line = reader.readLine();
                                String[] toarray2 = line.split(": ");
                                String froma2 = toarray2[1];
                                x1n = Integer.parseInt(froma2);
                                line = reader.readLine();
                                String[] toarray3 = line.split(": ");
                                String froma3 = toarray3[1];
                                y1n = Integer.parseInt(froma3);
                                effects.add("Circle" + "," + "Jump" + "," + Integer.parseInt(froma) + "," + (x1n) + "," + (y1n));
                            }
                            if (line.contains("Changecolor")) {
                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                line = reader.readLine();
                                String[] speedarr = line.split(": ");
                                String secondp = speedarr[1];
                                String[] speedarr2 = secondp.split(", ", 3);
                                red1 = Integer.parseInt(speedarr2[0]);
                                green1 = Integer.parseInt(speedarr2[1]);
                                blue1 = Integer.parseInt(speedarr2[2]);
                                effects.add("Circle" + "," + "Changecolor" + "," + Integer.parseInt(froma) + "," + (red1) + "," + (green1) + "," + (blue1));
                            }
                            line = reader.readLine();
                            if (line == null) {
                                break;
                            }
                        }
                        break;
                    case "Rect":
                        int c2x = 0;
                        int c2y = 0;
                        while (line.length() != 0) {
                            if (line.contains("x:") || line.contains("y:") || line.contains("border:") || line.contains("length:") || line.contains("width:")) {
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                switch (toarray[0]) {
                                    case "x":
                                        if (c2x < 1) {
                                            x1r = Integer.parseInt(froma);
                                            c2x++;
                                        }
                                        break;
                                    case "y":
                                        if (c2y < 1) {
                                            y1r = Integer.parseInt(froma);
                                            c2y++;
                                        }
                                        ;
                                        break;
                                    case "border":
                                        borderThickness1r = Integer.parseInt(froma);
                                        break;
                                    case "length":
                                        l1 = Integer.parseInt(froma);
                                        break;
                                    case "width":
                                        w1 = Integer.parseInt(froma);
                                        break;
                                }
                            }
                            if (line.contains("color:")) {
                                String[] speedarr = line.split(": ");
                                String secondp = speedarr[1];
                                String[] speedarr2 = secondp.split(", ", 3);
                                red1r = Integer.parseInt(speedarr2[0]);
                                green1r = Integer.parseInt(speedarr2[1]);
                                blue1r = Integer.parseInt(speedarr2[2]);
                            }
                            if (line.contains("borderColor")) {
                                String[] speedarr = line.split(": ");
                                String secondp = speedarr[1];
                                String[] speedarr2 = secondp.split(", ", 3);
                                borderRed1r = Integer.parseInt(speedarr2[0]);
                                borderGreen1r = Integer.parseInt(speedarr2[1]);
                                borderBlue1r = Integer.parseInt(speedarr2[2]);
                            }
                            if (line.contains("Hide") || line.contains("Show")) {

                                String effect = line;

                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                effects.add("Rect" + "," + effect + "," + Integer.parseInt(froma));
                            }
                            if (line.contains("Jump")) {
                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                line = reader.readLine();
                                String[] toarray2 = line.split(": ");
                                String froma2 = toarray2[1];
                                x1n = Integer.parseInt(froma2);
                                line = reader.readLine();
                                String[] toarray3 = line.split(": ");
                                String froma3 = toarray3[1];
                                y1n = Integer.parseInt(froma3);
                                effects.add("Rect" + "," + "Jump" + "," + Integer.parseInt(froma) + "," + (x1n) + "," + (y1n));
                            }
                            if (line.contains("Changecolor")) {
                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                line = reader.readLine();
                                String[] speedarr = line.split(": ");
                                String secondp = speedarr[1];
                                String[] speedarr2 = secondp.split(", ", 3);
                                System.out.println(speedarr2[0]);
                                System.out.println(speedarr2[1]);
                                System.out.println(speedarr2[2]);
                               int red12 = Integer.parseInt(speedarr2[0]);
                                int green12 = Integer.parseInt(speedarr2[1]);
                               int blue12 = Integer.parseInt(speedarr2[2]);
                               effects.add("Rect" + "," + "Changecolor" + "," + Integer.parseInt(froma) + "," + (red12) + "," + (green12) + "," + (blue12));
                            }
                            line = reader.readLine();
                            if (line == null) {
                                break;
                            }
                        }
                        break;
                    case "Line":
                        while (line.length() != 0) {
                            if (line.contains("startX:") || line.contains("startY:") || line.contains("border:") || line.contains("endX:") || line.contains("endY:")) {
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                switch (toarray[0]) {
                                    case "startX":
                                        StartX1 = Integer.parseInt(froma);
                                        break;
                                    case "startY":
                                        StartY1 = Integer.parseInt(froma);
                                        break;
                                    case "border":
                                        borderThickness1l = Integer.parseInt(froma);
                                        break;
                                    case "endX":
                                        endX1 = Integer.parseInt(froma);
                                        break;
                                    case "endY":
                                        endY1 = Integer.parseInt(froma);
                                        break;
                                }
                            }
                            if (line.contains("color:")) {
                                String[] speedarr = line.split(": ");
                                String secondp = speedarr[1];
                                String[] speedarr2 = secondp.split(", ", 3);
                                red1l = Integer.parseInt(speedarr2[0]);
                                green1l = Integer.parseInt(speedarr2[1]);
                                blue1l = Integer.parseInt(speedarr2[2]);
                            }
                            if (line.contains("Hide") || line.contains("Show")) {
                                String effect = line;
                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                effects.add("Line" + "," + effect + "," + Integer.parseInt(froma));
                            }
                            if (line.contains("Jump")) {
                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                line = reader.readLine();
                                String[] toarray2 = line.split(": ");
                                String froma2 = toarray2[1];
                                x1n = Integer.parseInt(froma2);
                                line = reader.readLine();
                                String[] toarray3 = line.split(": ");
                                String froma3 = toarray3[1];
                                y1n = Integer.parseInt(froma3);
                                effects.add("Line" + "," + "Jump" + "," + Integer.parseInt(froma) + "," + (x1n) + "," + (y1n));
                            }
                            if (line.contains("Changecolor")) {
                                line = reader.readLine();
                                String[] toarray = line.split(": ");
                                String froma = toarray[1];
                                line = reader.readLine();
                                String[] speedarr = line.split(": ");
                                String secondp = speedarr[1];
                                String[] speedarr2 = secondp.split(", ", 3);
                                red1 = Integer.parseInt(speedarr2[0]);
                                green1 = Integer.parseInt(speedarr2[1]);
                                blue1 = Integer.parseInt(speedarr2[2]);
                                effects.add("Line" + "," + "Changecolor" + "," + Integer.parseInt(froma) + "," + (red1) + "," + (green1) + "," + (blue1));
                            }
                            line = reader.readLine();
                            if (line == null) {
                                break;
                            }
                        }
                        break;

                }
                line = reader.readLine();
                if (line == null) {
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws InterruptedException {
        runAnnimation p = new runAnnimation();
        p.time = (frames / speed) * 1000;
        p.run2();
    }

    public static void main(String[] args) throws InterruptedException {
        AnimationPlayer player = new AnimationPlayer();
        player.LoadAnimationFromFile("Anitest.txt");
        player.run();
    }
}
