package io.github.jan.supabase.compose.auth


open class LoginConfig(open val serverClientId: String)

data class GoogleLoginConfig(
    override val serverClientId: String,
    val isSupported: Boolean = true,
    val filterByAuthorizedAccounts: Boolean = false,
    val associateLinkedAccounts: Pair<String, List<String>>? = null,
    val nonce: String? = null,
) : LoginConfig(serverClientId)

fun ComposeAuth.Config.googleNativeLogin(serverClientId: String, isSupported: Boolean = true, filterByAuthorizedAccounts: Boolean = false, associateLinkedAccounts: Pair<String, List<String>>? = null, nonce: String? = null) = GoogleLoginConfig(serverClientId, isSupported,filterByAuthorizedAccounts,associateLinkedAccounts, nonce)