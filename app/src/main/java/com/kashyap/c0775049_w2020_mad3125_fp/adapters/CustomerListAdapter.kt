package com.kashyap.c0775049_w2020_mad3125_fp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kashyap.c0775049_w2020_mad3125_fp.R
import com.kashyap.c0775049_w2020_mad3125_fp.dataRepo.DataRepo
import com.kashyap.c0775049_w2020_mad3125_fp.ui.ShowBillDetailsActivity
import kotlinx.android.synthetic.main.item_customer.view.*

class CustomerListAdapter : RecyclerView.Adapter<CustomerListAdapter.CustomerListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerListViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_customer,parent,false)
        return CustomerListViewHolder(mView)
    }


    override fun onBindViewHolder(holder: CustomerListViewHolder, position: Int) {
        val customer = DataRepo.getCustomer(position)

        holder.textViewFullName.text = customer.fullName
        holder.textViewTotalAmount.text = "Total Bill Amount:- ${customer.totalFormattedAmount}"

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(holder.imageView.context,ShowBillDetailsActivity::class.java)
            intent.putExtra("selectedCustomer",position)
            holder.itemView.context.startActivity(intent)
        })
    }


    override fun getItemCount(): Int {
        return DataRepo.getAllCustomers().size;
    }

    class CustomerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.imageView
        val textViewFullName = itemView.textViewFullName
        val textViewTotalAmount = itemView.textViewTotalAmount
    }
}