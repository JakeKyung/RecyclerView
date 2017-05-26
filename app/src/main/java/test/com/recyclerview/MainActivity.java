package test.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

/**
 * Created by Jake on 2017-05-25.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //Model ArrayList Dataset
    private ArrayList<Model> Dataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        // setAutoMeasureEnabled function is ChildView auto size control # !!! Child view Layout wrap_content fixed !!! #
        mLayoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new Adapter(Dataset);

        // Adapter Set
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Data Load
        loadAddressList();
    }

    public void loadAddressList() {
        Dataset.add(new Model("#puppy",R.drawable.puppy));
        Dataset.add(new Model("#car",R.drawable.car));
        Dataset.add(new Model("#beer",R.drawable.beer));
        Dataset.add(new Model("#fox",R.drawable.fox));
    }
}
