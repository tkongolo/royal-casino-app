package ind.co.royal_casino.Utilities.Repositories

import android.content.Context
import android.content.SharedPreferences
import com.auth0.android.jwt.JWT
import ind.co.royal_casino.R

class AcctMemRepository(private val ctx: Context) {
    private val prefName: String = ctx.getString(R.string.preference_tokenInfo)
    private var actPreference: SharedPreferences = ctx.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    fun getRefToken(): String?{
        return actPreference.getString(ctx.getString(R.string.tokenInfo_refreshToken),"")
    }

    fun getAccToken(): String?{
        return actPreference.getString(ctx.getString(R.string.tokenInfo_accessToken),"")
    }

    fun getSub(): Int{
        return actPreference.getInt(ctx.getString(R.string.tokenInfo_sub),0)
    }

    fun getUserName(): String?{
        return actPreference.getString(ctx.getString(R.string.tokenInfo_userName),"")
    }

    fun getPhoneNumber(): String{
        return actPreference.getString(ctx.getString(R.string.tokenInfo_phNumber),"")!!
    }

    fun getEmail(): String{
        return actPreference.getString(ctx.getString(R.string.tokenInfo_email),"")!!
    }

    fun saveRefToken(refTok: String){
        val editor = actPreference.edit()
        editor.putString(ctx.getString(R.string.tokenInfo_refreshToken),refTok)
        editor.apply()
    }

    fun saveAccToken(accTok: String){
        val editor = actPreference.edit()
        editor.putString(ctx.getString(R.string.tokenInfo_accessToken),accTok)
        editor.apply()
        val jwtVal = JWT(accTok)
        val subVal: Int? = jwtVal.getClaim("sub").asInt()
        val userName: String? = jwtVal.getClaim("username").asString()
        val userphone: String? = jwtVal.getClaim("phone").asString()
        val userEmail: String? = jwtVal.getClaim("email").asString()
        if(subVal != null){
            saveSub(subVal)
        }

        if(!userName.isNullOrEmpty()){
            saveUserName(userName)
        }

        if(!userEmail.isNullOrEmpty()){
            saveUserEmail(userEmail)
        }

        if(!userphone.isNullOrEmpty()){
            saveUserPhoneNumber(userphone)
        }
    }

    private fun saveUserName(uName: String){
        val editor = actPreference.edit()
        editor.putString(ctx.getString(R.string.tokenInfo_userName),uName)
        editor.apply()
    }

    fun saveUserEmail(emailVal: String){
        val editor = actPreference.edit()
        editor.putString(ctx.getString(R.string.tokenInfo_email),emailVal)
        editor.apply()
    }

    private fun saveSub(sub: Int){
        val editor = actPreference.edit()
        editor.putInt(ctx.getString(R.string.tokenInfo_sub),sub)
        editor.apply()
    }

    private fun saveUserPhoneNumber(uPhone: String){
        val editor = actPreference.edit()
        editor.putString(ctx.getString(R.string.tokenInfo_phNumber),uPhone)
        editor.apply()
    }

    fun resetAll(){
        val editor = actPreference.edit()
        editor.putString(ctx.getString(R.string.tokenInfo_userName),"")
        editor.putString(ctx.getString(R.string.tokenInfo_phNumber),"")
        editor.putInt(ctx.getString(R.string.tokenInfo_sub),0)
        editor.putString(ctx.getString(R.string.tokenInfo_email),"")
        editor.putString(ctx.getString(R.string.tokenInfo_accessToken),"")
        editor.putString(ctx.getString(R.string.tokenInfo_refreshToken),"")
        editor.apply()
    }
}