package net.wizzed.hunthelper.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Map {
	public int mapId;
	public String name;

//	public Bitmap map;

	public Map(Context ctx, String name, int mapId) {
		this.mapId = mapId;
		this.name = name;
//		BitmapFactory.Options opt = new BitmapFactory.Options();
//		opt.inMutable = true;
//		this.map = BitmapFactory.decodeResource(ctx.getResources(), mapId, opt);
	}
}
