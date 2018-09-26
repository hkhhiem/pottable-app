//database helper v2 by Khiem and google search
package tpp.pottable;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.InputStream;
import java.io.OutputStream; //shit wont load with Alt-Enter, had to google but it's fine now
import java.io.FileOutputStream; //and wtf is this?

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/tpp.pottable/databases/";

    //replace this with name of your db file which you copied into asset folder
    private static String DB_NAME = "pottable_def";

    private SQLiteDatabase myDatabase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param //context
     */
    public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
        this.createDatabase();
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDatabase(){
        try {
            boolean dbExist = checkDatabase();

            if(dbExist){
                //do nothing - database already exist
            }else{
                //By calling this method an empty database will be created into the default system path
                //of your application, which will get overwritten with ours.
                this.getReadableDatabase();


                copyDatabase();

            }
        }
        catch (Exception e) {
            //fuck this
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDatabase(){

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

        return checkDB != null;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transferring byte-stream which is retarded but hey we're just a small group of freshmen.
     * */
    private void copyDatabase(){

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}