package com.e.salon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CusAdapter extends RecyclerView.Adapter<CusAdapter.Holder>{

    private Context context;
    private ArrayList<CusModel> arrayList;

    CusDatabaseHelper cusDatabaseHelper;

    public CusAdapter(Context context, ArrayList<CusModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

        cusDatabaseHelper = new CusDatabaseHelper(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cusrow, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {

        // get for views
        CusModel cusModel = arrayList.get(position);
        final String id = cusModel.getId();
        final String image = cusModel.getImage();
        final String fname = cusModel.getFname();
        final String lname = cusModel.getLname();
        final String nic = cusModel.getNic();
        final String cnumber = cusModel.getCnumber();
        final String email = cusModel.getEmail();
        final String password = cusModel.getPassword();
        final String cpassword = cusModel.getCpassword();
        final String addTimeStamp = cusModel.getAddTimeStamp();
        final String updateTimeStamp = cusModel.getUpdateTimeStamp();

        // set data
        holder.profileIv.setImageURI(Uri.parse(image));
        holder.fname.setText(fname);
        holder.lname.setText(lname);
        holder.nic.setText(nic);
        holder.cnumber.setText(cnumber);
        holder.email.setText(email);
        holder.password.setText(password);
        holder.cpassword.setText(cpassword);



        // handle item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // handle when click on more button
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDialog(
                        ""+position,
                        ""+id,
                        ""+fname,
                        ""+lname,
                        ""+nic,
                        ""+cnumber,
                        ""+email,
                      ""+password,
                        ""+cpassword,
                        ""+image,
                        ""+addTimeStamp,
                        ""+updateTimeStamp


                );
            }
        });

        holder.deleteButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteDialog(""+id);
                return false;
            }
        });

    }

    private void deleteDialog(final String id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.ic_action_delete);
        builder.setCancelable(false);
        builder.setTitle("Delete");
        builder.setMessage("Are you want to delete?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cusDatabaseHelper.deleteInfo(id);
                ((CusMainActivity)context).onResume();
                Toast.makeText(context, "Delete Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.create().show();
    }

    private void editDialog(String position, final String id, final String fname, final String lname, final String nic ,final String cnumber , final String email ,final String password,final String cpassword,final String image, final String addTimeStamp, final String updateTimeStamp) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.ic_action_edit);
        builder.setCancelable(false);
        builder.setTitle("Edit");
        builder.setMessage("Are you want to edit?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(context, CusEditRecordActivity.class);
                intent.putExtra("ID", id);
                intent.putExtra("FNAME", fname);
                intent.putExtra("LNAME", lname);
                intent.putExtra("NIC", nic);
                intent.putExtra("CNUMBER",cnumber);
                intent.putExtra("EMAIL",email);
                intent.putExtra("PASSWORD",password);
                intent.putExtra("CPASSWORD",cpassword);
                intent.putExtra("IMAGE", image);
                intent.putExtra("ADD_TIMESTAMP", addTimeStamp);
                intent.putExtra("UPDATE_TIMESTAMP", updateTimeStamp);
                intent.putExtra("editMode", true);
                context.startActivity(intent);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.create().show();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView profileIv;
        TextView fname, lname, nic, cnumber, email,password,cpassword;
        ImageButton editButton,deleteButton;

        public Holder(@NonNull View itemView) {
            super(itemView);

            // initialize views
            profileIv = itemView.findViewById(R.id.profileIv);
            fname = itemView.findViewById(R.id.fname);
            lname = itemView.findViewById(R.id.lname);
            nic = itemView.findViewById(R.id.nic);
            cnumber = itemView.findViewById(R.id.cnumber);
            email = itemView.findViewById(R.id.email);
            password = itemView.findViewById(R.id.password);
            cpassword = itemView.findViewById(R.id.cpassword);
            // find id of more button
            editButton = itemView.findViewById(R.id.editBtn);
            deleteButton = itemView.findViewById(R.id.deleteBtn);
        }
    }
}
