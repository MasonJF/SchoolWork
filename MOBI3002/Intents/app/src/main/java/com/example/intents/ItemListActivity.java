package com.example.intents;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intents.database.DataBaseContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

//import com.example.mobipart2.database.DataBaseContent;

//import android.widget.Toolbar;
//import com.example.russ.save_v02.db.DataBaseContent;
//import com.example.russ.save_v02.dummy.DummyContent;

/**
 * An activity representing a list of animals. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {
//    public static HandleDataBase dbRaw;
//    public HandleDataBase dbRaw = new HandleDataBase(this, DATABASE_NAME, null, DATABASE_VERSION);

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    // DB connection class
    private DataBaseContent db;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("handleDB", "animalListActivity onCreate()");

        // Connect to DB first, because data is needed for recyclerView
        // otherwise, db object is null during recyclerView setup and fails
        // Connect to DB ... move this to background task later but
        // be mindful of the order these tasks are done.
        db = new DataBaseContent(this);

        // Log it all...verify static and dynamic both work
        // Original sample used static, but no need to keep it that way.
        Log.v("onCreate", "data_is_set=" + db.data_is_set);
        Log.v("onCreate", "static ITEMS=" + DataBaseContent.ITEMS.toString());
        Log.v("onCreate", "static ITEM_MAP=" + DataBaseContent.ITEM_MAP.toString());
        Log.v("onCreate", "ITEM_MAP=" + db.getITEM_MAP().toString());

        ///////////////////// back to stock code for fragment setup
        setContentView(R.layout.activity_item_list);
//
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

//         Floating email sign that says "replace..." when selected
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replaced with my own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // Set the animal list
        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        // Set the details...if exists
        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        if (DataBaseContent.ITEMS == null) {
            Log.v("setupRecyclerView", "items=null data_is_set=" + db.data_is_set);
        } else {
            Log.v("setupRecyclerView", DataBaseContent.ITEMS.toString());
        }
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DataBaseContent.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DataBaseContent.ThingItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<DataBaseContent.ThingItem> items) {
            if (items == null) {
                Log.v("SimpleIte...dapter", "items=null");
            } else {
                Log.v("SimpleIte...dapter", items.toString());
            }
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).id.toString());
            holder.mContentView.setText(mValues.get(position).name);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id.toString());
                        ItemDetailFragment fragment = new ItemDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.item_detail_container, fragment)
                                .commit();
                        Log.v("onBindViewHolder", "2 panes");


                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, ItemDetailActivity.class);
                        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id.toString());
                        context.startActivity(intent);
                        Log.v("onBindViewHolder", "1 pane");
                    }
                }
            });
        }



        @Override
        public int getItemCount() {

            return db.getSize();
            //return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public DataBaseContent.ThingItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}