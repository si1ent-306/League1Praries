package com.example.elliottwagner.team;

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
                "playerID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "playerFirstName TEXT, " +
                "playerLastName TEXT, " +
                "playerNumber INTEGER, " +
                "playerPosition TEXT" +
                "playerTeam TEXT" +
                "playerCountry TEXT " +
                "playerAge INTEGER " +
                "playerHeight INTEGER " +
                "playerWeight INTEGER " +
                ")";

        Log.d("DBHelper", "query made: " + queryCreatePlayersTable);
        //Create a table for all of the teams
        queryCreateTeamsTable = "CREATE TABLE tblTeams " +
                "( " +
                "teamID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "teamName TEXT, " +
                "teamCity TEXT " +
                "teamDivision TEXT " +
                "teamColor TEXT " +
                "teamWins INTEGER " +
                "teamLosses INTEGER " +
                "teamDraws INTEGER " +
                "teamPoints INTEGER " +
                "teamGoalDifference INTEGER " +
                ")";
        //Create a table for all of the games
        queryCreateGamesTable = "CREATE TABLE tblGames " +
                "( " +
                "gameID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "gameDate TEXT, " +
                "gameHomeTeam TEXT, " +
                "gameAwayTeam TEXT, " +
                "gameHomeScore INTEGER, " +
                "gameAwayScore INTEGER " +
                "gameStartTime TEXT " +
                "gameStadium TEXT " +
                ")";
        //Create a table for all of the stats
        queryCreateStatsTable = "CREATE TABLE tblStats " +
                "( " +
                "statID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "playerID INTEGER, " +
                "playerFirstName TEXT, " +
                "playerLastName TEXT, " +
                "playerPosition TEXT" +
                "playerTeam TEXT" +
                "playerGoals INTEGER " +
                "playerAssists INTEGER " +
                "playerYellowCards INTEGER " +
                "playerRedCards INTEGER " +
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
}
