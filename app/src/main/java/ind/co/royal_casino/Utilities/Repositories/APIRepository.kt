package ind.co.royal_casino.Utilities.Repositories

import android.content.Context
import android.util.Log
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.BusinessLogic.ApiInterface
import ind.co.royal_casino.Utilities.BusinessLogic.RequestModels.*
import ind.co.royal_casino.Utilities.Repositories.Models.DocumentType
import ind.co.royal_casino.Utilities.Repositories.Models.GameType
import ind.co.royal_casino.Utilities.Repositories.Models.MainTransactionType
import retrofit2.Call

class APIRepository(private val ctx: Context) {
    private val acctMemRepository: AcctMemRepository = AcctMemRepository(ctx)
    private val apiInterface: ApiInterface = ApiInterface.create()
    private val TAG = ctx.getString(R.string.tag_repository_api)

    val objectMapper: ObjectMapper = ObjectMapper()

    private fun getInJsonFormat(jsonValues: String): JsonNode?{
        var jsonNode: JsonNode? = null;

        if(!jsonValues.isNullOrEmpty()){
            try{
                jsonNode = objectMapper.readTree(jsonValues)
                return jsonNode
            }catch(ex:Exception){
                Log.e(TAG,"${ctx.getString(R.string.LOG_MSG_ERR_createJsonClass)} ${ex.message}")
            }
        }

        return jsonNode
    }

    private fun getUrlGameType(gType: GameType): String{
        return when(gType){
            GameType.SLOT_MACHINE -> "slot-machine"
            GameType.CAR_ROULETTE -> "car-roulette"
            GameType.COLOR_PREDICTION -> "color-prediction"
            GameType.DRAGON_VS_TIGER -> "dragon-vs-tiger"
        }
    }

    private fun getMainTransactionType(mType: MainTransactionType): String{
        return when(mType){
            MainTransactionType.TOPUP -> ctx.getString(R.string.transaction_topup)
            MainTransactionType.CLAIM -> ctx.getString(R.string.transaction_claim)
        }
    }

    private fun getAccessToken(): String{
        return "Bearer ${acctMemRepository.getAccToken()}"
    }

    private fun getPlayerID(): Int{
        return acctMemRepository.getSub()
    }

    private fun getDocumentType(dType: DocumentType): String{
        return when(dType){
            DocumentType.ABOUT_US -> ctx.getString(R.string.docType_about_us)
            DocumentType.ONLINE_SERVICES -> ctx.getString(R.string.docType_online_services)
            DocumentType.PRIVACY_POLICY -> ctx.getString(R.string.docType_privacy_policy)
            DocumentType.TERMS_AND_CONDITIONS -> ctx.getString(R.string.docType_terms_and_conditions)
        }
    }

    fun executeProcessLogin(phNumber: String, password: String,devToken: String): Call<String> {
        val loginDet: Body_Login = Body_Login(phNumber,password,devToken)
        return apiInterface.getLoginCred(loginDet)
    }

    fun executeRegisterProcess(name: String, phNumber: String, password: String,devToken: String,invitedBy: String?): Call<String> {
        val registerDet: Body_RegisterInfo = Body_RegisterInfo(name,phNumber,password,devToken,invitedBy)
        return apiInterface.registerNewPlayer(registerDet)
    }

    fun executeUpdateDeviceToken(newTk: String): Call<String>{
        val bodyDevToken = Body_DeviceUpdate(newTk)
        return apiInterface.updatePlayerDevice(getAccessToken(),getPlayerID(),bodyDevToken)
    }

    fun executeUpdateEmail(emailVal: String): Call<String>{
        val emailUpdateBody = Body_PlayerUpdate(emailVal)
        return apiInterface.updatePlayerEmail(getAccessToken(),acctMemRepository.getSub(),emailUpdateBody)
    }

    fun executeGetSummaryProfile(): Call<String>{
        return apiInterface.getProfile(getAccessToken(),getPlayerID())
    }

    fun executeTopUpTransaction(amt: Int): Call<String>{
        val bodyInfo: Body_NewMainTransaction = Body_NewMainTransaction(amt)
        return apiInterface.performTopUpTransaction(getAccessToken(),getPlayerID(),bodyInfo)

    }

    fun executeClaimTransaction(amt: Int): Call<String>{
        val bodyInfo: Body_NewMainTransaction = Body_NewMainTransaction(amt)
        return apiInterface.performClaimTransaction(getAccessToken(),getPlayerID(),bodyInfo)

    }

//    fun executeMainTransaction(amt: Int, mType: MainTransactionType): Call<String>{
//        val bodyInfo: Body_MainTransaction = Body_MainTransaction(amt,getMainTransactionType(mType))
//        return apiInterface.performMainTransaction(getAccessToken(),bodyInfo)
//    }

    fun executeUpdateTopUpTransaction(paymentID: String, orderID: String, signature: String): Call<String>{
        val bodyInfo: Body_RazorSuccessTransaction = Body_RazorSuccessTransaction(paymentID,orderID,signature)
        return apiInterface.performTopupUpdate(getAccessToken(),bodyInfo)
    }

    fun executeGameBet(gameType: GameType, amt: Int, choice: String): Call<String>{
        return apiInterface.performGameBet(getAccessToken(), getUrlGameType(gameType),amt,choice)
    }

    fun executeRefreshAccessToken(): Call<String>{
        val refTok = acctMemRepository.getRefToken()
        return if(!refTok.isNullOrEmpty()){
            val bodyRefresh = Body_Refresh(refTok)
            apiInterface.refrestAccessToken(bodyRefresh)
        }else{
            apiInterface.refrestAccessToken(Body_Refresh(""))
        }
    }

    fun getDocumentation(docType: DocumentType): Call<String>{
        return apiInterface.getDocumentation(getDocumentType(docType))
    }

}