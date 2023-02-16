# Jetpack Compose Confirmation Dialog Utils
A utils class for alert dialogs in compose

Just copy the class ConfirmationDialog.kt to you project and use it as below:

```kotlin
@Preview
@Composable
private fun ConfirmationDialogPreview() {
    AppTheme {
        val showDialog = remember { mutableStateOf(true) }
        ConfirmationDialog(
            showDialog = showDialog,
            titleResId = R.string.save_changes,
            bodyResId = R.string.are_you_sure,
            confirmBtnTextResId = R.string.save,
            dismissBtnTextResId = R.string.cancel
        )
    }
}
```
