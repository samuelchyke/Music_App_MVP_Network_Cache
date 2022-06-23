//package com.example.flowersappcat25.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.flowersappcat25.R
//import com.example.flowersappcat25.databinding.FlowerItemBinding
//import com.example.flowersappcat25.model.Flower
//import com.example.flowersappcat25.rest.FlowerApiService
//import com.squareup.picasso.Picasso
//
//class FlowerAdapter(
//    private val flowersData: MutableList<Flower> = mutableListOf(),
//    private val ddd: () -> Unit
//) : RecyclerView.Adapter<FlowerViewHolder>() {
//
//    fun updateFlowers(newDataSet: List<Flower>) {
//        flowersData.addAll(newDataSet)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder =
//        FlowerViewHolder(
//            FlowerItemBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//
//    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
//        holder.bind(flowersData[position], ddd)
//    }
//
//    override fun getItemCount(): Int = flowersData.size
//}
//
//class FlowerViewHolder(
//    private val binding: FlowerItemBinding
//) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(flower: Flower, ddd: () -> Unit) {
//        binding.flowerName.text = flower.name ?: "N/A"
//        binding.flowerPrice.text = flower.price.toString()
//        binding.flowerCategory.text = flower.category ?: "N/A"
//
//        Picasso.get()
//            .load(FlowerApiService.PHOTO_URL + flower.photo)
//            .placeholder(R.drawable.ic_baseline_image_search_24)
//            .error(R.drawable.ic_baseline_broken_image_24)
//            .fit()
//            .into(binding.flowerImg)
//
//        itemView.setOnClickListener {
//            ddd()
//        }
//    }
//}