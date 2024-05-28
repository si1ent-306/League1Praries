package com.example.elliottwagner.team;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.elliottwagner.Game;

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
    public static String TEAM_STANDING = "teamStanding";
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
        //Create a table for all of the players
        queryCreatePlayersTable = "CREATE TABLE tblPlayers " +
                "( " +
                PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PLAYER_FIRST_NAME + " TEXT, " +
                PLAYER_LAST_NAME +  " TEXT, " +
                PLAYER_NUMBER + " INTEGER, " +
                PLAYER_POSITION + " TEXT, " +
                PLAYER_TEAM + " TEXT, " +
                PLAYER_COUNTRY + " TEXT, " +
                PLAYER_AGE + " INTEGER, " +
                PLAYER_HEIGHT + " INTEGER, " +
                PLAYER_WEIGHT + " INTEGER" +
                ")";

        Log.d("DBHelper", "query made: " + queryCreatePlayersTable);
        //Create a table for all of the teams
        queryCreateTeamsTable = "CREATE TABLE tblTeams " +
                "( " +
                TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TEAM_NAME + " TEXT, " +
                TEAM_CITY + " TEXT, " +
                TEAM_DIVISION + " TEXT, " +
                TEAM_COLOR + " TEXT, " +
                TEAM_WINS + " INTEGER, " +
                TEAM_LOSSES + " INTEGER, " +
                TEAM_DRAWS + " INTEGER, " +
                TEAM_POINTS + " INTEGER, " +
                TEAM_GOAL_DIFFERENCE + " INTEGER, " +
                TEAM_STANDING + " TEXT"+
                ")";
        //Create a table for all of the games
        queryCreateGamesTable = "CREATE TABLE tblGames " +
                "( " +
                GAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GAME_DATE + " TEXT, " +
                GAME_HOME_TEAM + " TEXT, " +
                GAME_AWAY_TEAM + " TEXT, " +
                GAME_HOME_SCORE + " INTEGER, " +
                GAME_AWAY_SCORE + " INTEGER, " +
                GAME_START_TIME + " TEXT, " +
                GAME_STADIUM + " TEXT" +
                ")";
        //Create a table for all of the stats
        queryCreateStatsTable = "CREATE TABLE tblStats " +
                "( " +
                STAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                STAT_PLAYER_ID + " INTEGER, " +
                STAT_PLAYER_FIRST_NAME + " TEXT, " +
                STAT_PLAYER_LAST_NAME + " TEXT, " +
                STAT_PLAYER_POSITION + " TEXT, " +
                STAT_PLAYER_TEAM +" TEXT," +
                STAT_PLAYER_GOALS + " INTEGER, " +
                STAT_PLAYER_ASSISTS + " INTEGER, " +
                STAT_PLAYER_YELLOW_CARDS + " INTEGER, " +
                STAT_PLAYER_RED_CARDS + " INTEGER" +
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
        //Create a list of players
        ArrayList<Player> players = new ArrayList<>();
        //Get a reference to the database
        SQLiteDatabase db = this.getReadableDatabase();
        //Create a query to get all of the players where the team is the same as the team passed in
        String query = "SELECT * FROM tblPlayers WHERE playerTeam = team.teamName";
        //Execute the query
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
            //Get the values from the cursor
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
            //Create a new player object
            Player player = new Player(playerID,playerNumber,playerFirstName,playerLastName,playerCountry,playerAge, playerPosition,playerHeight,playerWeight, playerTeam);
            players.add(player);
        }
        //Return all of the players
        return players;
    }
    public ArrayList<Team> getAllTeams(){
        ArrayList<Team> teams = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tblTeams";
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
            int teamID = cursor.getInt(0);
            String teamName = cursor.getString(1);
            String teamCity = cursor.getString(2);
            String teamDivision = cursor.getString(3);
            int teamColor = cursor.getInt(4);
            int teamWins = cursor.getInt(5);
            int teamLosses = cursor.getInt(6);
            int teamDraws = cursor.getInt(7);
            int teamPoints = cursor.getInt(8);
            int teamGoalDifference = cursor.getInt(9);
            int teamStanding = cursor.getInt(10);
            Team team = new Team(teamID,teamName,teamCity,teamDivision,teamColor,teamWins,teamLosses,teamDraws,teamPoints,teamGoalDifference, teamStanding);
            teams.add(team);
        }
        return teams;
    }
//    public ArrayList<Game> getAllGames(){
//        ArrayList<Game> games = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT * FROM tblGames";
//        Cursor cursor = db.rawQuery(query,null);
//        while(cursor.moveToNext()){
//            int  gameID = cursor.getInt(0);
//            String gameDate = cursor.getString(1);
//            String gameHomeTeam = cursor.getString(2);
//            String gameAwayTeam = cursor.getString(3);
//            int gameHomeScore = cursor.getInt(4);
//            int gameAwayScore = cursor.getInt(5);
//            String gameStartTime = cursor.getString(6);
//            String gameStadium = cursor.getString(7);
//            Game game = new Game(gameID,gameDate,null, null,gameHomeScore,gameAwayScore,gameStartTime,gameStadium);
//            game.setHomeTeam(gameHomeTeam);
//            game.setAwayTeam(gameAwayTeam);
//            games.add(game);
//        }
//        return games;
//    }

    public void addTeam(Team team) {
        // create a reference to the database (writable)
        SQLiteDatabase db = getWritableDatabase();
        // create the key-value pair for the record
        ContentValues values = new ContentValues();
        // put the values into the key-value pair
        values.put(TEAM_ID, team.getId());
        values.put(TEAM_NAME, team.getName());
        values.put(TEAM_CITY, team.getCity());
        values.put(TEAM_DIVISION, team.getDivision());
        values.put(TEAM_COLOR, team.getColor());
        values.put(TEAM_WINS, team.getWins());
        values.put(TEAM_LOSSES, team.getLosses());
        values.put(TEAM_DRAWS, team.getDraws());
        values.put(TEAM_POINTS, team.getPoints());
        values.put(TEAM_GOAL_DIFFERENCE, team.getGoalDifference());
        // store the key-value pair to the table
        db.insert("tblTeams", null, values);
        db.close();
    }
    public void addPlayer(Player player) {
        // create a reference to the database (writable)
        SQLiteDatabase db = getWritableDatabase();
        // create the key-value pair for the record
        ContentValues values = new ContentValues();
        // put the values into the key-value pair
        values.put(PLAYER_ID, player.getId());
        values.put(PLAYER_FIRST_NAME, player.getFirstName());
        values.put(PLAYER_LAST_NAME, player.getLastName());
        values.put(PLAYER_NUMBER, player.getNumber());
        values.put(PLAYER_POSITION, player.getPosition());
        values.put(PLAYER_TEAM, player.getTeam());
        values.put(PLAYER_COUNTRY, player.getCountry());
        values.put(PLAYER_AGE, player.getAge());
        values.put(PLAYER_HEIGHT, player.getHeight());
        values.put(PLAYER_WEIGHT, player.getWeight());
        // store the key-value pair to the table
        db.insert("tblPlayers", null, values);
        db.close();
    }
//    public void addGame(Game game) {
//        // create a reference to the database (writable)
//        SQLiteDatabase db = getWritableDatabase();
//        // create the key-value pair for the record
//        ContentValues values = new ContentValues();
//        // put the values into the key-value pair
//        values.put("gameID", game.getGameID());
//        values.put("gameDate", game.getDateOfGame());
//        values.put("gameHomeTeam", game.getHomeTeam());
//        values.put("gameAwayTeam", game.getAwayTeam());
//        values.put("gameHomeScore", game.getHomeScore());
//        values.put("gameAwayScore", game.getAwayScore());
//        values.put("gameStartTime", game.getStartTime());
//        values.put("gameStadium", game.getStadium());
//        // store the key-value pair to the table
//        db.insert("tblGames", null, values);
//        db.close();
//    }
}
