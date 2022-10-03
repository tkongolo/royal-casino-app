package ind.co.royal_casino.Utilities.BusinessLogic.RequestModels

import com.fasterxml.jackson.annotation.JsonProperty

data class Body_Login(
    @JsonProperty("phone")
    var phone: String,
    @JsonProperty("password")
    var password: String,
    @JsonProperty("deviceToken")
    var deviceToken: String
)

data class Resp_LoginToken(
    @JsonProperty("access_token")
    var access_token: String,
    @JsonProperty("refresh_token")
    var refresh_token: String
)

data class Resp_TransactionMain(
    @JsonProperty("name")
    var name: String,

    @JsonProperty("amount")
    var amount: Float,

    @JsonProperty("action")
    var action: String,

    @JsonProperty("balance")
    var balance: Float
)

data class Resp_NewTransactionMain(
    @JsonProperty("name")
    var name: String,

    @JsonProperty("amount")
    var amount: Float,

    @JsonProperty("transactionResponse")
    var transactionResponse: String
)

data class Resp_SummaryProfile(
    @JsonProperty("name")
    var name: String,
    @JsonProperty("phoneNumber")
    var phoneNumber: String,
    @JsonProperty("activeState")
    var activeState: Boolean,
    @JsonProperty("dateJoined")
    var dateJoined: String,
    @JsonProperty("balance")
    var balance: Float
)

data class Body_RegisterInfo(
    var name: String,
    var phoneNumber: String,
    var password: String,
    var deviceToken: String,
    var invitedby: String?
)

data class Body_Refresh(
    var refresh_token: String
)

data class Resp_RefreshToken(
    @JsonProperty("access_token")
    var access_token: String
)

data class Resp_Message(
    @JsonProperty("message")
    var message: String
)

data class Body_MainTransaction(
    @JsonProperty("amount")
    var amount: Int,

    @JsonProperty("action")
    var action: String
)

data class Body_NewMainTransaction(
    @JsonProperty("amount")
    var amount: Int
)

data class Resp_Documentation(
    @JsonProperty("header")
    var header: String,

    @JsonProperty("body")
    var body: String
)

data class Body_DeviceUpdate(
    @JsonProperty("deviceToken")
    var deviceToken: String
)

data class Body_PlayerUpdate(
    @JsonProperty("email")
    var email: String
)

data class Resp_GamesResponse(
    @JsonProperty("game")
    var game: String,

    @JsonProperty("betAmount")
    var betAmount: Int,

    @JsonProperty("choice")
    var choice: String,

    @JsonProperty("gameResponse")
    var gameResponse: String,

    @JsonProperty("playerStatus")
    var playerStatus: String,

    @JsonProperty("newAmount")
    var newAmount: Float,

    @JsonProperty("playerBalance")
    var playerBalance: Float
)

data class Body_RazorSuccessTransaction(
    @JsonProperty("paymentID")
    var paymentID: String,

    @JsonProperty("orderID")
    var orderID: String,

    @JsonProperty("paymentSignature")
    var paymentSignature: String
)

data class Resp_MainAmountTransaction(
    @JsonProperty("name")
    var name: String,

    @JsonProperty("amount")
    var amount: Float,

    @JsonProperty("action")
    var action: String,

    @JsonProperty("balance")
    var balance: Float
)