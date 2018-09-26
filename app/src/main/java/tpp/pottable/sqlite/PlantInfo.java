//this class is for plant info (e.g. in the Database tab only). Monitored plants have another class since they contain different data slots.
package tpp.pottable.sqlite;

public class PlantInfo {
    public static final String TABLE_NAME = "Finalised_List"; //in the sqlite pottable_def.db file

    public static final String COLUMN_ID = "id";
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
//fucking chep phat is real
    private int id;
    private String CATEGORY;
    private String NAME;
    private String NAME_SCI;
    private String LIFESPAN;
    private int SUN;
    private int WATER;
    private int FERT_FREQ;
    private int FERT;
    private int SOIL;
    private int SPACE;
    private String PROBS;

    public PlantInfo(int id, String CATEGORY, String NAME, String NAME_SCI, String LIFESPAN, int SUN, int WATER, int FERT_FREQ, int FERT, int SOIL, int SPACE, String PROBS) {
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
    }
    //getters:
    public int getPlantID() {
        return id;
    }
    public String getPlantCategory() {
        return CATEGORY;
    }
    public String getPlantName() {
        return NAME;
    }
    public String getPlantNameSci() {
        return NAME_SCI;
    }
    public String getPlantLifespan() {
        return LIFESPAN;
    }
    public int getPlantSun() {
        return SUN;
    }
    public int getPlantWater() {
        return WATER;
    }
    public int getPlantFreq() {
        return FERT_FREQ;
    }
    public int getPlantFert() {
        return FERT;
    }
    public int getPlantSoil() {
        return SOIL;
    }
    public int getPlantSpace() {
        return SPACE;
    }
    public String getPlantProbs() {
        return PROBS;
    }

}
