import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ConfirmationDialog(
    showDialog: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    title: String = "",
    @StringRes titleResId: Int? = null,
    body: String = "",
    @StringRes bodyResId: Int? = null,
    confirmBtnText: String = "",
    @StringRes confirmBtnTextResId: Int? = null,
    confirmBtnAction: () -> Unit = {},
    dismissBtnText: String = "",
    @StringRes dismissBtnTextResId: Int? = null,
    dismissBtnAction: () -> Unit = {},
    confirmBtnColor: Color = MaterialTheme.colors.primary
) {
    val titleToDisplay =
        if (title.isNotEmpty()) title else if (titleResId != null) stringResource(titleResId) else ""
    val bodyToDisplay =
        if (body.isNotEmpty()) body else if (bodyResId != null) stringResource(bodyResId) else ""
    if (showDialog.value) {
        AlertDialog(modifier = modifier.fillMaxWidth(0.87f),
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = { showDialog.value = false },
            title = if (titleToDisplay.isNotEmpty()) {
                {
                    Text(
                        text = titleToDisplay,
                        style = WagzThemeTypography.h6,
                        fontWeight = FontWeight.Medium
                    )
                }
            } else null,
            text = if (bodyToDisplay.isNotEmpty()) {
                {
                    Text(
                        text = bodyToDisplay,
                        style = WagzThemeTypography.body1,
                        color = Black
                    )
                }
            } else null,
            confirmButton = {
                val buttonText = if (confirmBtnText.isNotEmpty()) confirmBtnText
                else if (confirmBtnTextResId != null) stringResource(id = confirmBtnTextResId)
                else ""
                if (buttonText.isNotEmpty()) {
                    TextButton(onClick = {
                        showDialog.value = false
                        confirmBtnAction()
                    }) {
                        Text(
                            text = buttonText.uppercase(),
                            color = confirmBtnColor,
                            letterSpacing = 1.sp
                        )
                    }
                }
            },
            dismissButton = {
                val buttonText = if (dismissBtnText.isNotEmpty()) dismissBtnText
                else if (dismissBtnTextResId != null) stringResource(id = dismissBtnTextResId)
                else ""
                if (buttonText.isNotEmpty())
                    TextButton(onClick = {
                        showDialog.value = false
                        dismissBtnAction()
                    }) {
                        Text(
                            text = buttonText.uppercase(),
                            letterSpacing = 1.sp
                        )
                    }
            })
    }
}
