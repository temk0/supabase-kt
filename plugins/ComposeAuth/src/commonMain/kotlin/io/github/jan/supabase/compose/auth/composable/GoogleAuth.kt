package io.github.jan.supabase.compose.auth.composable

import androidx.compose.runtime.Composable
import io.github.jan.supabase.compose.auth.ComposeAuth

@Composable
expect fun ComposeAuth.rememberLoginWithGoogle(onResult: (NativeSignInResult) -> Unit = {}, fallback: suspend () -> Unit = { this.fallbackLogin() }): NativeSignInState