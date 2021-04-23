

package com.ryanhansenwilliam.usersapi;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ryanhansenwilliam.usersapi.model.User;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<User> dataList;
    private Context context;

    public CustomAdapter(Context context, List<User> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        private TextView id;
        private TextView name;
        private TextView username;
        private TextView email;

        private LinearLayout userContainer;
        private TextView usernameHeader;
        private TextView emailHeader;

        CustomViewHolder(View itemView){
            super(itemView);
            mView       = itemView;
            id          = mView.findViewById(R.id.id);
            name        = mView.findViewById(R.id.name);
            username    = mView.findViewById(R.id.username);
            email       = mView.findViewById(R.id.email);

            userContainer = mView.findViewById(R.id.userContainer);
            usernameHeader = mView.findViewById(R.id.usernameHeader);
            emailHeader = mView.findViewById(R.id.emailHeader);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.CustomViewHolder holder, int position) {
        holder.id.setText(dataList.get(position).getId());
        holder.name.setText(dataList.get(position).getName());
        holder.username.setText(dataList.get(position).getUsername());
        holder.email.setText(dataList.get(position).getEmail());

        holder.userContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visible = holder.username.getVisibility();
                if(visible == View.GONE){
                    holder.usernameHeader.setVisibility(View.VISIBLE);
                    holder.emailHeader.setVisibility(View.VISIBLE);
                    holder.username.setVisibility(View.VISIBLE);
                    holder.email.setVisibility(View.VISIBLE);
                }
                else{
                    holder.usernameHeader.setVisibility(View.GONE);
                    holder.emailHeader.setVisibility(View.GONE);
                    holder.username.setVisibility(View.GONE);
                    holder.email.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
