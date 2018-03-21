package com.example.arturmusayelyan.menus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TextView textView;
    private Button contextModeButton;
    private ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        contextModeButton = findViewById(R.id.context_mode_button);

        registerForContextMenu(textView);//for register simple contex menu in certain view

        //for action mode contex menu
        contextModeButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }

                mActionMode = startActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });
    }

    //Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.new_game:
                Toast.makeText(this, "new game worked", Toast.LENGTH_SHORT).show();
                //invalidateOptionsMenu();
                return true;
            case R.id.help:
                Toast.makeText(this, "help worked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(this, "settings worked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.function1:
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                return true;
            case R.id.function2:
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                return true;
            case R.id.function3:
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    //ogtagorcvum e erb vor uzum enq runtime popoxel menuitem-nere
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }


    //contex menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.function1:
                textView.setTextSize(26);
                return true;
            case R.id.function2:
                textView.setTextSize(35);
                return true;
            case R.id.function3:
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    //Enabling the contextual action mode for individual views
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.action_mode_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            switch (item.getItemId()) {
                case R.id.menu_share:
                    Toast.makeText(MainActivity.this, "action mode share worked", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    //Creating a Popup Menu
    //This is not the same as a context menu, which is generally for actions that affect selected content.
    // For actions that affect selected content, use the contextual action mode or floating context menu.
    public void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.move_to:
                Toast.makeText(this, "Move to worked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.change_labels:
                Toast.makeText(this, "Change labels worked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mark_important:
                Toast.makeText(this, "Mark important worked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mute:
                Toast.makeText(this, "Mute worked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.print:
                Toast.makeText(this, "Print worked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.revert_auto_sizing:
                Toast.makeText(this, "Revert auto sizing worked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.report_spam:
                Toast.makeText(this, "Report spam worked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
