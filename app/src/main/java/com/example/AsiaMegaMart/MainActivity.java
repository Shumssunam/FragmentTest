package com.example.AsiaMegaMart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.view.Menu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.AsiaMegaMart.ui.CategoriesFragment;
import com.example.AsiaMegaMart.ui.dashboard.AccountFragment;

import com.example.AsiaMegaMart.ui.cart.CartFragment;
import com.example.AsiaMegaMart.ui.conditionsterms.ConditionsAndTermsFragment;
import com.example.AsiaMegaMart.ui.contactus.ContactUsFragment;
import com.example.AsiaMegaMart.ui.home.HomeFragment;
import com.example.AsiaMegaMart.ui.order.OrderFragment;
import com.example.AsiaMegaMart.ui.wishlist.WishListFragment;
import com.example.AsiaMegaMart.utils.ConstantResources;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        HomeFragment.homeFragmentClickListener {
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private SearchView searchView;
    private NavigationView navigationView;


    private Fragment selectedFragment;
    private String tag;

    private MeowBottomNavigation meowBottomNavigation;
    private final static int ID_HOME = 1;
    private final static int WISH_LIST = 2;
    private final static int CART = 3;
    private final static int ACCOUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayoutId);
        navigationView = findViewById(R.id.navigation_drawer);
        meowBottomNavigation = findViewById(R.id.bottomNav);


        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragments();


        meowBottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_outline_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(WISH_LIST, R.drawable.ic_outline_favorite));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(CART, R.drawable.ic_outline_shopping_cart));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(ACCOUNT, R.drawable.ic_outline_account_circle));


        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
                                                        @Override
                                                        public void onClickItem(MeowBottomNavigation.Model item) {
                                                            switch (item.getId()) {
                                                                case ID_HOME:
                                                                    selectedFragment = new HomeFragment(MainActivity.this);
                                                                    tag = ConstantResources.HOME_FRAGMENT;
                                                                    toolbar.setTitle("Home");
                                                                    loadFragments();
                                                                    break;
                                                                case WISH_LIST:
                                                                    selectedFragment = new WishListFragment();
                                                                    tag = ConstantResources.WISHLIST_FRAGMENT;
                                                                    toolbar.setTitle("My WishList");
                                                                    loadFragments();
                                                                    break;
                                                                case CART:
                                                                    selectedFragment = new CartFragment();
                                                                    tag = ConstantResources.CART_FRAGMENT;
                                                                    toolbar.setTitle("My Cart");
                                                                    loadFragments();
                                                                    break;
                                                                case ACCOUNT:
                                                                    selectedFragment = new AccountFragment();
                                                                    tag = ConstantResources.ACCOUNT_FRAGMENT;
                                                                    toolbar.setTitle("Account");
                                                                    loadFragments();
                                                                    break;

                                                            }


                                                        }

                                                    }
        );
        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                // your codes


            }

        });
        meowBottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                // your codes
                switch (item.getId()) {
                    case ID_HOME:
                        selectedFragment = new HomeFragment(MainActivity.this);
                        tag = ConstantResources.HOME_FRAGMENT;
                        toolbar.setTitle("Home");
                        loadFragments();
                        break;
                }

            }
        });
        meowBottomNavigation.show(ID_HOME, true);

    }

    //common loadFragments method
    private boolean loadFragments() {
        if (selectedFragment != null) {
            if (tag.equals(ConstantResources.HOME_FRAGMENT))
                toolbar.setVisibility(View.VISIBLE);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        } else {
            selectedFragment = new HomeFragment(MainActivity.this);
            tag = ConstantResources.HOME_FRAGMENT;
            loadFragments();
        }
        return false;
    }

    //for Drawer Navigation
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home1:
                selectedFragment = new HomeFragment(MainActivity.this);
                toolbar.setTitle("Home");
                break;
            case R.id.nav_account1:
                selectedFragment = new AccountFragment();
                toolbar.setTitle("Account");

                break;
            case R.id.nav_order1:
                selectedFragment = new OrderFragment();
                break;
            case R.id.nav_cart1:
                selectedFragment = new CartFragment();
                toolbar.setTitle("My Cart");
                break;
            case R.id.nav_wishlist1:
                selectedFragment = new WishListFragment();
                toolbar.setTitle("My WishList");
                break;
            case R.id.nav_contact:
                selectedFragment = new ContactUsFragment();
                toolbar.setTitle("Contact Us");
                break;
            case R.id.nav_conditions:
                selectedFragment = new ConditionsAndTermsFragment();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return loadFragments();
    }

    //For Search menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("What would you like to buy?");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void homeToCategory() {
        selectedFragment = new CategoriesFragment();
        tag = ConstantResources.CATEGORY_FRAGMENT;
        toolbar.setTitle("Category");
        loadFragments();
    }

    public void homeToOrder() {
        selectedFragment = new OrderFragment();
        tag = ConstantResources.ORDER_FRAGMENT;
        toolbar.setTitle("Order List");
        loadFragments();
    }



}
