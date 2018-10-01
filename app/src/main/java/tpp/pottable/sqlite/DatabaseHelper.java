//database helper v3 by Khiem and google search
package tpp.pottable.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream; //shit wont load with Alt-Enter, had to google but it's fine now
import java.io.FileOutputStream; //and wtf is this?
import java.util.ArrayList;
import java.util.List;

import tpp.pottable.sqlite.model.PlantInfo;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/tpp.pottable/databases/";
    public static final int DB_VERSION = 1;
    //replace this with name of your db file which you copied into asset folder
    private static String DB_NAME = "pottable_def";

    private SQLiteDatabase myDatabase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * //@param //context
     */
    public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with our own default plant info database.
     * */
    public void createDataBase() throws IOException{

        boolean dbExist = checkDatabase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDatabase();

            } catch (Exception e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    public boolean checkDatabase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME; //get full path by concatenating
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){
            //no database?
        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transferring byte-stream which is retarded but hey we're just a small group of freshmen.
     * */
    public void copyDatabase(){

        try{
            //Open your local db as the input stream
            InputStream myInput = myContext.getAssets().open(DB_NAME);

            // Path to the just created empty db
            String outFileName = DB_PATH + DB_NAME;

            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            //transfer bytes from the input file to the output file
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0){
                myOutput.write(buffer, 0, length);
            }

            //Close the streams
            myOutput.flush(); //da toilet
            myOutput.close(); //da lid
            myInput.close(); //wc door
        }
        catch (Exception e) {
            //catch exception but fuck it anyway
        }
    }

    public SQLiteDatabase openDatabase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        return myDatabase;
    }

    @Override
    public synchronized void close() {

        if(myDatabase != null)
        { myDatabase.close();}

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Pottable comes with our team's prebuilt database as default, no need to create anything.
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //THIS ONE GETS THEM DATA
    public PlantInfo getPlantInfo(long id) {
        // get plant info from the info-database
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(PlantInfo.TABLE_NAME, //absolute clusterfuck query
                new String[]{PlantInfo.COLUMN_ID, PlantInfo.COLUMN_NAME, PlantInfo.COLUMN_NAME_SCI,
                        PlantInfo.COLUMN_CATEGORY,PlantInfo.COLUMN_LIFESPAN,PlantInfo.COLUMN_SUN,
                        PlantInfo.COLUMN_WATER,PlantInfo.COLUMN_SOIL,PlantInfo.COLUMN_FERT_FREQ,
                        PlantInfo.COLUMN_FERT,PlantInfo.COLUMN_SPACE,PlantInfo.COLUMN_PROBS},
                PlantInfo.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare a complete plantinfo object
        PlantInfo plantinfo = new PlantInfo(
                cursor.getInt(cursor.getColumnIndex(PlantInfo.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(PlantInfo.COLUMN_CATEGORY)),
                cursor.getString(cursor.getColumnIndex(PlantInfo.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(PlantInfo.COLUMN_NAME_SCI)),
                cursor.getString(cursor.getColumnIndex(PlantInfo.COLUMN_LIFESPAN)),
                cursor.getInt(cursor.getColumnIndex(PlantInfo.COLUMN_SUN)),
                cursor.getInt(cursor.getColumnIndex(PlantInfo.COLUMN_WATER)),
                cursor.getInt(cursor.getColumnIndex(PlantInfo.COLUMN_FERT_FREQ)),
                cursor.getInt(cursor.getColumnIndex(PlantInfo.COLUMN_FERT)),
                cursor.getInt(cursor.getColumnIndex(PlantInfo.COLUMN_SOIL)),
                cursor.getInt(cursor.getColumnIndex(PlantInfo.COLUMN_SPACE)),
                cursor.getString(cursor.getColumnIndex(PlantInfo.COLUMN_PROBS))
                );
        // close the db connection
        cursor.close();
        return plantinfo;
    }
    
    //THIS GETS ALL PLANTS IN A CATEGORY, but only the 4 basic info (4 round icons) + name and pic
    public List<PlantInfo> getCatPlantInfo(String category) {
        List<PlantInfo> plantinfo_array = new ArrayList<>();

        //query to get plants of a specific category
        String selectQuery = "SELECT  * FROM " + PlantInfo.TABLE_NAME + " WHERE " + PlantInfo.COLUMN_CATEGORY +" LIKE "+ category + " ORDER BY " +
                PlantInfo.COLUMN_NAME + " DESC"; //list out by names, descending

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PlantInfo plantinfo = new PlantInfo();
                plantinfo.setID             (cursor.getInt      (cursor.getColumnIndex(PlantInfo.COLUMN_ID)));
                plantinfo.setCategory       (cursor.getString   (cursor.getColumnIndex(PlantInfo.COLUMN_CATEGORY)));
                plantinfo.setName           (cursor.getString   (cursor.getColumnIndex(PlantInfo.COLUMN_NAME)));
                //plantinfo.setNameSci        (cursor.getString   (cursor.getColumnIndex(PlantInfo.COLUMN_NAME_SCI))); //these are unneeded but still there for backup
                //plantinfo.setLifespan       (cursor.getString   (cursor.getColumnIndex(PlantInfo.COLUMN_LIFESPAN)));
                plantinfo.setSun            (cursor.getInt      (cursor.getColumnIndex(PlantInfo.COLUMN_SUN)));
                plantinfo.setWater          (cursor.getInt      (cursor.getColumnIndex(PlantInfo.COLUMN_WATER)));
                //plantinfo.setFertFreq       (cursor.getInt      (cursor.getColumnIndex(PlantInfo.COLUMN_FERT_FREQ)));
                //plantinfo.setFert           (cursor.getInt      (cursor.getColumnIndex(PlantInfo.COLUMN_FERT)));
                plantinfo.setSoil           (cursor.getInt      (cursor.getColumnIndex(PlantInfo.COLUMN_SOIL)));
                plantinfo.setSpace          (cursor.getInt      (cursor.getColumnIndex(PlantInfo.COLUMN_SPACE)));
                //plantinfo.setProbs          (cursor.getString   (cursor.getColumnIndex(PlantInfo.COLUMN_PROBS)));

                plantinfo_array.add(plantinfo); //add it to the array
            } while (cursor.moveToNext());
        }

        // close db connection
        cursor.close();
        db.close();

        // return da list
        return plantinfo_array;
    }
    public int getCatPlantCount() {
        String countQuery = "SELECT  * FROM " + PlantInfo.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}