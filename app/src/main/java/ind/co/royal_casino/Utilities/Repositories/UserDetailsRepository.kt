package ind.co.royal_casino.Utilities.Repositories

import android.content.Context
import android.content.SharedPreferences
import ind.co.royal_casino.R
import ind.co.royal_casino.Utilities.Repositories.Models.DocumentType

class UserDetailsRepository(private val ctx: Context) {
    private val prefName: String = ctx.getString(R.string.preference_importantDetails)
    private var actPreference: SharedPreferences = ctx.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    fun getVirtualCoinAmounts():Float{
        return actPreference.getFloat(ctx.getString(R.string.importantDetails_coinAmount), 0.0F)
    }

    fun saveVirtualCoinAmt(amt: Float){
        val editor = actPreference.edit()
        editor.putFloat(ctx.getString(R.string.importantDetails_coinAmount),amt)
        editor.apply()
    }

    fun reset(){
        saveVirtualCoinAmt(0.0F)
    }

    fun saveDocInfo(docType: DocumentType, docString: String){
        val editor = actPreference.edit()
        when(docType){
            DocumentType.ONLINE_SERVICES -> editor.putString(ctx.getString(R.string.docType_online_services),docString)
            DocumentType.ABOUT_US -> editor.putString(ctx.getString(R.string.docType_about_us),docString)
            DocumentType.PRIVACY_POLICY -> editor.putString(ctx.getString(R.string.docType_privacy_policy),docString)
            DocumentType.TERMS_AND_CONDITIONS -> editor.putString(ctx.getString(R.string.docType_terms_and_conditions),docString)
        }

        editor.apply()
    }

    fun getDocInfo(docType: DocumentType): String?{
        return when(docType){
            DocumentType.ONLINE_SERVICES -> actPreference.getString(ctx.getString(R.string.docType_online_services),"")
            DocumentType.ABOUT_US -> actPreference.getString(ctx.getString(R.string.docType_about_us),"")
            DocumentType.PRIVACY_POLICY -> actPreference.getString(ctx.getString(R.string.docType_privacy_policy),"")
            DocumentType.TERMS_AND_CONDITIONS -> actPreference.getString(ctx.getString(R.string.docType_terms_and_conditions),"")
        }
    }
}