package com.abhishekshah.railconnect;

import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<StudentDetails> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<StudentDetails> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        StudentDetails studentDetails = MainImageUploadInfoList.get(position);

        holder.tone.setText(studentDetails.getTime());
        holder.ttwo.setText(studentDetails.getSource());
        holder.tthree.setText(studentDetails.getDestination());
        holder.tfour.setText(studentDetails.getType());
        holder.tfive.setText(studentDetails.getStatus());
        holder.tsix.setText(studentDetails.getDelay());




    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tone;
        public TextView ttwo;
        public TextView tthree;
        public TextView tfour;
        public TextView tfive;
        public TextView tsix;

        public ViewHolder(View itemView) {

            super(itemView);

            tone = (TextView) itemView.findViewById(R.id.tone);

            ttwo = (TextView) itemView.findViewById(R.id.ttwo);
            tthree = (TextView) itemView.findViewById(R.id.tthree);

            tfour = (TextView) itemView.findViewById(R.id.tfour);
            tfive = (TextView) itemView.findViewById(R.id.tfive);

            tsix = (TextView) itemView.findViewById(R.id.tsix);
        }
    }
}