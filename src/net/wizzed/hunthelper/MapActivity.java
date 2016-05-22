package net.wizzed.hunthelper;

import java.io.IOException;
import java.util.ArrayList;

import net.wizzed.hunthelper.model.Map;
import net.wizzed.hunthelper.model.Mob;
import net.wizzed.hunthelper.model.Name;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MapActivity extends Activity {

	int currentMapIndex = 0;
	ArrayList<Mob> selectedMobNames = new ArrayList<Mob>();
	TouchImageView image;
	Bitmap b;
	BitmapFactory.Options opt;
	TextView txt_num_of_mobs;
	TextView txt_current_map;
	int mapSize;

	boolean hide_mob = false;

	int DIRECTION_NEXT = 1;
	int DIRECTION_PREV = 2;

	private SharedPreferences sharedPref;

	int currentLang = Name.EN;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		mapSize = Math.min(width, height);
		sharedPref = getSharedPreferences(C.PREF_NAME, Context.MODE_PRIVATE);
		currentLang = sharedPref.getInt(C.LANG, 0);
		Intent i = getIntent();
		try {
			selectedMobNames = (ArrayList<Mob>) ObjectSerializer.deserialize(i.getExtras().getString("selectedMobNames"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		hide_mob = i.getExtras().getBoolean("hide_mob");

		image = (TouchImageView) findViewById(R.id.imgMap);
		Button btn_prev_map = (Button) findViewById(R.id.btn_prev_map);
		Button btn_next_map = (Button) findViewById(R.id.btn_next_map);

		opt = new BitmapFactory.Options();
		opt.inMutable = true;
		txt_num_of_mobs = (TextView) findViewById(R.id.txt_num_of_mobs);
		txt_current_map = (TextView) findViewById(R.id.txt_current_map);
		btn_prev_map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				currentMapIndex -= 1;
				if (currentMapIndex < 0) {
					currentMapIndex = C.mapList.size() - 1;
				}

				toMap(currentMapIndex, DIRECTION_PREV);
			}
		});

		btn_next_map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				currentMapIndex = (currentMapIndex + 1) % C.mapList.size();
				toMap(currentMapIndex, DIRECTION_NEXT);
			}
		});

		toMap(0, DIRECTION_NEXT);
	}

	public void toMap(int mapIndex, int direction) {
		Map currentMap = C.mapList.get(mapIndex);
		int count = 0;

		for (int i = 0; i < selectedMobNames.size(); i++) {
			Mob selectedMobName = selectedMobNames.get(i);
			for (Mob m : C.mobList) {
				if (m.equals(selectedMobName) && m.map.equals(currentMap.name)) {
					count++;
				}
			}
		}

		if (count == 0 && hide_mob) {
			if (direction == DIRECTION_NEXT)
				mapIndex = (mapIndex + 1) % C.mapList.size();

			if (direction == DIRECTION_PREV) {
				mapIndex -= 1;
				if (mapIndex < 0) {
					mapIndex = C.mapList.size() - 1;
				}
			}

			currentMapIndex = mapIndex;
			toMap(mapIndex, direction);
		}

		else {
			if (b != null)
				b.recycle();

			b = decodeSampledBitmapFromResource(getResources(), currentMap.mapId, mapSize, mapSize);
			// b = Bitmap.createScaledBitmap(currentMap.map, mapSize, mapSize,
			// true);
			// opt.inJustDecodeBounds = true;
			// int imageHeight = opt.outHeight;
			// int imageWidth = opt.outWidth;
			// String imageType = opt.outMimeType;

			double height = b.getHeight() / 43;
			double width = b.getWidth() / 43;
			Canvas c = new Canvas(b);
			Paint strokePaint = new Paint();
			strokePaint.setTextSize(65);
			strokePaint.setAntiAlias(true);
			strokePaint.setStrokeWidth(2);

			strokePaint.setColor(Color.DKGRAY);
			strokePaint.setStyle(Style.STROKE);
			strokePaint.setTypeface(Typeface.SERIF);

			Paint fillPaint = new Paint();
			fillPaint.setTextSize(65);
			fillPaint.setAntiAlias(true);
			fillPaint.setColor(Color.BLUE);
			fillPaint.setStyle(Style.FILL);
			fillPaint.setTypeface(Typeface.SERIF);

			Paint grayPaint = new Paint();
			grayPaint.setTextSize(60);
			grayPaint.setAntiAlias(true);
			grayPaint.setStyle(Style.FILL_AND_STROKE);
			grayPaint.setTypeface(Typeface.SERIF);
			grayPaint.setColor(Color.GRAY);
			grayPaint.setAlpha(200);

			for (int i = 0; i < selectedMobNames.size(); i++) {
				Mob selectedMobName = selectedMobNames.get(i);
				for (Mob m : C.mobList) {
					if (m.equals(selectedMobName) && m.map.equals(currentMap.name)) {
						c.drawCircle((float) (height * m.location.x), (float) (width * m.location.y), 20, fillPaint);
						c.drawCircle((float) (height * m.location.x), (float) (width * m.location.y), 20, strokePaint);

						c.drawText(m.numberRequired + " " + m.name.getName(currentLang), (float) (height * m.location.x + 20), (float) (width * m.location.y + 20), fillPaint);
						c.drawText(m.numberRequired + " " + m.name.getName(currentLang), (float) (height * m.location.x + 20), (float) (width * m.location.y + 20), strokePaint);

					} else if (m.map.equals(currentMap.name)) {
						// c.drawCircle((float) (height * m.location.x), (float)
						// (width * m.location.y), 20, grayPaint);
						// c.drawText(m.name, (float) (height * m.location.x +
						// 20),
						// (float) (width * m.location.y + 20), grayPaint);
					}
				}
			}
			txt_num_of_mobs.setText(count + " mobs found");
			txt_current_map.setText(currentMap.name);
			image.setImageBitmap(b);
			image.resetZoom();
		}
	}

	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
		options.inMutable = true;
		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and
			// keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
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
}
