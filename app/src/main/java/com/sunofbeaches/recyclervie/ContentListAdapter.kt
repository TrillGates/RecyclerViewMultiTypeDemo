package com.sunofbeaches.recyclervie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sunofbeaches.recyclervie.databinding.ItemNoImageBinding
import com.sunofbeaches.recyclervie.databinding.ItemOneImageBinding
import com.sunofbeaches.recyclervie.databinding.ItemThreeImageBinding
import com.sunofbeaches.recyclervie.databinding.ItemTwoImageBinding

class ContentListAdapter : RecyclerView.Adapter<ContentListAdapter.InnerHolder>() {

    private val data = ArrayList<ListItem>()

    companion object {
        const val NONE_IMG: Int = 0
        const val ONE_IMG: Int = 1
        const val TWO_IMG: Int = 2
        const val THREE_IMG: Int = 3
    }

    fun addData(contents: List<ListItem>) {
        data.clear()
        data.addAll(contents)
        notifyDataSetChanged()
    }

    class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position].covers.size) {
            0 -> NONE_IMG
            1 -> ONE_IMG
            2 -> TWO_IMG
            else -> THREE_IMG
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InnerHolder {
        val itemView: View
        when (viewType) {
            NONE_IMG -> {
                val itemBind = DataBindingUtil.inflate<ItemNoImageBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_no_image,
                    parent,
                    false
                )
                itemView = itemBind.root
                itemView.tag = itemBind
            }
            ONE_IMG -> {
                val itemBind = DataBindingUtil.inflate<ItemOneImageBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_one_image,
                    parent,
                    false
                )
                itemView = itemBind.root
                itemView.tag = itemBind
            }
            TWO_IMG -> {
                val itemBind = DataBindingUtil.inflate<ItemTwoImageBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_two_image,
                    parent,
                    false
                )
                itemView = itemBind.root
                itemView.tag = itemBind
            }
            else -> {
                val itemBind = DataBindingUtil.inflate<ItemThreeImageBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_three_image,
                    parent,
                    false
                )
                itemView = itemBind.root
                itemView.tag = itemBind
            }
        }


        return InnerHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        val dataBinding = holder.itemView.tag
        val data = data[position]
        when (dataBinding) {
            is ItemNoImageBinding -> {
                dataBinding.item = data
            }
            is ItemOneImageBinding -> {
                dataBinding.item = data
            }
            is ItemTwoImageBinding -> {
                dataBinding.item = data
            }
            is ItemThreeImageBinding -> {
                dataBinding.item = data
            }
        }
    }
}