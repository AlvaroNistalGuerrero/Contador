//package com.example.contador;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//
//import java.util.List;
//
//public class Centros extends ArrayAdapter<String> {
//
//    private final List<String> centros;
//    public Centros(@NonNull Context context, int resource, @NonNull List<String> objects){
//        super(context, resource, objects);
//        centros = objects;
//
//    }
//    @NonNull
//    @Override
//    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
//        if(convertView == null)
//            convertView = LayoutInflater.from(this.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
//            ((TextView) convertView).setText(getItem(position));
//            return convertView;
//    }
//    public void remove(int position){
//        centros.remove(position);
//        notifyDataSetChanged();
//    }
//    public void editar(int position){
//        centros.add(position, String.format("%s%s", centros.remove(position), " (editado)"));
//        notifyDataSetChanged();
//    }
//
//}
