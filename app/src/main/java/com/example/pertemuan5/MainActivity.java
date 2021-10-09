package com.example.pertemuan5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView no_data_found;
    ArrayList<String> game_data_array = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no_data_found = (TextView) findViewById(R.id.no_data_found);
        if(game_data_array.isEmpty()){
            no_data_found.setVisibility(View.VISIBLE);
        }else{
            no_data_found.setVisibility(View.INVISIBLE);
            // Show ListView
            showListViewData();
        }
    }

    private void showAlert(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // Set title
        alertDialogBuilder.setTitle("Whoopss !");
        // Set alert message
        alertDialogBuilder.setMessage("Data gagal ditambahkan karena sudah ada")
        .setCancelable(true).setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        // Create alert from alertbuilder
        AlertDialog alertDialog = alertDialogBuilder.create();
        // Show alert dialog
        alertDialog.show();
    }

    public void addDataGame(View view){
        // Define EditText game_name
        EditText game_name = findViewById(R.id.game_name);
        // Get text game_name to add to array list
        String new_game_name = game_name.getText().toString();
        // Add new game_name to array list
        // Check first if the game_name does not exist
        if(game_data_array.indexOf(new_game_name) == -1){
            // If the game name not found, add
            no_data_found.setVisibility(View.INVISIBLE);
            game_data_array.add(new_game_name);
            showListViewData();
        }else{
            showAlert();
        }
    }

    public void showListViewData(){
        // Define Listview berdasarkan ID
        ListView list_view_games = findViewById(R.id.list_view_games);
        // Dummy Data
        // String[] game_data_array = {"PUBG Mobile - Solo","PUBG Mobile - Duo","PUBG Mobile - Squad","Free Fire - Solo"};

        // Convert array list to string
        String [] arrayGameLists = new String[game_data_array.size()];
        arrayGameLists = game_data_array.toArray(arrayGameLists);

        // Create adapter for ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_game,R.id.txt_game_lists, arrayGameLists);
        // Set adapter
        list_view_games.setAdapter(adapter);
    }

}