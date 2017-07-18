package next.shag.edu.filemanager;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Fragment1 extends Fragment {

    private TabHost th;
    private TabHost.TabSpec ts;
    private ListView lvInnerMemoryFirstTab, lvSDCardFirstTab;
    public static final String KEY = "TE";
    private ArrayList<String> als;
    private ArrayList<String> alst;
    private String pa;
    private File [] fi;
    private View v;
    private File copyFrom;
    private File copyTo;
    private Button btnBack;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.copy :
                copyFrom = new File(fi[acmi.position].getPath());
                return true;
            case R.id.delete :
                methDelete(acmi.position);
                return true;
            case R.id.past :
                if (!copyFrom.equals(null) || !copyTo.equals(null)) {
                    copyTo = new File(fi[acmi.position].getPath() + "fd");
                    methCopy(copyFrom, copyTo);
                    copyFrom = null;
                    copyTo = null;
                    refresh(v);
                }


                return true;
            default: return super.onContextItemSelected(item);
        }
    }

    private void methDelete(int acmi) {
        fi[acmi].delete();
        refresh(v);
    }
    private static void methCopy(File c, File c1) {
        InputStream is = null;
        OutputStream os = null;
        try{
            try {
                is = new FileInputStream(c);
                os = new FileOutputStream(c1);
            } catch (FileNotFoundException e) {

            }
            byte [] buffer = new byte [1024];
            int lenght;
            try {
                while((lenght = is.read(buffer))>0){
                    os.write(buffer, 0, lenght);
                }
            } catch (IOException e) {
            }
        } finally{
            try {
                is.close();
                os.close();
                //sc.close();
            } catch (IOException e) {
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmetn_fragment1, null);

        th = (TabHost) v.findViewById(R.id.th);
        th.setup();
        ts = th.newTabSpec("tab1");
        ts.setIndicator("Inner memory");
        ts.setContent(R.id.tab1);
        th.addTab(ts);
        ts = th.newTabSpec("tab2");
        ts.setContent(R.id.tab2);
        ts.setIndicator("SD-card");
        th.addTab(ts);

        lvInnerMemoryFirstTab = (ListView) v.findViewById(R.id.lv_inner);
        lvSDCardFirstTab = (ListView) v.findViewById(R.id.lv_sd);
        File f = new File("./data/data/next.shag.edu.filemanager/files");
        File [] files = f.listFiles();
        als = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            als.add(files[i].getName());
        }

        lvInnerMemoryFirstTab.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> aa = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, als);
        lvInnerMemoryFirstTab.setAdapter(aa);

        registerForContextMenu(lvInnerMemoryFirstTab);

        lvInnerMemoryFirstTab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent("android.intent.action.notMain");
                i.putExtra(KEY, "./data/data/next.shag.edu.filemanager/files/" + als.get(position).toString());
                startActivity(i);
            }
        });


        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            alst = new ArrayList<>();
            pa = "./sdcard";
            File ff = new File(pa);
            final File [] filess = ff.listFiles();
            fi = ff.listFiles();
            for (int i = 0; i < filess.length; i++) {
                alst.add(filess[i].getName());
            }
            ArrayAdapter<String> aa2 = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, alst);
            lvSDCardFirstTab.setAdapter(aa2);
            registerForContextMenu(lvSDCardFirstTab);
            lvSDCardFirstTab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (filess[position].isDirectory()) {
                        pa += "/" + filess[position].getName();
                        refresh(v);
                    } else {
                        Intent i = new Intent("android.intent.action.notMain");
                        i.putExtra(KEY, pa + "/" + alst.get(position).toString());
                        startActivity(i);
                    }

                }
            });
        } else {
            Toast.makeText(v.getContext(), "SD-card not set", Toast.LENGTH_SHORT).show();
        }
        btnBack = (Button) v.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pa = "./sdcard";
                refresh(v);
            }
        });


        return v;
    }

    private void refresh(View v) {
        alst = new ArrayList<>();
        File ff = new File(pa);
        final File [] filess = ff.listFiles();
        for (int i = 0; i < filess.length; i++) {
            alst.add(filess[i].getName());
        }
        ArrayAdapter<String> aa2 = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, alst);
        lvSDCardFirstTab.setAdapter(aa2);
        registerForContextMenu(lvSDCardFirstTab);
    }


}
