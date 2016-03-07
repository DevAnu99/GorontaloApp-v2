package com.MasGaptek.Hulondalo;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().
                    add(R.id.content,
                            new Profil(),
                            Profil.class.getSimpleName()).commit();
        }


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setVerticalScrollBarEnabled(false);
        navigationView.setHorizontalScrollBarEnabled(false);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.my_drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.setHorizontalScrollBarEnabled(false);
        drawerLayout.setVerticalScrollBarEnabled(false);
        actionBarDrawerToggle.syncState();

    }

    private boolean selectDrawerItem(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass;
        switch (item.getItemId()) {
            case R.id.Ihome:
                fragmentClass = Profil.class;
                setTitle("Provinsi Gorontalo");
                break;
            case R.id.Kebudayaan:
                fragmentClass = Kebudayaan.class;
                setTitle("Kebudayaan Gorontalo");
                break;
            case R.id.Pariwisata:
                fragmentClass = Pariwisata.class;
                setTitle("Pariwisata Gorontalo");
                break;
            case R.id.Lagu:
                fragmentClass = Lagu.class;
                setTitle("Lagu Daerah");
                break;
            case R.id.sejarah:
                fragmentClass = Sejarah.class;
                setTitle("Sejarah Gorontalo");
                break;
            case R.id.Visi:
                fragmentClass = Visi.class;
                setTitle("Visi Misi");
                break;
            case R.id.Pemerintahan:
                fragmentClass = Pemerintah.class;
                setTitle("Pemerintahan");
                break;
            case R.id.Ekonomi:
                fragmentClass = Ekonomi.class;
                setTitle("Ekonomi");
                break;
            case R.id.Lambang:
                fragmentClass = Lambang.class;
                setTitle("Lambang Daerah");
                break;
            case R.id.Geografis:
                fragmentClass = Geografis.class;
                setTitle("Geografis & Iklim");
                break;
            case R.id.Tentang:
                fragmentClass = Tentang.class;
                setTitle("Tentang");
                break;
            case R.id.Sumber:
                fragmentClass = Sumber.class;
                setTitle("Sumber");
                break;
            case R.id.Keluar:
                fragmentClass = Profil.class;
                setTitle("Provinsi Gorontalo");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to exit ?")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                HomeActivity.this.finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            default:
                fragmentClass = Profil.class;
                setTitle("Provinsi Gorontalo");
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
        drawerLayout.closeDrawers();
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sejarah) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HomeActivity.this.finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder1.create();
        alertDialog.show();
    }
}
