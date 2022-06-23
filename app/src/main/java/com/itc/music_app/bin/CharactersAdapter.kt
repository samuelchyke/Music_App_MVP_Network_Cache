//package com.example.starwarscat25.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.starwarscat25.databinding.CharacterItemBinding
//import com.example.starwarscat25.model.Results
//
//class CharactersAdapter(
//    private val charactersSet: MutableList<Results> = mutableListOf(),
//    private val onCharacterClicked: (String?) -> Unit
//) : RecyclerView.Adapter<CharactersViewHolder>() {
//
//    fun updateNewCharacters(newCharacters: List<Results>) {
//        charactersSet.clear()
//        charactersSet.addAll(newCharacters)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder =
//        CharactersViewHolder(
//            CharacterItemBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//
//    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) =
//        holder.bind(charactersSet[position], onCharacterClicked)
//
//    override fun getItemCount(): Int = charactersSet.size
//}
//
//class CharactersViewHolder(
//    private val binding: CharacterItemBinding
//) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(character: Results, onCharacterClicked: (String?) -> Unit) {
//        binding.cardName.text = character.name
//        binding.cardUrl.text = character.url
//
//        itemView.setOnClickListener { onCharacterClicked(character.uid) }
//    }
//}