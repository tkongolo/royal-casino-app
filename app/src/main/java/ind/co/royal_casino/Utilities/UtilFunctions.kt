package ind.co.royal_casino.Utilities

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ind.co.royal_casino.R
import ind.co.royal_casino.databinding.FragmentDialogProcessBinding
import java.net.InetAddress
import java.net.UnknownHostException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ViewModelFactoryWithContext(private val ctx: Context): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Context::class.java).newInstance(ctx)
    }

}

fun isInternetActive(ctx: Context): Boolean{
    var res: Boolean = false
    val connectivityManager: ConnectivityManager = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ){
        val nw = connectivityManager.activeNetwork
        val actNw = connectivityManager.getNetworkCapabilities(nw)
        if( nw != null){
            if(actNw != null){
                if(actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH)){
                    res = checkOnlineConnection()
                }
            }
        }
    }else{
        if(connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo?.isConnected == true){
            res = checkOnlineConnection()
        }
    }

    return res
}

fun checkOnlineConnection(): Boolean{
    var res: Boolean = false

    try {
        val address: InetAddress = InetAddress.getByName("www.google.com")
        res = !address.equals("")
    }catch (ex: UnknownHostException){

    }

    return res
}