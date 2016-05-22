package net.wizzed.hunthelper;

import java.util.ArrayList;

import net.wizzed.hunthelper.model.Mob;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class MobArrayAdapter extends ArrayAdapter<Mob> implements Filterable {
	private final Context context;
	private ArrayList<Mob> originalValues;
	private ArrayList<Mob> suggestions;
	private ArrayList<Mob> fullList;

	private int lang;

	@SuppressWarnings("unchecked")
	public MobArrayAdapter(Context context, ArrayList<Mob> values, int lang) {
		super(context, -1, values);
		this.context = context;

		this.originalValues = (ArrayList<Mob>) values.clone();
		this.fullList = values;
		this.lang = lang;
		suggestions = new ArrayList<Mob>();

	}

	public void changeLang(int lang) {
		this.lang = lang;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Holder h = new Holder();
		if (convertView == null) {
			View rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
			h.textView = (TextView) rowView.findViewById(android.R.id.text1);
			rowView.setTag(h);
			convertView = rowView;
		} else {
			h = (Holder) convertView.getTag();
		}
		h.textView.setText(fullList.get(position).name.getName(lang));
		return convertView;

	}

	@Override
	public void add(Mob object) {
		super.add(object);
//		fullList.add(object);
		// originalValues.add(object);
	}

	@Override
	public void clear() {
		super.clear();
		fullList.clear();
		// originalValues.clear();
	}

	@Override
	public int getCount() {
		return fullList.size();
	}

	@Override
	public Mob getItem(int position) {
		return fullList.get(position);
	}

	private ArrayFilter mFilter;

	@Override
	public Filter getFilter() {
		if (mFilter == null) {
			mFilter = new ArrayFilter();
		}
		return mFilter;
	}

	private class ArrayFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			if (constraint != null) {
				suggestions.clear();
				for (Mob mob : originalValues) {
					if (mob.name.getName(lang).toLowerCase().startsWith(constraint.toString().toLowerCase())) {
						suggestions.add(mob);
					}

				}
				FilterResults filterResults = new FilterResults();
				filterResults.values = suggestions;

				filterResults.count = suggestions.size();
				return filterResults;
			} else {
				return new FilterResults();
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			ArrayList<Mob> filteredList = (ArrayList<Mob>) results.values;
			if (results != null && results.count > 0) {
				clear();
				for (Mob c : filteredList) {
					add(c);
				}
				
				notifyDataSetChanged();
			}
		}
	}

	public class Holder {
		TextView textView;
	}
}
