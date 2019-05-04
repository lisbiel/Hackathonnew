package com.forcadoodio.meguia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class PerdidosAdapter
        extends ArrayAdapter<PessoaPerdida> {
    private int distance;
    public PerdidosAdapter(Context context, List<PessoaPerdida> perdidas, int distance) {
        super(context, -1, perdidas);
        this.distance = distance;
    }

    private class ViewHolder{
        public TextView nameTextView;
        public TextView distanceTextView;
        public TextView toTextView;
        public TextView fromTextView;

    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null){
            LayoutInflater inflater =
                    LayoutInflater.from(getContext());
            convertView =
                    inflater.
                            inflate(R.layout.list_item,
                                    parent, false);
            vh = new ViewHolder();
            vh.nameTextView =
                    convertView.findViewById(R.id.nameTextView);
            vh.distanceTextView =
                    convertView.findViewById(R.id.distanceTextView);
            vh.toTextView =
                    convertView.findViewById(R.id.toTextView);
            vh.fromTextView =
                    convertView.findViewById(R.id.fromTextView);
            convertView.setTag(vh);
        }
        else{
            //downcasting
            vh = (ViewHolder) convertView.getTag();
        }

        PessoaPerdida caraDaVez = getItem(position);

        vh.nameTextView.setText(caraDaVez.getNome());
        Random r = new Random();
        distance = distance + r.nextInt(200);
        vh.distanceTextView.setText("Dist: "+distance+"m");
        vh.fromTextView.setText("De: "+caraDaVez.getPartida());
        vh.toTextView.setText("Até: " + caraDaVez.getChegada());
        return convertView;
    }
}
