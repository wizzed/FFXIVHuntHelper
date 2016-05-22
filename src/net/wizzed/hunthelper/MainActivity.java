package net.wizzed.hunthelper;

import java.io.IOException;
import java.util.ArrayList;

import net.wizzed.hunthelper.model.Mob;
import net.wizzed.hunthelper.model.Name;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

	private SharedPreferences sharedPref;
	private AutoCompleteTextView actv;
	private ListView lv;
	private TextView tv;

	private ArrayList<Mob> selectedMobNames;
	private MobArrayAdapter selectedMobsAdapter;
	private MobArrayAdapter allMobsAdapter;
	private MenuItem hide_mob;
	private MenuItem menu_lang;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sharedPref = getSharedPreferences(C.PREF_NAME, Context.MODE_PRIVATE);

		setTitle(getResources().getString(R.string.app_name) + " " + Name.getStringName(sharedPref.getInt(C.LANG, 0)));


		C.setupMobsAndMaps(getApplicationContext());

		actv = (AutoCompleteTextView) findViewById(R.id.acTextViewMobName);
		OnItemClickListener otcl = new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int position, long id) {
				Mob selected = (Mob) parent.getItemAtPosition(position);
				actv.setText("");
				boolean found = false;
				for (Mob m : selectedMobNames) {
					if (m.equals(selected)) {
						found = true;
						break;
					}
				}

				if (!found) {
					selectedMobNames.add(0, selected);
					selectedMobsAdapter.notifyDataSetChanged();
					allMobsAdapter.notifyDataSetChanged();
					Toast.makeText(getApplicationContext(), selected.name.getName(sharedPref.getInt(C.LANG, 0)) + " is added to list", Toast.LENGTH_SHORT).show();
					tv.setText("(" + selectedMobNames.size() + ")  Selected Mobs (Hold to remove)");
					saveMob();
				} else {
					Toast.makeText(getApplicationContext(), selected.name.getName(sharedPref.getInt(C.LANG, 0)) + " is already in the list", Toast.LENGTH_SHORT).show();

				}
			}
		};
		actv.setOnItemClickListener(otcl);

		lv = (ListView) findViewById(R.id.selectMobListView);
		tv = (TextView) findViewById(R.id.textView1);

		try {
			selectedMobNames = (ArrayList<Mob>) ObjectSerializer.deserialize(sharedPref.getString(C.MOB_NAMES, ObjectSerializer.serialize(new ArrayList<Mob>())));
		} catch (IOException e) {
			selectedMobNames = new ArrayList<Mob>();
		}

		tv.setText("(" + selectedMobNames.size() + ")  Selected Mobs (Hold to remove)");

		selectedMobsAdapter = new MobArrayAdapter(this, selectedMobNames, sharedPref.getInt(C.LANG, 0));
		lv.setAdapter(selectedMobsAdapter);

		allMobsAdapter = new MobArrayAdapter(this, (ArrayList<Mob>) C.mobList.clone(), sharedPref.getInt(C.LANG, 0));
		actv.setAdapter(allMobsAdapter);
		actv.setThreshold(1);
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View arg1, int position, long id) {
				Mob selected = (Mob) parent.getItemAtPosition(position);
				selectedMobNames.remove(selected);
				allMobsAdapter.notifyDataSetChanged();
				selectedMobsAdapter.notifyDataSetChanged();
				tv.setText("(" + selectedMobNames.size() + ")  Selected Mobs (Hold to remove)");
				Toast.makeText(getApplicationContext(), selected.name.getName(sharedPref.getInt(C.LANG, 0)) + " is removed from list", Toast.LENGTH_SHORT).show();
				saveMob();
				return true;
			}
		});

		Button btn_next = (Button) findViewById(R.id.btnToMap);
		btn_next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (selectedMobNames.size() == 0) {
					Toast.makeText(getApplicationContext(), "Select at least one mob", Toast.LENGTH_SHORT).show();
				} else {
					Intent intent = new Intent(MainActivity.this, MapActivity.class);
					try {
						intent.putExtra("selectedMobNames", ObjectSerializer.serialize(selectedMobNames));
					} catch (IOException e) {
						e.printStackTrace();
					}
					intent.putExtra("hide_mob", hide_mob.isChecked());
					startActivity(intent);
				}
			}
		});

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						C.setupMobsAndMaps(getApplicationContext());
					}
				});
			}
		}, 2000);

	}

	public void saveMob() {
		try {
			Editor editor = sharedPref.edit();
			editor.putString(C.MOB_NAMES, ObjectSerializer.serialize(selectedMobNames));
			editor.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (getApplicationContext() != null) {
			C.setupMobsAndMaps(getApplicationContext());
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		hide_mob = (MenuItem) menu.findItem(R.id.hide_mob);
		boolean saved_check = sharedPref.getBoolean(C.HIDE_MOBS, false);
		hide_mob.setChecked(saved_check);

		menu_lang = (MenuItem) menu.findItem(R.id.lang);
		int saved_lang = sharedPref.getInt(C.LANG, 0);
		menu_lang.setTitle(Name.getStringName(saved_lang));

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		if (id == R.id.hide_mob) {
			item.setChecked(!item.isChecked());

			Editor editor = sharedPref.edit();
			editor.putBoolean(C.HIDE_MOBS, item.isChecked());
			editor.commit();
		}
		if (id == R.id.clear_all) {
			this.selectedMobNames.clear();
			selectedMobsAdapter.notifyDataSetChanged();
			tv.setText("(" + selectedMobNames.size() + ")  Selected Mobs (Hold to remove)");
			Toast.makeText(getApplicationContext(), "List cleared", Toast.LENGTH_SHORT).show();
			saveMob();
		}
		if (id == R.id.lang) {
			int currentLang = sharedPref.getInt(C.LANG, 0);
			currentLang += 1;
			currentLang = currentLang % 4;

			item.setTitle(Name.getStringName(currentLang));
			selectedMobsAdapter.changeLang(currentLang);
			allMobsAdapter.changeLang(currentLang);
			selectedMobsAdapter.notifyDataSetChanged();
			allMobsAdapter.notifyDataSetChanged();

			setTitle(getResources().getString(R.string.app_name) + " " + Name.getStringName(currentLang));

			Editor editor = sharedPref.edit();
			editor.putInt(C.LANG, currentLang);
			editor.commit();
		}
		return super.onOptionsItemSelected(item);
	}
}
