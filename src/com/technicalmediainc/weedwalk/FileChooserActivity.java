package com.technicalmediainc.weedwalk;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class FileChooserActivity extends ListActivity {

	private File currentDir;
	ArrayList<File> fileList = new ArrayList<File>();
	private File mnt;
	private File sd;
	private File removable;
	private FileArrayAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		currentDir = new File("/");
		mnt = new File("/mnt/");
		sd = new File("/sdcard/");
		removable = new File("/Removable/");
		fill(currentDir);
	}
	public void fill() {
		fileList.clear();
		if(mnt.exists()){
			fileList.add(mnt);
		}
		if(removable.exists()){
			fileList.add(removable);
		}
		if(sd.exists()){
			fileList.add(sd);
		}
		this.setTitle("Current Dir: " + "External Storage");
		List<Option> dir = new ArrayList<Option>();
		List<Option> fls = new ArrayList<Option>();
		try {
			for (File ff : fileList) {
				if (ff.isDirectory())
					dir.add(new Option(ff.getName(), "Folder", ff
							.getAbsolutePath()));
				else {
					fls.add(new Option(ff.getName(), "File Size: "
							+ ff.length(), ff.getAbsolutePath()));
				}
			}
		} catch (Exception e) {

		}
		Collections.sort(dir);
		Collections.sort(fls);
		dir.addAll(fls);
		adapter = new FileArrayAdapter(FileChooserActivity.this,
				R.layout.file_view, dir);
		this.setListAdapter(adapter);

	}

	public void fill(File f) {
		File[] dirs = f.listFiles();
		this.setTitle("Current Dir: " + f.getName());
		List<Option> dir = new ArrayList<Option>();
		List<Option> fls = new ArrayList<Option>();
		try {
			for (File ff : dirs) {
				if (ff.isDirectory())
					dir.add(new Option(ff.getName(), "Folder", ff
							.getAbsolutePath()));
				else {
					fls.add(new Option(ff.getName(), "File Size: "
							+ ff.length(), ff.getAbsolutePath()));
				}
			}
		} catch (Exception e) {

		}
		Collections.sort(dir);
		Collections.sort(fls);
		dir.addAll(fls);
		if (!f.getName().equalsIgnoreCase("")){
			dir.add(0, new Option("..", "Parent Directory", f.getParent()));
		adapter = new FileArrayAdapter(FileChooserActivity.this,
				R.layout.file_view, dir);
		this.setListAdapter(adapter);
		}else{
			fill();
		}
		// Button b = (Button) findViewById(R.id.button1);
		// b.setOnClickListener(new View.OnClickListener() {
		// public void onClick(View v) {
		//
		// FileChooserActivity.this.finish();
		// }
		// });

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Option o = adapter.getItem(position);
		if (o.getData().equalsIgnoreCase("folder")
				|| o.getData().equalsIgnoreCase("parent directory")) {
			currentDir = new File(o.getPath());
			fill(currentDir);
		} else {
			onFileClick(o);
		}
	}

	private void onFileClick(Option o) {
		Toast.makeText(this, "File Clicked: " + o.getName(), Toast.LENGTH_SHORT)
				.show();
		GlobalClass.fileDir = new File(o.getPath());
		GlobalClass.fileName = o.getName();
		this.finish();

	}
}
