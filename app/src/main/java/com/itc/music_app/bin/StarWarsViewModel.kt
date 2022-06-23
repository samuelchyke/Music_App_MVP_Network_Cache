//package com.example.starwarscat25.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.starwarscat25.model.StarWarsResponse
//import com.example.starwarscat25.network.StarWarsRepository
//import com.example.starwarscat25.network.StarWarsRepositoryImpl
//import com.example.starwarscat25.utils.UIState
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.*
//import javax.inject.Inject
//
//@HiltViewModel
//class StarWarsViewModel @Inject constructor(
//    private val starWarsRepository: StarWarsRepository
//) : ViewModel() {
//
//    private val _characters: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
//    val characters: LiveData<UIState> get() = _characters
//
//    fun getStarWarsCharacters(uniqueId: Int? = null) {
//        // this is a global coroutine scope
//        CoroutineScope(Dispatchers.IO).launch {
//            // here you are in the worker thread
//            delay(1000)
//            try {
//                val response = starWarsRepository.getCharacters(uniqueId)
//                if (response.isSuccessful) {
//                    // here you still in worker thread
//                    response.body()?.let {
//                        // here you might need to change ot main thread
//                        withContext(Dispatchers.Main) {
//                            // here you moved to the main thread
//                            // you update the UI
//                            // _characters.postValue(it)
//                            _characters.value = UIState.SUCCESS(it)
//                        }
//                        // propagate the success
//                    } ?: throw Exception("DATA IS NULL")
//                } else {
//                    throw Exception(response.errorBody()?.string())
//                }
//            } catch (e: Exception) {
//                // propagate the error
//                withContext(Dispatchers.Main) {
//                    // here you moved to the main thread
//                    // you update the UI
//                    _characters.postValue(UIState.ERROR(e))
//                }
//            }
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        // here you remove the viewmodel
//    }
//}