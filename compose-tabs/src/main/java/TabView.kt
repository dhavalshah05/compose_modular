import android.content.Context
import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy

class TabView(
    private val context: Context
) {

    private val tabsState = mutableStateOf(FeatureTabs.get())
    private val selectedTabIndexState = mutableStateOf(0)

    fun getRootView(): View {
        return ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CustomTabs(
                    selectedTabIndex = selectedTabIndexState.value,
                    featureTabs = tabsState.value,
                    onTabSelect = { featureTab ->
                        val index = tabsState.value.indexOf(featureTab)
                        selectedTabIndexState.value = index
                    }
                )
            }
        }
    }
}