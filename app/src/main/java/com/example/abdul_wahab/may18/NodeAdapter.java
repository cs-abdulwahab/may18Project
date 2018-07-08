package com.example.abdul_wahab.may18;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class NodeAdapter extends RecyclerView.Adapter<NodeAdapter.VH> {

    private static final String TAG = "MTAG";
    private List<Node> nodeList;

    public NodeAdapter(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_view, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "recycler onClick: ");
            }
        });

        VH viewholder = new VH(v);




        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {


        final Node node = nodeList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick() called with: view = [" + view + "]" + node.getName());
            }
        });

        holder.txtName.setText(node.getName());
        holder.txtURL.setText(node.getUrl());
        holder.btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "button onClick: " + node.getName());

            }
        });

    }

    @Override
    public int getItemCount() {
        return nodeList.size();
    }

    class VH extends RecyclerView.ViewHolder {

        // ImageView imgView;
        TextView txtName;
        TextView txtURL;
        Button btnCard;

        public VH(View itemView) {
            super(itemView);


            txtName = itemView.findViewById(R.id.txtName);
            txtURL = itemView.findViewById(R.id.txtURL);
            btnCard = itemView.findViewById(R.id.btnCard);

        }

    }

    interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }
}