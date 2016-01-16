package com.ljr.modernapp.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import com.ljr.modernapp.R;
import com.ljr.modernapp.drawingapp.DrawingActivity;
import com.ljr.modernapp.movieapp.MovieActivity;
import com.ljr.modernapp.reminderapp.ReminderActivity;
import com.ljr.modernapp.todoapp.TodoActivity;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

public class NotepadActivity extends AppCompatActivity {

    private Drawer mDrawer = null;
    private Toolbar mToolbar;
    private Activity mActivity;
    private int DEFAULT_APP;
    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Object activity;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        mActivity = this;

        mSharedPreference = mActivity.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreference.edit();
        DEFAULT_APP = mSharedPreference.getInt(Constants.DEFAULT_APP, 0);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Create Navigation Drawer Account Header
        AccountHeader headResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header1)
                .build();

        // Now Build the Navigation drawer and pass in the AccountHeader above
        mDrawer = new DrawerBuilder()
                .withAccountHeader(headResult)
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.label_notepad).withIcon(FontAwesome.Icon.faw_edit).withIdentifier(Constants.NOTEPAD),
                        new PrimaryDrawerItem().withName(R.string.label_todo_list).withIcon(FontAwesome.Icon.faw_list).withIdentifier(Constants.TODO),
                        new PrimaryDrawerItem().withName(R.string.label_drawing).withIcon(FontAwesome.Icon.faw_paint_brush).withIdentifier(Constants.DRAWING),
                        new PrimaryDrawerItem().withName(R.string.label_reminder).withIcon(FontAwesome.Icon.faw_clock_o).withIdentifier(Constants.REMINDER),
                        new PrimaryDrawerItem().withName(R.string.label_movie_list).withIcon(FontAwesome.Icon.faw_file_movie_o).withIdentifier(Constants.MOVIE),
                        new PrimaryDrawerItem().withName(R.string.label_setting).withIcon(FontAwesome.Icon.faw_cog).withIdentifier(Constants.SETTINGS)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null && drawerItem instanceof Nameable) {
                            String name = ((Nameable) drawerItem).getName().getText(NotepadActivity.this);
                            mToolbar.setTitle(name);
                        }
                        if (drawerItem != null) {
                            //do something with the Id
                            int idOfItemClicked = drawerItem.getIdentifier();
                            onTouchDrawer(idOfItemClicked);
                        }
                        return true;
                    }
                })
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {

                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                    }
                })

                .withFireOnInitialOnClick(true)
                .withSavedInstance(savedInstanceState)
                .build();


        if (DEFAULT_APP > 0) {
            onTouchDrawer(DEFAULT_APP);
        } else {
            onTouchDrawer(Constants.NOTEPAD);
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onTouchDrawer(int position) {
        switch (position) {
            case Constants.NOTEPAD:
                //go to the NoteList Fragment
                //to be implemented later
                break;
            case Constants.DRAWING:
                startActivity(new Intent(mActivity, DrawingActivity.class));
                break;
            case Constants.TODO:
                startActivity(new Intent(mActivity, TodoActivity.class));
                break;
            case Constants.MOVIE:
                startActivity(new Intent(mActivity, MovieActivity.class));
                break;
            case Constants.REMINDER:
                startActivity(new Intent(mActivity, ReminderActivity.class));
                break;
            case Constants.SETTINGS:
                //go to settings
                openFragment(new SettingsFragment(), "Settings");
                break;

        }
    }

    private void openFragment(SettingsFragment fragment, String screenTitle) {

        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();

        // commented this out due to verification warning when commiting to GIT
//        String scrTitle;
//        scrTitle = screenTitle;

//        if (scrTitle != null) {
//            getSupportActionBar().setTitle(scrTitle);
//        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Notepad Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.ljr.modernapp.common/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Notepad Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.ljr.modernapp.common/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}
