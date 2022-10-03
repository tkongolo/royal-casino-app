package ind.co.royal_casino.Games

interface BettingPlatformCallback{
    fun onBetPlatformChange(platform: BetPlatform,coinNumb: Int)
    fun onCancelBet()
    fun onBeginBet()
}