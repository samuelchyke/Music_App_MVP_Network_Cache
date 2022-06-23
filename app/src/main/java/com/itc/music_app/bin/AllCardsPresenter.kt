//package com.example.yugiohmvpapp25.presenters
//
//import com.example.yugiohmvpapp25.database.LocalDataRepository
//import com.example.yugiohmvpapp25.domain.DomainCard
//import com.example.yugiohmvpapp25.domain.mapToDomainCard
//import com.example.yugiohmvpapp25.rest.CardsRepository
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.schedulers.Schedulers
//import javax.inject.Inject
//
//class AllCardsPresenter @Inject constructor(
//    private val cardsRepository: CardsRepository,
//    private val compositeDisposable: CompositeDisposable,
//    private val localCardsRepository: LocalDataRepository
//) : AllCardsPresenterContract {
//
//    private var cardsViewContract: AllCardsViewContract? = null
//
//    override fun init(viewContract: AllCardsViewContract) {
//        cardsViewContract = viewContract
//    }
//
//    override fun registerToNetworkState() {
//        TODO("Not yet implemented")
//    }
//
//    override fun getAllCards() {
//        cardsViewContract?.loadingCards(true)
//        getCardsFromNetwork()
//    }
//
//    override fun destroyPresenter() {
//        cardsViewContract = null
//        compositeDisposable.dispose()
//    }
//
//    private fun getCardsFromNetwork() {
//        cardsRepository.getAllCards()
//            .subscribeOn(Schedulers.io())
//            .flatMapCompletable {
//                localCardsRepository.insertCards(it.cards.mapToDomainCard())
//            }
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { getCardsFromDb() },
//                { error ->
//                    cardsViewContract?.error(error)
//                    getCardsFromDb()
//                }
//            )
//            .also { compositeDisposable.add(it) }
//    }
//
//    private fun getCardsFromDb() {
//        localCardsRepository.getAllCards()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { cardsViewContract?.successCardsResponse(it, true) },
//                { cardsViewContract?.error(it) }
//            )
//            .also { compositeDisposable.add(it) }
//    }
//}
//
//interface AllCardsPresenterContract {
//    fun init(viewContract: AllCardsViewContract)
//    fun registerToNetworkState()
//    fun getAllCards()
//    fun destroyPresenter()
//}
//
//interface AllCardsViewContract {
//    fun loadingCards(isLoading: Boolean = false)
//    fun successCardsResponse(cards: List<DomainCard>, isOffline: Boolean = false)
//    fun error(error: Throwable)
//}