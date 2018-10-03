//this class is for plant info (e.g. in the Database tab only). Monitored plants have another class since they contain different data slots.
package tpp.pottable.sqlite.model;

import android.graphics.Bitmap;

public class PlantInfo {
    public static final String TABLE_NAME = "default"; //in the sqlite pottable_def.db file

    public static final String COLUMN_ID = "_id"; //yes Android has a retarded _ here.
    public static final String COLUMN_CATEGORY = "CATEGORY";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_NAME_SCI= "NAME_SCI";
    public static final String COLUMN_LIFESPAN = "LIFESPAN";
    public static final String COLUMN_SUN = "SUN";
    public static final String COLUMN_WATER = "WATER";
    public static final String COLUMN_FERT_FREQ = "FERT_FREQ";
    public static final String COLUMN_FERT = "FERT";
    public static final String COLUMN_SOIL = "SOIL";
    public static final String COLUMN_SPACE = "SPACE";
    public static final String COLUMN_PROBS = "PROBS";
    public static final String COLUMN_IMAGE = "IMAGE";

    public int id;
    public String CATEGORY;
    public String NAME;
    private String NAME_SCI;
    private String LIFESPAN;
    private int SUN;
    private int WATER;
    private int FERT_FREQ;
    private int FERT;
    private int SOIL;
    private int SPACE;
    private String PROBS;
    private Bitmap IMAGE;

    // Create SQL query, no longer used but kept here as backup
    /*public static final String CREATE_TABLE = //creates a table named "Default" with the following columns in our data base file.
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_CATEGORY + " TEXT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_NAME_SCI + " TEXT,"
                    + COLUMN_LIFESPAN + " TEXT,"
                    + COLUMN_SUN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_WATER + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FERT_FREQ + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FERT + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_SOIL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_SPACE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_PROBS + " TEXT,"
                    + ")";*/

    public PlantInfo() { //stupid blank constructor
    }
    //I really hate how Java defines a constructor, this makes it really similar to pre-declarations...
    //fuck it guys my decision to learn C++ is right after all, also this is literally chep phat

    public PlantInfo(int id, String CATEGORY, String NAME, String NAME_SCI, String LIFESPAN, int SUN, int WATER, int FERT_FREQ, int FERT, int SOIL, int SPACE, String PROBS, Bitmap IMAGE) {
        this.id=id;
        this.CATEGORY=CATEGORY;
        this.NAME=NAME;
        this.NAME_SCI=NAME_SCI;
        this.LIFESPAN=LIFESPAN;
        this.SUN=SUN;
        this.WATER=WATER;
        this.FERT_FREQ=FERT_FREQ;
        this.FERT=FERT;
        this.SOIL=SOIL;
        this.SPACE=SPACE;
        this.PROBS=PROBS;
        this.IMAGE=IMAGE;
    }
    //getters:
    public int getID() {
        return id;
    }
    public String getCategory() {
        return CATEGORY;
    }
    public String getName() {
        return NAME;
    }
    public String getNameSci() {
        return NAME_SCI;
    }
    public String getLifespan() {
        return LIFESPAN;
    }
    public int getSun() {
        return SUN;
    }
    public int getWater() {
        return WATER;
    }
    public int getFreq() {
        return FERT_FREQ;
    }
    public int getFert() {
        return FERT;
    }
    public int getSoil() {
        return SOIL;
    }
    public int getSpace() {
        return SPACE;
    }
    public String getProbs() {
        return PROBS;
    }
    public Bitmap getImage() {
        return IMAGE;
    }

    //setters:
    public void setID(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.CATEGORY = category;
    }


    public void setName(String name) {
        this.NAME = name;
    }

    public void setNameSci(String nameSci) {
        this.NAME_SCI = nameSci;
    }

    public void setLifespan(String lifespan) {
        this.LIFESPAN = lifespan;
    }

    public void setSun(int sun) {
        this.SUN = sun;
    }

    public void setWater(int water) {
        this.WATER = water;
    }

    public void setFertFreq(int fertFreq) {
        this.FERT_FREQ = fertFreq;
    }

    public void setFert(int fert) {
        this.FERT = fert;
    }

    public void setSoil(int soil) {
        this.SOIL = soil;
    }

    public void setSpace(int space) {
        this.SPACE = space;
    }

    public void setProbs(String probs) {
        this.PROBS = probs;
    }
    public void setImage(Bitmap IMAGE) {
        this.IMAGE = IMAGE;
    }
}
