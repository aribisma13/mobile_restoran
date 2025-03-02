package com.example.uts_210020006

data class DataMenu(
    val id: Int,           // ID unik untuk setiap item
    val menuName: String,  // Nama menu
    val year: String,      // Tahun (opsional, digunakan pada contoh sebelumnya)
    val imageResource: Int // Resource ID untuk gambar
) {
    companion object {
        fun menuList(): ArrayList<DataMenu> {
            return arrayListOf(
                DataMenu(1, "Soto Ayam", "2023", R.drawable.soto_ayam),
                DataMenu(2, "Rendang Sapi", "2019", R.drawable.rendang_sapi),
                DataMenu(3, "Nasi Goreng", "2024", R.drawable.nasi_goreng),
                DataMenu(4, "Nasi Campur", "2003", R.drawable.nasi_campur),
                DataMenu(5, "Mie Ramen", "2004", R.drawable.mie_ramen),
                DataMenu(6, "Kepeting Laut", "2009", R.drawable.kepeting_laut)
            )
        }
    }
}

