package com.example.abdul_wahab.may18;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NodeAdapter extends RecyclerView.Adapter<NodeAdapter.VH> {

    private List<Node> nodeList;

    public NodeAdapter(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_view, parent, false);
        VH viewholder = new VH(v);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {


        Node node = nodeList.get(position);

        holder.txtName.setText(node.getName());
        holder.txtURL.setText(node.getUrl());


    }

    @Override
    public int getItemCount() {
        return nodeList.size();
    }

    class VH extends RecyclerView.ViewHolder {

        // ImageView imgView;
        TextView txtName;
        TextView txtURL;

        public VH(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtURL = itemView.findViewById(R.id.txtURL);

        }


    }

}
