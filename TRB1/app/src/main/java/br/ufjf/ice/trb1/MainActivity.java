package br.ufjf.ice.trb1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import persistence.DBHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.deleteDatabase(DBHandler.DATABASE_NAME);

        BottomNavigationView nav = findViewById(R.id.bottomNavigationView);

        nav.setOnNavigationItemSelectedListener(navigationListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment,  new GetAllParticipantsFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
    new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.navigation_participants :
                    selectedFragment = new GetAllParticipantsFragment();
                    break;

                case R.id.navigation_events :
                    selectedFragment = new GetAllEventsFragment();
                    break;
                case R.id.navigation_register:
                    selectedFragment = new RegisterItemFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment, selectedFragment).commit();
            return true;
        }
    };
}
