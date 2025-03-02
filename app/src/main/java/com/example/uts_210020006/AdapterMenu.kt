package com.example.uts_210020006

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMenu(
    private val context: Context,
    private val menuList: List<DataMenu>,
    private val onDetailClick: (DataMenu) -> Unit // Callback untuk tombol Detail
) : RecyclerView.Adapter<AdapterMenu.MenuViewHolder>() {

    // ViewHolder untuk item menu
    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageMenu: ImageView = itemView.findViewById(R.id.imageMenu)
        val textMenuName: TextView = itemView.findViewById(R.id.textMenuName)
        val buttonDetail: Button = itemView.findViewById(R.id.buttonDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_menu_item, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menuList[position]


        // Mengisi data ke item layout
        holder.imageMenu.setImageResource(menuItem.imageResource)
        holder.textMenuName.text = menuItem.menuName

        // Klik pada item untuk membuka DetailMenuActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailMenuActivity::class.java).apply {
                putExtra("extra_menu_id", menuItem.id)
                putExtra("extra_menu_name", menuItem.menuName)
                putExtra("extra_menu_image", menuItem.imageResource)
            }
            context.startActivity(intent)
        }

        // Listener untuk tombol Detail
        holder.buttonDetail.setOnClickListener {
            onDetailClick(menuItem)
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}
