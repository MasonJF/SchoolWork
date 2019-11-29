package com.example.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.intents.database.DataBaseContent;
import com.example.intents.database.HandleDataBase;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import static com.example.intents.database.DataBaseContent.DATABASE_NAME;
import static com.example.intents.database.DataBaseContent.DATABASE_VERSION;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private static DataBaseContent.ThingItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DataBaseContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            Activity activity = this.getActivity();
            assert activity != null;
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

    public static DataBaseContent.ThingItem getmItem() {
        return mItem;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            Context context = rootView.getContext();
            HandleDataBase dbRaw = new HandleDataBase(context, DATABASE_NAME, null, DATABASE_VERSION);

            ((TextView) rootView.findViewById(R.id.item_detail)).setText(
                    mItem.details + "\n" +
                    "AccessCount: " + mItem.access_Count +
                    "\n" + "Wears a hat: " + mItem.wearsAHat + "\n" +
                    "Last Accessed: " + mItem.date);
            Log.v("Frags_V03", "webpage=" + mItem.webpage);
            Log.v("Frags_V03", "webpage=" + mItem.id);

            dbRaw.incrementAccessCount(mItem);
            dbRaw.setCurrentDate(mItem);

        }

        return rootView;
    }
}
