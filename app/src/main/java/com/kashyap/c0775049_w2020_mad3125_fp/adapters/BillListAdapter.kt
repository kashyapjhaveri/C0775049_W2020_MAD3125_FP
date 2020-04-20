package com.kashyap.c0775049_w2020_mad3125_fp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kashyap.c0775049_w2020_mad3125_fp.R
import com.kashyap.c0775049_w2020_mad3125_fp.dataRepo.DataRepo
import com.kashyap.c0775049_w2020_mad3125_fp.models.bill.Mobile
import com.kashyap.c0775049_w2020_mad3125_fp.models.customer.Customer
import kotlinx.android.synthetic.main.item_bill.view.*

class BillListAdapter(val customer : Customer) : RecyclerView.Adapter<BillListAdapter.BillListViewHolder>() {

    override fun getItemCount(): Int {
        return customer.bills.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillListViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_bill,parent,false)
        return BillListViewHolder(mView)
    }

    override fun onBindViewHolder(holder: BillListViewHolder, position: Int) {
        val bill = customer.bills[position]
        holder.itemView.textViewBillType.text = bill.billType
        holder.itemView.textViewBillDate.text = bill.billDate;
        holder.itemView.textViewTotalAmount.text = bill.totalFormattedAmount
    }

    class BillListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageViewBill = itemView.imageViewBill
        var textViewBillType = itemView.textViewBillType
        var textViewBillDate = itemView.textViewBillDate
        var textViewTotalAmount = itemView.textViewTotalAmount
    }
}