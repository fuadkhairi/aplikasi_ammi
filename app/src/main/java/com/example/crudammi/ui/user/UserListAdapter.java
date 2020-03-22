package com.example.crudammi.ui.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudammi.api.ItemClickListener;
import com.example.crudammi.R;
import com.example.crudammi.models.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> implements ItemClickListener {

    private List<User> userList;
    private Context context;

    public UserListAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = this.userList.get(position);
        if (user!=null) {
            holder.userNameTV.setText(user.getNama());
            holder.userGenderTV.setText(user.getGender());
            holder.userUmurTV.setText(user.getUmur());
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public void onClick(View view, int position) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView userNameTV;
        TextView userUmurTV;
        TextView userGenderTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameTV =itemView.findViewById(R.id.userName);
            userUmurTV = itemView.findViewById(R.id.userUmur);
            userGenderTV = itemView.findViewById(R.id.userGender);


        }
    }
}
