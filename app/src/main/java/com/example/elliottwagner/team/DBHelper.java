package com.example.elliottwagner.team;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static String PLAYER_ID = "playerID";
    public static String PLAYER_FIRST_NAME = "playerFirstName";
    public static String PLAYER_LAST_NAME = "playerLastName";
    public static String PLAYER_NUMBER = "playerNumber";
    public static String PLAYER_POSITION = "playerPosition";
    public static String PLAYER_TEAM = "playerTeam";
    public static String PLAYER_COUNTRY = "playerCountry";
    public static String PLAYER_AGE = "playerAge";
    public static String PLAYER_HEIGHT = "playerHeight";
    public static String PLAYER_WEIGHT = "playerWeight";
    public static String TEAM_ID = "teamID";
    public static String TEAM_NAME = "teamName";
    public static String TEAM_CITY = "teamCity";
    public static String TEAM_DIVISION = "teamDivision";
    public static String TEAM_COLOR = "teamColor";
    public static String TEAM_WINS = "teamWins";
    public static String TEAM_LOSSES = "teamLosses";
    public static String TEAM_DRAWS = "teamDraws";
    public static String TEAM_POINTS = "teamPoints";
    public static String TEAM_GOAL_DIFFERENCE = "teamGoalDifference";
    public static String GAME_ID = "gameID";
    public static String GAME_DATE = "gameDate";
    public static String GAME_HOME_TEAM = "gameHomeTeam";
    public static String GAME_AWAY_TEAM = "gameAwayTeam";
    public static String GAME_HOME_SCORE = "gameHomeScore";
    public static String GAME_AWAY_SCORE = "gameAwayScore";
    public static String GAME_START_TIME = "gameStartTime";
    public static String GAME_STADIUM = "gameStadium";
    public static String STAT_ID = "statID";
    public static String STAT_PLAYER_ID = "playerID";
    public static String STAT_PLAYER_FIRST_NAME = "playerFirstName";
    public static String STAT_PLAYER_LAST_NAME = "playerLastName";
    public static String STAT_PLAYER_POSITION = "playerPosition";
    public static String STAT_PLAYER_TEAM = "playerTeam";
    public static String STAT_PLAYER_GOALS = "playerGoals";
    public static String STAT_PLAYER_ASSISTS = "playerAssists";
    public static String STAT_PLAYER_YELLOW_CARDS = "playerYellowCards";
    public static String STAT_PLAYER_RED_CARDS = "playerRedCards";



    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context){
        this(context,"my.db",null,1);
        Log.d("DBHelper","Constructor Called");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create all required tables
        String queryCreatePlayersTable = "";
        String queryCreateTeamsTable = "";
        String queryCreateGamesTable = "";
        String queryCreateStatsTable = "";
        // create the query for the table
        //Create a table for all of the players
        queryCreatePlayersTable = "CREATE TABLE tblPlayers " +
                "( " +
                 PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PLAYER_FIRST_NAME + " TEXT, " +
                PLAYER_LAST_NAME +  "TEXT, " +
                PLAYER_NUMBER + "INTEGER, " +
                PLAYER_POSITION + "TEXT, " +
                PLAYER_TEAM + "TEXT, " +
                PLAYER_COUNTRY + "TEXT, " +
                PLAYER_AGE + "INTEGER, " +
                PLAYER_HEIGHT + "INTEGER, " +
                PLAYER_WEIGHT + "INTEGER, " +
                ")";

        Log.d("DBHelper", "query made: " + queryCreatePlayersTable);
        //Create a table for all of the teams
        queryCreateTeamsTable = "CREATE TABLE tblTeams " +
                "( " +
                TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TEAM_NAME + "TEXT, " +
                TEAM_CITY + "TEXT, " +
                TEAM_DIVISION + "TEXT " +
                TEAM_COLOR + "TEXT " +
                TEAM_WINS + "INTEGER " +
                TEAM_LOSSES + "INTEGER " +
                TEAM_DRAWS + "INTEGER " +
                TEAM_POINTS + "INTEGER " +
                TEAM_GOAL_DIFFERENCE + "INTEGER " +
                ")";
        //Create a table for all of the games
        queryCreateGamesTable = "CREATE TABLE tblGames " +
                "( " +
                GAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GAME_DATE + " TEXT, " +
                GAME_HOME_TEAM + " TEXT, " +
                GAME_AWAY_TEAM + " TEXT, " +
                GAME_HOME_SCORE + " INTEGER, " +
                GAME_AWAY_SCORE + " INTEGER " +
                GAME_START_TIME + " TEXT " +
                GAME_STADIUM + " TEXT " +
                ")";
        //Create a table for all of the stats
        queryCreateStatsTable = "CREATE TABLE tblStats " +
                "( " +
                STAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                STAT_PLAYER_ID + " INTEGER, " +
                STAT_PLAYER_FIRST_NAME + " TEXT, " +
                STAT_PLAYER_LAST_NAME + " TEXT, " +
                STAT_PLAYER_POSITION + " TEXT, " +
                STAT_PLAYER_TEAM +" TEXT" +
                STAT_PLAYER_GOALS + " INTEGER " +
                STAT_PLAYER_ASSISTS + " INTEGER " +
                STAT_PLAYER_YELLOW_CARDS + " INTEGER " +
                STAT_PLAYER_RED_CARDS + " INTEGER " +
                ")";

        // execute the query
        db.execSQL(queryCreatePlayersTable);
        Log.d("DBHelper", "query executed: " + queryCreatePlayersTable);
        db.execSQL(queryCreateTeamsTable);
        Log.d("DBHelper", "query executed: " + queryCreateTeamsTable);
        db.execSQL(queryCreateGamesTable);
        Log.d("DBHelper", "query executed: " + queryCreateGamesTable);
        db.execSQL(queryCreateStatsTable);
        Log.d("DBHelper", "query executed: " + queryCreateStatsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //TODO: Create all of the databases and tables
    public ArrayList<Player> getAllPlayers(Team team){
        ArrayList<Player> players = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tblPlayers WHERE playerTeam = team.teamName";
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
            int playerID = cursor.getInt(0);
            String playerFirstName = cursor.getString(1);
            String playerLastName = cursor.getString(2);
            int playerNumber = cursor.getInt(3);
            String playerPosition = cursor.getString(4);
            String playerTeam = cursor.getString(5);
            String playerCountry = cursor.getString(6);
            int playerAge = cursor.getInt(7);
            int playerHeight = cursor.getInt(8);
            int playerWeight = cursor.getInt(9);
            Player player = new Player(playerID,playerNumber,playerFirstName,playerLastName,playerCountry,playerAge, playerPosition,playerHeight,playerWeight, playerTeam);
            players.add(player);
        }
        return players;
    }

    public void createTeams() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a table for all of the teams


    }

    public void addTeam(Team team) {
        // create a reference to the database (writable)
        SQLiteDatabase db = getWritableDatabase();

        // create the key-value pair for the record
        ContentValues values = new ContentValues();

        // put the values into the key-value pair
        values.put("teamID", team.getId());
        values.put("teamName", team.getName());
        values.put("teamCity", team.getCity());
        values.put("teamDivision", team.getDivision());
        values.put("teamColor", team.getColor());
        values.put("teamWins", team.getWins());
        values.put("teamLosses", team.getLosses());
        values.put("teamDraws", team.getDraws());
        values.put("teamPoints", team.getPoints());
        values.put("teamGoalDifference", team.getGoalDifference());

        // store the key-value pair to the table
        db.insert("tblTeams", null, values);
    }
}
